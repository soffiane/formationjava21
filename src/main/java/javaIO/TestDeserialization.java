package javaIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TestDeserialization {
    public static void main(String[] args) {
        
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/java/javaIO/person.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object persons = objectInputStream.readObject();//personId est 0 car il est transient
            for(Person person : (ArrayList<Person>)persons){
                System.out.println(person);
                System.out.println("----------------------------");
            }
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

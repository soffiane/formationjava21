package javaIO;

import java.io.*;
import java.util.ArrayList;

/**
 * L'objet Person est Serializable mais un de ses attributs est un objet Weights qui n'est pas serializable
 * On ne pourra pas serialiser l'objet Person a moins de preciser qu'il est transient
 */
public class TestSerialization {
    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("Benjamin","Smith",20,false,1,new Weights(50)));
        personList.add(new Person("Emily","Johnson",21,false,2,new Weights(60)));
        personList.add(new Person("Alexander","Williams",22,true,3,new Weights(150)));
        personList.add(new Person("William","Taylor",23,true,4,new Weights(550)));

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/javaIO/person.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(personList);//si Person n'est pas serialisable -> java.io.NotSerializableException: javaIO.Person
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

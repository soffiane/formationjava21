package javaIO;

import java.io.*;
import java.util.Scanner;

/**
 * Read and Write to copy from file to another file
 */
public class CopyFileExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a filename");
        String filename = scanner.next();
        try {
            Reader reader = new FileReader("src/main/java/javaIO/testfile.txt");
            Writer writer = new FileWriter("src/main/java/javaIO/" + filename + ".txt");

            if (reader.ready()) {
                System.out.println("Reading data");
                //loop pour lire le fichier
                int charRead;
                do {
                    charRead = reader.read();
                    if (charRead != -1) {
                        writer.write(charRead);
                    }
                } while (charRead != -1);
            }
            scanner.close();
            reader.close();
            writer.close();
            System.out.println("Copy finished");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

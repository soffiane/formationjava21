package javaIO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * Input/Outputstram se basent sur des bytes -> Java 1
 * Reader/Writer se basent sur des characteres (UTF-8 etc....)
 * classe abstraite
 * implementations :
 * BufferedWriter, OutputStreamWriter, PipedWriter,
 * methodes :
 * write() avec + signatures avec String ou char[] en parametre
 */
public class WriterClassExample {
    public static final String FILENAME = "toto.txt";
    public static void main(String[] args) {
        try {
            Writer writer = new FileWriter(FILENAME);
            Scanner scanner = new Scanner(System.in);
            System.out.println("write something");
            String text = scanner.nextLine();
            writer.write(text);//parametres possible offset et longueur lue
            writer.close();
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

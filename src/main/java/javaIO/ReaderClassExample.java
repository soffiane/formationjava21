package javaIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Lire des caracteres depuis une source
 * classe abstraites
 * implementation :
 * BufferedReader, InputStreamReader .....
 * methodes
 * read() avec les 3 signatures
 * skip(long n) : pour skip n byte du stream
 * ready() : dit si le stream est pret a la lecture
 */
public class ReaderClassExample {
    public static final String FILENAME = "toto.txt";
    public static void main(String[] args) {
        try {
            Reader reader = new FileReader(FILENAME);
            int charRead;
            //char[] charArray = new char[100] //on essaie de predire la taille - nul
            String text = "";

            if(reader.ready()){
                do{
                    charRead = reader.read();
                    if(charRead != -1){
                        text = text.concat(String.valueOf((char)charRead));
                        //System.out.print((char)charRead);
                        //Thread.sleep(500);

                    }
                }while(charRead != -1);
            }
            System.out.print(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

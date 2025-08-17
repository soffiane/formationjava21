package javaIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Deplace des données dans des bytes, inverse de OutputStream
 * lire des données depuis des data sources pour le proggramme
 * implementations : FileInputStream, ByteArrayInputStream, ObjectInputStream, StringBufferInputStream
 * methodes :
 * read(int b), read(byte[]b), read(byte[]b, inbt offset, int length)
 * available() : renvoie le nombre estimés de byte pouvant etre lus ou skip sans bloquer le stream /
 * skip(long n) : saute et defausse n bytes du stream
 * mark(int readLimit) : marque la position en cours dans le stream
 * markSupported() : teste si le stream supporte mark() et reset()
 * reset() : replace le pointeur de lecture du stream sur la marque placée par mark()
 * close() : ferme le stream et libere les ressources
 */
public class InputStreamClassExample {
    public static final String FILENAME = "text.txt";

    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream(FILENAME);
            int length = inputStream.available();
            /*int charAsDecimal = inputStream.read();
            while(charAsDecimal != -1){
                char eachChar = (char) charAsDecimal;
                String eachCharAsString = String.valueOf(eachChar);
                System.out.print(eachCharAsString);
                Thread.sleep(1000);
                charAsDecimal = inputStream.read();
            }*/

            //On va juste affuicher le mot "Programming" depuis le fichier
            byte[] characterArray = new byte[length];
            inputStream.skip(5);//on skip le mot Java
            int characterRead = inputStream.read(characterArray, 0, 11);
            String chacterString = new String(characterArray);
            System.out.println(chacterString);
            inputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } /*catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }
}

package javaIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Lire des données depuis fichier, entree et afficher dans la console, fichier log, bdd etc....
 * character based, byte based...
 *
 * OutputStream : transfere les donnees du programme vers la destination
 * classe abstraite, super classes de toutes les implem qui represente un flux de sortie
 * ecrit dans des bytes : java.io
 * ByteArrayOutputStream, FileOutputStream,PrintStream, ObjectOutputStream
 * methodes :
 * write(int b), write(byte[] b), write(byte[] b,int offset, int lenght)
 * flush() : vide le stream et force lecriture des bytes dans la sortie
 * close() : fermeture du stream
 * ecriture dans l'ordre du stream
 */
public class OutputStreamExample {
    public static final String FILENAME = "text.txt";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text : ");
        String nextLine = scanner.nextLine();
        String currentPath = System.getProperty("user.dir");
        System.out.println("currentPath : "+currentPath);

        try {
            OutputStream outputStream = new FileOutputStream(currentPath+ File.separator+FILENAME);
            System.out.println(currentPath+ File.separator+FILENAME);
            outputStream.write(nextLine.getBytes(),5,11);//Programming au lieu de Java Programming Langage
            outputStream.flush();
            outputStream.close();
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

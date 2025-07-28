package io;

import java.util.Scanner;

public class BasicIO {

    //variable d'instance - variable associé a chaque instance = new
    int toto = 0;
    //variable static - variable partagée entre toutes les instances de la classe
    static int x = 50;
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Java java java");
        System.out.printf("%d + %d = %d\n",2,4,6);
        System.out.printf("%S","hello \n");

        //lis l'entrée en console - variable de methode, n'existe que dans la methode
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un nombre :");
        int i = scanner.nextInt();
        System.out.println("Il te reste "+i+" années a vivre");
        System.out.println("Dis un truc");
        String next = scanner.next();
        System.out.println("Tu as ecris "+next);
        scanner.close();
        System.out.println(doMultiply(5,3));

    }

    /**
     * This method multiplies two int
     * @param x
     * @param y
     * @return the result of x * y
     */
    public static int doMultiply(int x, int y){
        return x*y;
    }
}

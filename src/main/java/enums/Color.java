package enums;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Introduit en java5
 * Liste de constantes predefinies pour creer ses propres types
 * - Constructeur implicite static final
 * - utilisable dans un switch comme un String ou un int
 * - == et equals()
 * - on peut pas instancier un enum avec new
 */
public enum Color {
    RED,BLUE,YELLOW;
}

class Test {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("enter a color : ");
            String inputColor = scanner.next();
            Color color = Color.valueOf(inputColor.toUpperCase());//convertit le string en Color - IllegalArgumentException si ca correspond pas a une valeur de l'enum
            switch (color) {
                case RED -> System.out.println("its red");
                case YELLOW -> System.out.println("its yellow");
                case BLUE -> System.out.println("its blue");
                default -> System.out.println("unknwon color");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("enter a valid color in "+ Arrays.toString(Color.values()));
        }

    }
}

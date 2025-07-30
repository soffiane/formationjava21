package controlflow;

import java.util.Scanner;

public class IfLadderNestedElseStatement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age : ");
        int age = scanner.nextInt();

        if (age < 13) {
            System.out.println("you are a child");
        } else if (age < 19) {
            System.out.println("you are a teenager");
        } else {
            if (age < 65) {
                System.out.println("you are an adult");
            } else {
                System.out.println("you are an old man !");
            }
        }
        scanner.close();
    }

}

package methods;

import java.util.Scanner;

public class ExponentialNumber {
    public static void main(String[] args) {
        //methode doit etre statique pour y acceder dans un contexte statique
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = input.nextInt();
        System.out.println("Enter an exponent: ");
        int exponent = input.nextInt();
        for(int a=0;a<=exponent;a++){
            System.out.println(number +" to the power of "+a+" is " +pow(number,a));
        }

    }

    public static int pow(int a, int power){
        return (int) Math.pow(a,power);
    }
}

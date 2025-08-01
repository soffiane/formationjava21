package controlflow;

import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {
        int x=0;
        while(x<6){
            System.out.println(x++);
        }

        String[] animals = {"Cat","Dog","Horse"};
        int i = 0;
        while(i < animals.length){
            System.out.println("Animals["+i+"] =" +animals[i++]);
        }

        //calcul factoriel
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int number = scanner.nextInt();
        if(number < 0){
            System.out.println(number+"! is undefined ");
        } else if(number == 0 || number ==1){
            System.out.println(number+"! = 1");
        } else {
            int initialValue = number;
            long result = 1;
            while(number > 0){
                result *= number--;
            }
            System.out.println(initialValue+"! = "+result);
        }
        scanner.close();
    }
}

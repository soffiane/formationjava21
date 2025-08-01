package controlflow;

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        //le do est executé au moins une fois meme si la condition est directement fausse
        int i = 5;
        do{
            System.out.println(i--);
        } while (i > 5);
        System.out.println("Last value of i : "+i);

        Scanner scanner = new Scanner(System.in);
        int result = 0;
        char continueToCalculate;

        do {
            System.out.println("Enter a number : ");
            int number = scanner.nextInt();
            result += number;
            System.out.println("Contniue ? (Y/N)");
            continueToCalculate = scanner.next().charAt(0);
        } while(continueToCalculate == 'y' || continueToCalculate == 'Y');
        System.out.println("Sum is : "+result);
        scanner.close();
    }
}

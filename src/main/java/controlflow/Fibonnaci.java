package controlflow;

import java.util.Scanner;

public class Fibonnaci {
    public static void main(String[] args) {
        //Fibonnaci -> 0 1 1 2 3 5 8 13 21 34 55 89...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter max sequence number: ");
        int number = scanner.nextInt();
        int fibPrevious =0, fibonnaci = 1, sum =0;

        for(int i=1;i<= number;i++){
            System.out.println(fibPrevious+ " ");
            sum = fibPrevious + fibonnaci;
            fibPrevious = fibonnaci;
            fibonnaci = sum;
        }
    }
}

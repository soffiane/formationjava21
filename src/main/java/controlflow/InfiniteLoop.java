package controlflow;

import java.util.Random;
import java.util.Scanner;

public class InfiniteLoop {

    public static void main(String[] args) {
        //infinite loop avec while
        /*
        while (true)
        {//do something}
        int a =5; ---> unreachable code
         */

        //number guessing app
        Scanner scanner = new Scanner(System.in);
        Random number = new Random();
        int solution = number.nextInt(5,100);//origin = le plus petit, bound = le plus grand
        System.out.println("Guess the number between 5 and 100 : ");
        while(true){
            int guessedNumber = scanner.nextInt();
            if(guessedNumber > solution){
                System.out.println("its smaller");
            } else if (guessedNumber < solution){
                System.out.println("its bigger");
            } else {
                System.out.println("GG");
                //sortir du while
                break;
            }
        }
        scanner.close();
    }
}

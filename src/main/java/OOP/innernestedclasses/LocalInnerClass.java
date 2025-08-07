package OOP.innernestedclasses;

import java.util.Scanner;

/**
 * le scope d'une classe local est restreinte au bloc de code dans lequel elle est definie (comme une variable definie dans une methode hein)
 * une classe local ne peut pas etre instanciée en dehors du bloc dans laquelle est a ete crée
 * depuis java8, elle peut acceder aux variable locales non-final du bloc dans la classe local
 * la classe local A ACCES aux membres de la classe qui l'englobe
 */
public class LocalInnerClass {

    public static void main(String[] args) {
        //on a pas acces a la classe local en dehors du bloc ou elle est definie
        //NumberChecker
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int input = scanner.nextInt();
        checkNumber(input);
        scanner.close();

    }

    public static void checkNumber(int enteredNumber){
        int result = 0;

        //inner local class
        class NumberChecker{
            boolean check;
            //constructeur
            public NumberChecker(int number){
                check = number % 2 == result;
            }
            //methode
            public void printNumber(){
                //on accede au parametre de la methode englobante de la inner class
                System.out.println("Number is : "+enteredNumber);
            }
        }

        NumberChecker numberChecker = new NumberChecker(enteredNumber);
        numberChecker.printNumber();
        if(numberChecker.check){
            System.out.println(enteredNumber+" is an even number");
        } else {
            System.out.println(enteredNumber+" is an odd number");
        }
    }
}

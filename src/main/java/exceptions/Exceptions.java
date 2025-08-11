package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * difference entre Error et Exception
 * Error
 * souvent due a un manque de ressources systeme (OutOfmemoryError, StackOverflowError...)
 * impossible a recuperer
 * Unchecked Type
 *
 * Exception
 * due au code
 * possible a recuperer avec un try-catch
 * checked ou unchecked
 *
 * Types d'exception
 * checked exception -> compile time (FileNotFoundException par exemple)
 * unchecked exception -> runtime (ArithmeticException par exemple)
 * user defined exception (exception qu'on crée custom)
 *
 * methodes
 * getMessage() -> renvoie le message de l'exception
 * toString() ->
 * printStackTrace()
 */
public class Exceptions {
    public static void main(String[] args) {
        int num1 = 0, num2 = 0, result = 0;
        boolean loop = false;
        do{
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("first int ");
                num1 = scanner.nextInt();
                System.out.println("second int ");
                num2 = scanner.nextInt();
                result = num1 / num2;
                System.out.println("result is " + result);
                loop = true;
                scanner.close();
            } catch (InputMismatchException  e){
                System.err.println("erreur input");
            } catch (ArithmeticException e) {
                System.err.println("erreur calcul");
            }finally {
                System.out.println("ok");
            }
        }while(!loop);

    }
}

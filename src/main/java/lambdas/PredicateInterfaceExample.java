package lambdas;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Pour les tests unitaires
 * java.util.function
 * c'est une interface fonctionnel
 * une seul methode : boolean test(T t)
 *
 * Quel est l'interet des Predicate
 */
public class PredicateInterfaceExample {
    public static void main(String[] args) {
        /*
        Predicate<Integer> p0 = t -> (t < 10);
        System.out.println(p0.test(20));//false

        Predicate<String> p1 = s -> (s.equals("Java"));
        System.out.println(p1.test("Java"));

        Predicate<Integer> i2 = m -> m>5;
        //on peut tester plusieurs predicats avec and() et or()
        System.out.println(p0.and(i2).test(7));//true

        ArrayList<String> animals = new ArrayList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Cow");
        animals.add("Ant");
        animals.add("Lion");
        System.out.println("animals = " +animals);
        //la fonction removeIf prend un predicat
        animals.removeIf(animal -> animal.equals("Ant"));
        System.out.println("animals = " +animals);
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a number");
        int number = scanner.nextInt();
        if(isEven(number,i -> i%2 ==0)){
            System.out.println(number + " is even");
        } else {
            System.out.println(number + " is odd");
        }
        scanner.close();

    }

    public static boolean isEven(int num1, Predicate<Integer> p){
        return p.test(num1);
    }
}

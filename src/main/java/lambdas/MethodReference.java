package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * avec les lambdas
 * pour utiliser une methode directement
 * x -> f(x) -> lambda expression
 * f -> methode reference
 *
 * Attention a la compatibilité entre les fonction et les signatures de methodes
 * Meme prerequis que pour Functional Interface (1 seul methode)
 * Meme fonction que lambda
 */
public class MethodReference {
    public static void main(String[] args) {
        //static methode reference
        Function<String,Integer> stringToInt = Integer::parseInt;
        //equivalent lambda
        Function<String,Integer> stringToInt2 = s -> Integer.parseInt(s);
        //on appelle la Function avec apply()
        Integer apply = stringToInt.apply("5");
        System.out.println(apply);

        String str = "hello";
        //Supplier : interface fonctionnelle qui prend 0 input et fournit 1 output
        Supplier<String> stringSupplier = str::toUpperCase;
        //equivalent en lambda
        Supplier<String> stringSupplier2 = () -> str.toUpperCase();
        System.out.println(stringSupplier.get());

        //Non static method reference
        Function<String, String> methodRef = String::toUpperCase;
        Function<String, String> lambdaRef = s -> s.toUpperCase();

        //Constructor method reference
        Supplier<List<String>> listSupplier = ArrayList::new;
        Supplier<List<String>> listSupplierLambda = () -> new ArrayList<>();
        List<String> strings = listSupplier.get();

        List<String> animals = List.of("Cat","Dog","Horse","Cow");
        //Consumer est l'interface fonctionnel qui prend un parametre et ne renvoie rien
        Consumer<String> consume = System.out::println;
        consume.accept("555555555");
        animals.forEach(animal -> {
            //si code un peu compliqué on peut pas recourir a une reference de methode
            if(animal.startsWith("C")){
                System.out.println(animal);
            }
        });

        Animals animal2 = ((animal, speed) -> MethodReference.display(animal,speed));
        Animals animal = MethodReference::display;

    }
    //meme signature que celle dans l'interface fonctionnel Animals
    public static void display(String animal, int speed){
        System.out.println(animal+" has a speed of "+speed);
    }
}

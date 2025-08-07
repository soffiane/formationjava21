package OOP.varkeyword;

import java.util.function.Function;

/**
 * mot clé var introduit dans Java 10 en 2018
 * local variable type inference -> inference de type
 * pour declarer des var dans une methode ou un bloc
 * utilisations :
 * methode ou bloc
 * pour les types primitifs et non-primitifs
 * limites :
 * pas dans les varaibles de classe
 * pas dans les signatures de methode ou les types de retour
 * doit etre initialisé
 * on peut pas y mettre null -> compilation error
 * pas dans les lambdas
 */
public class VarExample {

    class Var{

    }
    //var age; -> pas dans les attributs de la classe
    public static void var(){

    }
    public static void main(String[] args) {
        var num = 10;
        var name = "Java";
        var animals = new String[10];
        var person = new Person();
        //var age; doit etre initialisé
        int age;
        //var test = null;peut pas etre null
        //num = "toto"; --> on peut pas mettre un String dans num car c'est deja defini comme un int

        //lambda
        Function<String,Integer> function = anyString -> anyString.length();
        //var function = anyString -> anyString.length(); --> pas de var pour une Function ou un Lambda
    }
}

package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListClass {
    public static void main(String[] args) {
        ArrayList<Integer> ages = new ArrayList<>();
        ages.add(20);
        ages.add(25);
        ages.add(30);
        System.out.println("ages : "+ ages);//la methode toString de ArrayList affiche les valeurs

        ArrayList<Object> mixedList = new ArrayList<>();
        mixedList.add("Hello World");
        mixedList.add(10.5);
        mixedList.add(10L);
        mixedList.add(true);

        System.out.println("mixedList : "+ mixedList);//la methode toString de ArrayList affiche les valeurs

        ArrayList<String> animals = new ArrayList<>();
        animals.add("Lion");
        animals.add("Cat");
        animals.add(2,"Dog");
        animals.add(1,"Cow");//ajoute l'element a l'index 1 et decale les autres elements vers la droite
        //resultat attendu : Lion Cow Cat Dog

        System.out.println("animals : "+ animals);//la methode toString de ArrayList affiche les valeurs

        animals.remove(2);//supprime le Cat et decalle les autres elements vers la gauche

        System.out.println("animals : "+ animals);

        animals.remove("Lion");

        System.out.println("animals : "+ animals);

        animals.set(1,"Ant");//on remplace le Dog par un Ant

        System.out.println("animals : "+ animals);
        ArrayList<String> cars = new ArrayList<>();
        System.out.println("size : "+cars.size());
        System.out.println("is empty ? :"+cars.isEmpty());
        cars.add("Mercedes");
        cars.add("Ferrari");
        cars.add("Ford");
        System.out.println("size : "+cars.size());
        System.out.println("is empty ? :"+cars.isEmpty());
        System.out.println("Toyota present ? "+cars.contains("Toyota"));
        System.out.println("Ferrari present ? "+cars.contains("Ferrari"));

        ArrayList<String> names = new ArrayList<>();
        names.add("Gerard");
        names.add("David");
        names.add("Robert");

        ArrayList<Object> names2 = new ArrayList<>();
        names2.add("Gerard");
        names2.add("David");
        names2.add("Robert");

        System.out.println(names.equals(names2));//compare les elements entre eux dans l'ordre - les listes doivent avoir la meme taille

        //ArrayList<Integer> nums = {1,2,3,4,5}; --> pas bon, on initialise pas un ArrayList comme un Array
        /*
        -----------------------------------------------------------------------------------------------------
         */


    }
}

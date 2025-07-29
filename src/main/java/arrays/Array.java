package arrays;

import java.util.Arrays;

/*
list of elements of the same type
 */
public class Array {

    public static void main(String[] args) {
        //declaration - la taille est fixée
        int[] tab = new int[3];
        //C style declaration
        int tab2[] = new int[3];
        tab[0] = 1;
        tab[1] = 2;
        tab[2] = 3;

        //tab[5] = 1; //indexArrayOutOfBoundException
        System.out.println(Arrays.toString(tab));
        System.out.println(tab.length);

        //tableau de type differents, faisable avec la classe Object
        Object[] mixedArray = {3,5.7, 5.8F, "Cat", 'h', false};
        System.out.println("mixedArray : "+Arrays.toString(mixedArray));

        //sorting arrays
        char[] letters = {'e','b','a','f','d','c'};
        Arrays.sort(letters);
        System.out.println(letters);
        System.out.println("letters : "+Arrays.toString(letters));

        String[] words = {"3","300","20","35","37","31", "4", "70", "ant","zebra"};
        System.out.println("words : "+Arrays.toString(words));
        Arrays.sort(words);
        System.out.println("sorted words : "+Arrays.toString(words));

        //searching in arrays
        //renvoie l'index de l'element dans le tableau, marche mieux dans un tableau sorted
        System.out.println(Arrays.binarySearch(words,"300"));
        //renvoie un entier negatif si il trouve pas et pas n'importe quel entier
        //il renvoie l'indice +1 de la ou devrait se trouver l'objet si il etait dans le tableau
        System.out.println(Arrays.binarySearch(words,"toto"));

        int[] numbers = {0,2,4,6,8,10};
        System.out.println("index of 8 is : "+Arrays.binarySearch(numbers,8));

        System.out.println("index of 7 is : "+Arrays.binarySearch(numbers,7));//-5 car c'est l'index ou devrait se trouver dans le tableau si il y etait

        int[] numbersUnsorted = {0,12,4,16,18,10};
        System.out.println("index of 4 is : "+Arrays.binarySearch(numbersUnsorted,4));
        System.out.println("index of 5 is : "+Arrays.binarySearch(numbersUnsorted,5));

    }
}

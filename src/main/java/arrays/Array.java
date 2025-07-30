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

        //multidimensionnal arrays
        int[][] twoDimArray = new int[3][3];
        twoDimArray[0][0] = 0;
        twoDimArray[0][1] = 1;
        twoDimArray[0][2] = 2;
        twoDimArray[1][0] = 3;
        twoDimArray[1][1] = 4;
        twoDimArray[1][2] = 5;
        twoDimArray[2][0] = 6;
        twoDimArray[2][1] = 7;
        twoDimArray[2][2] = 8;

        //imprime les adresses des tableaux 1D contenus dans le tableau 2D
        System.out.println("twoDimArray : "+Arrays.toString(twoDimArray)); //[[I@a09ee92, [I@30f39991, [I@452b3a41]
        //solution
        System.out.println("twoDimArray : "+Arrays.toString(twoDimArray[0]));
        System.out.println("twoDimArray : "+Arrays.toString(twoDimArray[1]));
        System.out.println("twoDimArray : "+Arrays.toString(twoDimArray[2]));

        //declarer et remplir un tableau 2D
        int [][] ages = {
                {1,2,3,4,5},
                {6,7,8,9},
                {10,11,12}
        };

        //imprime les adresses des tableaux 1D contenus dans le tableau 2D
        System.out.println("ages : "+Arrays.toString(ages));
        //solution
        System.out.println("ages : "+Arrays.toString(ages[0]));
        System.out.println("ages : "+Arrays.toString(ages[1]));
        System.out.println("ages : "+Arrays.toString(ages[2]));

        //tableau 3dimension
        char threeDimArray[][][] = {//3D array
                {//1st 2d array
                        {'a','b','c'},
                        {'d','e'}
                },
                {//2nd 2d array
                        {'f','g'},
                        {'h'},
                        {'i','j','k'}
                }
        };

        //imprime les adresses des tableaux 1D contenus dans le tableau 2D
        System.out.println("threeDimArray : "+Arrays.toString(threeDimArray));
        //solution
        System.out.println("threeDimArray : "+Arrays.toString(threeDimArray[0]));//adresse des tableaux 2D
        System.out.println("threeDimArray : "+Arrays.toString(threeDimArray[1]));//adresse des tableaux 2D

        System.out.println("threeDimArray : "+Arrays.toString(threeDimArray[0][0]));
        System.out.println("threeDimArray : "+Arrays.toString(threeDimArray[0][1]));

        System.out.println("threeDimArray : "+Arrays.toString(threeDimArray[1][0]));
        System.out.println("threeDimArray : "+Arrays.toString(threeDimArray[1][1]));
        System.out.println("threeDimArray : "+Arrays.toString(threeDimArray[1][2]));
    }
}

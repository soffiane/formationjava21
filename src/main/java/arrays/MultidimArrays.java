package arrays;

import java.util.Arrays;

public class MultidimArrays {
    public static void main(String[] args) {
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
        System.out.println("twoDimArray : "+ Arrays.toString(twoDimArray)); //[[I@a09ee92, [I@30f39991, [I@452b3a41]
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
        char[][][] threeDimArray = {//3D array
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

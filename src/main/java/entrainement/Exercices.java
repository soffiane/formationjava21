package entrainement;

import java.util.Arrays;

public class Exercices {

    public static void main(String[] args) {
        byte b1 = 5;
        byte b2 = 4;
        //le produit de 2 bytes est un int pour eviter un overflow
        int i = b1 * b2;

        boolean a = false, b = false;
        //A && B = false - num1 ^ num2 exclusive or pour les bits : num1 et num2 different, result 1 sinon 0
        a = (a && b) ^ (b = true);
        System.out.println(a + "," + b);

        //% prioritaire puis */ puis +-
        int result = 4 + 9 / 3 % 6 * 4 - 2;// 9/3 =3, 3%6 =3, 3*4 =12 -2 = 10 +4 =14
        System.out.println("result = " + result);

        //on ne peut pas assigner un int dans un booleen
        //on va plutot mettre true ou false
        /*boolean bool1 = 0;
        boolean bool2 = 1;
        System.out.println(bool1 + bool2);*/

        //on peut additionner des int et des char via leur code ASCII
        int i1 = (int) 10; //line 4
        System.out.println('c' + 'a' + i1); //97 + 99 + 10 = 206

        int x = 21;
        x++;
        System.out.println(x + " " + x % 5);

        //Integer nums3[] = new Array[3];

        int[] i2 = new int[4]; //line 4
        short[] i3 = new short[]{'a', 'b', 'c', 'd'}; //line 5
        //on ne peut pas mettre un tableau d'un type dans un tableau d'un autre type
        //i2 = i3; //line 6
        System.out.println(Arrays.toString(i2));

        /* pas d'expressions dans le case du switch que des variables ou des constantes
        attention a la presence du break ou pas dans les cases
        switch (x){
            default: System.out.print("Good");
            case 1:System.out.print(" Lucks");
            case x++:System.out.println(" Java Developers");break;
         }
         */

        String[] names = {"Alice", "Joe", "Foe", "Kim"};
        //on ne sort jamais du for car on a pas le j++ pour la condition de sortie
        //mais on a pas de Unreachable code error bien que le sout ne soit pas atteignable ici
        for (int j = 1; j < 3; ) {
        }
        System.out.print(names[3] + " ");

        //piege : le num++ ne sert a rien puisqu'il est defini dans le for et pas mis a jour dedans
        //donc num reste a 1 tout le temps
        for (int num = 1; num < 3; ) {
            System.out.print(num + " ");
            num = num++;
        }

    }
}

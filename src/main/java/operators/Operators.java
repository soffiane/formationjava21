package operators;

/*
+= , -=, /=, *=, %=
 */
public class Operators {

    public static void main(String[] args) {
        double number = 7.6;
        boolean isCheck = true;
        //changer le polarite d'un nombre, pre ou post incrementation/decrementation
        System.out.println("number : "+number);
        System.out.println("-number : "+ -number);
        System.out.println("++number : "+ ++number);
        System.out.println("--number : "+ --number);
        System.out.println("number++ : "+ number++);
        System.out.println("number-- : "+ number--);
        System.out.println("!isCheck : "+ !isCheck);


        //egalité et relational
        //== equal to
        //!= not equal to
        //> ou < greater or smaller
        // >= ou <= greater or equal | smaller or equal
        //renvoie true ou false

        //conditional operators
        //bool algebra
        // num1 && num2 -> and -> true if num1 and num2 are true
        // num1 || num2 -> or -> true if num1 or num2 is true
        //operateur ternaire : num1 ? num2 : c, if num1 true then num2, if num1 false then c

        //bitwise et bitshift

        System.out.println("& and pour les bits : 0 & 0 = 0, 0 & 1 = 0, 1 & 1 = 1");
        int num1 = 8; //1000
        int num2 = 9; //1001
        System.out.println("num1 & num2 : "+(num1&num2)); //8
        System.out.println("num1 & num2 : "+Integer.toBinaryString(num1&num2)); //1000

        int num3 = 5; //0101
        int num4 = 10; //1010
        System.out.println("num3 & num4 : "+(num3&num4)); //0
        System.out.println("num3 & num4 : "+Integer.toBinaryString(num3&num4)); //0

        System.out.println("num1 | num2 inclusive or pour les bits : 0 | 0 = 0 sinon 1");
        System.out.println("num1 | num2 : "+(num1|num2)); //9
        System.out.println("num1 | num2 : "+Integer.toBinaryString(num1|num2)); //1001

        System.out.println("num3 | num4 : "+(num3|num4)); //15
        System.out.println("num3 | num4 : "+Integer.toBinaryString(num3|num4)); //1111

        System.out.println("num1 ^ num2 exclusive or pour les bits : num1 et num2 different, result 1 sinon 0");
        System.out.println("num1 ^ num2 : "+(num1^num2)); //1
        System.out.println("num1 ^ num2 : "+Integer.toBinaryString(num1^num2)); //1

        System.out.println("num3 ^ num4 : "+(num3^num4)); //15
        System.out.println("num3 ^ num4 : "+Integer.toBinaryString(num3^num4)); //1111

        /*
        exemple : int num = 33; en bit ca donne 0010 0001 -> on inverse : 1101 1110 soit 222 en decimal
        mais comme on est sur du 32 bits, le tild va aussi inverser les 24 premiers bits en mettant des 1
        soit 1111 1111 1111 1111 1111 1111 1101 1110 ce qui donne -34 et pas 222 (222 - 256)
        parce que int est sur 8 octets
         */
        System.out.println("~ inverse les bits");
        System.out.println(~num1);
        System.out.println(Integer.toBinaryString(~num1));
        System.out.println(~num3);
        System.out.println(Integer.toBinaryString(~num3));

        System.out.println("<< left shift : decalage de bit num1 gauche");
        System.out.println("num3 : "+num3);
        System.out.println("num3 : "+Integer.toBinaryString(num3));
        System.out.println("num3 << 2 :"+(num3 << 2));
        System.out.println("num3 << 2 :"+Integer.toBinaryString(num3 << 2));

        System.out.println(">> right shift : decalage de bit num1 droite");
        System.out.println("num3 : "+num3);
        System.out.println("num3 : "+Integer.toBinaryString(num3));
        System.out.println("num3 >> 2 :"+(num3 >> 2));
        System.out.println("num3 >> 2 :"+Integer.toBinaryString(num3 >> 2));

        //les operateurs ont une priorité comme en math
        //dans l'ordre
        //unary + - ++ -- !
        //multiplication */%
        //addition +-
        //comparaison < <= > >=
        //egalité == !=
        //conditionnal and &&
        //conditional or ||
        //ternary ?:
        //assignment = += -= *= /= %=

        int x = 8, y = 4, z = 2, sum =0;
        sum = x + --y + --z;
        System.out.println("sum : "+sum);//12
    }
}

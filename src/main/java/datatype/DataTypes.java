package datatype;

/**
 * le type definit la place memoire occupée par une variable
 * java est fortement typée, typage statique (sauf avec le mot clé var)
 * byte, short,int, long, float, double, char, boolean -> types primitifs
 * 8 bits (1 byte) -127/128, 16 bits, -32768/32767, 32 bits -2^31, 2^31 -1, 64 bits -2^63, 2^63 -1, float : 32 bits , 32-bit floating point, double 64bits, floating type
 * char 16 bits unicode chars
 * Boolean, Character, Integer, Floating Point
 */
public class DataTypes {

    public static void main(String[] args) {
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 4;
        float g = 9876.1234F;

        char a = 'a';
        char c = 65;
        boolean bool = true;
        float f = 1.2F;
        long l1 = 987654321L;
        long l2 = 2_000_000_000_000L;
        double d = 1.2;

        var v = 1;
        v = 'a';
        System.out.println(c);

        i = (byte) b;

        byte b2 = (byte) 1000; //overflow
        System.out.println(b2);

        //risque de perte d'info lors de conversion
        //autoboxing/unboxing primitive <-> wrapper type

        //les nombres peuvent etre stockés au format binaire en java = base 2
        int numb = 0b1101;//13
        // et en octal = base 8
        int num0 = 015;//13
        //ou en hexa = base 16
        int numx = 0xD;//13
        //addition en octal = IDE propose la conversion en hexa
        int sumOctal = 015 + 0104;
        System.out.println(sumOctal);
        System.out.println(Integer.toOctalString(sumOctal));

        //Hexadecimal
        int hex1 = 0x1B0;//432
        System.out.println(hex1);
        int hex2 = 0X2F;//
        System.out.println(Integer.toHexString(hex1+hex2));
        System.out.println(hex1+hex2);

        //binaire
        int bin1 = 0b1001;//432
        System.out.println(bin1);
        int bin2 = 0b1011;//
        System.out.println(bin2);
        System.out.println(Integer.toBinaryString(bin1+bin2));
        System.out.println(bin1+bin2);

        //Conversion et cast
        //on peut mettre un petit type dans un grand sans probleme, l'inverse provoque une erreur de compilation ---> il faut forcer le cast
        double a1;
        int b1 = 20;
        a1=b1;

        //risque de perte de données avec un cast
        double a2 = 20;
        int b3;
        b3 = (int) a2;

        //char
        // peut etre un char ou un int - table ASCII -> 0 - 65535
        char c1 = '5'; //53 dans la table ASCII
        System.out.println(c1);
        System.out.println("is a letter ? "+Character.isLetter(c1));
        System.out.println("is a digit ? "+Character.isDigit(c1));

        char c2 = 'H'; //72 dans la table ASCII
        System.out.println(c2);
        System.out.println("is a letter ? "+Character.isLetter(c2));
        System.out.println("is a digit ? "+Character.isDigit(c2));

        char c3 = 65; //A dans la table ASCII
        System.out.println(c3);
        System.out.println("is a letter ? "+Character.isLetter(c3));
        System.out.println("is a digit ? "+Character.isDigit(c3));

        //on peut faire des operations sur les char vu que ce sont aussi des entiers
        char letter1 = 67; //C
        char letter2 = (char) (letter1 + 3);
        System.out.println("letter 2 is : "+letter2);//F

        //on peut faire des comparaisons
        char letter3 = 70;//F
        char letter4 = letter3--;
        boolean check1 = letter4 == 'E';
        boolean check2 = letter4 == 69;
        boolean check3 = letter3 > 'D';

        System.out.println("letter3 : "+letter3);
        System.out.println("letter4 : "+letter4);

        System.out.println("check1 : "+check1);
        System.out.println("check2 : "+check2);
        System.out.println("check3 : "+check3);





    }
}

package org.example;

//IEEE 754
public class PrimTypes {

    public static void main(String[] args){
        byte b =1;
        short s =2;
        int i =3;
        long l =4;

        char a = 'a';
        char c = 65;
        boolean bool = true;
        float f = 1.2F;
        long l2 = 2_000_000_000_000L;
        double d = 1.2;

        var v = 1;
        v = 'a';
        System.out.println(c);

        i=(byte)b;

        byte b2 = (byte)1000; //overflow
        System.out.println(b2);

        //risque de perte d'info lors de conversion
        //autoboxing/unboxing primitive <-> wrapper type
    }
}

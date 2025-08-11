package string;

import java.util.Arrays;

/**
 * toUpperCase() toLowerCase() length() concat() equals()
 * isEmpty() indexOf() substring() equalsIgnoreCase() charAt()
 * startsWith() endsWith() trim() contains()
 */
public class UsefullMethods {
    public static void main(String[] args) {
        String s1 = "Hello Java Developpers";
        String s2 = "java is fun";
        System.out.println("s1 length "+s1.length());
        System.out.println("s1 char at 0 "+s1.charAt(0));//StringIndexOutOfBoundException si on sort du String
        System.out.println("s1 char at end "+s1.charAt(s1.length() -1));
        System.out.println("s1 e emplacement "+s1.indexOf('e'));//ne trouve que le premier
        System.out.println("s1 e emplacement "+s1.indexOf('e',8));
        System.out.println("Empty ? "+s1.isEmpty());
        System.out.println("substring "+ s1.substring(6));
        System.out.println("substring "+ s1.substring(6,10));
        System.out.println("equals ? "+s1.equals(s2));
        System.out.println("concat "+s1.concat(" "+s2));
        System.out.println("lower case "+s1.toLowerCase());
        System.out.println("upper case "+s1.toUpperCase());
        System.out.println("trim "+s1.trim());
        System.out.println("contains "+s1.contains("Java"));
        System.out.println("replace "+s1.replace('l','L'));
        System.out.println("starts with "+s1.startsWith("Hello"));
        System.out.println("ends with "+s1.endsWith("s"));
        String[] s3 = s1.split(" ");
        System.out.println("split "+ Arrays.toString(s3));
    }
}

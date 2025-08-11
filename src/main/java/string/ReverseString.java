package string;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a string : ");
        String string = scanner.nextLine();
        int length = string.length();

        String reversedString = "";
        for(int i = length -1; i>=0;i--){
            reversedString += string.charAt(i);
        }
        System.out.println("reverse string is : "+reversedString);
        scanner.close();
    }
}

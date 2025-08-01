package controlflow;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------- CALCULATOR -------------------");
        System.out.println("Enter 2 numbers : ");
        int num1= input.nextInt();
        int num2 = input.nextInt();
        System.out.println("Choose an operator (+, -, *, /, %) : ");
        char operator = input.next().charAt(0);
        double result = 0.0;

        switch (operator){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            case '%':
                result = num1%num2;
                break;//just exit the switch
            default :
                System.out.println("Invalid operator");
                return; //terminate the current method
        }

        input.close();

        System.out.println("Result is : "+result);
    }
}

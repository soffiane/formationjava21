package lambdas;

import java.util.Scanner;

@FunctionalInterface
interface Operation{
    void performOperation(double x, double y);
}

class Calculator {
    public void calculate(double x, double y, Operation operation){
        operation.performOperation(x,y);
    }
}

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number : ");
        double x = scanner.nextInt();
        System.out.println("Enter second number : ");
        double y = scanner.nextInt();

        Calculator calculator = new Calculator();
        calculator.calculate(x,y,(x1, y1) -> {
            System.out.println("addition : "+(x+y));
            System.out.println("soustraction : "+(x-y));
            System.out.println("multiplication : "+(x*y));
            System.out.println("modulo : "+(x%y));

            if(y == 0){
                System.out.println("Cant divide by 0");
            } else {
                System.out.println("division : "+(x/y));
            }
        });

    }
}

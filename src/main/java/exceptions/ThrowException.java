package exceptions;

import java.util.Scanner;

public class ThrowException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("first int ");
        double d = scanner.nextDouble();
        System.out.println("second int ");
        double d2 = scanner.nextDouble();
        double result = 0.0;
        try {
            result = divide(d, d2);
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("result is " + result);
        scanner.close();
    }

    public static double divide(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("y cant be 0");
        }
        return x / y;
    }

}

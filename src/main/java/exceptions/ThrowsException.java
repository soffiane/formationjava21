package exceptions;

public class ThrowsException {

    public static void main(String[] args) {
        try {
            divide();
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format");
        } catch (ArithmeticException e){
            System.err.println("Cannot divide by 0");
        }
    }

    public static void divide() throws NumberFormatException, ArithmeticException{
        int a = Integer.parseInt("8b");
        int b = Integer.parseInt("0");
        int c = a / b;
        System.out.println("c "+c);
    }
}

package exercise;

import java.util.Scanner;

/*
Create a Customer class.
Define two local instance named "firstName" and "lastName"
Create a method with String return type. Its name will be "getFullName"
This method will take the firstName and lastName from the user using the Scanner.
And lastly, this method should return the full name of the customer.
 */
public class Customer {
    private String firstName;
    private String lastName;

    public String getFullName(String firstName, String lastName){
        return firstName+" "+lastName;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter first name :");
        String firstName = scanner.next();
        System.out.println("Please enter last name :");
        String lastName = scanner.next();
        Customer customer = new Customer();
        System.out.println(customer.getFullName(firstName, lastName));
    }
}


package exceptions.bankaccountbalance;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Scanner input = new Scanner(System.in);
        int choice;

        do{
            System.out.println("---------------BANK ACCOUNT MENU ------------------");
            System.out.println("1 - Deposit");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Show balance");
            System.out.println("4 - Quit");
            System.out.println("Select an option :");
            choice = input.nextInt();

            switch (choice){
                case 1 :
                    System.out.println("How much u want to deposit ?");
                    bankAccount.deposit(input.nextInt());
                    break;
                case 2 :
                    System.out.println("How much u want to withdraw ?");
                    try {
                        bankAccount.withdraw(input.nextInt());
                    } catch (InsufficientFoundException e) {
                        System.err.println(e.toString());
                    }
                    break;
                case 3 :
                    System.out.println("Current balance "+bankAccount.getBalance());
                    break;
                case 4 :
                    System.out.println("Goodbye");
                    return;
                default:
                    System.out.println("choose between 1 and 4 u madafaka");
            }
        } while(choice >= 1 && choice <=3);
    }
}

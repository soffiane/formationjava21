package toolsandtesting;

import exceptions.bankaccountbalance.InsufficientFoundException;

public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public synchronized void deposit(double amount) {

        balance += amount;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}

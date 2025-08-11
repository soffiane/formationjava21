package exceptions.bankaccountbalance;

public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFoundException {
        if (balance < amount) {
            throw new InsufficientFoundException("Not enough money");
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

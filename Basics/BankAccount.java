/**
 * BankAccount.java
 *
 * Demonstrates basic object-oriented programming concepts in Java:
 * - Defining a class with fields (instance variables)
 * - Using constructors to initialize objects
 * - Implementing methods for behavior (deposit, withdraw)
 * - Using encapsulation with getters and setters
 *
 * Author: Darshan P
 */

public class BankAccount {
    // Instance variables (fields)
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". Remaining balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    // Getter for balance (example of encapsulation)
    public double getBalance() {
        return balance;
    }

    // Display account details
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }

    // Main method to test the class
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Alice", "A12345", 500.00);
        account1.displayAccountInfo();
        account1.deposit(150.00);
        account1.withdraw(100.00);
        account1.displayAccountInfo();
    }
}

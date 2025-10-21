import java.util.ArrayList;
import java.util.Scanner;

// Expense class to store individual expense details
class Expense {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Category: " + category + ", Amount: $" + amount;
    }
}

// Main class for managing expenses
public class ExpenseTracker {
    private ArrayList<Expense> expenses;
    private Scanner scanner;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add a new expense
    public void addExpense() {
        System.out.print("Enter category (e.g., Food, Transport, Bills): ");
        String category = scanner.nextLine();

        System.out.print("Enter amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume leftover newline

        Expense newExpense = new Expense(category, amount);
        expenses.add(newExpense);
        System.out.println("Expense added successfully.");
    }

    // Method to show all expenses
    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("All Expenses:");
            for (Expense exp : expenses) {
                System.out.println(exp);
            }
        }
    }

    // Method to show total expenses
    public void viewTotalExpenses() {
        double total = 0;
        for (Expense exp : expenses) {
            total += exp.amount;
        }
        System.out.printf("Total Expenses: $%.2f%n", total);
    }

    // Menu for interacting with the expense tracker
    public void showMenu() {
        int choice;
        do {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    viewTotalExpenses();
                    break;
                case 4:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select from the menu.");
            }
        } while (choice != 4);
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.showMenu();
    }
}

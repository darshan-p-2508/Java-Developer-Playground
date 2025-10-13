import java.util.Scanner;

/**
 * A simple calculator program that performs basic arithmetic operations 
 * like addition, subtraction, multiplication, and division.
 * The program allows users to perform multiple calculations until they choose to exit.
 */
public class SimpleCalculator {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Display a welcome message
        System.out.println("Welcome to Simple Calculator!");

        // Run the calculator in a loop, allowing the user to perform multiple operations
        while (true) {
            // Display the operation menu to the user
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");

            // Read the user's choice of operation
            int choice = scanner.nextInt();

            // Check if the user wants to exit the program
            if (choice == 5) {
                System.out.println("Thank you for using the calculator. Goodbye!");
                break; // Exit the loop and terminate the program
            }

            // Ask the user to enter two numbers for the calculation
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            // Perform the selected operation
            double result = 0; // Variable to store the result
            switch (choice) {
                case 1:
                    result = num1 + num2;
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                    break;
                case 4:
                    // Handle division, check for division by zero
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("Result: " + result);
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                    break;
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice. Please select a valid operation.");
            }
        }

        // Close the scanner object to prevent resource leak
        scanner.close();
    }
}

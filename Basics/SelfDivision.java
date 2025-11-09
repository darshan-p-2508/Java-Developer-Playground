/**
 * SafeDivision.java
 * 
 * Demonstrates basic Exception Handling in Java.
 * Uses try-catch-finally and includes a custom exception for division by zero.
 */

import java.util.Scanner;

// Custom exception for handling division by zero
class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

public class SafeDivision {
    
    // Method that performs division and throws a custom exception if denominator is zero
    public static double divide(double numerator, double denominator) throws DivisionByZeroException {
        if (denominator == 0) {
            throw new DivisionByZeroException("Error: Cannot divide by zero!");
        }
        return numerator / denominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking user input for numerator and denominator
            System.out.print("Enter numerator: ");
            double num = scanner.nextDouble();

            System.out.print("Enter denominator: ");
            double den = scanner.nextDouble();

            // Try performing division
            double result = divide(num, den);
            System.out.println("Result = " + result);

        } catch (DivisionByZeroException e) {
            // Custom exception handling
            System.out.println(e.getMessage());

        } catch (Exception e) {
            // Handles any other unexpected exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());

        } finally {
            // Code in finally block always runs — great for cleanup
            scanner.close();
            System.out.println("Execution completed. Resources closed.");
        }
    }
}

/**
 * NumberConverter.java
 * --------------------
 * A simple console-based Number Converter program in Java.
 * 
 * Features:
 *  - Convert Decimal to Binary and Hexadecimal
 *  - Convert Binary or Hexadecimal to Decimal
 *  - Handles invalid inputs gracefully
 *
 * Author: [Your Name]
 * GitHub: [Your GitHub URL]
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("        NUMBER CONVERTER TOOL");
        System.out.println("========================================");

        boolean exit = false;

        // Main program loop
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Decimal to Binary");
            System.out.println("2. Decimal to Hexadecimal");
            System.out.println("3. Binary to Decimal");
            System.out.println("4. Hexadecimal to Decimal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice;
            try {
                choice = scanner.nextInt();  // Get user menu choice
            } catch (InputMismatchException e) {
                // Handle non-integer input for menu
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                scanner.next(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter a decimal number: ");
                    try {
                        int decimal = scanner.nextInt();
                        // Convert decimal to binary using Integer.toBinaryString()
                        String binary = Integer.toBinaryString(decimal);
                        System.out.println("Binary equivalent: " + binary);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a valid decimal number.");
                        scanner.next();
                    }
                }
                case 2 -> {
                    System.out.print("Enter a decimal number: ");
                    try {
                        int decimal = scanner.nextInt();
                        // Convert decimal to hexadecimal using Integer.toHexString()
                        String hex = Integer.toHexString(decimal).toUpperCase();
                        System.out.println("Hexadecimal equivalent: " + hex);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a valid decimal number.");
                        scanner.next();
                    }
                }
                case 3 -> {
                    System.out.print("Enter a binary number: ");
                    String binary = scanner.next();
                    try {
                        // Parse binary string to decimal using Integer.parseInt with radix 2
                        int decimal = Integer.parseInt(binary, 2);
                        System.out.println("Decimal equivalent: " + decimal);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid binary number! Please enter a valid binary (only 0s and 1s).");
                    }
                }
                case 4 -> {
                    System.out.print("Enter a hexadecimal number: ");
                    String hex = scanner.next();
                    try {
                        // Parse hexadecimal string to decimal using radix 16
                        int decimal = Integer.parseInt(hex, 16);
                        System.out.println("Decimal equivalent: " + decimal);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid hexadecimal number! Please enter valid hex digits (0-9, A-F).");
                    }
                }
                case 5 -> {
                    // Exit the program
                    System.out.println("Exiting program... Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice! Please choose between 1 and 5.");
            }
        }

        scanner.close();
    }
}

import java.util.Scanner;
import java.util.Random;

/**
 * A simple Number Guessing Game in Java.
 * 
 * The game generates a random number between 1 and 100, and the user must guess
 * the number. After each guess, the program will provide feedback if the guess is
 * too high, too low, or correct. The game continues until the user guesses the 
 * number correctly.
 * 
 * Darshan P
 */
public class NumberGuessingGame {
    
    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Create a random object to generate random numbers
        Random random = new Random();
        
        // Generate a random number between 1 and 100
        int numberToGuess = random.nextInt(100) + 1;
        
        // Initialize variables
        int userGuess = 0;
        int numberOfAttempts = 0;
        
        // Welcome message
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");
        
        // Game loop: keep asking for guesses until the user guesses correctly
        while (userGuess != numberToGuess) {
            // Prompt the user to enter a guess
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            numberOfAttempts++;
            
            // Check if the guess is too high, too low, or correct
            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } 
            else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } 
            else {
                // The guess is correct
                System.out.println("Congratulations! You guessed the number.");
                System.out.println("It took you " + numberOfAttempts + " attempts.");
            }
        }
        
        // Close the scanner object to prevent resource leak
        scanner.close();
    }
}

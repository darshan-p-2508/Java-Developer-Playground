import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        // Create a scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Ask for user's name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Ask for user's age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Calculate next year's age
        int nextYearAge = age + 1;

        // Output a personalized greeting
        System.out.println("Hello, " + name + "!");  // String concatination using '+'
        System.out.println("You are currently " + age + " years old.");
        System.out.println("Next year, you will be " + nextYearAge + " years old.");
        
        // Always the best practice to close the scanner to avoid memory leaks
        scanner.close();
    }
}

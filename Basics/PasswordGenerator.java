import java.util.Random;
import java.util.Scanner;

/**
 * A console-based password generator in Java.
 * Users can customize:
 * - Length of the password
 * - Whether to include uppercase letters, lowercase letters, digits, and special characters
 */
public class PasswordGenerator {

    // Character pools for different types
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{};:,.<>?/";

    /**
     * The main method where the program starts.
     * Accepts user preferences and generates a random password.
     *
     * @param args Command-line arguments (not used here).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔐 Welcome to the Password Generator!");

        // Get desired password length
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();

        // Ask for character type preferences
        boolean useUppercase = getUserChoice(scanner, "Include uppercase letters (A-Z)? (yes/no): ");
        boolean useLowercase = getUserChoice(scanner, "Include lowercase letters (a-z)? (yes/no): ");
        boolean useDigits = getUserChoice(scanner, "Include digits (0-9)? (yes/no): ");
        boolean useSpecial = getUserChoice(scanner, "Include special characters (!@#$...) ? (yes/no): ");

        // Generate password
        String password = generatePassword(length, useUppercase, useLowercase, useDigits, useSpecial);

        if (password != null) {
            System.out.println("\n🔑 Generated Password: " + password);
        } else {
            System.out.println("❌ Error: You must select at least one character type.");
        }

        scanner.close();
    }

    /**
     * Asks the user a yes/no question and returns their choice as a boolean.
     *
     * @param scanner Scanner object to read input.
     * @param message Prompt message to display.
     * @return true if user inputs "yes", false otherwise.
     */
    private static boolean getUserChoice(Scanner scanner, String message) {
        System.out.print(message);
        String input = scanner.next().trim().toLowerCase();
        return input.equals("yes") || input.equals("y");
    }

    /**
     * Generates a random password based on the given options.
     *
     * @param length       Desired password length.
     * @param useUppercase Include uppercase letters.
     * @param useLowercase Include lowercase letters.
     * @param useDigits    Include numerical digits.
     * @param useSpecial   Include special characters.
     * @return A randomly generated password as a String, or null if no character types were selected.
     */
    public static String generatePassword(int length, boolean useUppercase, boolean useLowercase,
                                          boolean useDigits, boolean useSpecial) {
        StringBuilder characterPool = new StringBuilder();

        // Add selected character sets to the pool
        if (useUppercase) characterPool.append(UPPERCASE);
        if (useLowercase) characterPool.append(LOWERCASE);
        if (useDigits) characterPool.append(DIGITS);
        if (useSpecial) characterPool.append(SPECIAL_CHARS);

        // If no character types were selected, return null
        if (characterPool.length() == 0) {
            return null;
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Randomly pick characters from the pool
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
}

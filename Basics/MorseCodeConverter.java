import java.util.Scanner;

public class MorseCodeConverter {

    // Morse code chart
    private static final String[] MORSE_CODE = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };
    
    // Normal alphabet
    private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * Converts normal text to Morse code.
     * @param text The normal text string to be converted.
     * @return The Morse code representation of the input text.
     */
    public static String textToMorse(String text) {
        text = text.toUpperCase(); // Convert text to uppercase
        StringBuilder morse = new StringBuilder();
        
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                morse.append(" / "); // Space between words
            } else {
                int index = getIndexOfChar(c);
                if (index != -1) {
                    morse.append(MORSE_CODE[index]).append(" ");
                }
            }
        }
        return morse.toString().trim();
    }

    /**
     * Converts Morse code to normal text.
     * @param morse The Morse code string to be converted.
     * @return The normal text representation of the input Morse code.
     */
    public static String morseToText(String morse) {
        String[] morseArray = morse.split(" ");
        StringBuilder text = new StringBuilder();
        
        for (String morseChar : morseArray) {
            if (morseChar.equals("/")) {
                text.append(" "); // Space between words
            } else {
                char decodedChar = getCharFromMorse(morseChar);
                if (decodedChar != 0) {
                    text.append(decodedChar);
                }
            }
        }
        return text.toString();
    }

    // Helper method to get the index of a character in the alphabet.
    private static int getIndexOfChar(char c) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (ALPHABET[i] == c) {
                return i;
            }
        }
        return -1;
    }

    // Helper method to get the character from a Morse code string.
    private static char getCharFromMorse(String morse) {
        for (int i = 0; i < MORSE_CODE.length; i++) {
            if (MORSE_CODE[i].equals(morse)) {
                return ALPHABET[i];
            }
        }
        return 0; // Return null character if not found.
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Morse Code Converter");
        System.out.println("1. Convert normal text to Morse code");
        System.out.println("2. Convert Morse code to normal text");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice == 1) {
            // Convert normal text to Morse code
            System.out.print("Enter the text to convert to Morse code: ");
            String text = scanner.nextLine();
            String morse = textToMorse(text);
            System.out.println("Morse Code: " + morse);
        } else if (choice == 2) {
            // Convert Morse code to normal text
            System.out.print("Enter the Morse code to convert to normal text (use spaces between letters and '/' between words): ");
            String morse = scanner.nextLine();
            String text = morseToText(morse);
            System.out.println("Normal Text: " + text);
        } else {
            System.out.println("Invalid choice! Please restart the program and choose either 1 or 2.");
        }
        
        scanner.close();
    }
}

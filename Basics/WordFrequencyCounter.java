/**
 * WordFrequencyCounter.java
 *
 * A simple Java program that counts the frequency of each word in a given string.
 * It ignores punctuation and is case-insensitive.
 *
 * Author: Darshan P
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {

    /**
     * Cleans the input text by removing punctuation and converting it to lowercase.
     *
     * @param text The input string to be cleaned.
     * @return A cleaned version of the input string.
     */
    public static String cleanText(String text) {
        return text.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
    }

    /**
     * Counts the frequency of each word in a given string.
     *
     * @param text The input text to analyze.
     * @return A map containing words as keys and their frequency as values.
     */
    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        String[] words = cleanText(text).split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        return frequencyMap;
    }

    /**
     * The main method — entry point of the program.
     * It takes input from the user and displays word frequencies.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a paragraph of text:");
        String inputText = scanner.nextLine();

        Map<String, Integer> result = countWordFrequency(inputText);

        System.out.println("\nWord Frequency:");
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        scanner.close();
    }
}

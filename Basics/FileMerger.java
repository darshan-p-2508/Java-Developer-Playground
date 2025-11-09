/**
 * FileMerger.java
 * 
 * Demonstrates basic File I/O in Java using java.io package.
 * Reads two text files and merges their content into a third file.
 */

import java.io.*;

public class FileMerger {
    public static void main(String[] args) {
        // Names of input and output files
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        String outputFile = "merged_output.txt";

        // Try-with-resources automatically closes streams
        try (
            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            BufferedReader reader2 = new BufferedReader(new FileReader(file2));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;

            // Read first file line by line and write to output
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();  // Adds a new line after each line
            }

            // Read second file line by line and append to output
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Files merged successfully into " + outputFile);

        } catch (FileNotFoundException e) {
            // Handles case when one of the files is missing
            System.out.println("Error: One of the input files was not found.");
        } catch (IOException e) {
            // Handles general I/O exceptions
            System.out.println("Error while reading or writing files: " + e.getMessage());
        }
    }
}

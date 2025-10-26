/**
 * NotesApp.java
 * 
 * A simple console-based Notes Manager application.
 * 
 * Features:
 *  - Create, view, search, and delete notes.
 *  - Notes are stored in a text file for persistence.
 * 
 * Demonstrates:
 *  - File I/O in Java
 *  - Object-oriented programming concepts
 *  - Collections (ArrayList)
 *  - Basic user input handling
 * 
 * Author: Darshan P
 */

import java.io.*;
import java.util.*;

class Note {
    private String title;
    private String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }

    @Override
    public String toString() {
        return "Title: " + title + "\nContent: " + content + "\n";
    }
}

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";
    private static ArrayList<Note> notes = new ArrayList<>();

    public static void main(String[] args) {
        loadNotes();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Add Note");
            System.out.println("2. View All Notes");
            System.out.println("3. Search Notes");
            System.out.println("4. Delete Note");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addNote(sc);
                case 2 -> viewNotes();
                case 3 -> searchNotes(sc);
                case 4 -> deleteNote(sc);
                case 5 -> saveNotes();
                default -> System.out.println("Invalid choice, try again.");
            }
        } while (choice != 5);

        sc.close();
        System.out.println("Exiting Notes App. Goodbye!");
    }

    private static void addNote(Scanner sc) {
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter content: ");
        String content = sc.nextLine();
        notes.add(new Note(title, content));
        System.out.println("Note added successfully!");
    }

    private static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
        } else {
            notes.forEach(System.out::println);
        }
    }

    private static void searchNotes(Scanner sc) {
        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Note note : notes) {
            if (note.getTitle().toLowerCase().contains(keyword) || 
                note.getContent().toLowerCase().contains(keyword)) {
                System.out.println(note);
                found = true;
            }
        }

        if (!found) System.out.println("No notes found with that keyword.");
    }

    private static void deleteNote(Scanner sc) {
        System.out.print("Enter title of note to delete: ");
        String title = sc.nextLine();
        boolean removed = notes.removeIf(n -> n.getTitle().equalsIgnoreCase(title));

        if (removed)
            System.out.println("Note deleted successfully!");
        else
            System.out.println("Note not found.");
    }

    private static void loadNotes() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("::", 2);
                if (parts.length == 2)
                    notes.add(new Note(parts[0], parts[1]));
            }
        } catch (IOException e) {
            System.out.println("No saved notes found. Starting fresh.");
        }
    }

    private static void saveNotes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Note n : notes) {
                bw.write(n.getTitle() + "::" + n.getContent());
                bw.newLine();
            }
            System.out.println("Notes saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving notes: " + e.getMessage());
        }
    }
}

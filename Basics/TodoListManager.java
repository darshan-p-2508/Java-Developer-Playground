import java.util.ArrayList;
import java.util.Scanner;

/**
 * TodoListManager.java
 *
 * A simple command-line To-Do List application that allows users to:
 * - Add new tasks
 * - View all tasks
 * - Delete tasks by index
 * - Exit the application
 *
 * This program demonstrates the use of ArrayLists, user input handling,
 * conditionals, loops, and basic program structure in Java.
 *
 * Author: Darshan P
 */
public class TodoListManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        int choice;

        while (true) {
            System.out.println("\n=== To-Do List Menu ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("Task added.");
                    break;
                case 2:
                    System.out.println("\nYour Tasks:");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter task number to delete: ");
                    int index = scanner.nextInt();
                    if (index > 0 && index <= tasks.size()) {
                        tasks.remove(index - 1);
                        System.out.println("Task deleted.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting To-Do List Manager. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Library Management System
 * 
 * This program allows you to manage a simple library system.
 * You can add books, view all books, borrow books, return books, and search for books.
 */
class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    /**
     * Constructor to initialize a book with title and author.
     * By default, the book is not borrowed.
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Getter and Setter for borrow status
    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        this.isBorrowed = true;
    }

    public void returnBook() {
        this.isBorrowed = false;
    }

    // String representation of the book
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + (isBorrowed ? " (Borrowed)" : " (Available)");
    }
}

public class LibraryManagementSystem {

    // A list to hold the collection of books
    private static ArrayList<Book> books = new ArrayList<>();

    /**
     * Adds a new book to the library.
     */
    public static void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added successfully.");
    }

    /**
     * Displays all books in the library.
     */
    public static void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    /**
     * Searches for a book by its title.
     */
    public static void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    /**
     * Allows a user to borrow a book if it is available.
     */
    public static void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isBorrowed()) {
                    book.borrowBook();
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    /**
     * Allows a user to return a borrowed book.
     */
    public static void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isBorrowed()) {
                    book.returnBook();
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("This book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    /**
     * Main method with a menu-driven interface.
     * Allows the user to interact with the system via the console.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String title, author;

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    author = scanner.nextLine();
                    addBook(title, author);
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    System.out.print("Enter Title to Search: ");
                    title = scanner.nextLine();
                    searchBook(title);
                    break;
                case 4:
                    System.out.print("Enter Title to Borrow: ");
                    title = scanner.nextLine();
                    borrowBook(title);
                    break;
                case 5:
                    System.out.print("Enter Title to Return: ");
                    title = scanner.nextLine();
                    returnBook(title);
                    break;
                case 6:
                    System.out.println("Exiting Library System...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Student Management System.
 * This program allows users to add, view, search, update, and delete student records.
 */
class Student {
    private String name;
    private int rollNumber;
    private int marks;

    // Constructor to initialize student details
    public Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", Marks: " + marks;
    }
}

/**
 * Main class for the Student Management System.
 */
public class StudentManagementSystem {

    private static ArrayList<Student> students = new ArrayList<>();

    /**
     * Adds a new student to the system.
     * 
     * @param name Name of the student
     * @param rollNumber Roll number of the student
     * @param marks Marks obtained by the student
     */
    public static void addStudent(String name, int rollNumber, int marks) {
        Student newStudent = new Student(name, rollNumber, marks);
        students.add(newStudent);
        System.out.println("Student added successfully.");
    }

    /**
     * Displays all the students in the system.
     */
    public static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    /**
     * Searches for a student by roll number.
     * 
     * @param rollNumber Roll number of the student to search for
     */
    public static void searchStudentByRollNumber(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    /**
     * Updates the marks of a student.
     * 
     * @param rollNumber Roll number of the student
     * @param marks New marks for the student
     */
    public static void updateStudentMarks(int rollNumber, int marks) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.setMarks(marks);
                System.out.println("Student marks updated successfully.");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    /**
     * Deletes a student from the system.
     * 
     * @param rollNumber Roll number of the student to delete
     */
    public static void deleteStudent(int rollNumber) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == rollNumber) {
                students.remove(i);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    /**
     * Main method to run the Student Management System.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter Marks: ");
                    int marks = scanner.nextInt();
                    addStudent(name, rollNumber, marks);
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    System.out.print("Enter Roll Number to search: ");
                    rollNumber = scanner.nextInt();
                    searchStudentByRollNumber(rollNumber);
                    break;
                case 4:
                    System.out.print("Enter Roll Number to update marks: ");
                    rollNumber = scanner.nextInt();
                    System.out.print("Enter new Marks: ");
                    marks = scanner.nextInt();
                    updateStudentMarks(rollNumber, marks);
                    break;
                case 5:
                    System.out.print("Enter Roll Number to delete: ");
                    rollNumber = scanner.nextInt();
                    deleteStudent(rollNumber);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

/**
 * JavaOOPConceptsDemo.java
 *
 * A single Java file that demonstrates the most important Core Java OOP concepts:
 *
 * 1. Classes & Objects
 * 2. Constructors
 * 3. Inheritance
 * 4. Interfaces
 * 5. Abstract Classes
 * 6. Polymorphism
 * 7. Encapsulation
 *
 * Each section contains detailed explanations and inline comments.
 */
public class JavaOOPConceptsDemo {

    // ------------------------------
    // 1. CLASSES & OBJECTS DEMO
    // ------------------------------

    /**
     * A simple class representing a Car.
     * This demonstrates CLASS & OBJECT creation.
     */
    static class Car {
        String brand;
        int year;

        /**
         * Method to display car info
         */
        void displayInfo() {
            System.out.println("Car Brand: " + brand + ", Year: " + year);
        }
    }

    // ------------------------------
    // 2. CONSTRUCTOR EXAMPLES
    // ------------------------------

    /**
     * A class showing how constructors work.
     */
    static class Person {
        String name;
        int age;

        // Default constructor
        Person() {
            this.name = "Unknown";
            this.age = 0;
        }

        // Parameterized constructor
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void show() {
            System.out.println("Person: " + name + " (" + age + ")");
        }
    }

    // ------------------------------
    // 3. INHERITANCE DEMO
    // ------------------------------

    /**
     * Parent class
     */
    static class Animal {
        void eat() {
            System.out.println("Animal eats food.");
        }
    }

    /**
     * Child class inheriting from Animal
     */
    static class Dog extends Animal {
        void bark() {
            System.out.println("Dog barks!");
        }
    }

    // ------------------------------
    // 4. INTERFACE DEMO
    // ------------------------------

    /**
     * An interface defining a contract.
     */
    interface Drivable {
        void drive(); // only method declaration, no body
    }

    /**
     * A class implementing the interface
     */
    static class Bike implements Drivable {
        @Override
        public void drive() {
            System.out.println("Bike is being driven.");
        }
    }

    // ------------------------------
    // 5. ABSTRACT CLASS DEMO
    // ------------------------------

    /**
     * Abstract class representing a shape.
     * It contains both abstract and non-abstract methods.
     */
    static abstract class Shape {
        abstract double area(); // abstract method

        void info() { // normal method
            System.out.println("Calculating area for a shape...");
        }
    }

    /**
     * Concrete class inheriting from abstract class
     */
    static class Circle extends Shape {
        double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        double area() {
            return 3.14 * radius * radius;
        }
    }

    // ------------------------------
    // 6. POLYMORPHISM DEMO
    // ------------------------------

    /**
     * Demonstrates method overriding and polymorphism.
     */
    static class Bird {
        void sound() {
            System.out.println("Bird makes a sound.");
        }
    }

    static class Sparrow extends Bird {
        @Override
        void sound() {
            System.out.println("Sparrow chirps!");
        }
    }

    static class Eagle extends Bird {
        @Override
        void sound() {
            System.out.println("Eagle screeches!");
        }
    }

    // ------------------------------
    // 7. ENCAPSULATION DEMO
    // ------------------------------

    /**
     * Encapsulation means restricting direct access to fields using private modifiers
     * and exposing them using getters and setters.
     */
    static class BankAccount {
        private double balance; // private = cannot be accessed directly

        // Getter
        public double getBalance() {
            return balance;
        }

        // Setter with validation
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }
    }

    // ------------------------------
    // MAIN METHOD TO RUN ALL DEMOS
    // ------------------------------
    public static void main(String[] args) {

        System.out.println("===== 1. Classes & Objects =====");
        Car c = new Car();
        c.brand = "Toyota";
        c.year = 2020;
        c.displayInfo();

        System.out.println("\n===== 2. Constructors =====");
        Person p1 = new Person();
        Person p2 = new Person("Alice", 25);
        p1.show();
        p2.show();

        System.out.println("\n===== 3. Inheritance =====");
        Dog d = new Dog();
        d.eat();   // inherited from Animal
        d.bark();

        System.out.println("\n===== 4. Interfaces =====");
        Drivable bike = new Bike();
        bike.drive();

        System.out.println("\n===== 5. Abstract Classes =====");
        Shape circle = new Circle(5);
        circle.info();
        System.out.println("Circle Area: " + circle.area());

        System.out.println("\n===== 6. Polymorphism =====");
        Bird b1 = new Sparrow();
        Bird b2 = new Eagle();
        b1.sound();
        b2.sound();

        System.out.println("\n===== 7. Encapsulation =====");
        BankAccount acc = new BankAccount();
        acc.deposit(500);
        System.out.println("Account Balance: " + acc.getBalance());
    }
}

/**
 * FizzBuzz Program
 * This is a basic program that prints the numbers from 1 to 100.
 * For multiples of 3, it prints "Fizz" instead of the number.
 * For multiples of 5, it prints "Buzz" instead of the number.
 * For numbers which are multiples of both 3 and 5, it prints "FizzBuzz".
 * 
 * This program demonstrates the use of loops, conditionals, and modular arithmetic.
 * 
 * Author: Darshan P
 */
public class FizzBuzz {

    public static void main(String[] args) {
        // Loop through numbers 1 to 100
        for (int i = 1; i <= 100; i++) {

            // Check if the number is divisible by both 3 and 5
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            }
            // Check if the number is divisible by 3
            else if (i % 3 == 0) {
                System.out.println("Fizz");
            }
            // Check if the number is divisible by 5
            else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            // If the number is not divisible by 3 or 5, just print the number
            else {
                System.out.println(i);
            }
        }
    }
}

import java.util.Scanner;

/**
 * TemperatureConverter class provides a simple program to convert temperatures
 * between Celsius, Fahrenheit, and Kelvin.
 * The program allows the user to choose the temperature scale they want to convert from 
 * and the scale they want to convert to.
 */
public class TemperatureConverter {

    public static void main(String[] args) {
        // Create a Scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Display the menu
        System.out.println("Temperature Converter");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Celsius to Kelvin");
        System.out.println("3. Fahrenheit to Celsius");
        System.out.println("4. Fahrenheit to Kelvin");
        System.out.println("5. Kelvin to Celsius");
        System.out.println("6. Kelvin to Fahrenheit");

        // Ask user to choose a conversion
        System.out.print("Enter your choice (1-6): ");
        int choice = scanner.nextInt();

        // Ask the user to input the temperature value
        System.out.print("Enter the temperature value: ");
        double temp = scanner.nextDouble();

        // Perform the conversion based on the user's choice
        switch (choice) {
            case 1:
                // Celsius to Fahrenheit
                double fahrenheit = (temp * 9/5) + 32;
                System.out.println(temp + "° Celsius is equal to " + fahrenheit + "° Fahrenheit.");
                break;
            case 2:
                // Celsius to Kelvin
                double kelvinFromCelsius = temp + 273.15;
                System.out.println(temp + "° Celsius is equal to " + kelvinFromCelsius + " Kelvin.");
                break;
            case 3:
                // Fahrenheit to Celsius
                double celsiusFromFahrenheit = (temp - 32) * 5/9;
                System.out.println(temp + "° Fahrenheit is equal to " + celsiusFromFahrenheit + "° Celsius.");
                break;
            case 4:
                // Fahrenheit to Kelvin
                double kelvinFromFahrenheit = (temp - 32) * 5/9 + 273.15;
                System.out.println(temp + "° Fahrenheit is equal to " + kelvinFromFahrenheit + " Kelvin.");
                break;
            case 5:
                // Kelvin to Celsius
                double celsiusFromKelvin = temp - 273.15;
                System.out.println(temp + " Kelvin is equal to " + celsiusFromKelvin + "° Celsius.");
                break;
            case 6:
                // Kelvin to Fahrenheit
                double fahrenheitFromKelvin = (temp - 273.15) * 9/5 + 32;
                System.out.println(temp + " Kelvin is equal to " + fahrenheitFromKelvin + "° Fahrenheit.");
                break;
            default:
                // Invalid choice
                System.out.println("Invalid choice! Please select a valid option from 1-6.");
                break;
        }

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}

package KI_36.Proshkin.Lab4;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class for running the expression calculation program.
 * <p>
 * The Main class is responsible for initializing the expression calculator and interacting with the user via the console.
 * The user inputs the value of x, after which the program calculates the expression and outputs the result.
 * The result is also saved to a file.
 * </p>
 *
 * @version 1.0
 */
public class Lab4ProshkinLev36 {

    /**
     * Entry point of the program. Handles user input, calculates the result of the expression,
     * and writes the result to a file.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();
        Scanner scanner = new Scanner(System.in);

        try {
            // Getting the value of x from the user
            System.out.print("Enter the value of x: ");
            String input = scanner.next();

            // Validation and calculation
            double x = calculator.validateAndParse(input);
            double result = calculator.calculate(x);

            System.out.println("Result: " + result);

            // Writing the result to a file
            String filePath = "result.txt";
            calculator.writeResultToFile(result, filePath);
            System.out.println("The result has been written to the file: " + filePath);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File write error: " + e.getMessage());
        } finally {
            // Closing the scanner to avoid resource leaks
            scanner.close();
        }
    }
}

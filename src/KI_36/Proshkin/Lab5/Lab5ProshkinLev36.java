package KI_36.Proshkin.Lab5;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class to run the expression calculation program and test reading and writing methods.
 */
public class Lab5ProshkinLev36 {
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

            // Writing the result to a text file
            String textFilePath = "result.txt";
            calculator.writeResultToFile(result, textFilePath);
            System.out.println("The result has been written to the text file: " + textFilePath);

            // Writing the result to a binary file
            String binaryFilePath = "result.bin";
            calculator.writeResultToBinaryFile(result, binaryFilePath);
            System.out.println("The result has been written to the binary file: " + binaryFilePath);

            // Reading the result from the text file
            double textResult = calculator.readResultFromFile(textFilePath);
            System.out.println("Result read from the text file: " + textResult);

            // Reading the result from the binary file
            double binaryResult = calculator.readResultFromBinaryFile(binaryFilePath);
            System.out.println("Result read from the binary file: " + binaryResult);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File write or read error: " + e.getMessage());
        } finally {
            // Closing the scanner to avoid resource leaks
            scanner.close();
        }
    }
}

package KI_36.Proshkin.Lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Class for calculating the expression y = tan(4x) / x.
 * Demonstrates exception handling and writing results to a file.
 */
public class ExpressionCalculator {

    /**
     * Calculates the expression y = tan(4x) / x.
     *
     * @param x the value of the variable x
     * @return the result of the calculation
     * @throws IllegalArgumentException if x = 0, as the expression is undefined
     */
    public double calculate(double x) throws IllegalArgumentException {
        if (x == 0) {
            throw new IllegalArgumentException("The value of x cannot be 0, as the expression is undefined.");
        }
        return Math.tan(4 * x) / x;
    }

    /**
     * Validates if the given input is a number.
     *
     * @param input the input value as a string
     * @return the numeric value of x if it is a valid number
     * @throws InputMismatchException if the input is not a number
     */
    public double validateAndParse(String input) throws InputMismatchException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InputMismatchException("The input value must be a number.");
        }
    }

    /**
     * Writes the calculation result to a file.
     *
     * @param result the result of the calculation
     * @param filePath the path to the file
     * @throws IOException if an error occurs while writing to the file
     */
    public void writeResultToFile(double result, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Calculation result: " + result);
        }
    }
}


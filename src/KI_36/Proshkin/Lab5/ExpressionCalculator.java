package KI_36.Proshkin.Lab5;

import java.io.*;
import java.util.InputMismatchException;

/**
 * Class for calculating the expression y = tan(4x) / x.
 * Demonstrates exception handling and writing results to files.
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
     * Writes the result of the calculation to a text file.
     *
     * @param result the result of the calculation
     * @param filePath the path to the text file
     * @throws IOException if an error occurs while writing to the file
     */
    public void writeResultToFile(double result, String filePath) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);
            writer.write("Calculation result: " + result);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * Writes the result of the calculation to a binary file.
     *
     * @param result the result of the calculation
     * @param filePath the path to the binary file
     * @throws IOException if an error occurs while writing to the file
     */
    public void writeResultToBinaryFile(double result, String filePath) throws IOException {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(filePath));
            dos.writeDouble(result);
        } finally {
            if (dos != null) {
                dos.close();
            }
        }
    }

    /**
     * Reads the result from a text file.
     *
     * @param filePath the path to the file
     * @return the result of the calculation read from the file
     * @throws IOException if an error occurs while reading the file
     */
    public double readResultFromFile(String filePath) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            return Double.parseDouble(line.replaceAll("[^\\d.-]", ""));
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    /**
     * Reads the result from a binary file.
     *
     * @param filePath the path to the binary file
     * @return the result of the calculation read from the file
     * @throws IOException if an error occurs while reading the file
     */
    public double readResultFromBinaryFile(String filePath) throws IOException {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(filePath));
            return dis.readDouble();
        } finally {
            if (dis != null) {
                dis.close();
            }
        }
    }
}

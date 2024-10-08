package KI_36.Proshkin.Lab2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class representing a logger for writing actions to a file and displaying them in the terminal.
 */
public class Logger {
    private FileWriter file;

    /**
     * Constructor for the Logger class.
     *
     * @throws IOException If there is an I/O error.
     */
    public Logger() throws IOException {
        file = new FileWriter("log.txt", true);
    }

    /**
     * Write a message to the log file and display it in the terminal.
     *
     * @param message The message to write and display.
     * @throws IOException If there is an I/O error.
     */
    public void write(String message) throws IOException {
        // Write to the log file
        file.write(message + "\n");
        // Display the message in the terminal
        System.out.println(message);
    }

    /**
     * Close the log file.
     *
     * @throws IOException If there is an I/O error.
     */
    public void close() throws IOException {
        if (file != null) {
            file.close();
        }
    }
}

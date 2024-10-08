package KI_36.Proshkin.Lab3;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас, що представляє логер для запису дій у файл.
 */
public class Logger {
    private FileWriter file;

    public Logger() throws IOException {
        file = new FileWriter("log.txt", true);
    }

    public void write(String message) throws IOException {
        file.write(message + "\n");
        System.out.println(message);
    }

    public void close() throws IOException {
        if (file != null) {
            file.close();
        }
    }
}


import java.io.*;
import java.util.Scanner;

public class Lab1ProshkinLev36 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        int sideLength = getSideLength();
        char fillerSymbol = getFillerSymbol();

        char[][] jaggedArray = initializeJaggedArray(sideLength);
        fillJaggedArray(jaggedArray, fillerSymbol);

        printJaggedArrayToConsole(jaggedArray, sideLength);
        writeJaggedArrayToFile(jaggedArray, sideLength, "Result.txt");
    }

    // Функція для отримання довжини сторони квадрата
    private static int getSideLength() {
        int sideLength;
        while (true) {
            System.out.print("Введіть довжину сторони квадрата (додатне число): ");
            // Перевірка, чи введене значення є числом і чи воно додатнє
            if (scanner.hasNextInt()) {
                sideLength = scanner.nextInt();
                scanner.nextLine(); // Споживання символу нового рядка
                if (sideLength > 0) {
                    break; // Вихід з циклу, якщо введено правильне значення
                } else {
                    System.out.println("Помилка: довжина сторони повинна бути додатним числом.");
                }
            } else {
                System.out.println("Помилка: введіть ціле число.");
                scanner.next(); // Пропустити неправильне введення
            }
        }
        return sideLength;
    }

    // Функція для отримання символа-заповнювача
    private static char getFillerSymbol() {
        String symbol;
        while (true) {
            System.out.print("Введіть один символ для заповнення: ");
            symbol = scanner.next();
            if (symbol.length() == 1) {
                break; // Вихід з циклу, якщо введено рівно один символ
            } else {
                System.out.println("Помилка: введіть лише один символ.");
            }
        }
        return symbol.charAt(0);
    }

    // Ініціалізація зубчастого масиву
    private static char[][] initializeJaggedArray(int sideLength) {
        char[][] jaggedArray = new char[sideLength][];

        // Заповнення перших і останніх рядків
        for (int i = 1; i <= sideLength / 2; i++) {
            jaggedArray[i - 1] = new char[i]; // Верхня частина
            jaggedArray[i - 1 + (sideLength / 2)] = new char[i]; // Нижня части-на
        }

        // Якщо кількість рядків непарна, середній рядок матиме більше символів
        if (jaggedArray.length % 2 == 1) {
            jaggedArray[jaggedArray.length - 1] = new char[sideLength / 2 + 1];
        }

        return jaggedArray;
    }

    // Заповнення зубчастого масиву символом
    private static void fillJaggedArray(char[][] jaggedArray, char symbol) {
        for (char[] row : jaggedArray) {
            if (row != null) { // Перевірка на null (бо зубчасті масиви можуть містити null-рядки)
                for (int i = 0; i < row.length; i++) {
                    row[i] = symbol;
                }
            }
        }
    }

    // Виведення зубчастого масиву в консоль
    private static void printJaggedArrayToConsole(char[][] jaggedArray, int sideLength) {
        for (int i = 0; i < jaggedArray.length; i++) {
            if (i >= sideLength / 2) {
                System.out.print(" ".repeat(sideLength / 2));
            }
            System.out.println(String.copyValueOf(jaggedArray[i]));
        }
    }

    // Запис зубчастого масиву у файл
    private static void writeJaggedArrayToFile(char[][] jaggedArray, int sideLength, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (int i = 0; i < jaggedArray.length; i++) {
                if (i >= sideLength / 2) {
                    fileWriter.write(" ".repeat(sideLength / 2));
                }
                fileWriter.write(String.copyValueOf(jaggedArray[i]));
                fileWriter.write(System.lineSeparator());
            }
            System.out.println("Дані успішно збережено у файл.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

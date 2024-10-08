package KI_36.Proshkin.Lab3;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class driver for testing the Rifle class with user interaction and a loop.
 * This class provides a console-based menu for simulating interactions with a Rifle object.
 * Users can shoot, reload, change fire mode, and perform other actions using the menu.
 */
@SuppressWarnings("ALL")
public class Lab3ProshkinLev36 {
    public static void main(String[] args) throws IOException {
        // Initialize scanner to read user input
        Scanner scanner = new Scanner(System.in);

        try {
            // Create a Bullet object and initialize it with a caliber and number of bullets
            Bullet bullet = new Bullet("7.62mm", 30);

            // Create a Magazine object with a specified capacity
            Magazine magazine = new Magazine(40);

            // Create a Rifle object (AssaultRifle subclass) with parameters like name, manufacturer, bullet, magazine, and fire mode
            Rifle rifle = new AssaultRifle("AK-47", "Mechanical Plant", bullet , magazine, "Single");

            boolean exit = false; // Control variable for the menu loop

            // Main loop to interact with the rifle via a menu
            while (!exit) {
                // Display menu options
                System.out.println("\n--- Rifle Menu ---");
                System.out.println("1. Shoot");
                System.out.println("2. Reload");
                System.out.println("3. Check ammo");
                System.out.println("4. Change Fire Mode");
                System.out.println("5. Check Rifle Status");
                System.out.println("6. Clean Rifle");
                System.out.println("7. Cool Down Rifle");
                System.out.println("8. Check if Rifle is functional");
                System.out.println("9. Exit");
                System.out.print("Choose an option: ");

                try {
                    // Read user's choice
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline to avoid input issues

                    // Switch case for different user actions
                    switch (choice) {
                        case 1:
                            rifle.shoot();
                            break;

                        case 2:
                            // Reload rifle with specified number of bullets
                            System.out.print("Enter number of bullets to reload: ");
                            int bullets = scanner.nextInt();
                            if (bullets > 0) {
                                rifle.reload(bullets);
                            } else {
                                System.out.println("Invalid number of bullets.");
                            }
                            break;

                        case 3:
                            // Check current ammo status
                            rifle.checkAmmo();
                            break;

                        case 4:
                            // Change the fire mode based on user input
                            System.out.print("Enter fire mode (e.g., 'Automatic' or 'Single'): ");
                            String fireMode = scanner.nextLine();
                            rifle.changeFireMode(fireMode);
                            break;

                        case 5:
                            // Display information about the rifle (name, manufacturer, etc.)
                            rifle.getInfo();
                            break;

                        case 6:
                            // Clean the rifle to maintain functionality
                            rifle.clean();
                            break;

                        case 7:
                            // Cool down the rifle (useful after shooting)
                            rifle.coolDown();
                            break;

                        case 8:
                            // Check if the rifle is functional
                            rifle.isFunctional();
                            break;

                        case 9:
                            // Exit the program, ensuring the rifle is properly closed
                            exit = true;
                            rifle.close();
                            System.out.println("Exiting program.");
                            break;

                        default:
                            // Handle invalid input
                            System.out.println("Invalid option. Please choose a number between 1 and 9.");
                    }
                } catch (InputMismatchException e) {
                    // Handle invalid input when the user enters something that is not a number
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input to continue
                }
            }
        } catch (IOException e) {
            // Handle IOExceptions that may arise when interacting with the rifle object
            e.printStackTrace();
        } finally {
            // Ensure scanner is closed to prevent resource leaks
            scanner.close();
        }
    }
}

package KI_36.Proshkin.Lab2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class driver for testing the Rifle class with user interaction and a loop.
 */
@SuppressWarnings("ALL")
public class Lab2ProshkinLev36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Create bullets and a rifle
            Bullet bullet = new Bullet("7.62mm", 30);
            Magazine magazine = new Magazine(40);
            Rifle rifle = new Rifle("AK-47", "Mechanical Plant", bullet , magazine);

            boolean exit = false;
            while (!exit) {
                System.out.println("\n--- Rifle Menu ---");
                System.out.println("1. Shoot");
                System.out.println("2. Reload");
                System.out.println("3. Check ammo");
                System.out.println("4. Change Fire Mode");
                System.out.println("5. Check Rifle Status");
                System.out.println("6. Clean Rifle");
                System.out.println("7. Cool Down Rifle");
                System.out.println("8. Check if Rifle is fucntional");
                System.out.println("9. Exit");
                System.out.print("Choose an option: ");

                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    switch (choice) {
                        case 1:
                            rifle.shoot(1);
                            break;
                        case 2:
                            System.out.print("Enter number of bullets to reload: ");
                            int bullets = scanner.nextInt();
                            if (bullets > 0) {
                                rifle.reload(bullets);
                            } else {
                                System.out.println("Invalid number of bullets.");
                            }
                            break;
                        case 3:
                            rifle.checkAmmo();
                            break;
                        case 4:
                            System.out.print("Enter fire mode: ");
                            String fireMode = scanner.nextLine();
                            rifle.changeFireMode(fireMode);
                            break;
                        case 5:
                            rifle.getInfo();
                            break;
                        case 6:
                            rifle.clean();
                            break;
                        case 7:
                            rifle.coolDown();
                            break;
                        case 8:
                            rifle.isFunctional();
                        case 9:
                            exit = true;
                            rifle.close();
                            System.out.println("Exiting program.");
                            break;
                        default:
                            System.out.println("Invalid option. Please choose a number between 1 and 8.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
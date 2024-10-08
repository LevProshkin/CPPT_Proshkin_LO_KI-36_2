package KI_36.Proshkin.Lab3;

import java.io.IOException;
import java.util.Scanner;

/**
 * AssaultRifle class extending the Rifle class and implementing FireModes interface.
 * This class represents a specific type of rifle with multiple firing modes.
 * It includes functionality for single, automatic, burst, and full-load shooting.
 */
public class AssaultRifle extends Rifle implements FireModes {

    /**
     * Constructor to initialize the AssaultRifle object.
     * Sets up the type, manufacturer, bullet, magazine, fire mode, and initial state.
     *
     * @param type         The type of the rifle (e.g., "AK-47").
     * @param manufacturer The manufacturer of the rifle.
     * @param bullet       The Bullet object associated with the rifle.
     * @param magazine     The Magazine object associated with the rifle.
     * @param fireMode     The initial fire mode for the rifle.
     * @throws IOException if there is an error during initialization.
     */
    public AssaultRifle(String type, String manufacturer, Bullet bullet, Magazine magazine, String fireMode) throws IOException  {
        super(type, manufacturer, bullet, magazine);
        this.type = type;
        this.manufacturer = manufacturer;
        this.bullet = bullet;
        this.magazine = magazine;
        this.shotsAmount = 0;        // Initial number of shots is zero
        this.fireMode = "Single";    // Default fire mode is "Single"
        this.cleaned = true;         // Indicates that the rifle is clean initially
        this.cooled = true;          // Indicates that the rifle is cool initially
    }

    /**
     * Shoots the rifle based on the number of shots and fire mode.
     * Handles conditions such as overheating and cleaning requirements.
     *
     * @throws IOException if there is an error during the shooting process.
     */
    @Override
    public void shoot() throws IOException {
        // Check if the rifle needs cleaning before shooting
        if (shotsAmount >= 50 && !cleaned) {
            logger.write("Cannot shoot: Rifle needs cleaning!");
            System.out.println("You need to clean the rifle before shooting again!");

            // Check if the rifle is too hot and needs cooling
        } else if (shotsAmount >= 20 && !cooled) {
            logger.write("Cannot shoot: Rifle is too hot and needs cooling!");
            System.out.println("Your rifle is too hot and needs to cool down before shooting again!");

            // If there are bullets left in the magazine
        } else if (bullet.getQuantity() > 0) {

            // Single fire mode: Shoot one bullet at a time
            if (fireMode.equals("Single")) {
                bullet.use();
                shotsAmount++;  // Increment the number of shots fired
                cleaned = false;  // Mark the rifle as not cleaned
                logger.write("Shot fired. Shots amount: " + shotsAmount + ". Remaining bullets: " + bullet.getQuantity());
                System.out.println("Shot fired! Shots amount: " + shotsAmount);

                // Automatic fire mode: Shoot specified number of bullets
            } else if (fireMode.equals("Automatic")) {
                automaticShoot();

                // Burst fire mode: Shoot three bullets
            } else if (fireMode.equals("Burst")) {
                burstShoot();

                // Full load fire mode: Shoot all bullets in the magazine
            } else if (fireMode.equals("Full load")) {
                fullLoadShoot();
            }

            // If shots exceed a certain limit, set the rifle to "not cooled" state
            if (shotsAmount >= 20) {
                cooled = false;
            }
        } else {
            // Handle case when there are no bullets left
            logger.write("No bullets left.");
        }
    }

    /**
     * Automatic shooting mode. Fires a specified number of shots in quick succession.
     *
     * @throws IOException if there is an error during the shooting process.
     */
    @Override
    public void automaticShoot() throws IOException {
        System.out.print("Amount of shots: ");
        Scanner scanner = new Scanner(System.in);
        int shots = scanner.nextInt();
        logger.write("Automatic shooting started for " + shots + " shots.");
        for (int i = 0; i < shots; i++) {
            if (bullet.getQuantity() > 0) {
                bullet.use();      // Use one bullet for each shot
                shotsAmount++;     // Increment the number of shots fired
                cleaned = false;   // Mark the rifle as not cleaned
            } else {
                logger.write("Stopped shooting. No bullets left.");
                break;
            }
        }
    }

    /**
     * Burst shooting mode. Fires three bullets in a single burst.
     *
     * @throws IOException if there is an error during the shooting process.
     */
    @Override
    public void burstShoot() throws IOException {
        logger.write("Burst shooting started.");
        for (int i = 0; i < 3; i++) {
            if (bullet.getQuantity() > 0) {
                bullet.use();       // Use one bullet for each shot
                shotsAmount++;      // Increment the number of shots fired
                cleaned = false;    // Mark the rifle as not cleaned
            } else {
                logger.write("Stopped shooting. No bullets left.");
                break;
            }
        }
    }

    /**
     * Full load shooting mode. Fires all bullets left in the magazine.
     *
     * @throws IOException if there is an error during the shooting process.
     */
    @Override
    public void fullLoadShoot() throws IOException {
        int shotsFired = 0;  // Track the number of shots fired in this mode
        logger.write("Full load shooting started.");
        for (int i = 0; i < bullet.getQuantity(); i++) {
            if (bullet.getQuantity() > 0) {
                bullet.use();       // Use one bullet for each shot
                shotsFired++;       // Increment the number of shots fired
                shotsAmount++;      // Update total shots amount
                cleaned = false;    // Mark the rifle as not cleaned
            } else {
                logger.write("Stopped shooting. No bullets left.");
                break;
            }
        }
        // Log the total shots fired and overall shots amount
        logger.write(shotsFired + " shots fired and " + shotsAmount + " shots amount for the whole time.");
    }
}

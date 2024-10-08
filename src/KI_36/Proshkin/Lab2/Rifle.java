package KI_36.Proshkin.Lab2;

import java.io.IOException;

/**
 * Class representing a rifle with shot tracking, cooling, and cleaning logic.
 */
public class Rifle {
    private final String type;
    private final String manufacturer;
    private Bullet bullet;
    private final Magazine magazine;
    private int shotsAmount; // Field to track number of shots
    private boolean cooled;  // Field to track if rifle is cooled down
    private boolean cleaned; // Field to track if rifle is cleaned
    private final Logger logger;

    // Parameterized constructor
    public Rifle(String type, String manufacturer, Bullet bullet, Magazine magazine) throws IOException {
        this.type = type;
        this.manufacturer = manufacturer;
        this.bullet = bullet;
        this.magazine = magazine;
        this.shotsAmount = 0;  // Initialize shots amount to 0
        this.cooled = true;    // Initially cooled
        this.cleaned = true;   // Initially cleaned
        this.logger = new Logger();
        logger.write("Rifle created: " + this);
    }

    // 1. Method to shoot
    public void shoot(int shots) throws IOException {
        if (shotsAmount >= 50 && !cleaned) {
            logger.write("Cannot shoot: Rifle needs cleaning!");
            System.out.println("You need to clean the rifle before shooting again!");
        } else if (shotsAmount >= 20 && !cooled) {
            logger.write("Cannot shoot: Rifle is too hot and needs cooling!");
            System.out.println("Your rifle is too hot and needs to cool down before shooting again!");
        } else if (bullet.getQuantity() > 0) {
                bullet.use();
                shotsAmount++;  // Increment the number of shots fired
                cleaned = false;  // Mark as not cleaned after firing
                cooled = false;
                logger.write("Shot fired. Shots amount: " + shotsAmount + ". Remaining bullets: " + bullet.getQuantity());
                System.out.println("Shot fired! Shots amount: " + shotsAmount);

        } else {
            logger.write("No bullets left.");
            System.out.println("No bullets left.");
        }
    }

    // 2. Method to reload the rifle
    public void reload(int quantity) throws IOException {
        int checkAmount = bullet.getQuantity() + quantity;
        if(checkAmount <= magazine.getMaxAmountOfBullets())
        {
            bullet.add(quantity);
            logger.write("Reloaded. Total bullets: " + bullet.getQuantity());
        }
        else
        {
            logger.write("Too much bullets for this magazine.");
        }
    }

    // 3. Method to check ammunition
    public void checkAmmo() throws IOException {
        logger.write("Checked ammo: " + bullet.getQuantity());
    }

    // 4. Method to change bullets (e.g., change caliber)
    public void changeBullet(Bullet newBullet) throws IOException {
        this.bullet = newBullet;
        logger.write("Bullet changed to: " + newBullet.getCaliber());
    }

    // 5. Method to clean the rifle
    public void clean() throws IOException {
        logger.write("Rifle cleaned.");
        cleaned = true;   // Mark as cleaned
        System.out.println("Rifle cleaned. Shots amount reset.");
    }

    // 6. Method to get information about the rifle
    public void getInfo() throws IOException {
        String info = this.toString() +
                "\nShots fired: " + shotsAmount +
                "\nCooled down: " + cooled +
                "\nCleaned: " + cleaned;logger.write("Info retrieved: " + info);
        System.out.println(info);
    }

    // 7. Method to check if the rifle is functional
    public void isFunctional() throws IOException {
        boolean functional = bullet.getQuantity() > 0 && cooled && cleaned;
        System.out.println("Functional : " + functional);
        logger.write("Functional check: " + functional);
    }

    // 8. Method to change the firing mode (e.g., single/automatic)
    public void changeFireMode(String mode) throws IOException {
        logger.write("For now only Single mode available");
    }

    // 9. Method to cool down the rifle after use
    public void coolDown() throws IOException {
        logger.write("Rifle cooled down.");
        cooled = true;  // Mark as cooled
        System.out.println("Rifle cooled down.");
    }

    // Method to close the logger and clean up resources
    public void close() throws IOException {
        logger.write("Work with rifle finished.");
        logger.close();
    }

    //Method to collect basic info
    public String toString() {
        return "Rifle{" +
                "type='" + type + "' " +
        ", manufacturer='" + manufacturer + "'" +
        ", bullet=" + bullet +
                '}';
    }
}
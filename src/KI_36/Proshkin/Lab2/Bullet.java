package KI_36.Proshkin.Lab2;

/**
 * Class representing bullets (ammunition) for a rifle.
 */
public class Bullet {
    private final String caliber;
    private int quantity;

    /**
     * Constructor for the Bullet class.
     *
     * @param caliber  The caliber of the bullet.
     * @param quantity The initial quantity of bullets.
     */
    public Bullet(String caliber, int quantity) {
        this.caliber = caliber;
        this.quantity = quantity;
    }

    /**
     * Get the caliber of the bullet.
     *
     * @return Caliber as a string.
     */
    public String getCaliber() {
        return caliber;
    }

    /**
     * Get the current quantity of bullets.
     *
     * @return Quantity as an integer.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Use one bullet (decrease the quantity by one).
     */
    public void use() {
        if (quantity > 0) {
            quantity--;
        }
    }

    /**
     * Add bullets to the current quantity.
     *
     * @param quantity The number of bullets to add.
     */
    public int add(int quantity) {
        this.quantity += quantity;
        return this.quantity;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "caliber='" + caliber + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

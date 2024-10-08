package KI_36.Proshkin.Lab3;

/**
 * Клас, що представляє боєприпаси (Patron) для зброї.
 */
public class Bullet {
    private String caliber;
    private int quantity;

    public Bullet(String caliber, int quantity) {
        this.caliber = caliber;
        this.quantity = quantity;
    }

    public String getCaliber() {
        return caliber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void use() {
        if (quantity > 0) {
            quantity--;
        }
    }

    public void add(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "caliber='" + caliber + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}


package KI_36.Proshkin.Lab3;

public class Magazine {
    private final int maxAmountOfBullets;

    Magazine(int maxAmountOfBullets) {
        this.maxAmountOfBullets = maxAmountOfBullets;
    }
    /**
     * Get the Maximal quantity of bullets.
     *
     * @return Maximal Quantity as an integer.
     */
    public int getMaxAmountOfBullets() {
        return maxAmountOfBullets;
    }
}

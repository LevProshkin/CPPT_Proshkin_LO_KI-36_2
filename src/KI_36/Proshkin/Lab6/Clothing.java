package KI_36.Proshkin.Lab6;

/**
 * Class representing clothing.
 */
class Clothing implements Comparable<Clothing>, Weighable {
    private final String type;
    private final double weight;
    private final int size;

    public Clothing(String type, double weight, int size) {
        this.type = type;
        this.weight = weight;
        this.size = size;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Clothing other) {
        return Integer.compare(this.size, other.size);
    }

    @Override
    public String toString() {
        return "Clothing{type='" + type + "', weight=" + weight + "kg, size=" + size + "}";
    }
}

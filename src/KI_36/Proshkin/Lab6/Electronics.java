package KI_36.Proshkin.Lab6;

/**
 * Class representing electronic devices.
 */
class Electronics implements Comparable<Electronics>, Weighable {
    private final String name;
    private final double weight;
    private final double price;

    public Electronics(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Electronics other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return "Electronics{name='" + name + "', weight=" + weight + "kg, price=" + price + " UAH}";
    }
}

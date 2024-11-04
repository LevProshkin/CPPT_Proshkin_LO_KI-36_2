package KI_36.Proshkin.Lab6;

/**
 * Driver class to test the functionality of the Suitcase class.
 */
public class Lab6ProshkinLev36 {
    public static void main(String[] args) {
        // Creating a suitcase for clothing
        Suitcase<Clothing> clothingSuitcase = new Suitcase<>(10.0); // maximum weight 10 kg

        // Adding clothing items
        clothingSuitcase.addItem(new Clothing("Jeans", 0.8, 32));
        clothingSuitcase.addItem(new Clothing("T-shirt", 0.2, 38));
        clothingSuitcase.addItem(new Clothing("Sweater", 0.5, 40));

        System.out.println("Weight of the clothing suitcase: " + clothingSuitcase.getCurrentWeight() + " kg");
        System.out.println("Minimum item in the clothing suitcase (by size): " + clothingSuitcase.findMinElement());

        // Creating a suitcase for electronics
        Suitcase<Electronics> electronicsSuitcase = new Suitcase<>(5.0); // maximum weight 5 kg

        // Adding electronic items
        electronicsSuitcase.addItem(new Electronics("Laptop", 2.5, 45000.0));
        electronicsSuitcase.addItem(new Electronics("Phone", 0.2, 25000.0));
        electronicsSuitcase.addItem(new Electronics("Charger", 0.3, 1500.0));

        System.out.println("\nWeight of the electronics suitcase: " + electronicsSuitcase.getCurrentWeight() + " kg");
        System.out.println("Minimum item in the electronics suitcase (by price): " + electronicsSuitcase.findMinElement());

        // Testing item removal
        System.out.println("\nRemoving the last item from the electronics suitcase: " + electronicsSuitcase.removeLastItem());
        System.out.println("New weight of the electronics suitcase: " + electronicsSuitcase.getCurrentWeight() + " kg");

        // Clearing the suitcases
        clothingSuitcase.clear();
        electronicsSuitcase.clear();

        System.out.println("\nAfter clearing:");
        System.out.println("Weight of the clothing suitcase: " + clothingSuitcase.getCurrentWeight() + " kg");
        System.out.println("Weight of the electronics suitcase: " + electronicsSuitcase.getCurrentWeight() + " kg");
    }
}

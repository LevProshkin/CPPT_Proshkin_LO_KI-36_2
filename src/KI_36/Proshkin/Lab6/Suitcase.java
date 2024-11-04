package KI_36.Proshkin.Lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A parameterized class that implements a "Suitcase" container.
 * @param <T> the type of items stored in the suitcase
 */
public class Suitcase<T extends Comparable<T>> {
    private final List<T> items;
    private final double maxWeight;
    private double currentWeight;

    /**
     * Constructor with a parameter for the maximum suitcase weight.
     * @param maxWeight the maximum weight of the suitcase in kg
     */
    public Suitcase(double maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.items = new ArrayList<>();
    }

    /**
     * Adds an item to the suitcase.
     * @param item the item to add
     * @return true if the item was successfully added, false if the suitcase is overfilled
     */
    public boolean addItem(T item) {
        if (item instanceof Weighable) {
            double itemWeight = ((Weighable) item).getWeight();
            if (currentWeight + itemWeight > maxWeight) {
                return false;
            }
            currentWeight += itemWeight;
        }
        return items.add(item);
    }

    /**
     * Removes the last added item from the suitcase.
     * @return the last item or null if the suitcase is empty
     */
    public T removeLastItem() {
        if (items.isEmpty()) {
            return null;
        }
        T item = items.remove(items.size() - 1);
        if (item instanceof Weighable) {
            currentWeight -= ((Weighable) item).getWeight();
        }
        return item;
    }

    /**
     * Finds the minimum item in the suitcase (for comparable items).
     * @return the minimum item or null if the suitcase is empty
     */
    public T findMinElement() {
        if (items.isEmpty()) {
            return null;
        }
        return items.stream()
                .filter(Objects::nonNull)
                .min(Comparable::compareTo)
                .orElse(null);
    }

    /**
     * Returns the current weight of the suitcase.
     * @return the current weight in kg
     */
    public double getCurrentWeight() {
        return currentWeight;
    }

    /**
     * Checks if an item is in the suitcase.
     * @param item the item to search for
     * @return true if the item is found, false otherwise
     */
    public boolean contains(T item) {
        return items.contains(item);
    }

    /**
     * Clears all items from the suitcase.
     */
    public void clear() {
        items.clear();
        currentWeight = 0;
    }
}

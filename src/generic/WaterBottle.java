package generic;

import java.util.Stack;

public class WaterBottle {
    private Stack<String> layers;  // Each string represents a color
    private int capacity;

    public WaterBottle(int capacity) {
        this.capacity = capacity;
        this.layers = new Stack<>();
    }

    // Method to pour liquid from this bottle into another bottle
    public boolean pourInto(WaterBottle otherBottle) {
        if (this.isEmpty() || otherBottle.isFull()) {
            return false;  // Cannot pour if this bottle is empty or the other bottle is full
        }

        String topColor = this.getTopColor();
        int pourableAmount = 0;

        // Count how many layers of the top color can be poured
        while (!this.isEmpty() && this.getTopColor().equals(topColor)) {
            pourableAmount++;
            this.layers.pop();
        }

        // Pour into the other bottle
        for (int i = 0; i < pourableAmount && !otherBottle.isFull(); i++) {
            otherBottle.addColor(topColor);
        }

        return true;  // Successfully poured
    }

    // Add color to the bottle
    public void addColor(String color) {
        if (layers.size() < capacity) {
            layers.push(color);
        }
    }

    // Check if the bottle is empty
    public boolean isEmpty() {
        return layers.isEmpty();
    }

    // Check if the bottle is full
    public boolean isFull() {
        return layers.size() == capacity;
    }

    // Get the color on the top of the bottle
    public String getTopColor() {
        return layers.isEmpty() ? null : layers.peek();
    }

    // Check if the bottle is fully sorted (i.e., all layers are the same color)
    public boolean isSorted() {
        if (isEmpty()) return true;  // An empty bottle is considered sorted
        String topColor = layers.peek();
        for (String layer : layers) {
            if (!layer.equals(topColor)) return false;
        }
        return true;
    }

    // Method to print the bottle's layers (for debugging purposes)
    public void printBottle() {
        System.out.println("Bottle layers: " + layers.toString());
    }

    // Get the capacity of the bottle
    public int getCapacity() {
        return this.capacity;
    }

    // Get the layers in the bottle
    public Stack<String> getLayers() {
        return this.layers;
    }

    // Method to check if we can pour from this bottle into another bottle
    public boolean canPourInto(WaterBottle otherBottle) {
        if (this.isEmpty() || otherBottle.isFull()) {
            return false;
        }
        if (otherBottle.isEmpty()) {
            return true;  // You can always pour into an empty bottle
        }
        return this.getTopColor().equals(otherBottle.getTopColor());
    }
}

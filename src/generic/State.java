package generic;

import java.util.Arrays;

public class State {
    private WaterBottle[] bottles;

    // Constructor
    public State(WaterBottle[] bottles) {
        this.bottles = bottles;
    }

    // Get the bottles in the current state
    public WaterBottle[] getBottles() {
        return bottles;
    }

    // Check if the current state is a goal (all bottles sorted)
    public boolean isGoal() {
        return Arrays.stream(bottles).allMatch(WaterBottle::isSorted);
    }

    // Perform an action (pour liquid from one bottle to another)
    public boolean performAction(int fromBottleIndex, int toBottleIndex) {
        return bottles[fromBottleIndex].pourInto(bottles[toBottleIndex]);
    }

    // Method to print the state (for debugging purposes)
    public void printState() {
        System.out.println("State:");
        for (int i = 0; i < bottles.length; i++) {
            System.out.println("Bottle " + i + ": ");
            bottles[i].printBottle();
        }
    }

    // Clone the current state to create a new state for expansion
    public State cloneState() {
        WaterBottle[] clonedBottles = new WaterBottle[bottles.length];
        for (int i = 0; i < bottles.length; i++) {
            WaterBottle bottle = bottles[i];
            WaterBottle clonedBottle = new WaterBottle(bottle.getCapacity());
            for (String color : bottle.getLayers()) {
                clonedBottle.addColor(color);
            }
            clonedBottles[i] = clonedBottle;
        }
        return new State(clonedBottles);
    }
}

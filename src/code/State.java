package code;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class State {
    private WaterBottle[] bottles;

    // Constructor
    public State(WaterBottle[] bottles) {
        this.bottles = bottles;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bottles);  // Generates a hash based on the contents of the bottles array
    }

    // Override equals() to compare the content of the bottles array
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Check if it's the same object
        if (obj == null || getClass() != obj.getClass()) return false;  // Check type

        State otherState = (State) obj;  // Cast the object
        return Arrays.equals(bottles, otherState.bottles);  // Compare the contents of the bottles arrays
    }      
    // Get the bottles in the current state
    public WaterBottle[] getBottles() {
        return bottles;
    }

    // Check if the current state is a goal (all bottles sorted)
    public boolean isGoal() {
//    	boolean flag=false;
    	boolean issorted=Arrays.stream(bottles).allMatch(WaterBottle::isSorted);
//    	for (WaterBottle waterBottle : bottles) {
//			if (waterBottle.isEmpty())
//			{
//				flag =true;
//			}
//		}
    	return  issorted;
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
            WaterBottle clonedBottle = new WaterBottle(bottle.getCapacity(),new Stack<>());
            for (String color : bottle.getLayers()) {
                clonedBottle.addColor(color);
            }
            clonedBottles[i] = clonedBottle;
        }
        return new State(clonedBottles);
    }
}

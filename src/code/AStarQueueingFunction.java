package code;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AStarQueueingFunction implements QueueingFunction {
    private PriorityQueue<Node> priorityQueue;

 // Constructor to initialize the priority queue
    public AStarQueueingFunction() {
        // Initialize the priority queue with a comparator for A* (f(n) = g(n) + h(n))
        this.priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.getHeuristicValue() + node.getPathCost()));
    }
    
    @Override
    public void enqueue(Node node) {
        // Add the node to the priority queue
        priorityQueue.add(node);
    }
    
    public Node dequeue() {
        return priorityQueue.poll();  // Remove and return the node with the lowest heuristicValue
    }


	@Override
	public boolean isEmpty() {
        return priorityQueue.isEmpty();
	}
	@Override
	public void displayQueue() {
		// TODO Auto-generated method stub
		
	}

}

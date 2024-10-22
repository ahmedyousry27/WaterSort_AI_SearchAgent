package code;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;

public class UCSQueueingFunction implements QueueingFunction {
    private PriorityQueue<Node> priorityQueue;

    public UCSQueueingFunction() {
        this.priorityQueue = new PriorityQueue<>(Comparator.comparingInt(SearchTreeNode::getPathCost));  // Sort nodes by path cost
    }

    public PriorityQueue<Node> getPriorityQueue() {
		return priorityQueue;
	}

	@Override
    public void enqueue(Node node) {
        priorityQueue.add(node);  // Add node to the priority queue, sorted by cost
    }

    public Node dequeue() {
        return priorityQueue.poll();  // Remove and return the node with the lowest cost
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

	@Override
	public void displayQueue() {
		// TODO Auto-generated method stub
		
	}
}

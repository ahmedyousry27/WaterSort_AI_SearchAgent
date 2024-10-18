package code;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyQueueingFunction implements QueueingFunction {
    private PriorityQueue<Node> priorityQueue;
    private int type;
	public GreedyQueueingFunction(int type)
	{
		this.priorityQueue=new PriorityQueue<>(Comparator.comparingInt(Node->Node.getHeuristicValue()+Node.getPathCost()));//sort nodes by heuristic value
		this.type=type;

	}
	public int getType() {
		return type;
	}
	@Override
	public void enqueue(Node node) {
        priorityQueue.add(node);  // Add node to the priority queue, sorted by heuristicValue
		
	}
    public PriorityQueue<Node> getPriorityQueue() {
		return priorityQueue;
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

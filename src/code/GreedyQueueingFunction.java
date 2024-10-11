package code;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyQueueingFunction implements QueueingFunction {
    private PriorityQueue<Node> priorityQueue;

	public GreedyQueueingFunction()
	{
		this.priorityQueue=new PriorityQueue<>(Comparator.comparingInt(Node->Node.getHeuristicValue()+Node.getPathCost()));//sort nodes by heuristic value
	}
	@Override
	public void enqueue(List<Node> queue, Node node) {
        priorityQueue.add(node);  // Add node to the priority queue, sorted by heuristicValue
		
	}
    public Node dequeue() {
        return priorityQueue.poll();  // Remove and return the node with the lowest heuristicValue
    }


	@Override
	public boolean isEmpty() {
        return priorityQueue.isEmpty();

	}

}

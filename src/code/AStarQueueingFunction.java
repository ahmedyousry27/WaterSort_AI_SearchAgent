package code;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AStarQueueingFunction implements QueueingFunction {
    private PriorityQueue<Node> priorityQueue;

	@Override
	public void enqueue(List<Node> queue, Node node) {
		// TODO Auto-generated method stub
		this.priorityQueue=new PriorityQueue<>(Comparator.comparingInt(Node->Node.getHeuristicValue()+Node.getPathCost()));//sort nodes by heuristic value

	}
    public Node dequeue() {
        return priorityQueue.poll();  // Remove and return the node with the lowest heuristicValue
    }


	@Override
	public boolean isEmpty() {
        return priorityQueue.isEmpty();
	}

}

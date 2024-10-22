package code;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AStarQueueingFunction implements QueueingFunction {
    private PriorityQueue<Node> priorityQueue;
    private int type;
    
    public PriorityQueue<Node> getPriorityQueue() {
		return priorityQueue;
	}
	public int getType() {
		return type;
	}
	public AStarQueueingFunction(int type)
    {
		this.priorityQueue=new PriorityQueue<>(Comparator.comparingInt(Node->Node.getHeuristicValue()+Node.getPathCost()));//sort nodes by heuristic value
		this.type=type;
    }
	@Override
	public void enqueue(Node node) {
		// TODO Auto-generated method stub
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

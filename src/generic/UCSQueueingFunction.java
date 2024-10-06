package generic;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;

public class UCSQueueingFunction implements QueueingFunction {
    private PriorityQueue<SearchTreeNode> priorityQueue;

    public UCSQueueingFunction() {
        this.priorityQueue = new PriorityQueue<>(Comparator.comparingInt(SearchTreeNode::getPathCost));  // Sort nodes by path cost
    }

    @Override
    public void enqueue(List<SearchTreeNode> nodeList, SearchTreeNode node) {
        priorityQueue.add(node);  // Add node to the priority queue, sorted by cost
    }

    public SearchTreeNode dequeue() {
        return priorityQueue.poll();  // Remove and return the node with the lowest cost
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }
}

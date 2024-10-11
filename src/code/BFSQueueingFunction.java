package code;

import java.util.LinkedList;
import java.util.List;

public class BFSQueueingFunction implements QueueingFunction {
    private LinkedList<Node> queue;

    public BFSQueueingFunction() {
        this.queue = new LinkedList<>();  // Initialize LinkedList as a queue (FIFO)
    }

    @Override
    public void enqueue(List<Node> nodeList, Node node) {
        queue.add(node);  // Add node to the end of the queue (FIFO)
    }

    public Node dequeue() {
        return queue.poll();  // Remove and return the front node from the queue
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
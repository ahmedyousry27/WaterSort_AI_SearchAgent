package code;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSQueueingFunction implements QueueingFunction {
    private LinkedList<Node> queue;

    public LinkedList<Node> getQueue() {
		return queue;
	}

	public BFSQueueingFunction() {
        this.queue = new LinkedList<>();  // Initialize LinkedList as a queue (FIFO)
    }

    @Override
    public void enqueue(Node node) {
        queue.add(node);  // Add node to the end of the queue (FIFO)
    }

    public Node dequeue() {
        return queue.poll();  // Remove and return the front node from the queue
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

	@Override
	public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Queue contents: ");
            for (Node element : queue) {
                element.display();
            }
        }		
	}
}

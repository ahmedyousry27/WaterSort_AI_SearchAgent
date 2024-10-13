package code;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFSQueueingFunction implements QueueingFunction {
    private LinkedList<Node> stack;

    public DFSQueueingFunction() {
        this.stack = new LinkedList<>();  // Initialize Stack for DFS (LIFO)
    }

    @Override
    public void enqueue(Node node) {
        stack.push(node);  // Push the node onto the stack (LIFO)
    }


    public boolean isEmpty() {
        return stack.isEmpty();
    }

	@Override
	public Node dequeue() {
        return stack.pollLast();  // Pop the node from the top of the stack
	}

	@Override
	public void displayQueue() {
		// TODO Auto-generated method stub
		
	}
}

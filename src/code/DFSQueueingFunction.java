package code;

import java.util.List;
import java.util.Stack;

public class DFSQueueingFunction implements QueueingFunction {
    private Stack<Node> stack;

    public DFSQueueingFunction() {
        this.stack = new Stack<>();  // Initialize Stack for DFS (LIFO)
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
        return stack.pop();  // Pop the node from the top of the stack
	}

	@Override
	public void displayQueue() {
		// TODO Auto-generated method stub
		
	}
}

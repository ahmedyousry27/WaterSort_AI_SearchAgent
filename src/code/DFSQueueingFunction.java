package code;

import java.util.List;
import java.util.Stack;

public class DFSQueueingFunction implements QueueingFunction {
    private Stack<Node> stack;

    public DFSQueueingFunction() {
        this.stack = new Stack<>();  // Initialize Stack for DFS (LIFO)
    }

    @Override
    public void enqueue(List<Node> stackList, Node node) {
        stack.push(node);  // Push the node onto the stack (LIFO)
    }

    public Node pop() {
        return stack.pop();  // Pop the node from the top of the stack
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

	@Override
	public Node dequeue() {
		// TODO Auto-generated method stub
		return null;
	}
}

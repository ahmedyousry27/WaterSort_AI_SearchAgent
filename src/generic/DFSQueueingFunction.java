package generic;

import java.util.List;
import java.util.Stack;

public class DFSQueueingFunction implements QueueingFunction {
    private Stack<SearchTreeNode> stack;

    public DFSQueueingFunction() {
        this.stack = new Stack<>();  // Initialize Stack for DFS (LIFO)
    }

    @Override
    public void enqueue(List<SearchTreeNode> stackList, SearchTreeNode node) {
        stack.push(node);  // Push the node onto the stack (LIFO)
    }

    public SearchTreeNode pop() {
        return stack.pop();  // Pop the node from the top of the stack
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

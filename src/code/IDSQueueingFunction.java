package code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class IDSQueueingFunction implements QueueingFunction {

    private LinkedList<Node> stack;
    private int currentDepthLimit;  // Limit for depth in each iteration
    

    public IDSQueueingFunction() {
        this.stack = new LinkedList<>();  // Initialize Stack for IDS (LIFO)
    }

    @Override
    public void enqueue(Node node) {
        if (node.getDepth() <= currentDepthLimit) {  // Only enqueue nodes within the depth limit
            stack.push(node);  
        }
        }



	public int getCurrentDepthLimit() {
		return currentDepthLimit;
	}

	public void setCurrentDepthLimit(int currentDepthLimit) {
		this.currentDepthLimit = currentDepthLimit;
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

	// The IDS search method with an iterative deepening strategy
    public Node iterativeDeepeningSearch(WaterSortSearch waterSortSearch) {

        while (true) {
            // Perform DFS with current depth limit
        	HashSet<State> visited=waterSortSearch.getIsRepeated();
        	Node node = new Node(waterSortSearch.getInitialState(), null, null, 0, 0,0,1); 
            Node result = depthLimitedSearch(waterSortSearch,node, waterSortSearch.getIsRepeated(), 0);
            
            if (result != null) {
                return result;  // Solution found
            }

            // Increment depth limit and restart search
            currentDepthLimit++;
            visited.clear();  // Clear visited set for the new depth limit iteration
        }
    }

    // DFS with depth limit
    private Node depthLimitedSearch(WaterSortSearch waterSortSearch,Node currentNode, HashSet<State> visited, int currentDepth) {
        // Check if we have exceeded the depth limit
        if (currentDepth > currentDepthLimit) {
            return null;
        }

        if (currentNode.getState().isGoal()) {
            return currentNode;  // Return the solution
        }

        visited.add(currentNode.getState());

        // For each neighbor, perform DFS until depth limit is reached
        for (Node neighbor : waterSortSearch.expand(currentNode)) {
            if (!visited.contains(neighbor)) {
                Node result = depthLimitedSearch(waterSortSearch,neighbor, visited, currentDepth + 1);
                if (result != null) {
                    return result;  // Return solution if found
                }
            }
        }

        return null;  // No solution found within the current depth limit
    }
}


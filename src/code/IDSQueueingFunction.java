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
//    public Node iterativeDeepeningSearch(Node root, int maxDepthLimit) {
//        for (int depthLimit = 0; depthLimit <= maxDepthLimit; depthLimit++) {
//            System.out.println("Searching with depth limit: " + depthLimit);
//            Node result = depthLimitedSearch(root, depthLimit);
//            if (result != null) {
//                return result;  // Return the solution if found
//            }
//        }
//        return null;  // No solution found within the depth limit
//    }
//
//    // Depth-Limited Search (DLS) for a specific depth limit
//    public Node depthLimitedSearch(Node root, int depthLimit) {
//        stack.clear();  // Clear the stack for each depth-limited search
//        enqueue(root);  // Start with the root node
//
//        while (!isEmpty()) {
//            Node currentNode = dequeue();
//
//            // Check if the current node is the goal state
//            if ((currentNode.getState().isGoal())) {
//                return currentNode;
//            }
//
////            // Enqueue the children nodes if they are within the depth limit
////            for (Node child : currentNode.getChildren()) {
////                child.setDepth(currentNode.getDepth() + 1);  // Set the depth of the child node
////                enqueue(child);
////            }
//        }
//        return null;  // No solution found at this depth level
//    }
	// The IDS search method with an iterative deepening strategy
    public Node iterativeDeepeningSearch(WaterSortSearch waterSortSearch) {

        while (true) {
            // Perform DFS with current depth limit
        	HashSet<State> visited=waterSortSearch.getIsRepeated();
        	Node node = new Node(waterSortSearch.getInitialState(), null, null, 0, 0,0,false); 
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

        // Check if the current node is the goal
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


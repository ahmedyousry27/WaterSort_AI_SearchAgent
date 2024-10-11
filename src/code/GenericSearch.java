package code;
import java.util.Deque;
import java.util.List;
public abstract class GenericSearch {
	private State initialState;//representing initial world configuration
	private String[] actions; //Available for the agent to perform
	private State StateSpace; //set of states reachable from initial state
	
	public State getInitialState() {
		return initialState;
	}

	public String[] getActions() {
		return actions;
	}

	public State getStateSpace() {
		return StateSpace;
	}

	public GenericSearch(State initialState , String [] actions,State StateSpace) {
		this.initialState=initialState;
		this.actions=actions;
		this.StateSpace=StateSpace;
	}
	
    // Main search function that will run the search algorithm based on the strategy
	public Node genericSearch(GenericSearch problem,QueueingFunction qFunction)
	{ 
	    Node initialNode = makeNode(problem.initialState);
        qFunction.enqueue(initialNode);  // Enqueue the initial node using the provided queueing function


        while (!qFunction.isEmpty()) {
            Node node;
            node = qFunction.dequeue();  // Dequeue the node

			/*
			 * } if (node==null){ throw new
			 * IllegalStateException("Unknown queueing function"); }
			 * 
			 */
            // Check if this node's state is the goal
            if (isGoal(node.getState())) {
                return (Node) node;  // Return the goal node if found
            }

            // Expand the node (get children nodes) and enqueue them
            List<Node> expandedNodes = expand(node);
            for (Node child : expandedNodes) {
                qFunction.enqueue( child);  // Enqueue each child node using the provided strategy
            }
        }
        return null;  // Return null if no solution is found
	}
	

    // Helper method to create the initial node
    public Node makeNode(State initialState) {
        return new Node(initialState, null, null, 0, 0,0,false);  // Create root node
    }    
	//abstract methods
    //is goal in lecture is implemeted inside genericseach(search problem) if that is right? we should delete it from Node
	public abstract boolean isGoal(State node);
	public abstract int pathCost(String action);
    public abstract List<Node> expand(Node node); // Expand nodes
	
}

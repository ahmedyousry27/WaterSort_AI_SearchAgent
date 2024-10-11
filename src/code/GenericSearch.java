package code;
import java.util.List;
public abstract class GenericSearch {
	private State initialState;//representing initial world configuration
	private String[] actions; //Available for the agent to perform
	private State StateSpace; //set of states reachable from initial state
	
	public GenericSearch(State initialState , String [] actions,State StateSpace) {
		this.initialState=initialState;
		this.actions=actions;
		this.StateSpace=StateSpace;
	}
	
    // Main search function that will run the search algorithm based on the strategy
	public Node genericSearch(GenericSearch problem,QueueingFunction qFunction)
	{ 
	    Node initialNode = makeNode(problem.initialState);
        qFunction.enqueue(null, initialNode);  // Enqueue the initial node using the provided queueing function


        while (!qFunction.isEmpty()) {
            Node node;
            if (qFunction instanceof BFSQueueingFunction || qFunction instanceof UCSQueueingFunction || qFunction instanceof GreedyQueueingFunction || qFunction instanceof AStarQueueingFunction) {
                node = qFunction.dequeue();  // Dequeue the node
            } else if (qFunction instanceof DFSQueueingFunction) {
                node = ((DFSQueueingFunction) qFunction).pop();  // Pop the node from the stack
            } else {
                throw new IllegalStateException("Unknown queueing function");
            }

            // Check if this node's state is the goal
            if (isGoal(node.getState())) {
                return (Node) node;  // Return the goal node if found
            }

            // Expand the node (get children nodes) and enqueue them
            List<Node> expandedNodes = expand(node, problem);
            for (Node child : expandedNodes) {
                qFunction.enqueue(null, child);  // Enqueue each child node using the provided strategy
            }
        }
        return null;  // Return null if no solution is found
	}
	

    // Helper method to create the initial node
    private Node makeNode(State initialState) {
        return new Node(initialState, null, null, 0, 0,0,0);  // Create root node
    }    
	//abstract methods
    //is goal in lecture is implemeted inside genericseach(search problem) if that is right? we should delete it from Node
	public abstract boolean isGoal(State node);
	public abstract int pathCost(String action);
    public abstract List<Node> expand(Node node, GenericSearch problem); // Expand nodes
	
}
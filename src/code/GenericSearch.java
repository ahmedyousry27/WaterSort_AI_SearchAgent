package code;
import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
public abstract class GenericSearch {
	private State initialState;//representing initial world configuration
	private String[] actions; //Available for the agent to perform
	private State StateSpace; //set of states reachable from initial state
	private HashSet<State> isRepeated;
	private static ArrayList<String> traverseSequence;
	
	public static ArrayList<String> getTraverseSequence() {
		return traverseSequence;
	}

	public HashSet<State> getIsRepeated() {
		return isRepeated;
	}

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
		this.isRepeated=new HashSet<State>();
		this.traverseSequence=new ArrayList<>();
	}
	
    // Main search function that will run the search algorithm based on the strategy
	public Node genericSearch(GenericSearch problem,QueueingFunction qFunction)
	{ 
	    Node initialNode = makeNode(problem.initialState,qFunction);
        qFunction.enqueue(initialNode);  // Enqueue the initial node using the provided queueing function
        while (!qFunction.isEmpty()) {
            Node node;
            node = qFunction.dequeue();  // Dequeue the node
            if (node.getParent()!=null)
            {
            traverseSequence.add(node.getAction());
            }

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
    public Node makeNode(State initialState,QueueingFunction qFunction) {
    	if (qFunction instanceof AStarQueueingFunction )
    	{
    		return new Node(initialState, null, null, 0, 0,0,((AStarQueueingFunction)qFunction).getType());
    	}
    	else if (qFunction instanceof GreedyQueueingFunction)
    	{
    		return new Node(initialState, null, null, 0, 0,0,((GreedyQueueingFunction)qFunction).getType());
    	}
        return new Node(initialState, null, null, 0, 0,0,1);  // Create root node // default heuristic type ==1 we don't need it.
    }    
	//abstract methods
	public abstract boolean isGoal(State node);
	public abstract int pathCost(State parentState, State childState);
    public abstract List<Node> expand(Node node); // Expand nodes
	
}

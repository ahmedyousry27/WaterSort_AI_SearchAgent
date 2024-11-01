package code;
public class SearchTreeNode {
    private State state;      // State of the puzzle (bottles and liquid configuration)
	private SearchTreeNode parent;       // Parent node to trace back the solution
    private String action;     // The action that resulted in this state (e.g., pour(0,1))
    private int pathCost;      // The cost to reach this node (e.g., number of pours)
    private int depth;         // Depth in the search tree
    private int heuristicValue;  // Heuristic value for Greedy/A* Search
    private int heuristictype;   // defines which heuristic will be applied 0 or 1
    
    public SearchTreeNode(State state, SearchTreeNode parent ,String action ,int pathCost , int depth , int heuristicValue,int heuristictype )
    {
    	this.state=state;
    	this.parent=parent;
    	this.action=action;
    	this.pathCost=pathCost;
    	this.depth=depth;
    	this.heuristicValue=heuristicValue;
    	this.heuristictype=heuristictype;
    }
    
    public void setDepth(int depth) {
		this.depth = depth;
	}

	//Getter methods
    public State getState() {
		return state;
	}

	public SearchTreeNode getParent() {
		return parent;
	}

	public String getAction() {
		return action;
	}

	public int getPathCost() {
		return pathCost;
	}

	public int getDepth() {
		return depth;
	}

	public int getHeuristicValue() {
		return heuristicValue;
	}

	public int getHeuristictype() {
		return heuristictype;
	}
	
}

package code;

public class Node extends SearchTreeNode {

	public Node(State state, SearchTreeNode parent, String action, int pathCost, int depth, int heuristicValue,
			boolean heuristictype) {
		super(state, parent, action, pathCost, depth, heuristicValue, heuristictype);
		// TODO Auto-generated constructor stub
	}
	public void display()
	{
		
		 this.getState().printState();
		 
	}

}

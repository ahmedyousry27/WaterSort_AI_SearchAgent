package game;

import java.util.ArrayList;
import java.util.List;

import generic.GenericSearch;
import generic.State;

public class WaterSortSearch extends GenericSearch {

	public WaterSortSearch(State intialState, String[] actions, State StateSpace) {
		super(intialState, actions, StateSpace);
		// TODO Auto-generated constructor stub
	}

	
	
	
	public static String solve(String initialState,String strategy,boolean visualize)
	{
		/*-Take intial state manipulted 
		-create waterSort object instance
		-call generic search function inhereted from generic search (watersort problem,strategy)
		-return solution*/
		/*
		 * if (solution != null) { return formatSolution(solution); // Return solution
		 * in required format } else { return "NOSOLUTION"; }
		 */
		return " ";//return String of 3 elements plan;pathCost;nodesExpanded 
		//if no solution print "NOSOLUTION"
	}
	
	
    // Helper method to format the solution string
	private String formatSolution(Node node) {
	    StringBuilder plan = new StringBuilder();
	    int pathCost = node.getPathCost();
	    int nodesExpanded = 0;  // Track nodes expanded
	
	    // Trace back the actions from the goal node to the root
	    while (node.getParent() != null) {
	        plan.insert(0, node.getAction() + ",");
	        node = (Node) node.getParent();
	        nodesExpanded++;
	    }
	
	    return plan.toString() + ";" + pathCost + ";" + nodesExpanded;
	}
	
	
    // Generate child node based on an action and current state, adding heuristic value
    private Node generateChildNode(Node parent, String action, GenericSearch problem) {
        State newState = applyAction(parent.getState(), action);  // Apply the pour action
        int newPathCost = parent.getPathCost() + 1;  // Increase the path cost
        int heuristicValue = calculateHeuristic(newState);  // Calculate heuristic for the new state
        int heuristicType=parent.getHeuristictype();
        return new Node(newState, parent, action, newPathCost, parent.getDepth() + 1, heuristicValue,heuristicType);
    }
    // Define valid actions (pour actions) based on the current state
    private List<String> getValidActions(State state) {
        List<String> actions = new ArrayList<>();
        // Implement logic to return all valid pour actions (e.g., pour(0,1), pour(0,2), etc.)
        return actions;
    }
    // Apply the pour action to the state and return the new state
    private State applyAction(State state, String action) {
        // Implement logic to modify the state based on the action (pour between bottles)
        return state;  // Placeholder, modify as needed
    }

    // Calculate a heuristic value for the state
    private int calculateHeuristic(State state) {
        // Implement heuristic function (e.g., number of bottles with mixed colors, etc.)
        return 0;  // Placeholder, modify as needed
    }
	@Override
	public boolean isGoal(State node) {
		// TODO Auto-generated method stub
		return false;
	}	
	
	@Override
	public int pathCost(String action) {
		// TODO Auto-generated method stub
		return 0;
	}




    @Override
    public List<Node> expand(Node node, GenericSearch problem) {
        // Implement logic to generate valid child nodes (pour actions)
        List<Node> children = new ArrayList<>();

        // Iterate over all valid actions (pour from one bottle to another)
        for (String action : getValidActions(node.getState())) {
            Node child = generateChildNode(node, action, problem);
            children.add(child);
        }

        return children;
    }



}

package game;

import java.util.ArrayList;
import java.util.List;

import generic.BFSQueueingFunction;
import generic.DFSQueueingFunction;
import generic.GenericSearch;
import generic.QueueingFunction;
import generic.SearchTreeNode;
import generic.State;
import generic.UCSQueueingFunction;
import generic.WaterBottle;

public class WaterSortSearch extends GenericSearch {

	public WaterSortSearch(State intialState, String[] actions, State StateSpace) {
		super(intialState, actions, StateSpace);
		// TODO Auto-generated constructor stub
	}

	
	
	
	public static String solve(String initialState, String strategy, boolean visualize) {
        // Create the initial state object (you need to implement the logic to parse the string)
        State initialStateObj = parseInitialState(initialState);

        // Create an instance of WaterSortSearch with the parsed initial state
        WaterSortSearch waterSortSearch = new WaterSortSearch(initialStateObj, new String[]{}, null);

		// Map the strategy to the appropriate QueueingFunction
		QueueingFunction qFunction = getQueueingFunctionForStrategy(strategy);

        // Call the generic search function and get the solution node
        Node solution = waterSortSearch.genericSearch(waterSortSearch, qFunction);  // Modify strategy handling as per your implementation

        // Return formatted solution or "NOSOLUTION" if no solution found
        if (solution != null) {
            return waterSortSearch.formatSolution(solution);  // Return solution in required format
        } else {
            return "NOSOLUTION";
        }
    }

		// Helper method to map the strategy string to the appropriate QueueingFunction
	private static QueueingFunction getQueueingFunctionForStrategy(String strategy) {
		switch (strategy) {
			case "BFS":
				return new BFSQueueingFunction();
			case "DFS":
				return new DFSQueueingFunction();
			case "UCS":
				return new UCSQueueingFunction();
			// Add more strategies as needed
			default:
				throw new IllegalArgumentException("Unknown strategy: " + strategy);
		}
	}

	// Helper method to parse the initial state from a string input
    private static State parseInitialState(String initialState) {
        // Implement the logic to parse the string and create a State object
        return null;  // Placeholder
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
    private Node generateChildNode(SearchTreeNode parent, String action, GenericSearch problem) {
        State newState = applyAction(parent.getState(), action);  // Apply the pour action
        int newPathCost = parent.getPathCost() + 1;  // Increase the path cost
        int heuristicValue = calculateHeuristic(newState);  // Calculate heuristic for the new state
        int heuristicType=parent.getHeuristictype();
        return new Node(newState, parent, action, newPathCost, parent.getDepth() + 1, heuristicValue,heuristicType);
    }
    // Define valid actions (pour actions) based on the current state
    private List<String> getValidActions(State state) {
        List<String> actions = new ArrayList<>();
        WaterBottle[] bottles = state.getBottles();

        // Iterate over all pairs of bottles and add valid pour actions
        for (int i = 0; i < bottles.length; i++) {
            for (int j = 0; j < bottles.length; j++) {
                if (i != j && bottles[i].canPourInto(bottles[j])) {
                    actions.add("pour(" + i + "," + j + ")");
                }
            }
        }
        return actions;
	}
    // Apply the pour action to the state and return the new state
    private State applyAction(State state, String action) {
        String[] parts = action.replace("pour(", "").replace(")", "").split(",");
        int fromBottle = Integer.parseInt(parts[0]);
        int toBottle = Integer.parseInt(parts[1]);

        // Clone the state and perform the action
        State newState = state.cloneState();
        newState.performAction(fromBottle, toBottle);
        return newState;
    }

    // Calculate a heuristic value for the state
    private int calculateHeuristic(State state) {
        // Implement heuristic function (e.g., number of bottles with mixed colors, etc.)
        int heuristic = 0;
        WaterBottle[] bottles = state.getBottles();

        // Example heuristic: Count bottles that are not fully sorted
        for (WaterBottle bottle : bottles) {
            if (!bottle.isSorted()) {
                heuristic++;
            }
        }
        return heuristic;
    }
	@Override
	public boolean isGoal(State state) {
		return state.isGoal();
	}	
	
	@Override
	public int pathCost(String action) {
		return 1;  // Each pour action has a cost of 1
	}




    @Override
    public List<SearchTreeNode> expand(SearchTreeNode node, GenericSearch problem) {
        List<SearchTreeNode> children = new ArrayList<>();

        // Iterate over all valid actions (pour from one bottle to another)
        for (String action : getValidActions(node.getState())) {
            SearchTreeNode child = generateChildNode(node, action, problem);
            children.add(child);
        }

        return children;
    }



}

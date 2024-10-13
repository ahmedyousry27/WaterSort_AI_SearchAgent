package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WaterSortSearch extends GenericSearch {

	public WaterSortSearch(State initialState, String[] actions, State StateSpace) {
		super(initialState, actions, StateSpace);
	}

	
	
	
	public static String solve(String initialState, String strategy, boolean visualize) {
        // Create the initial state object (you need to implement the logic to parse the string)
        State initialStateObj = parseInitialState(initialState);

        // Create an instance of WaterSortSearch with the parsed initial state
        WaterSortSearch waterSortSearch = new WaterSortSearch(initialStateObj, new String[]{}, null);
        waterSortSearch.getIsRepeated().add(initialStateObj);
        if (strategy.equals("ID"))
        {
    		QueueingFunction qFunction = getQueueingFunctionForStrategy(strategy);
    		((IDSQueueingFunction)qFunction).iterativeDeepeningSearch(waterSortSearch);
            
            }
        
        
		// Map the strategy to the appropriate QueueingFunction
		QueueingFunction qFunction = getQueueingFunctionForStrategy(strategy);
        // Call the generic search function and get the solution node
		if (qFunction instanceof IDSQueueingFunction)
		{
    		Node solution=((IDSQueueingFunction)qFunction).iterativeDeepeningSearch(waterSortSearch);
            if (solution != null) {
                return waterSortSearch.formatSolution(solution);  // Return solution in required format
            } else {
                return "nosolution";
            }

		}
        Node solution = waterSortSearch.genericSearch(waterSortSearch, qFunction);  // Modify strategy handling as per your implementation

        // Return formatted solution or "NOSOLUTION" if no solution found
        if (solution != null) {
            return waterSortSearch.formatSolution(solution);  // Return solution in required format
        } else {
            return "nosolution";
        }
    }

		// Helper method to map the strategy string to the appropriate QueueingFunction
	public static QueueingFunction getQueueingFunctionForStrategy(String strategy) {
		switch (strategy) {
			case "BF":
				return new BFSQueueingFunction();
			case "DF":
				return new DFSQueueingFunction();
			case "UC":
				return new UCSQueueingFunction();
			case "ID":
				return new IDSQueueingFunction();
			case "GR1":
				return new GreedyQueueingFunction();
			case "GR2":
				return new GreedyQueueingFunction();
			case "AS1":
				return new AStarQueueingFunction();
			case "AS2":
				return new AStarQueueingFunction();
			// Add more strategies as needed\\\\\\\\
			default:
				throw new IllegalArgumentException("Unknown strategy: " + strategy);
		}
	}

	// Helper method to parse the initial state from a string input
    public static State parseInitialState(String initialState) {
    	String []arrayIntialState=initialState.split(";");
    	int numberOfBottles=Integer.parseInt(arrayIntialState[0]);
    	int bottleCapacity=Integer.parseInt(arrayIntialState[1]);
    	WaterBottle[] bottles=new WaterBottle[numberOfBottles];
    	for (int i=0;i<numberOfBottles;i++)
    	{
    		String []stringLayers=arrayIntialState[i+2].split(",");
    		Stack<String>layers=new Stack<>();
    		for (int j=stringLayers.length-1;j>=0;j--)
    		{
    			if (!stringLayers[j].equals("e"))
    			{
    				layers.add(stringLayers[j]);
    			}
    		}
    		WaterBottle waterBottle=new WaterBottle (bottleCapacity,layers);
    		bottles[i]=waterBottle;
    	}
    	State intialState=new State(bottles);
    	
    	return intialState;  
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
	    plan.deleteCharAt(plan.length() - 1);
	    return plan.toString() + ";" + pathCost + ";" + getTraverseSequence().size();
	}
	
	
    // Generate child node based on an action and current state, adding heuristic value
    public Node generateChildNode(Node parent, String action) {
        State newState = applyAction(parent.getState(), action);  // Apply the pour action
        int newPathCost = pathCost(parent.getState(),newState)+parent.getPathCost();  // Increase the path cost
        int heuristicValue = calculateHeuristic(newState,parent.getHeuristictype());  // Calculate heuristic for the new state
        boolean heuristicType=parent.getHeuristictype();
    
        if (getIsRepeated().contains(newState))
        {
			  return null; // detect repeated state
        }
        else {
        	getIsRepeated().add(newState);
        	//newState.printState();
        return new Node(newState, parent, action, newPathCost, parent.getDepth() + 1, heuristicValue,heuristicType);
        }
        }
    
    // Define valid actions (pour actions) based on the current state
    public List<String> getValidActions(State state) {

        List<String> actions = new ArrayList<>();
        WaterBottle[] bottles = state.getBottles();

        // Iterate over all pairs of bottles and add valid pour actions
        for (int i = 0; i < bottles.length; i++) {
            for (int j = 0; j < bottles.length; j++) {
                if (i != j && bottles[i].canPourInto(bottles[j])) {
                    actions.add("pour_" + i + "_" + j );
                }
            }
        }
        return actions;
	}
    // Apply the pour action to the state and return the new state
    private State applyAction(State state, String action) {
    	String[] parts = action.replace("pour_", "").split("_");
        int fromBottle = Integer.parseInt(parts[0]);
        int toBottle = Integer.parseInt(parts[1]);

        // Clone the state and perform the action
        State newState = state.cloneState();
        newState.performAction(fromBottle, toBottle);
        return newState;
    }

    // Calculate a heuristic value for the state
    private int calculateHeuristic(State state, boolean heuristicType) {
        // Implement heuristic function (e.g., number of bottles with mixed colors, etc.)
    	int heuristic = 0;
    	WaterBottle[] bottles = state.getBottles();
    	
    	if (!heuristicType) // case heuristic == 0 // heuristic(1)
    	{ 
//         Count bottles that are not fully sorted
	        for (WaterBottle bottle : bottles) 
	        {
	            if (!bottle.isSorted())
	            {
	                heuristic++;
	            }
	        }
    	}
        else // case heuristic ==1  // heuristic(2)
        {     
//        	Sum of mismatched layers in each bottle
        	for (WaterBottle bottle : bottles)
        	{
                 heuristic += bottle.countMismatchedLayers();  
            }
        }
        
        return heuristic;
    
    }
    

	@Override
	public boolean isGoal(State state) {

		return state.isGoal();
		
	}	
	
	public int pathCost(State parentState, State childState) {
	    int totalCost = 0;
	    WaterBottle parentBottles []= parentState.getBottles();
	    WaterBottle childBottles []  = childState.getBottles();

	    for (int i = 0; i < parentBottles.length; i++) {
	        WaterBottle parentBottle = parentBottles[i];
	        WaterBottle childBottle = childBottles[i];

	        int layersRemovedFromParent = parentBottle.getLayers().size() - childBottle.getLayers().size();

	        if (layersRemovedFromParent > 0) {
	            totalCost += layersRemovedFromParent;
	        }
	    }

	    return totalCost;
	}


    @Override
    public List<Node> expand(Node node) {
        List<Node> children = new ArrayList<>();

        // Iterate over all valid actions (pour from one bottle to another)
        for (String action : getValidActions(node.getState())) {
        	//System.out.println(action);
            Node child = generateChildNode(node, action);

            if (child !=null) {
            children.add(child);

            }
        }

        return children;
    }



}

package generic;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import game.Node;
public abstract class GenericSearch {
	
	private State intialState;//representing initial world configuration
	private String[] actions; //Available for the agent to perform
	private State StateSpace; //set of states reachable from initial state
	
	public GenericSearch(State intialState , String [] actions,State StateSpace) {
		this.intialState=intialState;
		this.actions=actions;
		this.StateSpace=StateSpace;
	}
	
	public String genericSearch(GenericSearch problem,String strategy)
	{
	    Queue<Node> qingFun = getQueueForStrategy(strategy); 
	    Node initialNode = makeNode(problem.intialState);
        qingFun.add(initialNode);

        while (!qingFun.isEmpty()) {
            Node node = qingFun.poll();  // Dequeue the first node

/*            if (goalTest(node)) {  // Check if this node is the goal
                return node;
                }
                
            qingFun.addAll(expand(node, problem));  // Expand and add to the queue
                */ 
            }       
		return null;// Return null if no solution is found
	}
	
	  // Determine the appropriate queue based on the search strategy
    private Queue<Node> getQueueForStrategy(String strategy) {
        switch (strategy) {
            case "BF": return new LinkedList<>();  // BFS uses FIFO queue
            case "DF": return new ArrayDeque<>();  // DFS uses LIFO (stack)
            case "UC": return new PriorityQueue<>(Comparator.comparingInt(Node::getPathCost));  // UCS
            case "GR1":
                return new PriorityQueue<>(Comparator.comparingInt(Node::getHeuristicValue));  // Greedy with heuristic 1
            case "AS1":
                return new PriorityQueue<>(Comparator.comparingInt(node -> node.getPathCost() + node.getHeuristicValue()));  // A* with heuristic 1
            case "AS2":
                return new PriorityQueue<>(Comparator.comparingInt(node -> node.getPathCost() + node.getHeuristicValue()));  // A* with heuristic 2
            default: return new LinkedList<>();  // Default to BFS if unspecified
        }
    }

    // Helper method to create the initial node
    private Node makeNode(State initialState) {
        return new Node(initialState, null, null, 0, 0,0,0);  // Create root node
    }    
	//abstract methods
    //is goal in lecture is implemeted inside genericseach(search problem) if that is right? we should delete it from SearchTreeNode
	public abstract boolean isGoal(State node);
	public abstract int pathCost(String action);
    public abstract List<Node> expand(Node node, GenericSearch problem); // Expand nodes
	
}

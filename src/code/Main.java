package code;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import code.WaterSortSearch;
public class Main {


		public static void main (String[] args) {
		    String grid0 = "3;" +
		            "4;" +
		            "r,y,r,y;" +
		            "y,r,y,r;" +
		            "e,e,e,e;";
		    
		    
			/*
			 * String init = "5;4;" + "b,y,r,b;" + "b,y,r,r;" + "y,r,b,y;" + "e,e,e,e;" +
			 * "e,e,e,e;";
			 */
			  State parsedInput=WaterSortSearch.parseInitialState(grid0);
	        WaterSortSearch waterSortSearch = new WaterSortSearch(parsedInput, new String[]{}, null);
		    String solution=waterSortSearch.solve(grid0, "BF", false);
		    System.out.println(solution);
			/*
			 * State parsedInput=WaterSortSearch.parseInitialState(init);
			 * //solution.printState();
			 * 
			 * WaterSortSearch waterSortSearch = new WaterSortSearch(parsedInput, new
			 * String[]{}, null);
			 * 
			 * QueueingFunction qFunction =
			 * waterSortSearch.getQueueingFunctionForStrategy("BF");
			 * //((State)waterSortSearch.getInitialState()).printState(); Node initialNode
			 * =waterSortSearch.makeNode(waterSortSearch.getInitialState());
			 * //initialNode.getState().printState(); qFunction.enqueue(initialNode);
			 * //((BFSQueueingFunction)qFunction).displayQueue(); while
			 * (!qFunction.isEmpty()) { Node node; node = qFunction.dequeue(); // Dequeue
			 * the node if (waterSortSearch.isGoal(node.getState())) {
			 * 
			 * ((Node) node).display(); // Return the goal node if found } //List<Node>
			 * expandedNodes = waterSortSearch.expand(node);
			 * //System.out.println(expandedNodes); //List<String> expandedNodes =
			 * waterSortSearch.getValidActions(node.getState());
			 * //System.out.println(expandedNodes);
			 * 
			 * List<String> actions = new ArrayList<>(); WaterBottle[] bottles =
			 * node.getState().getBottles(); for (int i=0 ; i<bottles.length;i++) {
			 * bottles[i].printBottle(); }
			 * 
			 * // Iterate over all pairs of bottles and add valid pour actions for (int i =
			 * 0; i < bottles.length; i++) { for (int j = 0; j < bottles.length; j++) { if
			 * (i != j && bottles[i].canPourInto(bottles[j])) {
			 * System.out.println(bottles[i].getTopColor());
			 * 
			 * actions.add("pour(" + i + "," + j + ")"); } } } System.out.println(actions);
			 * List<Node> children = new ArrayList<>(); for (String action : actions) { Node
			 * child = waterSortSearch.generateChildNode(node, action); if (child !=null) {
			 * children.add(child); } } for (Node child : children) { child.display(); }
			 * 
			 * // return actions;
			 * 
			 * }
			 * 
			 * 
			 * 
			 * 
			 * // Node solution = waterSortSearch.genericSearch(waterSortSearch, qFunction);
			 * //System.out.println(solution);
			 * 
			 */
		}
}

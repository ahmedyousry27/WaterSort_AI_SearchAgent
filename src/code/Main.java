package code;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import code.WaterSortSearch;

public class Main {

	public static void main(String[] args) {
		/*
		 * String grid0 = "3;" + "4;" + "r,y,r,y;" + "y,r,y,r;" + "e,e,e,e;";
		 * 
		 * 
		 * 
		 * String init = "5;4;" + "b,y,r,b;" + "b,y,r,r;" + "y,r,b,y;" + "e,e,e,e;" +
		 * "e,e,e,e;";
		 * 
		 * State parsedInput=WaterSortSearch.parseInitialState(grid0); WaterSortSearch
		 * waterSortSearch = new WaterSortSearch(parsedInput, new String[]{}, null);
		 * String solution=waterSortSearch.solve(grid0, "BF", false);
		 * System.out.println(solution);
		 */
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
		String solution = "pour02,pour12,pour10,pour01,pour12,pour21,pour02,pour20,pour01,pour02,pour12,pour10,pour02,pour12,pour02,pour20,pour10,pour01,pour12,pour21,pour10,pour10;6;6;";
        boolean x = true;
        solution = solution.toLowerCase();
        if (solution.equals("nosolution")) {
            System.out.println(false);
        }
//        System.out.println(solution);
        String[] y  = solution.split(";");
        String z = y[0];
        int _a = Integer.parseInt(y[1]);
        System.out.println(_a);
		/*
		 * for (String string : y) { System.out.println(string); }
		 */
        z.replace(" ", "");
        z.replace("\n", "");
        z.replace("\r", "");
        z.replace("\n\r", "");
        z.replace("\t", "");

        String[] j = z.split(",");
		/*
		 * for (String string : _b) { System.out.println(string); }
		 */
        for (int a=0; a<j.length; a++){
            String[] k = j[a].split("_");
            for (String string : k) { System.out.println(string);}
        }
		   

	}
}

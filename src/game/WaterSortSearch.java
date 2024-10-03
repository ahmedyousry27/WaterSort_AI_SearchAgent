package game;

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
		-create waterSort object function
		-call generic search function inhereted from generic search (watersort problem,strategy)
		-return solution*/
		return " ";//return String of 3 elements plan;pathCost;nodesExpanded 
		//if no solution print "NOSOLUTION"
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





}

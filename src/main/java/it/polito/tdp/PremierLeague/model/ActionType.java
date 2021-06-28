package it.polito.tdp.PremierLeague.model;

public enum ActionType {
	
	GOAL(50), 
	ESPULSIONE(30),
	INFORTUNIO(20);
	
	private int probabilità;

	private ActionType(int probabilità) {
		this.probabilità = probabilità;
	}
	
	

}

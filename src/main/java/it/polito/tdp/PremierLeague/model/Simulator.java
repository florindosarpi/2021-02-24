package it.polito.tdp.PremierLeague.model;

import java.util.LinkedList;

public class Simulator {
	
	
	private LinkedList<Azione> azioni ;
	
	private int N ; // numero azioni dato dall'utente
	private Match m; // per la partita m 
	
	private Squadra s1;
	private Squadra s2;
	private Integer g1;
	private Integer g2;
	private Model modello ;
	
	public void init(Match partita, Integer num, Model model) {
		this.N = num;
		this.m = partita;
		s1 = new Squadra(partita, partita.getTeamHomeID());
		s2 = new Squadra(partita, partita.getTeamAwayID());
		this.g1 = 11;
		this.g2 = 11;
		this.modello = model;
	}
	
	
	
	public String run (Match partita, Integer num, Model model) {
		this.init(partita, num, model);
		
		Player giocatore = model.getBest();
		Integer teamID = model.getTeamByPlayer(giocatore.playerID);
		int num2 = 0;
		System.out.println("Partita: ");
		for(int i = 1; i<=num; i++) {
			Integer p = (int) (Math.random() *100);
			if(p<=50) {
				if(g1>g2) {
					s1.addGoal();
					System.out.println("Goal per s1");
				} else if(g1<g2) {
					s2.addGoal();
					System.out.println("Goal per s2");
				} else {
					if(s1.getTeamId().equals(teamID)) {
						s1.addGoal();
						System.out.println("Goal per s1");
					} else if(s2.getTeamId().equals(teamID)) {
						s2.addGoal();
						System.out.println("Goal per s2");
					}
				}
			} else if(p>50 && p<= 80) {
				Integer p2 = (int) (Math.random() * 100);
				if(p2<=60) {
					if(s1.getTeamId().equals(teamID)) {
						s1.addEspulsione();
						g1--;
						System.out.println("Espulsione per s1");
					} else if(s2.getTeamId().equals(teamID)) {
						s2.addEspulsione();
						g2--;
						System.out.println("Espulsione per s2");
					}
				}else {
					if(!s1.getTeamId().equals(teamID)) {
						s1.addEspulsione();
						g1--;
						System.out.println("Espulsione per s1");
					} else if(!s2.getTeamId().equals(teamID)) {
						s2.addEspulsione();
						g2--;
						System.out.println("Espulsione per s2");
					}
				}
			}else {
				Integer p3 = (int)(Math.random()*100);
				System.out.println("Infortunio");
				if(p3<=50) {
					num2 = num2 + 2;
				}else {
					num2 = num2 + 3;
				}
			}
		}
		
		if (num2 > 0) {
			System.out.println("Tempo di recupero: ");
			for(int i = 1; i<=num2; i++) {
				Integer p = (int) (Math.random() *100);
				if(p<=50) {
					if(g1>g2) {
						s1.addGoal();
						System.out.println("Goal per s1");
					} else if(g1<g2) {
						s2.addGoal();
						System.out.println("Goal per s2");
					} else {
						if(s1.getTeamId().equals(teamID)) {
							s1.addGoal();
							System.out.println("Goal per s1");
						} else if(s2.getTeamId().equals(teamID)) {
							s2.addGoal();
							System.out.println("Goal per s2");
						}
					}
				} else if(p>50 && p<= 80) {
					Integer p2 = (int) (Math.random() * 100);
					if(p2<=60) {
						if(s1.getTeamId().equals(teamID)) {
							s1.addEspulsione();
							g1--;
							System.out.println("Espulsione per s1");
						} else if(s2.getTeamId().equals(teamID)) {
							s2.addEspulsione();
							g2--;
							System.out.println("Espulsione per s2");
						}
					}else {
						if(!s1.getTeamId().equals(teamID)) {
							s1.addEspulsione();
							g1--;
							System.out.println("Espulsione per s1");
						} else if(!s2.getTeamId().equals(teamID)) {
							s2.addEspulsione();
							g2--;
							System.out.println("Espulsione per s2");
						}
					}
				}
			}
		}
		
		
		String result = "Squadra : " +s1.getTeamId() +" numero di goal: " +s1.getGoal() +" num giocatori " +g1 +"\n";
		result += "Squadra : " +s2.getTeamId() +" numero di goal " +s2.getGoal() +" num giocatori " +g2 +"\n";
		
		return result;
	}
	
	

}

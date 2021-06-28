package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	
	private PremierLeagueDAO dao;
	private Graph<Player, DefaultWeightedEdge> grafo;
	private Map<Integer, Player> idMap;
	private Player best;
	private Simulator sim;
	public Model() {
		dao = new PremierLeagueDAO();
		idMap = new HashMap<>();
		sim = new Simulator();
	}
	
	public List<Match> getAllMatches(){
		List<Match> result = this.dao.listAllMatches();
		Collections.sort(result);
		return result;
	}
	
	
	public List<Player> getVertici(Match m){
		return dao.getVertici(m, idMap);
	}
	
	public String creaGrafo(Match m) {
		grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(this.grafo, dao.getVertici(m, idMap));
		String result = "Grafo creato" +"\n";
		result += "#VERTICI: " +grafo.vertexSet().size() +"\n";
		
		Map<Player, Arco> archi = dao.getArchi(m, idMap);
		for(Player p1 : this.grafo.vertexSet()) {
			for (Player p2 : this.grafo.vertexSet()) {
				if(p1.getPlayerID() != p2.getPlayerID()) {
					if(archi.get(p1).team != archi.get(p2).team) {
						double peso = Math.abs(archi.get(p1).getEfficienza() - archi.get(p2).getEfficienza()) ;
						if(archi.get(p1).getEfficienza() >= archi.get(p2).getEfficienza()) {
							Graphs.addEdgeWithVertices(grafo, p1, p2, peso);
						} else if (archi.get(p1).getEfficienza() < archi.get(p2).getEfficienza()){
							Graphs.addEdgeWithVertices(grafo, p2, p1, peso);
						}
					}
				}
			}
		}
		result += "#ARCHI: " + grafo.edgeSet().size() +"\n";
		
		return result;
	}
	

	public String getBestPlayer() {
		Player result = null;
		double e = 0;
		for (Player p : grafo.vertexSet()) {
			double sommaUscenti = 0.0;
			double sommaEntranti = 0.0;
			for (DefaultWeightedEdge d : grafo.outgoingEdgesOf(p)) {
				sommaUscenti += grafo.getEdgeWeight(d);
			}
			for (DefaultWeightedEdge f : grafo.incomingEdgesOf(p)) {
				sommaEntranti += grafo.getEdgeWeight(f);
			}
			double delta = sommaUscenti - sommaEntranti;
			if (delta > e) {
				e = delta;
				result = p;
				this.best = p;
			}
		}
		String risultato = "Il giocatore migliore è: " + result.toString() + "delta efficienza = " +String.format("%.2f", e);
		
		return risultato;
	}
	
	public Player getBest() {
		return this.best;
	}
	
	public Integer getTeamByPlayer(Integer pID) {
		return this.dao.getTeamByPlayer(pID);
	}
	
	public String risultatoSim(Match partita, Integer num) {
		return this.sim.run(partita, num, this);
	}

	
}

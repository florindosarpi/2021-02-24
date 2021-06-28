package it.polito.tdp.PremierLeague.model;

public class Squadra {
	
	private Match partita;
	private Integer teamId;
	private Integer goal;
	private Integer espulsioni;
	private Integer infortuni;
	public Squadra(Match partita, Integer teamId) {
		super();
		this.partita = partita;
		this.teamId = teamId;
		this.goal = 0;
		this.espulsioni = 0;
		this.infortuni = 0;
	}
	public Match getPartita() {
		return partita;
	}
	public void setPartita(Match partita) {
		this.partita = partita;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public Integer getGoal() {
		return goal;
	}
	public void setGoal(Integer goal) {
		this.goal = goal;
	}
	public Integer getEspulsioni() {
		return espulsioni;
	}
	public void setEspulsioni(Integer espulsioni) {
		this.espulsioni = espulsioni;
	}
	public Integer getInfortuni() {
		return infortuni;
	}
	public void setInfortuni(Integer infortuni) {
		this.infortuni = infortuni;
	}
	
	public void addGoal() {
		this.goal ++;
	}
	public void addEspulsione() {
		this.espulsioni ++;
	}
	public void addInfortunio() {
		this.infortuni ++;
	}
	
	

}

package it.polito.tdp.PremierLeague.model;

public class Arco {
	
	Player p;
	float efficienza;
	Integer team;
	
	
	public Arco(Player p, float efficienza2, Integer team) {
		super();
		this.p = p;
		this.efficienza = efficienza2;
		this.team = team;
	}
	public Player getP() {
		return p;
	}
	public void setP(Player p) {
		this.p = p;
	}
	public Float getEfficienza() {
		return efficienza;
	}
	public void setEfficienza(float efficienza) {
		this.efficienza = efficienza;
	}
	public Integer getTeam() {
		return team;
	}
	public void setTeam(Integer team) {
		this.team = team;
	}
	
	
	

}

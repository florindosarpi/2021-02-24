package it.polito.tdp.PremierLeague.model;

public class Azione {
	
	private ActionType tipoAzione;
	private Integer numAzione;
	private Player best;
	
	public Azione(ActionType tipoAzione, Integer numAzione,
			Player best) {
		super();
		this.tipoAzione = tipoAzione;
		this.numAzione = numAzione;
		this.best = best;
	}

	public ActionType getTipoAzione() {
		return tipoAzione;
	}

	public void setTipoAzione(ActionType tipoAzione) {
		this.tipoAzione = tipoAzione;
	}


	public Integer getNumAzione() {
		return numAzione;
	}

	public void setNumAzione(Integer numAzione) {
		this.numAzione = numAzione;
	}

	public Player getBest() {
		return best;
	}

	public void setBest(Player best) {
		this.best = best;
	}
	
	
	
	

}

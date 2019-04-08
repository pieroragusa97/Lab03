package it.polito.tdp.spellchecker.model;

public class RichWord {
	private String parola;
	private boolean stato;
	
	public RichWord(String parola, boolean stato) {
		super();
		this.parola = parola;
		this.stato = stato;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isStato() {
		return stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	
	

}

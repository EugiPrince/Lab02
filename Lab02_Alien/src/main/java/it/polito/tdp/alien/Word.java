package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class Word {
	
	private String parola;
	private String traduzione;
	private List<String> traduzioniMultiple= new LinkedList<>();
	private int contatore;
	
	public Word(String parola, String traduzione) {
		this.parola = parola;
		this.traduzione = traduzione;
		
		this.traduzioniMultiple.add(traduzione);
		this.contatore = 0;
	}
	
	public boolean equals(Object o) {
		Word altra = (Word)o;
		if(this.parola.compareTo(altra.parola)==0)
			return true;
		return false;
	}

	public void setTraduzione(String traduzione) {
		this.traduzione = traduzione;
	}

	public String getParola() {
		return parola;
	}

	public String getTraduzione() {
		return traduzione;
	}
	
	public void addTraduzione(String traduzione) {
		this.traduzioniMultiple.add(traduzione);
	}
	
	public String elencoTraduzioni() {
		String s = "";
		for(String ss : this.traduzioniMultiple)
			s += ss+"\n";
		
		return s;
	}
	
	public void incrementaContatore() {
		this.contatore++;
	}
	
	public int getContatore() {
		return this.contatore;
	}
}

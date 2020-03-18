package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	private List<Word> dizionario = new ArrayList<>();
	
	public List<Word> getDizionario() {
		List<Word> elenco = new LinkedList<>();
		
		for(Word w : dizionario)
			elenco.add(w);
		
		return elenco;
	}

	public void add(Word w) {
		
		//Nel caso di esercizio 1
		/*for(Word wo : dizionario)
			if(wo.equals(w))
				wo.setTraduzione(w.getTraduzione());
		*/
		for(Word wo : dizionario)
			if(wo.equals(w))
				wo.addTraduzione(w.getTraduzione());
		
		this.dizionario.add(w);
	}
	
	public Word getParola(int i) {
		return dizionario.get(i);
	}
	
	public String traduciParola(String alienWord) {
		//In esercizio 1
		/*for(Word w : dizionario)
			if(w.getParola().compareTo(alienWord)==0)
				return w.getTraduzione();
		return null;*/
		
		//Esercizio 2
		for(Word w : dizionario) {
			if(w.getParola().compareTo(alienWord)==0)
				return w.elencoTraduzioni();
		}
		return null;
	}
	
}

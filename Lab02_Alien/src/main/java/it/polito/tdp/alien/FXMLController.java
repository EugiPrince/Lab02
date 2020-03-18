package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary dizionario = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTesto;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String ts = txtTesto.getText();
    	ts.toLowerCase();
    	
    	//AGGIUNTA AL DIZIONARIO
    	if(ts.contains(" ")) {
    		String array[] = ts.split(" ");
        	String parola = array[0];
        	String traduzione = array[1];
        	
        	if(this.controlloParola(parola) || this.controlloParola(traduzione)) {
        		txtResult.setText("Devi inserire delle parole con caratteri validi"); // o append ?
        	}
        	
        	Word w = new Word(parola, traduzione);
        	
        	dizionario.add(w);
    	}
    	
    	//TRADUZIONE DELLA PAROLA
    	else {
    		//nel caso di esercizi 1 e 2 
    		/*if(this.controlloParola(ts))
    			txtResult.setText("Devi inserire delle parole con caratteri validi");
    		*/
    		String risultato = "";
    		if(ts.contains("?")) {
    			int posizioneWild = ts.indexOf("?");
    			List<Word> corrette = new LinkedList<>();
    			for(Word w : dizionario.getDizionario()) {
    				if(w.getParola().length()==ts.length()) {
    					if(w.getParola().substring(0, posizioneWild).compareTo(ts.substring(0, posizioneWild))==0
    							&& w.getParola().substring(posizioneWild+1).compareTo(ts.substring(posizioneWild+1))==0) {
    						corrette.add(w);
    					}
    				}
    			}
    			
    			for(Word w : corrette)
    				txtResult.appendText("\nLa parola aliena "+ts+" potrebbe corrispondere a "+w.getTraduzione());
    				
    		}
    		else {
    			risultato = dizionario.traduciParola(ts);
    		}
    		
    		if(risultato==null) {
    			txtResult.setText("La parola cercata non e' presente nel dizionario");
    			return;
    		}
    		
    		txtResult.appendText(risultato);
    	}
    	
    }

    @FXML
    void initialize() {
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    private  boolean controlloParola(String parola) {
    	for(int i=0; i<parola.length(); i++)
    		if(!Character.isAlphabetic(parola.charAt(i)))
    			return true;
    	
    	return false;
    }
}

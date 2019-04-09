package it.polito.tdp.spellchecker.controller;

	import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextArea;

	public class SpellCheckerController {
		ObservableList<String> comboBoxOpzioni=FXCollections.observableArrayList("English","Italian");
		// Inserisco i valori che voglio dentro la combobox
		
		private Dictionary model; // creo un model 
		
		public void setModel(Dictionary model) {
			this.model = model;
		}
		
		@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ComboBox<String> btnChoose;

	    @FXML
	    private TextArea AreaInserimento;

	    @FXML
	    private Button btnSpellCheck;

	    @FXML
	    private TextArea AreaErrori;

	    @FXML
	    private Label tempo;

	    @FXML
	    private Label errori;

	    @FXML
	    private Button btnClearText;

	    @FXML
	    void doChoose(ActionEvent event) {
	    	if(btnChoose.isShowing()) {      /*imparare bene i metodi per le combobox*/
	    	 model.loadDictionary(btnChoose.getValue());  /* prendo la lingua selezionata*/
	    	 //AreaErrori.appendText(model.getParole().get(14)); mi serve per controllare se inserisce le parole
	    	}
        }
	   
	    @FXML
	    void doClear(ActionEvent event) {
	    	if(btnClearText.isArmed()) {
	    		AreaErrori.clear();
	    		AreaInserimento.clear();
	    	}
	    }

	    @FXML
	    void doSpellCheck(ActionEvent event) {
	    	if(btnSpellCheck.isArmed()) {
	    	    LinkedList<String> parole=new LinkedList<String>();
	    	    AreaInserimento.getText().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_'()\\[\\]\"]","");
	    	    AreaInserimento.getText().toLowerCase();
	    	    StringTokenizer st=new StringTokenizer(AreaInserimento.getText()," ");
	    	    
	    	    while(st.hasMoreTokens()) {         /*controllo se ci sono altri elementi*/
	    	        String parola=st.nextToken();
	    	        parole.add(parola);
	    	    }
	    	    
	            for(RichWord s: model.spellCheckTest(parole)) {      /*metto nell'areaErrori tutti gli elementi*/
	    		    if(s.isStato()==false)                             /* che sono risultati sbagliati*/
	    			     AreaErrori.appendText(s.getParola()+"\n");
	    	    }
	    	}
        }

	    @FXML
	    void initialize() {
	        assert AreaInserimento != null : "fx:id=\"AreaInserimento\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert AreaErrori != null : "fx:id=\"Area\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert tempo != null : "fx:id=\"tempo\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert errori != null : "fx:id=\"errori\" was not injected: check your FXML file 'SpellChecker.fxml'.";
	        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
            btnChoose.setItems(comboBoxOpzioni);  /*inizializzo la combobox*/
	    
	    }
	}



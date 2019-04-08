package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {
	private LinkedList<String> parole=new LinkedList<String>();
	

	public void loadDictionary(String language) {
		try {
			if(language.compareTo("English")==0) {
			FileReader fr=new FileReader("rsc/English.txt");
		    BufferedReader br=new BufferedReader(fr);
			String parola;
			while((parola=br.readLine())!=null) {
				parole.add(parola);
			}
			br.close();
			}
			
			else if(language.compareTo("Italian")==0) {
				FileReader fr=new FileReader("rsc/Italian.txt");
			    BufferedReader br=new BufferedReader(fr);
				String parola;
				while((parola=br.readLine())!=null) {
					parole.add(parola);
				}
				br.close();
			}
			
		}catch(IOException e) {
			System.out.println("errore nella lettura del file");
		}
	}
	
	public List<RichWord> spellCheckTest(List<String> inputTextList){
		LinkedList<RichWord> parole_passate=new LinkedList<RichWord>();
		List<String> parole_daPassare=inputTextList;
		for(String s:parole_daPassare) {
			if(parole.contains(s)) {
				parole_passate.add(new RichWord(s,true));
			}
			else 
				parole_passate.add(new RichWord(s,false));
				
		}
		return parole_passate;
	}

	public LinkedList<String> getParole() {
		return parole;
	}

	public void setParole(LinkedList<String> parole) {
		this.parole = parole;
	}

}

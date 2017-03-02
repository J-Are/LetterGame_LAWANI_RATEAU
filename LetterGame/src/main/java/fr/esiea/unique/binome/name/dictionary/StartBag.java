package fr.esiea.unique.binome.name.dictionary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class StartBag {

	public ArrayList arrayPotCommun = new ArrayList();
	private int indexLetter;
		
	public ArrayList addPotCommun(char letter){
		this.arrayPotCommun.add(letter);
		return this.arrayPotCommun;
	}
	
	public ArrayList delete_pot_commun(ArrayList pot_commun, char letter){
		
	 for(int i=0;i<pot_commun.size();i++){
		
		 if(this.arrayPotCommun.contains(letter)==true){
			 
		   System.out.println("Suppression");
		   this.arrayPotCommun.remove(i);
		 
		 }

		 
	 }
	 
	 return this.arrayPotCommun;
	}	 
	 
	 
	
	
	public void print_Pot_commun(ArrayList pot_commun){


		System.out.println("POT COMMUN: ");	

		for(int i = 0; i < pot_commun.size(); i++)
	    {

	      System.out.println("donnée à l'indice " + i + " = " + pot_commun.get(i));
	    }  
		
	}
	
	public static int toASCII(char letter)
	{
	return (int)letter;
	} 
	
	public int who_Starts(int letter_P1, int letter_P2){
		
	 	if(letter_P1<letter_P2){
	 		return 1;
	 	}
		
	 	if(letter_P1>letter_P2){
	 		return 2;
	 	}
	 	if(letter_P1==letter_P2){

	 	    return 3;

	 	}
	 	
	 	return 0;
	}
	

	public boolean isTheWordPresentInTheBag(ArrayList pot_commun, char lettre){
		return pot_commun.contains(lettre);
		
	}
	
	public boolean isItAGoodWord(ArrayList pot_commun,char tab_mot[]){
		boolean bool=true;
		
		for(int i=0;i<tab_mot.length;i++){
			bool=isTheWordPresentInTheBag(pot_commun,tab_mot[i]);
		 
			if(bool==false){
				return false;
			}
		}
		
		return true;
	}

}

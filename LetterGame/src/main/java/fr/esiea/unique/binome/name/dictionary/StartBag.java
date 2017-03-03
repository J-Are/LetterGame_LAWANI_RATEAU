package fr.esiea.unique.binome.name.dictionary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class StartBag {

	public ArrayList array_pot_commun = new ArrayList();
	private int indexLetter;
		
	
	
	public ArrayList add_pot_commun(char letter){
		this.array_pot_commun.add(letter);
		return this.array_pot_commun;
	}
	
	public ArrayList delete_pot_commun(ArrayList pot_commun, char letter){
		
	 for(int i=0;i<pot_commun.size();i++){
		
		 if(this.array_pot_commun.contains(letter)==true){
			 
		   System.out.println("Suppression");
		   this.array_pot_commun.remove(i);
		 
		 }

		 
	 }
	 
	 return this.array_pot_commun;
	}	 

	
	public ArrayList deleteLettersWhenWordIsGood(ArrayList pot_commun, char tab_mot[]){
		
		 for(int i=0;i<tab_mot.length;i++){
			 
			 for(int j=0;j<pot_commun.size();j++){
			
			  if(this.array_pot_commun.get(j).equals(tab_mot[i])){
				 
			   System.out.println("Suppression Lettre: "+tab_mot[i]+"à la case "+i);
			   this.array_pot_commun.remove(j);
			   
			 
			  }
			 }
			 
		 }
		 
		 return this.array_pot_commun;
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
	

	public boolean is_the_Word_present_in_the_Bag(ArrayList pot_commun, char lettre){
		return pot_commun.contains(lettre);
		
	}
	
	public boolean is_it_a_good_Word(ArrayList pot_commun,char tab_mot[]){
		boolean bool=true;
		
		for(int i=0;i<tab_mot.length;i++){
			bool=is_the_Word_present_in_the_Bag(pot_commun,tab_mot[i]);
		 
			if(bool==false){
				return false;
			}
		}
		
		return true;
	}

}

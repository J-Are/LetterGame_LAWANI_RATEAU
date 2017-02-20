package fr.esiea.unique.binome.name.dictionary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class StartBag {
	ArrayList array_pot_commun = new ArrayList();
	
	public ArrayList add_pot_commun(char letter){
		this.array_pot_commun.add(letter);
		return this.array_pot_commun;
	}
	
	public void print_Pot_commun(ArrayList pot_commun){
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
	
	
	

}

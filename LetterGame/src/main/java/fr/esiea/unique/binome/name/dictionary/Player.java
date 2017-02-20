package fr.esiea.unique.binome.name.dictionary;

import java.util.ArrayList;
import java.util.Random;

public class Player {
	private int indexLetter;
	private char tabLetter[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','k','r','s','t','u','v','w','x','y','z'};
	private int nb_mot=0;
	private ArrayList mot=new ArrayList();
	private String mot_joueur;
	private char tab_mot[];
	
	public char start_Random_Letter(){
		Random r = new Random();
		this.indexLetter = r.nextInt(25);
		return this.tabLetter[this.indexLetter];
				
	}
	
	public void setMotJoueur(String mot){
		this.mot_joueur=mot;
	}
	
	public String getMotJoueur(){
		return this.mot_joueur;
	}
	

    public void two_Letters_more_in_the_Bag(char letter_P1, StartBag pot_commun){
		
		for(int i=0;i<2;i++){
			letter_P1=start_Random_Letter();
			pot_commun.add_pot_commun(letter_P1);
			
			
		}
    }
   
    public ArrayList add_pot_commun(char letter){
		this.mot.add(letter);
		return this.mot;
	}
    
    public char[] switch_into_CharTab(String mot){
    	return mot.toCharArray();
    	
    }
    
    public void printCharTab(char tabChar[]){
    	for(int i=0;i<tabChar.length;i++){
    		System.out.println("Mot: " + tabChar[i]);
    		
    	}
    	
    }
}
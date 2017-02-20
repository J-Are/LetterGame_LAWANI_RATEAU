package fr.esiea.unique.binome.name.dictionary;

import java.util.Random;

public class Player {
	private int indexLetter;
	private char tabLetter[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','k','r','s','t','u','v','w','x','y','z'};
	private int nb_mot=0;
	public char start_Random_Letter(){
		Random r = new Random();
		this.indexLetter = r.nextInt(25);
		return this.tabLetter[this.indexLetter];
		
		
	}

}

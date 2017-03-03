package fr.esiea.unique.binome.name.dictionary;

import java.util.Scanner;

public class StartGame {
	private int choix=0;
	
	
	public int getChoix(){
		return this.choix;
	}
	
	public void kindOfGame(){
	 
	 while(this.choix!=1 && this.choix!=2 ){
		System.out.println("Taper 1, si vous voulez jouer contre un autre joueur et 2 pour jouer contre l'IA");
		Scanner sc = new Scanner(System.in);
		this.choix = sc.nextInt();
	 }
		
		
	}
	
	

}

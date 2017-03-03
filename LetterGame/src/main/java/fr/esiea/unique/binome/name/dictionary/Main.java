package fr.esiea.unique.binome.name.dictionary;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
 	// TODO Auto-generated method stub

		int start=3;
		StartGame jeu=new StartGame();
	
		jeu.kindOfGame();
   
	 
	if(jeu.getChoix()==1){	
		System.out.println("Début de la partie: ");
		Player joueur1= new Player();
		Player joueur2= new Player();
		StartBag pot_Commun= new StartBag();

		char letter_P1='a';
		char letter_P2='a';
		File fichier= new File();
		
	while(start==3){		

		
		letter_P1=joueur1.start_Random_Letter();
		System.out.println("Lettre_P1: "+letter_P1);
		
		pot_Commun.add_pot_commun(letter_P1);
		
		letter_P2=joueur2.start_Random_Letter();
		pot_Commun.add_pot_commun(letter_P2);
		System.out.println("Lettre_P2: "+letter_P2);
		
		pot_Commun.print_Pot_commun(pot_Commun.array_pot_commun);
		
		int ASCII_letterP1=pot_Commun.toASCII(letter_P1);
		int ASCII_letterP2=pot_Commun.toASCII(letter_P2);
		System.out.println("Lettre_P1_ASCII: "+ASCII_letterP1);
		System.out.println("Lettre_P1_ASCII: "+ASCII_letterP2);
		
		

		start=pot_Commun.who_Starts(letter_P1, letter_P2);
		
		
		if(start==3){
				
			pot_Commun.delete_pot_commun(pot_Commun.array_pot_commun,letter_P1);
			pot_Commun.delete_pot_commun(pot_Commun.array_pot_commun,letter_P2);
			
		}
		
     }

 while(true){
	
	 System.out.println("Player: "+start+" JOUE");
	 if(start==1){
		
		 joueur1.setNumeroJoueur(1);
		 joueur1.run(joueur1,pot_Commun, letter_P1,fichier,joueur2);
		 boolean finDuJeu=joueur1.endOfTheGame(joueur2);
		 
		 if(finDuJeu==true){
			 
			 System.exit(0);
		 }
		 
		 start=2;
	 } 
     
	 System.out.println("Player: "+start+" JOUE");
	 
     if(start==2){
    	 
    	 joueur2.setNumeroJoueur(2);
    	 joueur2.run(joueur2,pot_Commun, letter_P1,fichier,joueur1);
    	 
         boolean finDuJeu=joueur2.endOfTheGame(joueur1);
		 
		 if(finDuJeu==true){
			 
			 System.exit(0);
		 }
    	 start=1;
     }
 }
     
    }
	
	if(jeu.getChoix()==2){
		
		
	}
 }
	
	

}
	
	
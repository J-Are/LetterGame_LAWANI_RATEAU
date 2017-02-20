package fr.esiea.unique.binome.name.dictionary;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start=3;
		System.out.println("Début de la partie: ");
		Player joueur1= new Player();
		Player joueur2= new Player();
		StartBag pot_Commun= new StartBag();
		char letter_P1='a';
		char letter_P2='a';
		
		
	while(start==3){	
		
		letter_P1=joueur1.start_Random_Letter();
		letter_P2=joueur1.start_Random_Letter();
		System.out.println("Lettre_P1: "+letter_P1);
		
		pot_Commun.add_pot_commun(letter_P1);
				
		pot_Commun.add_pot_commun(letter_P2);
		System.out.println("Lettre_P2: "+letter_P2);
		
		pot_Commun.print_Pot_commun(pot_Commun.array_pot_commun);
		
		int ASCII_letterP1=pot_Commun.toASCII(letter_P1);
		int ASCII_letterP2=pot_Commun.toASCII(letter_P2);
		System.out.println("Lettre_P1_ASCII: "+ASCII_letterP1);
		System.out.println("Lettre_P1_ASCII: "+ASCII_letterP2);
		
		start=pot_Commun.who_Starts(letter_P1, letter_P2);
		System.out.println("Player: "+start+" commence");
				
     }
	
	 if(start==1){
    	 joueur1.two_Letters_more_in_the_Bag(letter_P1,pot_Commun);
    	 
     }
     
     if(start==2){
    	 joueur2.two_Letters_more_in_the_Bag(letter_P1,pot_Commun);
    	 
     }
		
     pot_Commun.print_Pot_commun(pot_Commun.array_pot_commun);
    
     Scanner sc = new Scanner(System.in);
     System.out.println("Veuillez saisir un mot :");
     String mot_joueur_1 = sc.nextLine();
     joueur1.setMotJoueur(mot_joueur_1);
     System.out.println("Vous avez saisi : " +joueur1.getMotJoueur());
     
     char tab_mot[]=joueur1.switch_into_CharTab(mot_joueur_1);
     joueur1.printCharTab(tab_mot);
     
     boolean retour=pot_Commun.is_it_a_good_Word(pot_Commun.array_pot_commun,tab_mot);
     
     if(retour==true){
       System.out.println("Les lettres sont dans le pot commun");
     }
     
     if(retour==false){
         System.out.println("Les lettres ne sont pas dans le pot commun");
       }
     
     File fichier= new File();
     boolean is_Word;
     is_Word=fichier.read_File(mot_joueur_1);
     System.out.println("Retour fichier: "+is_Word);
     
    }
	
	
	
	
	 

}

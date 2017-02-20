package fr.esiea.unique.binome.name.dictionary;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Début de la partie: ");
		Player joueur1= new Player();
		Player joueur2= new Player();
		StartBag pot_Commun= new StartBag();
		
		char letter_P1=joueur1.start_Random_Letter();
		System.out.println("Lettre_P1: "+letter_P1);
		
		pot_Commun.add_pot_commun(letter_P1);
		
		char letter_P2=joueur2.start_Random_Letter();
		pot_Commun.add_pot_commun(letter_P2);
		System.out.println("Lettre_P2: "+letter_P2);
		
		pot_Commun.print_Pot_commun(pot_Commun.array_pot_commun);
		
		int ASCII_letterP1=pot_Commun.toASCII(letter_P1);
		int ASCII_letterP2=pot_Commun.toASCII(letter_P2);
		System.out.println("Lettre_P1_ASCII: "+ASCII_letterP1);
		System.out.println("Lettre_P1_ASCII: "+ASCII_letterP2);
		
		int start=pot_Commun.who_Starts(letter_P1, letter_P2);
		System.out.println("Player: "+start+" commence");

	}

}

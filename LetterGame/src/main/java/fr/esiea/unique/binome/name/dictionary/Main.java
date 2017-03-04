package fr.esiea.unique.binome.name.dictionary;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int start = 3;
		StartGame jeu = new StartGame();

		jeu.kindOfGame();

		if (jeu.getChoix() == 1) {
			System.out.println("Début de la partie: ");
			Player joueur1 = new Player();
			Player joueur2 = new Player();
			StartBag potCommun = new StartBag();

			char letter_P1 = 'a';
			char letter_P2 = 'a';
			File fichier = new File();

			while (start == 3) {

				letter_P1 = joueur1.startRandomLetter();
				System.out.println("Lettre_P1: " + letter_P1);

				potCommun.addPotCommun(letter_P1);

				letter_P2 = joueur2.startRandomLetter();
				potCommun.addPotCommun(letter_P2);
				System.out.println("Lettre_P2: " + letter_P2);

				potCommun.printPotCommun();

				int ASCII_letterP1 = potCommun.toASCII(letter_P1);
				int ASCII_letterP2 = potCommun.toASCII(letter_P2);
				System.out.println("Lettre_P1_ASCII: " + ASCII_letterP1);
				System.out.println("Lettre_P1_ASCII: " + ASCII_letterP2);

				start = potCommun.who_Starts(letter_P1, letter_P2);

				if (start == 3) {

					potCommun.deletePotCommun(letter_P1);
					potCommun.deletePotCommun(letter_P2);

				}

			}

			while (true) {

				System.out.println("Player: " + start + " JOUE");
				if (start == 1) {

					joueur1.setNumeroJoueur(1);
					joueur1.run(joueur1, potCommun, letter_P1, fichier, joueur2);
					boolean finDuJeu = joueur1.endOfTheGame(joueur2);

					if (finDuJeu == true) {

						System.exit(0);
					}

					start = 2;
				}

				System.out.println("Player: " + start + " JOUE");

				if (start == 2) {

					joueur2.setNumeroJoueur(2);
					joueur2.run(joueur2, potCommun, letter_P1, fichier, joueur1);

					boolean finDuJeu = joueur2.endOfTheGame(joueur1);

					if (finDuJeu == true) {

						System.exit(0);
					}
					start = 1;
				}
			}

		}

		if (jeu.getChoix() == 2) {

		}
	}

}

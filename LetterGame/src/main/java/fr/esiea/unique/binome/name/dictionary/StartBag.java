package fr.esiea.unique.binome.name.dictionary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class StartBag {

	public ArrayList arrayPotCommun = new ArrayList();
	private int indexLetter;

	public void addPotCommun(char letter) {
		this.arrayPotCommun.add(letter);
	}

	public void deletePotCommun(char letter) {

		for (int i = 0; i < this.arrayPotCommun.size(); i++) {

			if (this.arrayPotCommun.contains(letter) == true) {

				System.out.println("Suppression");
				this.arrayPotCommun.remove(i);

			}

		}

	}

	public void deleteLettersWhenWordIsGood(char tab_mot[]) {

		for (int i = 0; i < tab_mot.length; i++) {

			for (int j = 0; j < this.arrayPotCommun.size(); j++) {

				if (this.arrayPotCommun.get(j).equals(tab_mot[i])) {

					System.out.println("Suppression Lettre: " + tab_mot[i] + "à la case " + i);
					this.arrayPotCommun.remove(j);

				}
			}

		}

	}

	public void printPotCommun() {

		System.out.println("POT COMMUN: ");

		for (int i = 0; i < this.arrayPotCommun.size(); i++) {

			System.out.println("donnée à l'indice " + i + " = " + this.arrayPotCommun.get(i));
		}

	}

	public static int toASCII(char letter) {
		return (int) letter;
	}

	public static int who_Starts(int letter_P1, int letter_P2) {

		if (letter_P1 < letter_P2) {
			return 1;
		}

		if (letter_P1 > letter_P2) {
			return 2;
		}
		if (letter_P1 == letter_P2) {

			return 3;

		}

		return 0;
	}

	public boolean isTheWordPresentInTheBag(char lettre) {
		return arrayPotCommun.contains(lettre);

	}

	public boolean isItAGoodWord(char tabMot[]) {
		boolean bool = true;

		for (int i = 0; i < tabMot.length; i++) {
			bool = isTheWordPresentInTheBag(tabMot[i]);

			if (bool == false) {
				return false;
			}
		}

		return true;
	}

}

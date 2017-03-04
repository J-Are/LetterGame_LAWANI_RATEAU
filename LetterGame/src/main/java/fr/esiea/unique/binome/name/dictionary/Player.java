package fr.esiea.unique.binome.name.dictionary;

import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class Player {

	protected int indexLetter;
	protected char tabLetter[] = { 'a', 'a', 'a', 'a', 'a', 'b', 'c', 'd', 'e', 'e', 'e', 'e', 'e', 'f', 'g', 'h', 'i',
			'i', 'i', 'i', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'o', 'o', 'o', 'o', 'p', 'k', 'r', 's', 't', 'u', 'u',
			'u', 'u', 'u', 'v', 'w', 'x', 'y', 'z' };
	protected int nb_mot = 0;
	public static String passer;
	protected int ajout_2_lettres = 0;

	protected int numeroJoueur;
	protected int indiceMotVole;

	private ArrayList listeLettre = new ArrayList();
	private ArrayList<String> listeMotJoueur = new ArrayList<String>();

	private String motJoueur;

	public char startRandomLetter() {

		Random r = new Random();
		this.indexLetter = r.nextInt(45);
		return this.tabLetter[this.indexLetter];

	}

	public void setMotJoueur(String mot) {
		this.motJoueur = mot;
	}

	public String getMotJoueur() {
		return this.motJoueur;
	}

	public int getNbMotJoueur() {
		return this.nb_mot;
	}

	public void setNumeroJoueur(int numero_joueur) {
		this.numeroJoueur = numero_joueur;
	}

	public int getNumeroJoueur() {
		return this.numeroJoueur;
	}

	public void twoLettersMoreInTheBag(char letter_P1, StartBag pot_commun) {

		for (int i = 0; i < 2; i++) {
			letter_P1 = startRandomLetter();
			pot_commun.addPotCommun(letter_P1);

		}
	}

	public char one_Letter_more_in_the_Bag(char letter_P1, StartBag pot_commun) {

		letter_P1 = startRandomLetter();
		System.out.println("Lettre en plus: " + letter_P1);
		pot_commun.addPotCommun(letter_P1);

		return letter_P1;
	}

	public void oneLetterMoreInTheBag(char letter_P1, StartBag pot_commun) {

		letter_P1 = startRandomLetter();
		pot_commun.addPotCommun(letter_P1);

	}

	public ArrayList add_word_in_the_player_list(String word) {

		if (this.listeMotJoueur.contains(word) == false) {
			this.listeMotJoueur.add(word);
		}
		return this.listeMotJoueur;
	}

	public ArrayList addPotCommun(char letter) {
		this.listeLettre.add(letter);
		return this.listeLettre;
	}

	public char[] switch_into_CharTab(String mot) {
		return mot.toCharArray();

	}

	public void printCharTab(char tabChar[]) {
		for (int i = 0; i < tabChar.length; i++) {
			System.out.println("Mot: " + tabChar[i]);

		}
	}

	public void print_List_of_Words_Player(ArrayList list_Word, Player joueur) {

		System.out.println("Liste de mots du joueur " + this.numeroJoueur + ":");

		for (int i = 0; i < list_Word.size(); i++) {

			System.out.println("mot à l'indice " + i + " = " + list_Word.get(i));
		}

		this.nb_mot = list_Word.size();
		System.out.println("Nb_de mot du joueur " + this.numeroJoueur + ": " + nb_mot);

	}

	public boolean stealWord(String mot_joueur_entrant, Player joueur2, ArrayList<String> liste_joueur2, int indice) {

		if (mot_joueur_entrant.indexOf(liste_joueur2.get(indice)) != -1
				&& mot_joueur_entrant.equals(liste_joueur2.get(indice)) == false) {
			liste_joueur2.remove(indice);
			this.add_word_in_the_player_list(mot_joueur_entrant);
			this.nb_mot++;
			joueur2.nb_mot--;
			return true;
		}

		return false;

	}

	public void run(Player joueur, StartBag pot_commun, char letterJoueur, File fichier, Player joueur2) {

		int retour_vol = 0;
		boolean turnPlayer = false;

		if (this.ajout_2_lettres == 0) {
			joueur.twoLettersMoreInTheBag(letterJoueur, pot_commun);
			this.ajout_2_lettres++;
		}
		
		pot_commun.printPotCommun();

		while (turnPlayer == false) {
			System.out.println("ETAPE 2");

			motJoueur = enter_a_Word();
			
			
			if (motJoueur.equals("1") == true) {
				this.ajout_2_lettres--;
				
				return;

			}
			System.out.println("ETAPE 1");

			if (motJoueur.equals("2") == true) {

				while (retour_vol != 1) {
					int indice = indiceMotVole();

					if (indice == 3) {

						retour_vol = 1;
					}

					if (indice <= (joueur2.listeMotJoueur.size() - 1)) {
						boolean steal = joueur.stealWord(motJoueur, joueur2, joueur2.listeMotJoueur, indice);

						if (steal == true) {
							System.out.println(
									"Le mot: " + motJoueur + "a bien été volé par le joueur " + joueur.numeroJoueur);
						}

						if (steal == false) {
							System.out.println(
									"Le mot: " + motJoueur + "n'a pas été volé par le joueur " + joueur.numeroJoueur);

						}

						retour_vol = 1;
					}
				}
			}

			this.motJoueur = enter_a_Word();

			char tab_mot[] = joueur.switch_into_CharTab(this.motJoueur);
			joueur.printCharTab(tab_mot);

			boolean retour = pot_commun.isItAGoodWord(tab_mot);

			if (retour == true) {
				System.out.println("Les lettres sont dans le pot commun");
			}

			while (retour == false) {
				System.out.println("Les lettres ne sont pas dans le pot commun");

				pot_commun.printPotCommun();
				this.motJoueur = enter_a_Word();
				tab_mot = joueur.switch_into_CharTab(this.motJoueur);
				retour = pot_commun.isItAGoodWord(tab_mot);
				turnPlayer = motJoueur.equals("1");

				pot_commun.printPotCommun();
				this.motJoueur = enter_a_Word();
				tab_mot = joueur.switch_into_CharTab(this.motJoueur);
				retour = pot_commun.isItAGoodWord(tab_mot);

				if (turnPlayer == true) {
					return;
				}

			}

			boolean is_Word;

			is_Word = fichier.readFile(this.motJoueur);

			System.out.println("Retour fichier: " + is_Word);

			while (is_Word == false) {
				System.out.println("Ce mot n'existe pas, veuillez en entrer un nouveau svp");
				pot_commun.printPotCommun();
				this.motJoueur = enter_a_Word();
				tab_mot = joueur.switch_into_CharTab(this.motJoueur);
				is_Word = fichier.readFile(this.motJoueur);
			}

			if (is_Word == true && retour == true) {

				joueur.printCharTab(tab_mot);
				pot_commun.deleteLettersWhenWordIsGood(tab_mot);
				pot_commun.printPotCommun();
			}
			char letter_test;

			if (is_Word == true) {

				add_word_in_the_player_list(this.motJoueur);
				print_List_of_Words_Player(this.listeMotJoueur, joueur);
				pot_commun.printPotCommun();
				letter_test = joueur.one_Letter_more_in_the_Bag(letterJoueur, pot_commun);
				System.out.println("POT COMMUN après ajout d'une lettre " + letter_test + " mot Trouvé");
				pot_commun.printPotCommun();

				add_word_in_the_player_list(this.motJoueur);
				print_List_of_Words_Player(this.listeMotJoueur, joueur);
				//joueur.oneLetterMoreInTheBag(letterJoueur, pot_commun);
				

			}

		}
	}

	public String enter_a_Word() {
		String ret;
		Scanner sc = new Scanner(System.in);

		System.out.println("Veuillez saisir un mot ou tapez 1 pour passer ou 2 pour voler un mot à votre adversaire:");
		ret = sc.nextLine();

		// System.out.println("Vous avez saisi : " +this.motJoueur);

		return ret;

	}

	public int indiceMotVole() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Veuillez saisir l'indice du mot à voler chez votre adversaire ou taper 3 pour retourner à l'entrée des mots:");
		this.indiceMotVole = sc.nextInt();
		return this.indiceMotVole;

	}

	public boolean endOfTheGame(Player joueur) {

		if (this.nb_mot == 10) {
			return true;

		}

		if (joueur.getNbMotJoueur() == 10) {

			return true;
		}

		return false;

	}

}

package fr.esiea.unique.binome.name.dictionary;


import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class Player {
	private int indexLetter;
	private char tabLetter[]={'a','a','a','a','a','b','c','d','e','e','e','e','e','f','g','h','i','i','i','i','i','j','k','l','m','n','o','o','o','o','o','p','k','r','s','t','u','u','u','u','u','v','w','x','y','z'};
	private int nb_mot=0;

	private ArrayList liste_lettre=new ArrayList();
	private ArrayList liste_mot_joueur=new ArrayList();
	private String mot_joueur;
	
	private int numeroJoueur;
	

	public char start_Random_Letter(){
		Random r = new Random();
		this.indexLetter = r.nextInt(45);
		return this.tabLetter[this.indexLetter];

				
	}
	
	public void setMotJoueur(String mot){
		this.mot_joueur=mot;
	}
	
	public String getMotJoueur(){
		return this.mot_joueur;
	}
	
	
	public void setNumeroJoueur(int numero_joueur){
		this.numeroJoueur=numero_joueur;
	}
	
	public int getNumeroJoueur(){
		return this.numeroJoueur;
	}

    public void two_Letters_more_in_the_Bag(char letter_P1, StartBag pot_commun){
		
		for(int i=0;i<2;i++){
			letter_P1=start_Random_Letter();
			pot_commun.add_pot_commun(letter_P1);
			
			
		}
    }
   
    public void one_Letter_more_in_the_Bag(char letter_P1, StartBag pot_commun){
		
			letter_P1=start_Random_Letter();
			pot_commun.add_pot_commun(letter_P1);
		
    }
    
    public ArrayList add_pot_commun(char letter){
		this.liste_lettre.add(letter);
		return this.liste_lettre;
	}
    
    public ArrayList add_word_in_the_player_list(String word){
		this.liste_mot_joueur.add(word);
		return this.liste_mot_joueur;
	}
    
    public char[] switch_into_CharTab(String mot){
    	return mot.toCharArray();
    	
    }
    
    public void printCharTab(char tabChar[]){
    	for(int i=0;i<tabChar.length;i++){
    		System.out.println("Mot: " + tabChar[i]);
    		
    	}
     }
    
    public void print_List_of_Words_Player(ArrayList list_Word,Player joueur){
    	
    	System.out.println("Liste de mots du joueur "+this.numeroJoueur+":");	

		for(int i = 0; i < list_Word.size(); i++)
	    {

	      System.out.println("mot à l'indice " + i + " = " + list_Word.get(i));
	    }  
		
		this.nb_mot=list_Word.size();
		System.out.println("Nb_de mot du joueur "+this.numeroJoueur+": "+nb_mot);
    	
    }
    
    public void run(Player joueur, StartBag pot_commun, char letter_joueur, File fichier){
    	
    	joueur.two_Letters_more_in_the_Bag(letter_joueur,pot_commun);
    	pot_commun.print_Pot_commun(pot_commun.array_pot_commun);
    	
    	this.mot_joueur=enter_a_Word();
    	
        char tab_mot[]=joueur.switch_into_CharTab(this.mot_joueur);
        joueur.printCharTab(tab_mot);
        
        boolean retour=pot_commun.is_it_a_good_Word(pot_commun.array_pot_commun,tab_mot);
        
        if(retour==true){
          System.out.println("Les lettres sont dans le pot commun");
        }
        
        while(retour==false){
            System.out.println("Les lettres ne sont pas dans le pot commun");
            pot_commun.print_Pot_commun(pot_commun.array_pot_commun);
            this.mot_joueur=enter_a_Word();
            tab_mot=joueur.switch_into_CharTab(this.mot_joueur);
            retour=pot_commun.is_it_a_good_Word(pot_commun.array_pot_commun,tab_mot);
            
            
          }

        boolean is_Word;
        is_Word=fichier.read_File(this.mot_joueur);
        System.out.println("Retour fichier: "+is_Word);
        
        while(is_Word==false){
        	System.out.println("Ce mot n'existe pas, veuillez en entrer un nouveau svp");
        	pot_commun.print_Pot_commun(pot_commun.array_pot_commun);
        	this.mot_joueur=enter_a_Word();
            tab_mot=joueur.switch_into_CharTab(this.mot_joueur);
            is_Word=fichier.read_File(this.mot_joueur);
        }
        
        
        if(is_Word==true){
        	add_word_in_the_player_list(this.mot_joueur);
        	print_List_of_Words_Player(this.liste_mot_joueur,joueur);
        	joueur.one_Letter_more_in_the_Bag(letter_joueur, pot_commun);
        	pot_commun.print_Pot_commun(pot_commun.array_pot_commun);
        }
    	
    }
    
    public String enter_a_Word(){
    	
    	Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un mot :");
        this.mot_joueur = sc.nextLine();
        
        System.out.println("Vous avez saisi : " +this.mot_joueur);
        
        return this.mot_joueur;
        
    }
     
}

package fr.esiea.unique.binome.name.dictionary;


import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class Player {
	private int indexLetter;
	private char tabLetter[]={'a','a','a','a','a','b','c','d','e','e','e','e','e','f','g','h','i','i','i','i','i','j','k','l','m','n','o','o','o','o','o','p','k','r','s','t','u','u','u','u','u','v','w','x','y','z'};
	private int nb_mot=0;

	private ArrayList listeLettre=new ArrayList();
	private ArrayList listeMotJoueur=new ArrayList();
	private String motJoueur;
	
	private int numeroJoueur;
	

	public char startRandomLetter(){
		Random r = new Random();
		this.indexLetter = r.nextInt(45);
		return this.tabLetter[this.indexLetter];

				
	}
	
	public void setMotJoueur(String mot){
		this.motJoueur=mot;
	}
	
	public String getMotJoueur(){
		return this.motJoueur;
	}
	
	
	public void setNumeroJoueur(int numero_joueur){
		this.numeroJoueur=numero_joueur;
	}
	
	public int getNumeroJoueur(){
		return this.numeroJoueur;
	}

    public void twoLettersMoreInTheBag(char letter_P1, StartBag pot_commun){
		
		for(int i=0;i<2;i++){
			letter_P1=startRandomLetter();
			pot_commun.addPotCommun(letter_P1);
			
			
		}
    }
   
    public void oneLetterMoreInTheBag(char letter_P1, StartBag pot_commun){
		
			letter_P1=startRandomLetter();
			pot_commun.addPotCommun(letter_P1);
		
    }
    
    public ArrayList addPotCommun(char letter){
		this.listeLettre.add(letter);
		return this.listeLettre;
	}
    
    public ArrayList add_word_in_the_player_list(String word){
		this.listeMotJoueur.add(word);
		return this.listeMotJoueur;
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
    	
    	joueur.twoLettersMoreInTheBag(letter_joueur,pot_commun);
    	pot_commun.print_Pot_commun(pot_commun.arrayPotCommun);
    	
    	this.motJoueur=enter_a_Word();
    	
        char tab_mot[]=joueur.switch_into_CharTab(this.motJoueur);
        joueur.printCharTab(tab_mot);
        
        boolean retour=pot_commun.isItAGoodWord(pot_commun.arrayPotCommun,tab_mot);
        
        if(retour==true){
          System.out.println("Les lettres sont dans le pot commun");
        }
        
        while(retour==false){
            System.out.println("Les lettres ne sont pas dans le pot commun");
            pot_commun.print_Pot_commun(pot_commun.arrayPotCommun);
            this.motJoueur=enter_a_Word();
            tab_mot=joueur.switch_into_CharTab(this.motJoueur);
            retour=pot_commun.isItAGoodWord(pot_commun.arrayPotCommun,tab_mot);
            
            
          }

        boolean is_Word;
        is_Word=fichier.read_File(this.motJoueur);
        System.out.println("Retour fichier: "+is_Word);
        
        while(is_Word==false){
        	System.out.println("Ce mot n'existe pas, veuillez en entrer un nouveau svp");
        	pot_commun.print_Pot_commun(pot_commun.arrayPotCommun);
        	this.motJoueur=enter_a_Word();
            tab_mot=joueur.switch_into_CharTab(this.motJoueur);
            is_Word=fichier.read_File(this.motJoueur);
        }
        
        
        if(is_Word==true){
        	add_word_in_the_player_list(this.motJoueur);
        	print_List_of_Words_Player(this.listeMotJoueur,joueur);
        	joueur.oneLetterMoreInTheBag(letter_joueur, pot_commun);
        	pot_commun.print_Pot_commun(pot_commun.arrayPotCommun);
        }
    	
    }
    
    public String enter_a_Word(){
    	
    	Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un mot :");
        this.motJoueur = sc.nextLine();
        
        System.out.println("Vous avez saisi : " +this.motJoueur);
        
        return this.motJoueur;
        
    }
     
}

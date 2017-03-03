package fr.esiea.unique.binome.name.dictionary;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class File {
	
	public boolean read_File(String mot){
		String chaine="";
		String fichier ="src/main/resources/dico.txt";
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				
				//System.out.println(ligne);
				//chaine+=ligne+"\n";
				
				if(mot.equalsIgnoreCase(switch_Letter_without_accent(ligne))==true){
					return true;
				}
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
	}
		return false;

  }
	public String switch_Letter_without_accent(String mot){
		mot=mot.replace("é", "e");
		mot=mot.replace("è", "e");
		mot=mot.replace("ê", "e");
		mot=mot.replace("ë", "e");
		mot=mot.replace("î", "i");
		mot=mot.replace("ï", "i");
		mot=mot.replace("ô", "o");
		mot=mot.replace("à", "a");
		mot=mot.replace("â", "a");
		
		//System.out.println("MOT sans accent: "+mot);
		
		return mot;
	}

}

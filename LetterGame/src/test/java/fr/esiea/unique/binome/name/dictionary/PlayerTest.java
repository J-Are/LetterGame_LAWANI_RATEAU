package fr.esiea.unique.binome.name.dictionary;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Test;

public class PlayerTest {
	private Player player;


	@Test
	public void testStartRandomLetter()
	{
		player = new Player();
		assertNotNull("L'instance n'est pas créée", player);
	}
	
	
	@Test
	public void testSetMotJoueur()
	{
		player = new Player();
		player.setMotJoueur("mot2");
		assertEquals("Le mot est incorrect", "mot2", player.getMotJoueur());
	}
		
	@Test
	public void testSetNumeroJoueur()
	{
		player = new Player();
		player.setNumeroJoueur(1);
		assertEquals("Le numéro est incorrect", 1, player.getNumeroJoueur());
		
	}
	
	@Test
	public void testAddPotCommun()
	{
		player = new Player();
		player.addPotCommun('a');
		equals("Il n'ya pas de lettre dans le potCommun");
	}
	
	@Test
	public void testPrintListOfWordsPlayer()
	{
		player = new Player();	
		ArrayList listeLetter= new ArrayList();
		for(int x=1; x<3; x++)
	          listeLetter.add(x);
		String tab[] = new String[listeLetter.size()];
		assertEquals(listeLetter.size(), 2);
		
	}
	

}
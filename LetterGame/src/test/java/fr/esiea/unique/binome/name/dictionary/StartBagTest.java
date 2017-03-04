package fr.esiea.unique.binome.name.dictionary;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class StartBagTest {

	
	
	@Test
	public void testIsTheWordPresentInTheBag()
	{
		StartBag bag = new StartBag();
	
		char letter = 'a';
		
		assertFalse(bag.isTheWordPresentInTheBag(letter));
		
	}
}

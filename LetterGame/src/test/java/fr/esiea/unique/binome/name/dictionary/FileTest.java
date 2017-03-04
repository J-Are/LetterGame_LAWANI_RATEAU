package fr.esiea.unique.binome.name.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileTest {
	@Test
	public void testReadFile() {
	File mot = new File();
	String motus = "elephant";
	String nofound = "acdf";
	  assertTrue(mot.readFile(motus));
	  assertFalse(mot.readFile(nofound));
	}

}

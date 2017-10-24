package etatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

import etatPassager.EtatPassager.Etat;

public class EtatPassagerTest {

	Etat monEtat;

	@Test
	public void testAssis() {
		EtatPassager etatDePassage = new EtatPassager(monEtat);
		assertFalse("Etat non exterieur", etatDePassage.estExterieur());
		assertTrue("Etat assis", etatDePassage.estAssis());
		assertFalse("Etat non debout", etatDePassage.estDebout());
	}

	@Test
	public void testDebout() {
		EtatPassager etatDePassage = new EtatPassager(monEtat);
		assertFalse("Etat non exterieur", etatDePassage.estExterieur());
		assertFalse("Etat non assis", etatDePassage.estAssis());
		assertTrue("Etat debout", etatDePassage.estDebout());
	}
	
	@Test
	public void testExterieur() {
		EtatPassager etatDePassage = new EtatPassager(monEtat);
		assertTrue("Etat exterieur", etatDePassage.estExterieur());
		assertFalse("Etat non assis", etatDePassage.estAssis());
		assertFalse("Etat non debout", etatDePassage.estDebout());
	}


	@Test
	public void testInterieur() {
		fail("Not yet implemented");
	}

}

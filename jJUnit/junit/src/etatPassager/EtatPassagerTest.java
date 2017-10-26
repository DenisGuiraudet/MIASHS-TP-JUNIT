package etatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

import etatPassager.EtatPassager.Etat;

public class EtatPassagerTest {

	@Test
	public void testAssis() {
		EtatPassager etatDePassage = new EtatPassager(EtatPassager.Etat.ASSIS);
		assertFalse("Etat non exterieur", etatDePassage.estExterieur());
		assertTrue("Etat assis", etatDePassage.estAssis());
		assertFalse("Etat non debout", etatDePassage.estDebout());
	}

	@Test
	public void testDebout() {
		EtatPassager etatDePassage = new EtatPassager(EtatPassager.Etat.DEBOUT);
		assertFalse("Etat non exterieur", etatDePassage.estExterieur());
		assertFalse("Etat non assis", etatDePassage.estAssis());
		assertTrue("Etat debout", etatDePassage.estDebout());
	}
	
	@Test
	public void testExterieur() {
		EtatPassager etatDePassage = new EtatPassager(EtatPassager.Etat.DEHORS);
		assertTrue("Etat exterieur", etatDePassage.estExterieur());
		assertFalse("Etat non assis", etatDePassage.estAssis());
		assertFalse("Etat non debout", etatDePassage.estDebout());
	}


	@Test
	public void testInterieur() {
		EtatPassager etatDePassage = new EtatPassager(EtatPassager.Etat.ASSIS);
		assertTrue("Etat interieur", etatDePassage.estInterieur());
		etatDePassage = new EtatPassager(EtatPassager.Etat.DEBOUT);
		assertTrue("Etat interieur", etatDePassage.estInterieur());
		etatDePassage = new EtatPassager(EtatPassager.Etat.DEHORS);
		assertFalse("Etat non interieur", etatDePassage.estInterieur());
	}

}

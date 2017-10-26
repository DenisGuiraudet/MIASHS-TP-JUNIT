package etatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

public class EtatPassagerChaineTest {

	@Test
	public void testAssis() { // TODO
		EtatPassagerChaine etatDePassage = new EtatPassagerChaine("ASSIS");
		assertFalse("Etat non exterieur", etatDePassage.estExterieur());
		assertTrue("Etat assis", etatDePassage.estAssis());
		assertFalse("Etat non debout", etatDePassage.estDebout());
	}

	@Test
	public void testDebout() {
		EtatPassagerChaine etatDePassage = new EtatPassagerChaine("DEBOUT");
		assertFalse("Etat non exterieur", etatDePassage.estExterieur());
		assertFalse("Etat non assis", etatDePassage.estAssis());
		assertTrue("Etat debout", etatDePassage.estDebout());
	}
	
	@Test
	public void testExterieur() {
		EtatPassagerChaine etatDePassage = new EtatPassagerChaine("DEHORS");
		assertTrue("Etat exterieur", etatDePassage.estExterieur());
		assertFalse("Etat non assis", etatDePassage.estAssis());
		assertFalse("Etat non debout", etatDePassage.estDebout());
	}


	@Test
	public void testInterieur() {
		EtatPassagerChaine etatDePassage = new EtatPassagerChaine("ASSIS");
		assertTrue("Etat interieur", etatDePassage.estInterieur());
		etatDePassage = new EtatPassagerChaine("DEBOUT");
		assertTrue("Etat interieur", etatDePassage.estInterieur());
		etatDePassage = new EtatPassagerChaine("DEHORS");
		assertFalse("Etat non interieur", etatDePassage.estInterieur());
	}

}

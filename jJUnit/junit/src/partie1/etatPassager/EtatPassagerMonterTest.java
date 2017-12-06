package partie1.etatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

public class EtatPassagerMonterTest {

	@Test
	public void testAssis() {
		EtatPassagerMonter etatDePassage = new EtatPassagerMonter(EtatPassagerMonter.Etat.ASSIS);
		assertTrue("Etat assis", etatDePassage.estAssis());
		assertFalse("Etat non debout", etatDePassage.estDebout());
	}

	@Test
	public void testDebout() {
		EtatPassagerMonter etatDePassage = new EtatPassagerMonter(EtatPassagerMonter.Etat.DEBOUT);
		assertFalse("Etat non assis", etatDePassage.estAssis());
		assertTrue("Etat debout", etatDePassage.estDebout());
	}


	@Test
	public void testInterieur() {
		EtatPassagerMonter etatDePassage = new EtatPassagerMonter(EtatPassagerMonter.Etat.ASSIS);
		assertTrue("Etat interieur", etatDePassage.estInterieur());
		etatDePassage = new EtatPassagerMonter(EtatPassagerMonter.Etat.DEBOUT);
		assertTrue("Etat interieur", etatDePassage.estInterieur());
	}

}

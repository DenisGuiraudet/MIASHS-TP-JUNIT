package tec;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public abstract class PassagerAbstractTest {

	abstract protected PassagerAbstrait creerPassager(String nom, int destination);

	@Test
	public void accepterSortirTest() {
		PassagerAbstrait temp = creerPassager("test", 2);
		temp.accepterSortie();
		assertTrue("Etat non exterieur", temp.estDehors());
	}
	@Test
	public void accepterAssisTest() {
		PassagerAbstrait temp = creerPassager("test", 2);
		temp.accepterPlaceAssise();;
		assertTrue("Etat non assis", temp.estAssis());
	}
	@Test
	public void accepterDeboutTest() {
		PassagerAbstrait temp = creerPassager("test", 2);
		temp.accepterPlaceDebout();
		assertTrue("Etat non debout", temp.estDebout());
	}
	
	@Test
	public abstract void nouvelArretTest();
	
	@Test
	public abstract void monterDansTest();
	
}

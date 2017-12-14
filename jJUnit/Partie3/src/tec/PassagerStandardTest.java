package tec;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import util.EtatPassager;

public class PassagerStandardTest {
	
	@Test
	public void accepterSortir() {
		PassagerStandard temp = new PassagerStandard("test", 2);
		temp.accepterSortie();
		assertTrue("Etat non exterieur", temp.estDehors());
	}
	@Test
	public void accepterAssis() {
		PassagerStandard temp = new PassagerStandard("test", 2);
		temp.accepterPlaceAssise();;
		assertTrue("Etat non assis", temp.estAssis());
	}
	@Test
	public void accepterDebout() {
		PassagerStandard temp = new PassagerStandard("test", 2);
		temp.accepterPlaceDebout();
		assertTrue("Etat non debout", temp.estDebout());
	}
	
	
}

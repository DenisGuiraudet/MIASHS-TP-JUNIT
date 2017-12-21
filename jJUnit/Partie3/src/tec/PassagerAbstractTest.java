package tec;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public abstract class PassagerAbstractTest {

	@Test
	public void accepterSortirTest() {
		PassagerStandard temp = new PassagerStandard("test", 2);
		temp.accepterSortie();
		assertTrue("Etat non exterieur", temp.estDehors());
	}
	@Test
	public void accepterAssisTest() {
		PassagerStandard temp = new PassagerStandard("test", 2);
		temp.accepterPlaceAssise();;
		assertTrue("Etat non assis", temp.estAssis());
	}
	@Test
	public void accepterDeboutTest() {
		PassagerStandard temp = new PassagerStandard("test", 2);
		temp.accepterPlaceDebout();
		assertTrue("Etat non debout", temp.estDebout());
	}
	
	@Test
	public void nouvelArretTest() {
		PassagerStandard temp = new PassagerStandard("test", 2);
		Autobus t = new Autobus(1, 1);
		try {
			temp.monterDans(t);
			assertTrue("Le passager n'est pas assis !",temp.estAssis());
			t.allerArretSuivant();
			assertFalse("Le passager est sortis !", temp.estDehors());
			assertTrue("Le passager n'est pas debout !",temp.estDebout());
			t.allerArretSuivant();
			assertTrue("Le passager est toujours a l'interieur !", temp.estDehors());
		} catch (UsagerInvalideException e) {
			System.out.println("Trop de passager !");
		}
		//BLBL
	}
	
	@Test
	public void monterDansTest() {
		PassagerStandard temp = new PassagerStandard("test", 2);
		PassagerStandard temp2 = new PassagerStandard("test", 2);
		PassagerStandard temp3 = new PassagerStandard("test", 2);

		Autobus t = new Autobus(1, 1);
		try {
			temp.monterDans(t);
			temp2.monterDans(t);
			temp3.monterDans(t);
		} catch (UsagerInvalideException e) {
			System.out.println("Trop de passager !");
		}
		assertTrue("Le passager n'est pas assis !",temp.estAssis());
		assertTrue("Le passage 2 n'est pas debout !",temp2.estDebout());
		assertTrue("Le passager 3 n'est pas dehors !",temp3.estDehors());
	}
	
}

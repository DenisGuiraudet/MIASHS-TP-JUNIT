package tec;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PassagerLunatiqueTest extends PassagerAbstractTest {
	
	@Override
	public void nouvelArretTest() {
		PassagerAbstrait temp = creerPassager("test", 2);
		Autobus t = new Autobus(1, 1);
		try {
			temp.monterDans(t);
			assertTrue("Le passager n'est pas debout !",temp.estDebout());
			t.allerArretSuivant();
			assertFalse("Le passager est sortis !", temp.estDehors());
			assertFalse("Le passager est debout !",temp.estDebout());
			assertTrue("Le passager n'est pas debout !",temp.estAssis());
			t.allerArretSuivant();
			assertTrue("Le passager est toujours a l'interieur !", temp.estDehors());
		} catch (UsagerInvalideException e) {
			System.out.println("Trop de passager !");
		}
	}
	
	@Override
	public void monterDansTest() {
		PassagerAbstrait temp = creerPassager("test", 2);
		PassagerAbstrait temp2 = creerPassager("test", 2);

		Autobus t = new Autobus(1, 1);
		try {
			temp.monterDans(t);
			temp2.monterDans(t);
		} catch (UsagerInvalideException e) {
			System.out.println("Trop de passager !");
		}
		assertTrue("Le passage n'est pas debout !",temp.estDebout());
		assertTrue("Le passage 2 n'est pas dehors !",temp2.estDehors());
	}

	@Override
	protected PassagerAbstrait creerPassager(String nom, int destination) {
		PassagerLunatique pass = new PassagerLunatique(nom,destination);
		return pass;
	}
	
	
}

package tec;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PassagerStresseTest extends PassagerAbstractTest {
	
	@Override
	public void nouvelArretTest() {
		PassagerAbstrait temp = creerPassager("test", 5);
		Autobus t = new Autobus(1, 1);
		try {
			temp.monterDans(t);
			t.allerArretSuivant();
			assertTrue("Le passager n'est pas assis !",temp.estAssis());
			t.allerArretSuivant();
			assertTrue("Le passager n'est pas debout !",temp.estDebout());
			t.allerArretSuivant();
			assertTrue("Le passager n'est pas debout !",temp.estDebout());
			t.allerArretSuivant();
			assertTrue("Le passager n'est pas debout !",temp.estDebout());
			t.allerArretSuivant();
			assertTrue("Le passager n'est pas sortis !",temp.estDehors());

		} catch (UsagerInvalideException e) {
			System.out.println("Trop de passager !");
		}
	}
	
	@Override
	public void monterDansTest() {
		PassagerAbstrait temp = creerPassager("test", 5);
		PassagerAbstrait temp2 = creerPassager("test", 5);

		Autobus t = new Autobus(1, 1);
		try {
			temp.monterDans(t);
			temp2.monterDans(t);
		} catch (UsagerInvalideException e) {
			System.out.println("Trop de passager !");
		}
		assertTrue("Le passager n'est pas assis !",temp.estAssis());
		assertTrue("Le passage 2 n'est pas dehors !",temp2.estDehors());
	}

	@Override
	protected PassagerAbstrait creerPassager(String nom, int destination) {
		PassagerStresse pass = new PassagerStresse(nom,destination);
		return pass;
	}
	
	
}

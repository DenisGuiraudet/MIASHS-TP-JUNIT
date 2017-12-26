package tec;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import util.EtatPassager;

public class AutobusTest {

	@Test
	public void aPlaceAssiseTest() {
		Autobus temp = new Autobus(10, 13);
		assertTrue("Autobus n'a pas de place assise !", temp.aPlaceAssise());
	}
	
	@Test
	public void aPlaceDeboutTest() {
		Autobus temp = new Autobus(10, 13);
		assertTrue("Autobus n'a pas de place debout", temp.aPlaceDebout());
	}
	
	@Test
	public void demanderPlaceAssiseTest() {
		Autobus temp = new Autobus(1, 1);
		PassagerStandard tempP = new PassagerStandard("Billy", 2);
		temp.demanderPlaceAssise(tempP);
		assertTrue("Le passager n'est pas assis !",tempP.estAssis());
		assertFalse("Il ne doit pas y avoir de place assise !",temp.aPlaceAssise());	
	}
	
	@Test
	public void demanderPlaceDeboutTest() {
		Autobus temp = new Autobus(1, 1);
		PassagerStandard tempP = new PassagerStandard("Billy", 2);
		temp.demanderPlaceDebout(tempP);
		assertTrue("Le passager n'est pas debout !",tempP.estDebout());
		assertFalse("Il ne doit pas y avoir de place debout !",temp.aPlaceDebout());	
	}
	
	@Test
	public void demanderChangerEnDeboutTest() {
		Autobus temp = new Autobus(1, 1);
		PassagerStandard tempP = new PassagerStandard("Billy", 2);
		try {
			tempP.monterDans(temp);
			assertTrue("Le passager doit être assis !",tempP.estAssis());
			temp.demanderChangerEnDebout(tempP);
			assertTrue("Le passager doit être debout !",tempP.estDebout());
		} catch (UsagerInvalideException e) {
		}
	}
	
	@Test
	public void demanderChangerEnAssisTest() {
		Autobus temp = new Autobus(1, 1);
		PassagerStandard tempP = new PassagerStandard("Billy", 2);
		try {
			tempP.monterDans(temp);
			temp.demanderChangerEnDebout(tempP);
			temp.demanderChangerEnAssis(tempP);
			assertTrue("B : Le passager doit être assis !",tempP.estAssis());
		} catch (UsagerInvalideException e) {
		}
	}
	
	@Test
	public void demanderSortieTest() {
		Autobus temp = new Autobus(1, 1);
		PassagerStandard tempP = new PassagerStandard("Billy", 2);
		try {
			tempP.monterDans(temp);
			temp.demanderSortie(tempP);
			assertTrue("Les places assises doivent être vide !",temp.aPlaceAssise());
			assertTrue("Les places debout doivent être vide !",temp.aPlaceDebout());

		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void allerArretSuivantTest() {
		Autobus t = new Autobus(1, 1);
		PassagerStandard temp = new PassagerStandard("Billy", 2);
		try {
			temp.monterDans(t);
			assertFalse("A : Le passager doit etre dans le bus !",temp.estDehors());
			t.allerArretSuivant();
			assertFalse("B : Le passager doit toujours etre dans le bus !",temp.estDehors());
			t.allerArretSuivant();
			assertTrue("Le nombre de place assise doit être vide !",t.aPlaceAssise());
			assertTrue("Le nombre de place debout doit être vide !",t.aPlaceDebout());
		} catch (UsagerInvalideException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}

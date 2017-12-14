package tec;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import util.EtatPassager;

public class AutobusTest {

	@Test
	public void aPlaceAssise() {
		Autobus temp = new Autobus(10, 13);
		assertTrue("Autobus n'a pas de place assise", temp.aPlaceAssise());
	}
	
	@Test
	public void aPlaceDebout() {
		Autobus temp = new Autobus(10, 13);
		assertTrue("Autobus n'a pas de place debout", temp.aPlaceDebout());
	}
	
	
	
	
}

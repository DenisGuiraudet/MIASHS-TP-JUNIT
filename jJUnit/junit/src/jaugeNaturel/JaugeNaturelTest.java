package jaugeNaturel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeNaturelTest {

	JaugeNaturel jaugeRouge;
	JaugeNaturel jaugeVert;
	JaugeNaturel jaugeBleu;

	@Before
	public void setUp() throws Exception {
		jaugeRouge = new JaugeNaturel(0, 50, 50);
		jaugeVert = new JaugeNaturel(0, 50, 25);
		jaugeBleu = new JaugeNaturel(0, 50, 0);
	}

	@After
	public void tearDown() throws Exception {
		jaugeRouge = null;
		jaugeVert = null;
		jaugeBleu = null;
	}
	
	//BLBL

	@Test
	public void testJaugeNaturel() {
		assertNotNull("ma jauge est bien cr��e", jaugeRouge);
		assertNotNull("ma jauge est bien cr��e", jaugeVert);
		assertNotNull("ma jauge est bien cr��e", jaugeBleu);
	}

	@Test
	public void testEstRouge() {
		assertTrue("ma jauge est rouge", jaugeRouge.estRouge());
	}

	@Test
	public void testEstVert() {
		assertTrue("ma jauge est vert", jaugeVert.estVert());
	}

	@Test
	public void testEstBleu() {
		assertTrue("ma jauge est  bleu", jaugeBleu.estBleu());
	}
	
	public void run() {
	     System.out.print("Test de JaugeNaturel:");

	     System.out.print(".");
	     testDansIntervalle();

	      System.out.print(".");
	      //testInferieurIntervalle();

	     System.out.println("OK");
	  }
	
	@Test
	public void testDansIntervalle() {
		JaugeNaturel jaugeBis = new JaugeNaturel(-345, 67899, 100);
		assertFalse("ma jauge n'est pas bleu", jaugeBis.estBleu());
		assertTrue("ma jauge est vert", jaugeBis.estVert());
		assertFalse("ma jauge n'est pas rouge", jaugeBis.estRouge());
	}
	
	@Test
	public void testDeplacement() {
		JaugeNaturel jaugeBis = new JaugeNaturel(0, 2, 1);
		assertFalse("ma jauge n'est pas bleu", jaugeBis.estBleu());
		assertTrue("ma jauge est vert", jaugeBis.estVert());
		assertFalse("ma jauge n'est pas rouge", jaugeBis.estRouge());
		jaugeBis.decrementer();
		assertTrue("ma jauge est bleu", jaugeBis.estBleu());
		assertFalse("ma jauge n'est pas vert", jaugeBis.estVert());
		assertFalse("ma jauge n'est pas rouge", jaugeBis.estRouge());
		jaugeBis.incrementer();
		assertFalse("ma jauge n'est pas bleu", jaugeBis.estBleu());
		assertTrue("ma jauge est vert", jaugeBis.estVert());
		assertFalse("ma jauge n'est pas rouge", jaugeBis.estRouge());
		jaugeBis.incrementer();
		assertFalse("ma jauge n'est pas bleu", jaugeBis.estBleu());
		assertFalse("ma jauge n'est pas vert", jaugeBis.estVert());
		assertTrue("ma jauge est rouge", jaugeBis.estRouge());
	}
	
	@Test
	public void testInferieurIntervalle() {
		
	}
	
	
}

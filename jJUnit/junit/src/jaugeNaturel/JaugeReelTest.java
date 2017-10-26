package jaugeNaturel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeReelTest {

	JaugeReel jaugeRouge;
	JaugeReel jaugeVert;
	JaugeReel jaugeBleu;

	@Before
	public void setUp() throws Exception {
		jaugeRouge = new JaugeReel(0, 50, 50);
		jaugeVert = new JaugeReel(0, 50, 25);
		jaugeBleu = new JaugeReel(0, 50, 0);
	}

	@After
	public void tearDown() throws Exception {
		jaugeRouge = null;
		jaugeVert = null;
		jaugeBleu = null;
	}

	@Test
	public void testJaugeNaturel() {
		assertNotNull("ma jauge est bien init", jaugeRouge);
		assertNotNull("ma jauge est bien init", jaugeVert);
		assertNotNull("ma jauge est bien init", jaugeBleu);
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

	     System.out.println("OK");
	  }
	
	@Test
	public void testDansIntervalle() {
		JaugeReel jaugeBis = new JaugeReel(-345, 67899, 100);
		assertFalse("ma jauge n'est pas bleu", jaugeBis.estBleu());
		assertTrue("ma jauge est vert", jaugeBis.estVert());
		assertFalse("ma jauge n'est pas rouge", jaugeBis.estRouge());
	}
	
	@Test
	public void testDeplacement() {
		JaugeReel jaugeBis = new JaugeReel(0, 2, 1);
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

}

package JaugeTest;

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
		JaugeNaturel jaugeInf = new JaugeNaturel(0, 50, -1);

		assertTrue("ma jauge est bleu", jaugeInf.estBleu());
		assertFalse("ma jauge n'est pas vert", jaugeInf.estVert());
		assertFalse("ma jauge n'est pas rouge", jaugeInf.estRouge());
		jaugeBleu.incrementer();
		assertTrue("ma jauge est bleu", jaugeInf.estBleu());
		assertFalse("ma jauge n'est pas vert", jaugeInf.estVert());
		assertFalse("ma jauge n'est pas rouge", jaugeInf.estRouge());
		
	}
	@Test
	public void testLimiteVigieMaxInferieurVigieMin() {
		JaugeNaturel jaugeVigie = new JaugeNaturel(100, 0, 50);

		assertTrue("ma jauge est bleu", jaugeVigie.estBleu());
		assertFalse("ma jauge n'est pas vert", jaugeVigie.estVert());
		assertTrue("ma jauge est rouge", jaugeVigie.estRouge());
		
	}
	
	@Test
	public void testMaxEgaleMin() {
		JaugeNaturel jaugeEgaleMin = new JaugeNaturel(50, 50, 51);

		assertFalse("ma jauge n'est pas bleu", jaugeEgaleMin.estBleu());
		assertFalse("ma jauge n'est pas vert", jaugeEgaleMin.estVert());
		assertTrue("ma jauge est rouge", jaugeEgaleMin.estRouge());
		
		jaugeEgaleMin.decrementer();
		assertTrue("ma jauge est bleu", jaugeEgaleMin.estBleu());
		assertFalse("ma jauge n'est pas vert", jaugeEgaleMin.estVert());
		assertTrue("ma jauge est rouge", jaugeEgaleMin.estRouge());

	}
	
	@Test
	public void testSuperieurIntervalle() {
		JaugeNaturel jaugeSup = new JaugeNaturel(0, 50, 51);

		assertFalse("ma jauge n'est pas bleu", jaugeSup.estBleu());
		assertFalse("ma jauge n'est pas vert", jaugeSup.estVert());
		assertTrue("ma jauge est rouge", jaugeSup.estRouge());
		jaugeSup.decrementer();
		assertFalse("ma jauge n'est pas bleu", jaugeSup.estBleu());
		assertFalse("ma jauge n'est pas vert", jaugeSup.estVert());
		assertTrue("ma jauge est rouge", jaugeSup.estRouge());
		
	}
	
	
	
}

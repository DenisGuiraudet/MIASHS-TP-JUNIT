package jaugeNaturel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeDistanceTest {

	JaugeDistance jaugeRouge;
	JaugeDistance jaugeVert;
	JaugeDistance jaugeBleu;

	@Before
	public void setUp() throws Exception {
		jaugeRouge = new JaugeDistance(0, 50, 50);
		jaugeVert = new JaugeDistance(0, 50, 25);
		jaugeBleu = new JaugeDistance(0, 50, 0);
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
		JaugeDistance jaugeBis = new JaugeDistance(-345, 67899, 100);
		assertFalse("ma jauge n'est pas bleu", jaugeBis.estBleu());
		assertTrue("ma jauge est vert", jaugeBis.estVert());
		assertFalse("ma jauge n'est pas rouge", jaugeBis.estRouge());
	}
	
	@Test
	public void testDeplacement() {
		JaugeDistance jaugeBis = new JaugeDistance(0, 2, 1);
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
	public void testCreationNonValide ( ) {
		JaugeDistance inverse;
		try {
			inverse = new JaugeDistance( 78 , 13 , 0 ) ;
			assertFalse("Echec",true);
		}catch(Exception e){
			
		}
		JaugeDistance egale;
		try {
			egale = new JaugeDistance( 78 , 13 , 0 ) ;
			assertFalse("Echec",true);
		}catch(Exception e){
		}
	}
}

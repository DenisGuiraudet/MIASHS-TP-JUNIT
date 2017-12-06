package tec;

import util.EtatPassager;

public class PassagerStandard implements Passager, Transport {
	
	private EtatPassager etatPassager;
	private String nom;
	private int dest;

	public PassagerStandard(String nom, int dest) {

		etatPassager = new EtatPassager(EtatPassager.Etat.ASSIS);
		this.nom = nom;
		this.dest = dest;
		
	}

	@Override
	public String nom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean estDehors() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estAssis() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estDebout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void accepterSortie() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accepterPlaceAssise() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accepterPlaceDebout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void allerArretSuivant() throws UsagerInvalideException {
		// TODO Auto-generated method stub
		
	}

}

package tec;

import util.EtatPassager;

public class PassagerStandard implements Passager, Usager {
	
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
		return this.nom;
	}

	@Override
	public boolean estDehors() {
		if(this.etatPassager.estExterieur() == true) {return true;}
		else {return false;}
	}

	@Override
	public boolean estAssis() {
		if(this.etatPassager.estAssis() == true) {return true;}
		else {return false;}
	}

	@Override
	public boolean estDebout() {
		if(this.etatPassager.estDebout() == true) {return true;}
		else {return false;}
	}

	@Override
	public void accepterSortie() {
		if(this.etatPassager.estInterieur() == true) {
			etatPassager = new EtatPassager(EtatPassager.Etat.DEHORS);
		}
		else {
			System.out.println("Le passager est déjà dehors !");
		}
	}

	@Override
	public void accepterPlaceAssise() {
		etatPassager = new EtatPassager(EtatPassager.Etat.ASSIS);
	}

	@Override
	public void accepterPlaceDebout() {
		etatPassager = new EtatPassager(EtatPassager.Etat.DEBOUT);
	}

	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		if(this.dest == numeroArret) {
			this.accepterSortie();
		}
		else {
			this.accepterPlaceDebout();
		}
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		
	}
	
	@Override
	public String toString() {
		String chaine = "";
		chaine += "Nom : " + this.nom + "\n" + "   Destination : " + this.dest + "\n";
		return chaine;
	}


}

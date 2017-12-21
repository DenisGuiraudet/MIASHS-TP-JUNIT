package tec;

import util.EtatPassager;

public abstract class PassagerAbstrait implements Passager, Usager {
	
	private EtatPassager etatPassager;
	private String nom;
	private int dest;

	public PassagerAbstrait(String nom, int dest) {

		etatPassager = new EtatPassager(EtatPassager.Etat.DEHORS);
		this.nom = nom;
		this.dest = dest;
		
	}

	@Override
	public String nom() {
		return this.nom;
	}
	
	public int getDest() {
		return this.dest;
	}
	
	public void setDest(int desti) {
		this.dest = desti;
	}
	
	public void setEtat(EtatPassager etat) {
		this.etatPassager = etat;
	}
	
	public abstract void choixPlaceMontee(Bus b);
	
	public abstract void choixChangerPlace(Bus b, int arret);

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
		etatPassager = new EtatPassager(EtatPassager.Etat.DEHORS);
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
	public abstract void nouvelArret(Bus bus, int numeroArret);

	@Override
	public abstract void monterDans(Transport t) throws UsagerInvalideException;
	
	@Override
	public String toString() {
		String chaine = "";
		chaine += "Nom : " + this.nom + "\n" + "	Destination : " + this.dest + "\n" + "	State : "+ this.etatPassager.toString();
		return chaine;
	}


}

package tec;

import util.EtatPassager;

public class PassagerStandard implements Passager, Usager {
	
	private EtatPassager etatPassager;
	private String nom;
	private int dest;

	public PassagerStandard(String nom, int dest) {

		etatPassager = new EtatPassager(EtatPassager.Etat.DEHORS);
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
	public void nouvelArret(Bus bus, int numeroArret) {
		if(this.dest == numeroArret) {
			bus.demanderSortie(this);
			this.accepterSortie();
		}
		else {
			if(this.estAssis() == true) {
				bus.demanderChangerEnDebout(this);
				this.accepterPlaceAssise();
			}
			else {
				bus.demanderChangerEnDebout(this);
				this.accepterPlaceDebout();
			}
		}
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		if((((Autobus)t).aPlaceAssise() == true)&&(((Autobus)t).aPlaceDebout() == true)){
			((Autobus)t).demanderPlaceAssise(this);
			this.accepterPlaceAssise();
			((Autobus)t).addPassenger(this);
		}
		else {
			if(((Autobus)t).aPlaceAssise() == true) {
				((Autobus)t).demanderPlaceAssise(this);
				if(this.estAssis()==true) {
					this.accepterPlaceAssise();
					((Autobus)t).addPassenger(this);

				}
				else {
					((Autobus)t).demanderPlaceDebout(this);
					if(this.estDebout()==true) {
						this.accepterPlaceDebout();
						((Autobus)t).addPassenger(this);

					}
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String chaine = "";
		chaine += "Nom : " + this.nom + "\n" + "   Destination : " + this.dest + "\n" + "State : "+ this.etatPassager.toString();
		return chaine;
	}


}

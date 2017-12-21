package tec;

import util.EtatPassager;

public class PassagerLunatique extends PassagerAbstrait implements Passager, Usager  {
	
	private EtatPassager etatPassager;


	public PassagerLunatique(String nom, int dest) {

		super(nom, dest);
		super.setEtat(new EtatPassager(EtatPassager.Etat.DEHORS));
		
	}
	
	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		if(super.getDest() == numeroArret) {
			bus.demanderSortie(this);
		}
		else {
			choixChangerPlace(bus, numeroArret);
		}
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		if((((Autobus)t).aPlaceAssise() == false) && (((Autobus)t).aPlaceDebout() == false)){
			throw new UsagerInvalideException ( "Plus de place  " ) ;
		}
		else {
			this.choixPlaceMontee(((Bus)t));
		}
	}
	
	@Override
	public String toString() {
		String chaine = "";
		chaine += "Nom : " + this.nom() + "\n" + "	Destination : " + this.getDest() + "\n" + "	State : "+ this.etatPassager.toString();
		return chaine;
	}

	@Override
	public void choixPlaceMontee(Bus b) {
		if(b.aPlaceDebout()) {
			b.demanderPlaceDebout(this);
		}
	}

	@Override
	public void choixChangerPlace(Bus b, int arret) {
		if((this.estAssis())&&(b.aPlaceDebout()) ){
			b.demanderChangerEnDebout(this);
		}
		else {
			if((this.estDebout() && (b.aPlaceAssise()))) {
				b.demanderChangerEnAssis(this);
			}
		}		
	}


}

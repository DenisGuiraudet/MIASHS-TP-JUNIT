package tec;

public class PassagerStresse extends PassagerAbstrait {

	public PassagerStresse(String nom, int dest) {

		super(nom, dest);
		
	}
	
	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		if(super.getDest() == numeroArret) {
			bus.demanderSortie(this);
		}
		else {
			if(this.estDehors()==false) {
				choixChangerPlace(bus, bus.getArret());
			}
		}
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		if((((Autobus)t).aPlaceAssise() == false) && (((Autobus)t).aPlaceDebout() == false)){
			throw new UsagerInvalideException ( "Plus de place  " ) ;
		}
		else{
			this.choixPlaceMontee(((Bus)t));
		}
	}

	@Override
	public void choixPlaceMontee(Bus b) {
		if(b.aPlaceAssise()) {
			b.demanderPlaceAssise(this);
			b.addPassenger(this);
		}
	}

	@Override
	public void choixChangerPlace(Bus b, int arret) {
		if((this.getDest() - b.getArret() == 3)&&(b.aPlaceDebout())&&(this.estAssis())) {
			b.demanderChangerEnDebout(this);
		}
	}


}

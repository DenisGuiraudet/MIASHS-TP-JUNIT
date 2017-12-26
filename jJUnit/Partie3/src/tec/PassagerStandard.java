package tec;

public class PassagerStandard extends PassagerAbstrait {

	public PassagerStandard(String nom, int dest) {

		super(nom, dest);
		
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
			choixPlaceMontee((Bus)t);
		}
		
	}

	@Override
	public void choixPlaceMontee(Bus b) {
		if((b.aPlaceAssise() == true)&&(b.aPlaceDebout() == true)){
			b.demanderPlaceAssise(this);
			b.addPassenger(this);
		}
		else {
			if(b.aPlaceAssise() == true) {
				b.demanderPlaceAssise(this);
				b.addPassenger(this);
			}
			else {
				b.demanderPlaceDebout(this);
				this.accepterPlaceDebout();
				b.addPassenger(this);
			}
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

package tec;
import util.JaugeNaturel;


public class Autobus implements Transport, Bus{

	private JaugeNaturel placeAssise;
	private JaugeNaturel placeDebout;
	private int arretCourant;

	
	public Autobus(int assis, int debout) {
		this.placeAssise = new JaugeNaturel(0 , assis , 0);
		this.placeDebout = new JaugeNaturel(0 , debout , 0);
		this.arretCourant = 0;
	}


	@Override
	public boolean aPlaceAssise() {
		if(this.placeAssise.estRouge() == true) {return true;}
		else{return false;}
	}

	@Override
	public boolean aPlaceDebout() {
		if(this.placeDebout.estRouge() == true) {return true;}
		else{return false;}
	}

	@Override
	public void demanderPlaceAssise(Passager p) {
		if(this.placeAssise.estVert()) {
			this.placeAssise.incrementer();
		}
	}

	@Override
	public void demanderPlaceDebout(Passager p) {
		if(this.placeDebout.estVert()) {
			this.placeDebout.incrementer();
		}
	}

	@Override
	public void demanderChangerEnDebout(Passager p) {
		if((this.placeAssise.estRouge() == false) && (this.placeDebout.estBleu() == false)) {
			this.placeDebout.incrementer();
			this.placeAssise.decrementer();
		}		
	}

	@Override
	public void demanderChangerEnAssis(Passager p) {
		if((this.placeAssise.estRouge() == false) && (this.placeDebout.estBleu() == false)) {
			this.placeAssise.incrementer();
			this.placeDebout.decrementer();
		}		
	}

	@Override
	public void demanderSortie(Passager p) {
		if(p.estDebout() == true) {
			this.placeDebout.decrementer();
		}
		if(p.estAssis() == true) {
			this.placeAssise.decrementer();
		}
	}


	@Override
	public void allerArretSuivant() throws UsagerInvalideException {
		this.arretCourant += 1;
		
	}
	
	@Override
	public String toString() {
		String chaine = "";
		chaine += "Arret : " + this.arretCourant + "\n Assis : " + this.placeAssise.toString() + "\n" + "Debout : " + this.placeDebout.toString();
		return chaine;
	}

}

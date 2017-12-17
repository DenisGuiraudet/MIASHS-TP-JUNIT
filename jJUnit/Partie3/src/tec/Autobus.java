package tec;
import java.util.ArrayList;
import java.util.Iterator;

import util.JaugeNaturel;


public class Autobus implements Transport, Bus{

	private JaugeNaturel placeAssise;
	private JaugeNaturel placeDebout;
	private int arretCourant;
	private ArrayList<PassagerStandard> passager;
	
	public Autobus(int assis, int debout) throws IllegalArgumentException{
		if ((assis == 0)||(debout==0)) throw new IllegalArgumentException();
		this.placeAssise = new JaugeNaturel(0 , assis , 0);
		this.placeDebout = new JaugeNaturel(0 , debout , 0);
		this.arretCourant = 0;
		this.passager = new ArrayList<>();
	}
	
	public void addPassenger(PassagerStandard p) {
		this.passager.add(p);
	}
	
	public void removePassenger(Passager p) {
		this.passager.remove(p);
	}

	@Override
	public boolean aPlaceAssise() {
		if((this.placeAssise.estVert() == true)||(this.placeAssise.estBleu() == true)) {return true;}
		else{return false;}
	}

	@Override
	public boolean aPlaceDebout() {
		if((this.placeDebout.estVert() == true)||(this.placeDebout.estBleu() == true)) {return true;}
		else{return false;}
	}

	@Override
	public void demanderPlaceAssise(Passager p) {
		if(this.aPlaceAssise()==true && p.estDehors() == true) {
			p.accepterPlaceAssise();
			this.placeAssise.incrementer();
		}
	}

	@Override
	public void demanderPlaceDebout(Passager p) {
		if(this.aPlaceDebout()==true && p.estDehors() == true) {
			p.accepterPlaceDebout();
			this.placeDebout.incrementer();
		}
	}

	@Override
	public void demanderChangerEnDebout(Passager p) {
		if(this.aPlaceDebout()) {
			p.accepterPlaceDebout();
			this.placeDebout.incrementer();
			this.placeAssise.decrementer();
		}		
	}

	@Override
	public void demanderChangerEnAssis(Passager p) {
		if(this.aPlaceAssise()) {
			p.accepterPlaceAssise();
			this.placeAssise.incrementer();
			this.placeDebout.decrementer();
		}		
	}

	@Override
	public void demanderSortie(Passager p) {
		if(p.estDebout()) {
			this.placeDebout.decrementer();
			p.accepterSortie();
		}
		if(p.estAssis()) {
			this.placeAssise.decrementer();
			p.accepterSortie();
		}
	}


	@Override
	public void allerArretSuivant() throws UsagerInvalideException {
		this.arretCourant = this.arretCourant + 1;
		for(int i=0;i<this.passager.size();i++) {
			this.passager.get(i).nouvelArret(this, this.arretCourant);
		}
		for(int i=0;i<this.passager.size();i++) {
			if(this.passager.get(i).estDehors()) {
				this.removePassenger(this.passager.get(i));
				i = i-1;
			}

		}
	}
	
	@Override
	public String toString() {
		String chaine = "";
		chaine += "Arret : " + this.arretCourant + 
				  "\n	Assis : " + this.placeAssise.toString() + 
				  "\n" + "	Debout : " + this.placeDebout.toString()+"\n" 
				  + "	Nb_Passager : " + this.passager.size()+"\n";
		for (int i = 0; i < this.passager.size(); i++) {
			chaine+=" 		Passager : "+this.passager.get(i).nom()+"\n";
		}
		return chaine;
	}

}

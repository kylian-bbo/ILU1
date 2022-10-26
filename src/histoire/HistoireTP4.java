package histoire;

import personnages.Humain;
import personnages.Commercant;


public class HistoireTP4 {
	
	public static void main(String[] args) {
		Humain prof = new Humain("Prof","kombucha",54);
		Commercant marco = new Commercant("Marco",20);
		
		prof.direBonjour();
		prof.acheter("une boisson",12);
		prof.boire("kombucha");
		prof.acheter("un jeu",2);
		prof.acheter("un kimono",50);
		
		System.out.println();
		
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire("th�");
	}
}

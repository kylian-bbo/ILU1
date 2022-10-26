package histoire;

import personnages.Humain;
import personnages.Ronin;
import personnages.Yakuza;
import personnages.Commercant;


public class HistoireTP4 {
	
	public static void main(String[] args) {
		Humain prof = new Humain("Prof","kombucha",54);
		Commercant marco = new Commercant("Marco",20);
		Yakuza yaku = new Yakuza("Yaku Le Noir","whisky",30,"Warsong");
		Ronin roro = new Ronin("Roro","shochu",60);
		
		prof.direBonjour();
		prof.acheter("une boisson",12);
		prof.boire("kombucha");
		prof.acheter("un jeu",2);
		prof.acheter("un kimono",50);
		
		System.out.println();
		
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire("thé");
		
		System.out.println();
		
		yaku.direBonjour();
		yaku.extorquer(marco);
		
		System.out.println();
		
		roro.direBonjour();
		roro.donner(marco);
	}
}

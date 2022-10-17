package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;
import personnages.Equipement;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",8);
		Gaulois obelix = new Gaulois("Obélix",50);
		Romain minus = new Romain("Minus",6);
		Druide panoramix = new Druide("Panoramix",5,10);
		
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		
		panoramix.booster(obelix);
		obelix.parler("« Par Bélénos, ce n'est pas juste !»");
		panoramix.booster(asterix);
		
		asterix.parler("Bonjour");
		
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}

}

package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super();
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force "
				+ effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole( ) {
		return "Le druide " + nom + " : ";
	}
	
	public int preparerPotion() {
		Random random = new Random();
		int effetPotion = 0;
		
		while(effetPotion < effetPotionMin) {
			effetPotion = random.nextInt(effetPotionMax);
		}
			
		if(effetPotion > 7) {
			parler("« J'ai préparé une super potion de force " + effetPotion + "»");
		}
		else {
			parler("« Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + effetPotion + "»");
		}
		
		forcePotion = effetPotion;
		return forcePotion;
	}
	
	public void booster(Gaulois gaulois) {
		if("Obélix".equals(gaulois.getNom())) {
			parler("« Non, Obélix !... Tu n’auras pas de potion magique ! »");
		}
		else {
			gaulois.boirePotion(forcePotion);
		}
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		
		panoramix.preparerPotion();
	}
}

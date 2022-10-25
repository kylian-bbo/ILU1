package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees = 0;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
//				+ romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion * effetPotion;
		parler("« Merci Druide, je sens que ma force est "+ forcePotion + " fois décuplée. »");
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	//TP3
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la "
				+ "m�choire de " + romain.getNom());
		Equipement[] tropheesTemp = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesTemp != null && i < tropheesTemp.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesTemp[i];
		}
	}
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees >= 0) {
			System.out.println(prendreParole()+"« Je donne au musee tous mes trophees :");
			for (int i = 0; i<nbTrophees; i++) {
				Equipement equipement = trophees[i];
				System.out.println("- " + equipement.toString());
				musee.donnerTrophees(this, equipement);
				trophees[i] = null;
			}
			nbTrophees = 0;
			System.out.println("»");
		}

	}

	//main
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",8);
//		Romain terminus = new Romain("Terminus",1);	
//		
//		System.out.println(asterix.nom);
//		System.out.println(asterix);
//		asterix.parler("Ou est ma potion magique ?!");
//		asterix.frapper(terminus);
//		
//		System.out.println(); //Pour la mise en page
//		
//		Druide panoramix = new Druide("Panoramix",5,10);
//		int forcePotion = panoramix.preparerPotion();
//		asterix.boirePotion(forcePotion);
		
		Musee musee = new Musee();
		Equipement equipement = Equipement.CASQUE;
		Equipement equipement2 = Equipement.CASQUE;
		Equipement equipement3 = Equipement.BOUCLIER;
		
		asterix.trophees[asterix.nbTrophees] = equipement;
		asterix.nbTrophees++;
		asterix.trophees[asterix.nbTrophees] = equipement2;
		asterix.nbTrophees++;
		asterix.trophees[asterix.nbTrophees] = equipement3;
		asterix.nbTrophees++;
		
		asterix.faireUneDonnation(musee);
		
		System.out.println(musee.extraireInstructionsCaml());
	}
}

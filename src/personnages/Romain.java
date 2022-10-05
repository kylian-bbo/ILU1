package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	
	
	public Romain(String nom, int force) {
		
		assert force > 0;
		
		//Invariant
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		
		assert this.force > 0; //Précondition
		int forceAvantCoup = this.force;
		
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		
		assert this.force < forceAvantCoup; //Postcondition
	}
	
	public void sEquiper(Equipement equipement) {
		
	}
	
	public static void main(String[] args) {
		Romain pasunmotdeplus = new Romain("Pasunmotdeplus",6);
		
		pasunmotdeplus.parler("Ave Cesar !");
		pasunmotdeplus.recevoirCoup(2);
		
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		System.out.println("\n"+casque);
		System.out.println(bouclier+"\n");
		
		
	}
}

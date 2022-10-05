package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		
		assert force > 0;
		
		//Invariant
		this.nom = nom;
		this.force = force;
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
	
	public static void main(String[] args) {
		Romain pasunmotdeplus = new Romain("Pasunmotdeplus",6);
		
		pasunmotdeplus.parler("Ave Cesar !");
		pasunmotdeplus.recevoirCoup(2);
	}
}

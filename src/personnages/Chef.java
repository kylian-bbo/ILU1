package personnages;

public class Chef {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;
	public Chef(String nom, int force, int effetPotion, Village village) {
		super();
		this.nom = nom;
		this.force = force;
		this.effetPotion = effetPotion;
		this.village = village;
	}
	
}

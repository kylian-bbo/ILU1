package personnages;

public class Village {
	private Gaulois chef;
	private String nom;
	
	public Village(Gaulois chef, String nom) {
		super();
		this.chef = chef;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
}

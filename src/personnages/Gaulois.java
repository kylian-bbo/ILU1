package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
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
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
				+ romain.getNom());
		romain.recevoirCoup(force / 3);
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion * effetPotion;
		parler("« Merci Druide, je sens que ma force est "+ forcePotion + " fois décuplée. »");
	}
	
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + 
				", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		Romain terminus = new Romain("Terminus",1);	
		
		System.out.println(asterix.nom);
		System.out.println(asterix);
		asterix.parler("Ou est ma potion magique ?!");
		asterix.frapper(terminus);
		
		System.out.println(); //Pour la mise en page
		
		Druide panoramix = new Druide("Panoramix",5,10);
		int forcePotion = panoramix.preparerPotion();
		asterix.boirePotion(forcePotion);
	}
}

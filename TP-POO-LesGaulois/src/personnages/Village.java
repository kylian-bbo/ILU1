package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;
	
	public Village(String nom, int nbVillageoisMaximum) {
		super();
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
		nbVillageois = 0;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public Chef getChef() {
		return chef;
	}

	public String getNom() {
		return nom;
	}
	
	public int getNbVillageois() {
		return nbVillageois;
	}

	public void ajouterHabitant(Gaulois gaulois, int indVillageois) {
		villageois[indVillageois] = gaulois;
		nbVillageois += 1;
	}
	
	public Gaulois trouverHabitant(int indVillageois) {
		return villageois[indVillageois];
	}
	
	public void afficherVillageois(Village village) {
		Chef chef = village.getChef();
		String nomChef = chef.getNom();
		int indVillageois = 0;
		
		System.out.println("Dans le village du chef " 
				+ nomChef 
				+ " vivent les légendaires gaulois :");
		
		while(indVillageois < village.getNbVillageois()) {
			Gaulois gaulois = village.trouverHabitant(indVillageois);
			String nomGaulois = gaulois.getNom();
			System.out.println("- " + nomGaulois);
			
			indVillageois += 1;
		}
	}
	
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		//Gaulois gaulois = village.trouverHabitant(30);
		//On obtient l'exception du point précédent car on essaye d'accéder
		//à la case d'indice 30 du tableau alors que ce dernier s'arrête à
		//l'indice 29.
		
		Chef abraracourcix = new Chef("Abraracourcix",6,village);
		village.setChef(abraracourcix);
		
		Gaulois asterix = new Gaulois("Astérix",8);
		village.ajouterHabitant(asterix, 0);
		
		//Gaulois gaulois = village.trouverHabitant(1);
		//System.out.println(gaulois);
		//On obtient "null" car étant donné que l'on n'a pas encore associé
		//de gaulois à l'indice 1 du Village il n'y a rien dans cette case
		//du tableau
		
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix, 1);
		
		village.afficherVillageois(village);
		
		System.out.println("//main Village terminé");
	}
}

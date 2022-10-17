package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	String texte;
	
	
	public Romain(String nom, int force) {
		
		assert force > 0;
		
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "ï¿½ " + texte + " ï¿½");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		
//		assert this.force > 0; //Prï¿½condition
//		int forceAvantCoup = this.force;
//		
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aï¿½e");
//		} else {
//			parler("J'abandonne...");
//		}
//		
//		assert this.force < forceAvantCoup; //Postcondition
//	}
	
	public void sEquiper(Equipement equipement) {
		int nb_equip = this.nbEquipement;
		String nom_romain = this.getNom();
	
		switch (nb_equip) {
			case (0) :
				this.equipements[0] = equipement;
				this.nbEquipement+=1;
				System.out.println("Le soldat " + nom_romain + " s'Ã©quipe avec un " 
									+ equipement.toString() + ".");
				break;
				
			case (1) :
				if (this.equipements[0] == equipement) {
					System.out.println("Le soldat " + nom_romain + " possÃ¨de dÃ©jÃ  un " 
									+ equipement.toString() + ".");
				}
				else {
					this.equipements[1] = equipement;
					this.nbEquipement+=1;
					System.out.println("Le soldat " + nom_romain + " s'Ã©quipe avec un " 
										+ equipement.toString() + ".");
				}
				break;
				
			case (2) :
				System.out.println("Le soldat "+nom_romain+" est dÃ©jÃ  bien protÃ©gÃ© !");
				break;
		}
	}
	
	
	//TP3
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
		 if (force > 0) {
		 		parler("Aïe");
		 } else {
		 		equipementEjecte = ejecterEquipement();
		 		parler("J'abandonne...");
		 }
//		if (force == 0) {
//			parler("Aïe");
//		} else {
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//		}
		// post condition la force à diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	
	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du "
				+ "coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa " + "force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null && 
						equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	
	
	public static void main(String[] args) {
		Romain pasunmotdeplus = new Romain("Pasunmotdeplus",6);
		
		pasunmotdeplus.parler("Ave Cesar !");
		pasunmotdeplus.recevoirCoup(2);
		
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		
		System.out.println("\n"+casque);
		System.out.println(bouclier+"\n");
		
		pasunmotdeplus.sEquiper(casque);
		pasunmotdeplus.sEquiper(casque);
		pasunmotdeplus.sEquiper(bouclier);
		pasunmotdeplus.sEquiper(bouclier);
	}
}

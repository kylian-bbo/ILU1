package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee trophee = new Trophee(gaulois, equipement);
		
		trophees[nbTrophee] = trophee;
		nbTrophee++;
	}
	
	public String extraireInstructionsCaml() {
		assert nbTrophee > 0 : "Le tableau de trophées est vide";
		
		String stringTrophees = "";
		for (int i = 0; i<nbTrophee; i++) {
			String nomGaulois = '"' + (trophees[i].getGaulois()).getNom() + '"';
			String nomEquipement = '"' + (trophees[i].getEquipement()).toString() + '"';
			
			stringTrophees = stringTrophees + "	" +  nomGaulois + ", " + nomEquipement + "\n";
		}
		
		return "let musee = [\n" + stringTrophees + "]";
	}
}

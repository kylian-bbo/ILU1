package personnages;

public class Trophee {
	private Gaulois gaulois;
	private Equipement equipement;
	
	public Trophee(Gaulois gaulois, Equipement equipement) {
			this.gaulois = gaulois;
			this.equipement = equipement;
		}
		
	
	public Gaulois getGaulois() {
		return gaulois;
	}
	
	public void setGaulois(Gaulois gaulois) {
		this.gaulois = gaulois;
	}
	
	public Equipement getEquipement() {
		return equipement;
	}
	
}

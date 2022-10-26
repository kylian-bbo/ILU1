package personnages;

public class Ronin extends Humain {
	int honneur = 1;
	
	public Ronin(String nom, String boissonPref, int argent) {
		super(nom, boissonPref, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		String nombeneficiaire = beneficiaire.getNom();
		
		int don = (int) (0.10 * argent);
		parler(nombeneficiaire + " prend ces " + don + " sous");
		beneficiaire.recevoir(don);
		argent -= don;
	}
}

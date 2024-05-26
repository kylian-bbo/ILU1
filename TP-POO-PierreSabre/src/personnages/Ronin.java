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
	
	public void provoquer(Yakuza adversaire) {
		int force = 2 * honneur;
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que "
				+ "tu as fait à ce pauvre marchand !");
		if (force >= adversaire.reputation) {
			parler("Je t’ai eu petit yakusa !");
			int gain = adversaire.perdre();
			argent += gain;
			honneur += 1;
			
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			honneur -= 1;
			adversaire.gagner(argent);
			argent = 0;
			
		}
	}
}

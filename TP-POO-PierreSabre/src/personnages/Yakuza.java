package personnages;

public class Yakuza extends Humain {
	String clan;
	int reputation = 4;
	
	public Yakuza(String nom, String boissonPref, int argent, String clan) {
		super(nom, boissonPref, argent);
		this.clan = clan;
	}
	
	public void extorquer(Commercant victime) {
		String nomVictime = victime.getNom() ;
		
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe "
				+ "par là ?");
		parler(nomVictime + ", si tu tiens à la vie donne moi ta bourse !");
		
		int gain = victime.seFaireExtorquer();
		argent += gain;
		
		parler("J’ai piqué les " + gain + " sous de " + nomVictime + ", ce qui "
				+ "me fait 45 sous dans ma poche. Hi ! Hi !");
		
		reputation += 1;
	}
	
	public int perdre() {
		int perte = argent;
		argent = 0;

		if (reputation > 0) {
			reputation -= 1;
		}
		
		parler("J’ai perdu mon duel et mes " + perte + " sous, snif... "
				+ "J'ai déshonoré le clan de " + clan + ".");
		return perte;
	}
	
	public void gagner(int gain) {
		argent += gain;
		reputation += 1;
		parler("Ce ronin pensait vraiment battre " + nom + " du clan de " 
		+ clan + " ? Je l'ai dépouillé de ses " + gain + " sous.");
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan + '.');
	}
}
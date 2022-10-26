package personnages;

public class Yakuza extends Humain {
	String clan;
	int reputation = 0;
	
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
}
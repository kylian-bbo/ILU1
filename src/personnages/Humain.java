package personnages;

public class Humain {
	protected String nom;
	private String boissonPref;
	protected int argent;
	private int nbConnaissanceMax = 30;
	protected Humain[] connaissance = new Humain[nbConnaissanceMax];
	private int nbConnaissance = 0;
	
	public Humain(String nom, String boissonPref, int argent) {
		this.nom = nom;
		this.boissonPref = boissonPref;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public String getBoissonPref() {
		return boissonPref;
	}

	public int getArgent() {
		return argent;
	}
	
	public void parler(String texte) {
		System.out.println('(' + nom + ") - " + texte);
	}
	
	public void boire(String boissonPref) {
		parler("Mmmm, un bon verre de " + boissonPref + " ! GLOUPS !");
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m’appelle " + nom 
					+ " et j’aime boire du " + boissonPref + '.');
	}
	
	public void acheter(String bien, int prix) {
		if (argent >= prix) {
			parler("J'ai " + argent + " sous en poche. Je vais "
					+ "pouvoir m'offrir " + bien + " à " + prix + " sous.");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + argent +" sous en poche."
					+ " Je ne peux même pas m'offrir " + bien + " à "
					+ prix + " sous.");
		}
	}
	
	public void gagnerArgent(int gain) {
		argent += gain;
	}

	public void perdreArgent(int perte) {
		argent -= perte;
		if (argent<0) {
			argent = 0;
		}
	}
	
	public void faireConnaissanceAvec(Humain humain2) {
		direBonjour();
		humain2.repondre(this);
		memoriser(humain2);
	}
	
	private void repondre(Humain humain1) {
		direBonjour();
		memoriser(humain1);
	}

	private void memoriser(Humain humain) {
		if (nbConnaissance == nbConnaissanceMax) {
			for (int i=0;i<nbConnaissance-1;i++) {
				connaissance[i] = connaissance[i+1];
			}
			nbConnaissance -= 1;
			connaissance[nbConnaissance] = humain;
			nbConnaissance++;
		}
		else { 
			connaissance[nbConnaissance] = humain;
			nbConnaissance++;
		}
	}
	
	public void listerConnaissance() {
		if (nbConnaissance>0) {
			String listeConnaissance = ' ' + connaissance[0].getNom();
			
			for (int i=1;nbConnaissance>1 && i<nbConnaissance;i++) {
				listeConnaissance += (", " + connaissance[i].getNom());
			}
			parler("Je connais beaucoup de monde dont :" + listeConnaissance);
		}
		else {
			parler("Je ne connais personne pour le moment.");
		}
		
	}
}

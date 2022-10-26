package personnages;

public class Commercant extends Humain{

	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}

	public int seFaireExtorquer() {
		int perte = argent;
		argent = 0;
		
		parler("J’ai tout perdu! Le monde est trop injuste...");
		return perte;
	}
	
	public void recevoir(int gain) {
		argent += gain;
		parler(gain + " sous ! Je te remercie généreux donateur !");
	}
}
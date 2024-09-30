package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];
	
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	
//	AVANT TP3
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
//	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup( (force / 3) * effetPotion);
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois decuplee.");
		effetPotion = forcePotion;
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		Equipement[] newTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; newTrophees != null && i < newTrophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = newTrophees[i];
		}
	}
	
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		Romain minus = new Romain("Minus",5);
		asterix.parler("J'ai une force de " + asterix.force + " !");
		asterix.frapper(minus);
		
		Druide panoramix = new Druide("Panoramix", 5, 10);
		asterix.boirePotion(panoramix.preparerPotion());
		asterix.frapper(minus);
	}
}

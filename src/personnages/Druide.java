package personnages;

import java.util.Random;

public class Druide {
	private static final int SEUIL_SUPER_POTION = 7;
	
	private String nom;
	private int forcePotion = 1;
	private int effetPotionMin;
	private int effetPotionMax;
	
	Random randomizer = new Random();
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom
				+ " et ma potion peut aller d'une force " + effetPotionMin + " a "
				+ effetPotionMax + ".");
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public int preparerPotion() {
		forcePotion = effetPotionMin + randomizer.nextInt(effetPotionMax-effetPotionMin);
		if (forcePotion > SEUIL_SUPER_POTION) {
			parler("J'ai prepare une super potion de force");
		} else {
			parler("Je n'ai pas trouve tous les ingredients, ma potion est seulement de force " + forcePotion);
		}
		return forcePotion;
	}
	
	public void booster(Gaulois gaulois) {
		if ("Obelix".equals(gaulois.getNom())) {
			parler("Non, Obelix !... Tu n'auras pas de potion magique !");
		} else {
			gaulois.boirePotion(forcePotion);
		}
		
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		for (int i = 0; i < 3; i++) {
			panoramix.preparerPotion();
			System.out.println("Force de la potion : " + panoramix.forcePotion);
		}
	}
}

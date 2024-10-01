package personnages;

import villagegaulois.Musee;
import villagegaulois.Trophee;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Trophee[] trophees = new Trophee[100];
	
	
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
		Equipement[] equipementsEjectes = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; equipementsEjectes != null && i < equipementsEjectes.length; i++, nbTrophees++) {
			Trophee nouveauTrophee = new Trophee(this,equipementsEjectes[i]);
			this.trophees[nbTrophees] = nouveauTrophee;
		}
	}
	
	public void faireUneDonnation(Musee musee) {
		String texte = "";
		for (int i = 0; trophees[i] != null && i < trophees.length; i++) {
			musee.donnerTrophee(this,trophees[i]);
			texte += ("\n- " + trophees[i].getEquipement().getNom());
		}
		if ("".equals(texte)) {
			parler("Je n'ai pas de trophees a donner au musee...");
		} else {
			parler("Je donne au musee tous mes trophees : " + texte);
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

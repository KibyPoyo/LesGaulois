// SCENARIO AVANT TP3
//package histoire;
//
//import personnages.Druide;
//import personnages.Gaulois;
//import personnages.Romain;
//
//public class Scenario {
//
//	public static void main(String[] args) {
//		Gaulois asterix = new Gaulois("Asterix",8);
//		Gaulois obelix = new Gaulois("Obelix",25);
//		Romain minus = new Romain("Minus",6);
//		Druide panoramix = new Druide("Panoramix",5,10);
//		
//		panoramix.parler("Je vais aller preparer une petite potion...");
//		panoramix.preparerPotion();
//		panoramix.booster(obelix);
//		obelix.parler("Par Benelos, ce n'est pas juste !");
//		panoramix.booster(asterix);
//		
//		asterix.parler("Bonjour");
//		minus.parler(" UN GAU... UN GAUGAU...");
//		asterix.frapper(minus);
//	}
//
//}

package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;
//import villagegaulois.Musee;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.preparerPotion();
		Gaulois obelix = new Gaulois("Obelix", 25);
		Gaulois asterix = new Gaulois("Asterix", 8);
		druide.booster(obelix);
		obelix.parler("Par Belenos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (minus.getForce() > 0 && Boolean.FALSE.equals(minus.getVainqueur()) );
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(milexcus);
		} while (milexcus.getForce() > 0 && Boolean.FALSE.equals(minus.getVainqueur()));
		
//		Partie a decommenter
		
//		Musee musee = new Musee();
//		asterix.faireUneDonnation(musee);

	}

}
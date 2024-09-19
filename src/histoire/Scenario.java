package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		Gaulois obelix = new Gaulois("Obelix",25);
		Romain minus = new Romain("Minus",6);
		Druide panoramix = new Druide("Panoramix",5,10);
		
		panoramix.parler("Je vais aller preparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Benelos, ce n'est pas juste !");
		panoramix.booster(asterix);
		
		asterix.parler("Bonjour");
		minus.parler(" UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
	}

}

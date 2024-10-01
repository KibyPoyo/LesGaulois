package villagegaulois;

import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophees = 0;
	
	public void donnerTrophee(Gaulois gaulois, Trophee trophee) {
		trophees[nbTrophees] = trophee;
		nbTrophees++;
	}
	
	public String extraireInstructionsOCaml() {
		StringBuilder instructionsBuilder = new StringBuilder();
		
		instructionsBuilder.append("let musee = [\n");
		for (int i = 0; i < nbTrophees; i++) {
			instructionsBuilder.append("\t\"" + trophees[i].donnerNom() + "\", \"" +
										trophees[i].getEquipement().getNom() + "\"");
			if (i == nbTrophees) {
				instructionsBuilder.append("\n");
			} else {
				instructionsBuilder.append(";\n");
			}
		}
		instructionsBuilder.append("]");
		return instructionsBuilder.toString();
	}
}

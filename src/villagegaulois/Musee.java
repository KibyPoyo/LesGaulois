package villagegaulois;

import personnages.Equipement;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophees = 0;
	
	public void donnerTrophee(Trophee trophee) {
		trophees[nbTrophees] = trophee;
		nbTrophees++;
	}
	
	public String extraireInstructionsOCaml() {
		StringBuilder instructionsBuilder = new StringBuilder();
		
		instructionsBuilder.append("let musee = [\n");
		for (int i = 0; i < nbTrophees; i++) {
			Equipement equipement = trophees[i].getEquipement();
			instructionsBuilder.append("\t\"" + trophees[i].donnerNom() + "\", \"" +
										equipement.getNom() + "\"");
			if (i == nbTrophees-1) {
				instructionsBuilder.append("\n");
			} else {
				instructionsBuilder.append(";\n");
			}
		}
		instructionsBuilder.append("]");
		return instructionsBuilder.toString();
	}
}

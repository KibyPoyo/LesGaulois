package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipements = 0;
	private Boolean vainqueur = false;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		invariantForcePositive(force);
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}
	
	public Boolean getVainqueur() {
		return vainqueur;
	}

	private Boolean invariantForcePositive(int force) {
		return force > 0;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		vainqueur = false;
		Equipement[] equipementEjecte = null;
		
		assert invariantForcePositive(force); // Pre-condition
		int oldForce = force;

		forceCoup = calculResistanceEquipement(forceCoup);

		if (forceCoup > 0) {
			force -= forceCoup;
		} else {
			vainqueur = true;
			parler("Tu ne m'a meme pas effleure !");
		}
		
		if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		
		assert (force < oldForce ^ vainqueur); // Post-condition (^ == x or)
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipements != 0) {
			texte += "\nMais heureusement, grace a mon equipement sa force est diminuee de ";
			for (int i = 0; i < nbEquipements; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipements];
		System.out.println("L'equipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipements; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	
	public void sEquiper(Equipement equipement) {
		String debutTexte = "Le soldat ";
		switch (nbEquipements) {
		case 2: {
			System.out.println(debutTexte + nom + " est deja bien protege !");
			break;
		}
		case 1: {
			if (equipements[0] == equipement) {
				System.out.println(debutTexte + nom + " possede deja un " + equipement.getNom() + " !");
			} else {
				ajouterEquipement(equipement);
			}
			break;
		}
		case 0: {
			ajouterEquipement(equipement);
			break;
		}
		default:
			break;
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipements] = equipement;
		nbEquipements++;
		System.out.println("Le soldat" + nom + " s'equipe avec un " + equipement.getNom() + " !");
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}

}

package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipements = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force > 0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int forceAvantCoup = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert forceAvantCoup > force;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipements) {
			case 2: {
				System.out.println("Le soldat " + nom + " est deja bien protege !");
				break;
			}
			case 1: {
				if (equipements[0] == equipement) {
					System.out.println("Le soldat " + nom + " possede deja un " + equipement.getNom() + " !");
				} else {
					equipements[1] = equipement;
					nbEquipements++;
					System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement.getNom() + " !");
				}
				break;
			}
			case 0: {
				equipements[0] = equipement;
				nbEquipements++;
				System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement.getNom() + " !");
				break;
			}
			default:
				break;
			}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
	
}

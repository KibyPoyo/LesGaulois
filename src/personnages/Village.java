package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}
	
	public Gaulois trouverHabitant(int idVillageois) {
		return villageois[idVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le " + nom + " du chef " + chef.getNom() + " vivent les legendaires Gaulois :");
		for (int i = 0; i < villageois.length; i++) {
			if(villageois[i] != null) {
				System.out.println("- " + villageois[i].getNom());
			}
		}
	}
	
	public static void main(String[] args) {
		Village monVillage = new Village("Village des Irreductibles",30);
//		Gaulois gaulois = monVillage.trouverHabitant(30);
//		L'inststruction ci-dessus cherche un habitant en dehors du tableau des habitants
//		Il y a bien 30 places dans ce village mais allant des indices 0 a 29 (inclus)
		Chef abraracourcix = new Chef("Abraracourcix",6,monVillage);
		monVillage.setChef(abraracourcix);
		
		Gaulois asterix = new Gaulois("Asterix",8);
		monVillage.ajouterHabitant(asterix);
		
//		Gaulois gaulois = monVillage.trouverHabitant(1);
//		System.out.println(gaulois);
//		On cherche le gaulois a l'emplacement numero 1, or on a place asterix a l'element 0
//		On obtient alors un resultat indetermine, ici <null>
		
		Gaulois obelix = new Gaulois("Obelix",25);
		monVillage.ajouterHabitant(obelix);
		
		monVillage.afficherVillageois();
	}
}

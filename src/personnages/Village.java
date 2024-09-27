package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois villageois[];
	private int nbVillageois;
	
	
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
		this.nbVillageois=0;
	}
	
	public void setChef(Chef chef){
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois<villageois.length) {
			this.villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
		else {
			System.out.println("Le village est plein.");
		}
	}
	
	public void afficherHabitants() {
		System.out.println("Bienvenue dans " + nom + ", dirigé par le glorieux "+ chef.getNom() +" qui contient " + nbVillageois + " villageois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
		
	}
	
	
	public Gaulois trouverHabitant(int numVill) {
		if (numVill<villageois.length){
			return villageois[numVill] ;
		}
		else {
			System.out.println("Il n'y a pas autant de gaulois dans ce village, il ne peut y en avoir que " + villageois.length);
			return null;
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des irréductibles", 30);
		Gaulois gaulois = village.trouverHabitant(30);
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
		Gaulois gaulois2 = village.trouverHabitant(0);
		System.out.println(gaulois2.getNom());
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherHabitants();
		
		
	}
	
}
package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement stuff[];
	private int carryCapacity;
	private int nbEquipement;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.nbEquipement = 0;
		this.stuff = new Equipement[carryCapacity];
		assert (force>=0);
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		assert (force>=0);
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
			assert (force>=0);
		}
	}
	
	public static void main(String[] args) {
		Romain loupailebus = new Romain ("Loupailebus", 2);
		loupailebus.parler("sup");
		System.out.println(Equipement.CASQUE);
		
	}
	
}

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
		this.carryCapacity = 2;
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
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 0:
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString());
				stuff[nbEquipement]=equipement;
				nbEquipement++;
				break;
			case 1:
				if (stuff[0].getNom()==equipement.getNom()) {
					System.out.println("Le soldat " + nom + " possède déjà un " + equipement.toString() );
				}
				else {
					System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString());
					stuff[nbEquipement]=equipement;
					nbEquipement++;
				}
				break;
			default:
				System.out.println("Le soldat " + nom + " est déjà bien équipé");
				
		}
	}
	
	public static void main(String[] args) {
		Romain loupailebus = new Romain ("Loupailebus", 2);
		loupailebus.parler("sup");
		System.out.println(Equipement.CASQUE);
		loupailebus.sEquiper(Equipement.CASQUE);
		loupailebus.sEquiper(Equipement.CASQUE);
		loupailebus.sEquiper(Equipement.BOUCLIER);
		loupailebus.sEquiper(Equipement.CASQUE);
		
	}
	
}

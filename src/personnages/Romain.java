package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement stuff[];
	private int carryCapacity;
	private int nbEquipement;
	
	private String texte;
	
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

	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}


	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		// Precondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
	
		if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
		}
	
	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((stuff[i] != null && stuff[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
				resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		if (forceCoup>resistanceEquipement) {
			forceCoup -= resistanceEquipement;
		}
		else {
			forceCoup=0;
		}
		return forceCoup;
		}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (stuff[i] != null) {
				equipementEjecte[nbEquipementEjecte] = stuff[i];
				nbEquipementEjecte++;
				stuff[i] = null;
			}
		}
		return equipementEjecte;
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

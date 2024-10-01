package personnages;

import java.lang.reflect.Method;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}

//	private String prendreParole() {
//		return "Le Gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un gros taquet dans la bouche de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] loot = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,nbTrophees++) {
			this.trophees[nbTrophees] = loot[i];
		}
	}
	
	public void boirePotion(int puissancePotion) {
		this.effetPotion=puissancePotion;
		parler("Merci Druide, je sens que ma force est " + puissancePotion + " fois décuplée");
		
		
		
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println("Gaulois [nom=" + asterix.nom + ", force=" + asterix.force + "]");
		
		asterix.parler("Bonjour a tous");
		Romain troudukus = new Romain("Troudukus", 12);
		
		
		
		asterix.boirePotion(5);
		asterix.frapper(troudukus);
	}

}

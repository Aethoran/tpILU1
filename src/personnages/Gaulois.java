package personnages;

import java.lang.reflect.Method;

public class Gaulois {
	private String nom;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
		
	private int force;
	private int effetPotion = 1;

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le Gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un gros taquet dans la bouche de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}
	
	@Override
//	public String toString() {
//		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
//	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("asterix", 8);
		System.out.println(asterix);
	}

}

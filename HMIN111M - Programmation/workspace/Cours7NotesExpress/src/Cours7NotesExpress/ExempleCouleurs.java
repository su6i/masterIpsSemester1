/*
 * 4- les différents schémas de construction des méthodes 
 *    dans le contexte de la programmation par objets (voir fichier des couleurs)
 * 
 */

package Cours7NotesExpress;

abstract class Pinceau{
	
	/*
	 * méthode vert()
	 * schéma : héritage de comportement
	 * 
	 * la méthode est définie dans Pinceau
	 * et héritée dans les autres classes
	 * 
	 */
	
	public void vert(){System.out.print("vert");}
	
	/*
	 * méthode rose()
	 * schéma : spécialisation de comportement
	 * 
	 * la méthode est définie dans Pinceau
	 * et spécialisée dans PinceauPastel (appel à super)
	 * 
	 */
	
	public void rose(){System.out.print("rose");}
	
	/*
	 * méthode bleu()
	 * schéma : masquage de comportement
	 * 
	 * la méthode est définie dans Pinceau
	 * et totalement réécrite dans les sous-classes
	 * 
	 */
	
	public void bleu(){System.out.print("bleu");}
	
	/*
	 * méthode jaune()
	 * schéma : programmation par généralisation avec point de variabilité anticipé
	 * (la méthode gamme() est le point de variabilité)
	 * 
	 * la méthode est définie dans Pinceau et appelle une méthode abstraite gamme()
	 * la méthode abstraite est définie dans une sous-classe
	 * 
	 */
	
	public void jaune(){System.out.print("jaune"); gamme(); }	
	
	/*
	 * méthode jaune()
	 * schéma : programmation par généralisation avec point de variabilité anticipé
	 * (la méthode variante_orange() est le point de variabilité)
	 * 
	 * la méthode est définie dans Pinceau et appelle une méthode concrète 
	 * variante_orange().
	 * la méthode concrète est définie dans une sous-classe
	 * 
	 */
	
	public void orange(){System.out.print("orange"); variante_orange();  }	
	
	
	public void variante_orange(){System.out.print(" standard");}
	

	abstract void gamme();
}


abstract class PinceauClair extends Pinceau{
	
	@Override
	public void bleu(){System.out.print("bleu clair");}
	
}


class PinceauPastel extends PinceauClair{
	
	@Override
	public void bleu(){System.out.print("bleu pastel");}
	
	
	@Override
	public void rose(){super.rose(); System.out.print(" dragée");}
	
	
	@Override
	public void variante_orange(){System.out.print(" coquille d'oeuf");}
	
	/*
	 * méthode mauve1()
	 * schéma : combinaison de méthodes
	 * 
	 * c'est bien construit car on appelle les versions les plus spécialisées
	 * de rose() et de bleu() grâce à la liaison dynamique
	 * 
	 */
	public void mauve1(){this.rose(); System.out.print("---"); this.bleu();}
	
	/*
	 * méthode mauve2()
	 * schéma : combinaison de méthodes
	 * 
	 * c'est MAL construit car on N'appelle PAS les versions les plus spécialisées
	 * de rose() et de bleu() à cause de super.
	 * 
	 * Il faut réserver l'usage de super.m() dans la méthode m()
	 * ou dans des cas rares et particuliers.
	 * 
	 */
	public void mauve2(){super.rose(); System.out.print("---"); super.bleu();}
	

	@Override
	public void gamme() {System.out.print(" pastel");}
	
}




public class ExempleCouleurs {

	public static void main(String[] args) {
		
		// Impossible : le type de la variable n'est pas un super-type
		// du type de l'instance
		//PinceauPastel pp1 = new Pinceau();	
		//PinceauPastel pp2 = new PinceauClair();
		
		System.out.println("------------- pinceau pp3 -----------------");
		
		PinceauPastel pp3 = new PinceauPastel();	
		
		pp3.vert();         System.out.println();
		pp3.rose();        System.out.println();
		pp3.bleu();        System.out.println();
		pp3.jaune();      System.out.println();
		pp3.orange();      System.out.println();
		pp3.mauve1();	 System.out.println();
		pp3.mauve2();	 System.out.println();
		
		
		//Impossible : Pinceau et PinceauClair sont abstraites
		// Pinceau p1 = new Pinceau();	
		// Pinceau p2 = new PinceauClair();
		
		Pinceau p3 = new PinceauPastel();
		
		System.out.println("------------- pinceau p3 -----------------");
		
		p3.vert(); 		System.out.println();
		p3.rose();    System.out.println();
		p3.bleu();    System.out.println();
		p3.jaune();  System.out.println();
		p3.orange();      System.out.println();
		// p3.mauve1(); // Impossible : mauve1 est définie sur PinceauPastel
		// p3.mauve2(); // Impossible : mauve1 est définie sur PinceauPastel
		
		// Impossible : le type de la variable n'est pas un super-type
		// du type de l'instance
		// PinceauClair pc1 = new Pinceau();
		// PinceauClair pc2 = new PinceauClair();

		System.out.println("------------- pinceau pc3 -----------------");
		
		PinceauClair pc3 = new PinceauPastel();	
		
		pc3.vert();    System.out.println();
		pc3.rose();   System.out.println();
		pc3.bleu();   System.out.println();
		pc3.jaune(); System.out.println();
		pc3.orange();      System.out.println();
		// pc3.mauve1(); // Impossible : mauve1 est définie sur PinceauPastel
		// pc3.mauve2(); // Impossible : mauve1 est définie sur PinceauPastel	
	}

}
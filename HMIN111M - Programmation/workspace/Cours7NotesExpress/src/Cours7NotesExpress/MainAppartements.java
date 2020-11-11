/*
 * Partie 3
 */

package Cours7NotesExpress;

import java.util.Scanner;

public class MainAppartements {

	public static void main(String[] args) {
		/*
		 * La création d'un appartement de luxe reste correcte
		 */
		
		ApptLuxe a1 = new ApptLuxe("Montpellier",100,5,"internet piscine");
	
		/* 
		 * On peut toujours utiliser le type Appartement 
		 * pour créer une instance de la classe ApptLuxe.
		 * Ceci s'appelle une affectation polymorphe
		 */
		
		Appartement a2 = new ApptLuxe("Paris",50,2,"conciergerie");
		
		/*
		 * 2- les règles de compilation et d'interprétation et la liaison dynamique
		 * 
		 * Appartement est le type STATIQUE de a2 (type de la variable).
		 * ApptLuxe est le type DYNAMIQUE de a2 (type de l'instance).
		 * 
		 * Le type de la variable doit être une super-classe du type
		 * de l'instance.
		 */
		
		/*
		 * On ne peut plus créer d'instance propre (ou directe)
		 * de la classe Appartement
		 */
		
		// a2 = new Appartement("Nantes",150,4);
	
		/*
		 * Analyse de la compilation et de l'interprétation (exécution)
		 */
		
		double loyerA2 = a2.loyer(); 
		
		/*
		 * Analyse du travail du compilateur :
		 * 
		 * a2 a pour type statique (type de la variable) Appartement
		 * 
		 * La classe Appartement possède bien une méthode de signature 
		 * double loyer()
		 * 
		 * donc l'instruction double "loyerA2 = a2.loyer();" est acceptée
		 * 
		 */
		
		System.out.println(loyerA2);
		
		/*
		 * Décomposition du calcul (travail de l'interprète) :
		 * 
		 * - le type de l'instance est ApptLuxe
		 * 
		 * - loyer() est recherché dans ApptLuxe et n'y est pas trouvé
		 *   on remonte dans les super-classes jusqu'à trouver la plus basse
		 *   (la plus spécifique)
		 *   qui dispose d'une définition de loyer()
		 *   ici c'est Appartement.
		 *   On exécute loyer() de loyer()
		 *   = this.valeurLocativeBase()
		 *             *
		 *     this.CoeffModerateur();
		 *     
		 * - QUI EST THIS : c'est a2 et c'est TOUJOURS une instance d'ApptLuxe
		 * 
		 * - on cherche valeurLocativeBase() à partir de la classe ApptLuxe
		 *   on le trouvera en remontant dans Appartement
		 *   
		 * - on cherche CoeffModerateur() à partir de la classe ApptLuxe
		 *   et on le trouve bien ApptLuxe, on n'a pas besoin de remonter
		 *   
		 */
	}
}

/*
 * Partie 2
 */

package Cours7NotesExpress;

import java.util.Scanner;

/*
 * Les appartements de luxe sont des sortes d'appartements
 * C'est exprimé par le mot-clef "extends".
 * On peut le lire aussi comme :
 * la sous-classe ApptLuxe étend la super-classe Appartement.
 * 
 * Après avoir lu ce fichier, orientez-vous vers MAinAppartements
 */

public class ApptLuxe extends Appartement {

	/*
	 * Dans une instance d'appartement de luxe, on trouvera tous les attributs 
	 * d'un appartement (ils sont hérités).
	 * 
	 * Et on écrit dans cette classe uniquement l'attribut supplémentaire.
	 * 
	 */
	
	private String services = "aucun service";

	public ApptLuxe() {
	}

	/*
	 * on passe comme paramètre au constructeur tous les paramètres 
	 * attendus pour initialiser les attributs hérités
	 * (qui sont à initialiser)
	 */

	public ApptLuxe(String adresse, double superficie, int nbPieces,
			/*
			 * Et on ajoute un paramètre pour l'attribut propre
			 * aux appartements de luxe
			 */
					String services) {
		
		/*
		 * une forme syntaxique particulière permet d'appeler
		 * un constructeur de la super-classe qui va prendre en charge
		 * l'initialisation des attributs hérités
		 * (principe de responsabilité des classes : chacune s'occupe de
		 * ses attributs propres).
		 * 
		 */
		
		super(adresse, superficie, nbPieces);
		
		/*
		 * puis on initialise l'attribut propre
		 * 
		 */
		
		this.setServices(services);
	}

	/*
	 * Accesseurs : on écrit les accesseurs aux attributs propres
	 * Parfois on redéfinira les accesseurs aux attibuts hérités
	 * lorsque la sous-classe a des règles particulières les concernant
	 */
	
	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

/*
 * Méthodes	: les méthodes définies dans la super-classe 
 * s'appliquent aux instances de la sous-classe (elles sont héritées)
 * On peut aussi re-définir des méthodes pour ajouter un
 * comportement (des instructions) propres aux instances de la sous-classe.
 * 
 */
	
	/*
	 * On spécialise pour commencer la méthode toString
	 */
	
	@Override // cette annotation permet au compilateur de surveiller
	// que vous redéfinissez correctement (voir cours prochain ce que veut dire "correctement")
	public String toString() {
		/*
		 * la forme syntaxique super.meth(..) permet d'appeler la
		 * méthode redéfinie au sein de sa redéfinition.
		 * Ici ce sera : super.toString()
		 */
		
		return super.toString()
				/* 
				 * code spécifique aux appartements de luxe
				 */
				+ " services offerts "+ this.getServices();
	}
	
	@Override 
	public void saisie(Scanner clav) {
		/*
		 * appel de saisie de la classe Appartement
		 * qui permet de saisir les valeurs pour les attributs hérités
		 */
		super.saisie(clav);
		System.out.println("services ?");
		this.setServices(clav.next());
	}
	
	@Override
	public double CoeffModerateur() {
		return 1.1;
	}
	
	/*
	 * 3- la règle de redéfinition des méthodes
	 * 
	 * Règle de redéfinition d'une méthode
	 * - même nom
	 * - même liste de type de paramètres
	 * - type de retour identique ou plus spécialisé
	 * - visibilité identique ou plus large (ex. protected -> public)
	 */
	
	@Override // annotation recommandée devant la méthode
			  // provoquant la vérification de
	          // la règle de bonne redéfinition par le compilateur
	public boolean estIdentiqueA(Appartement a) {
		if (a instanceof ApptLuxe)
		{
			ApptLuxe aConvertiEnLuxe = (ApptLuxe)a;
			return this.estIdentiqueA(aConvertiEnLuxe)&&
					this.getServices().equals(aConvertiEnLuxe.getServices());
		}
		else return false;
	}
	
	// Exemple de mauvaise redéfinition
	// Cela compile mais ne sera pas appelé par la liaison dynamique
	// C'est de la surcharge statique et non pas de la redéfinition
	// L'annotation @Override ne sera pas acceptée ici
	/*public boolean estIdentiqueA(ApptLuxe a) {
			return this.estIdentiqueA(a)&&
					this.getServices().equals(a.getServices());
	}*/
	
	// redéfinition avec spécialisation du type de retour
	@Override
	public ApptLuxe copie() {
		return new ApptLuxe(this.getAdresse(),this.getSuperficie(),
							this.getNbPieces(), this.getServices());
	}
}


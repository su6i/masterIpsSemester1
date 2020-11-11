
/*
 * Héritage et spécialisation/généralisation 
 * Partie 2
 */

/*
 * Dans ce cours, nous proposons une introduction à la notion d'héritage.
 * Nous retravaillons à nouveau la classe Appartement des cours précédents.
 * 
 * Nous allons développer ces différents aspects :
 * 1- la notion de méthode abstraite et de classe abstraite
 * 2- les règles de compilation et d'interprétation et la liaison dynamique
 * 3- la règle de redéfinition des méthodes
 * 4- les différents schémas de construction des méthodes 
 *    dans le contexte de la programmation par objets (voir fichier des couleurs)
 * 
 */
package Cours7NotesExpress;

import java.util.Scanner;

/*
 * 1- la notion de méthode abstraite et de classe abstraite
 * 
 * Comme on l'a vu, l'héritage permet de factoriser des parties de code (structure
 * ou instructions) communes entre plusieurs classes, comme ApptNormal et ApptLuxe. 
 * Ceci est fait en créant une super-classe (Appt) possédant ces parties communes.
 * 
 * Cela va parfois nous amener à factoriser des définitions partielles et à avoir des 
 * classes et des méthodes incomplètes.
 * 
 * Par exemple, considérons un calcul de loyer pour les appartements, qui se
 * présenterait sous la forme suivante :
 * le loyer est égal à une valeur locative de base multipliée par un coefficient 
 * modérateur.
 * 
 * la valeur locative de base est donnée par la formule :
 * superficie * 5 * (1+nbPieces/10).
 * 
 * Le coefficient modérateur est :
 * -- pour les appartements de luxe = 1.1 
 * -- pour les appartements normaux = 1-(0.1*(nbNuisances)), 
 *    on suppose que nbNuisances <=10
 *    
 * Une mise en oeuvre classique en programmation par objets va consister
 * à écrire la méthode loyer de la manière la plus générale possible,
 * comme le produit du résultat de deux méthodes auxiliaires :
 * - l'une calculant la valeur locative de base, qui peut être réalisée dans
 *   la classe Appartement (valeurLocativeBase)
 * - l'autre calculant le coefficient modérateur (CoeffModerateur), qui ne peut être réalisée
 *   concrètement que dans les sous-classes, mais dont on va indiquer l'existence
 *   dans la classe Appartement, sous forme d'une méthode ABSTRAITE (seule sa
 *   signature sera donnée).
 *   
 * La classe Appartement voit sa définition devenir incomplète puisque
 * la méthode CoeffModerateur n'est pas écrite entièrement (on connaît seulement
 * sa signature) : la classe Appartement devient ABSTRAITE.
 * 
 * La classe Appartement ne pourra pas avoir d'intance propre :
 * Appartement a; // reste possible
 * a = new Appartement( .... ); // ne l'est plus
 * a = new ApptLuxe( ....) // sera possible
 * 
 */

public abstract class Appartement {
	
	// Attributs
	
	private String adresse = "adresse inconnue";
	private double superficie;
	private int nbPieces;
	
	// Constructeurs
	
	public Appartement() {}
	
	public Appartement(String adresse, double superficie, int nbPieces) {
		this.setAdresse(adresse);
		this.setSuperficie(superficie);
		this.setNbPieces(nbPieces);
	}
	
	
	// Accesseurs

	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public double getSuperficie() {
		return superficie;
	}

	// à améliorer en contrôlant que superficie est un réel positif
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}


	public int getNbPieces() {
		return nbPieces;
	}

	// à améliorer en contrôlant que nbPieces est un entier positif
	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}
	
	// Méthodes
	
	public String toString() {
		return this.adresse+" "+this.superficie
				+" "+this.nbPieces;
	}
	
	public void saisie(Scanner clav) {
		System.out.println("adresse ?");
		this.setAdresse(clav.next());
		System.out.println("superficie ?");
		this.setSuperficie(clav.nextDouble());
		System.out.println("nombre de pièces ?");
		this.setNbPieces(clav.nextInt());
	}
	
	// Méthode ABSTRAITE
	// elle n'a pas de corps (pas d'instruction entre '{' et '}')
	
	public abstract double CoeffModerateur();
	
	// Méthode écrite pour factoriser le comportement
	// commun de calcul de loyer
	// Notez l'appel d'une méthode abstraite à ce niveau de la hiérarchie
	
	public double loyer() {
		return this.valeurLocativeBase()*this.CoeffModerateur();
	}
	
	public double valeurLocativeBase() {
		return this.superficie * 5 * (1+this.nbPieces/10);
	}
	
	// Ci-dessous des méthodes pour observer la règle
	// de redéfinition des méthodes dans la sous-classe
	
	public boolean estIdentiqueA(Appartement a) {
		return this.getAdresse().equals(a.getAdresse());
	}
	
	public Appartement copie() {
		return null; // on ne peut pas instancier Appartement
	}
}


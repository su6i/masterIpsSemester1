package cc1_2019;

import java.io.IOException;

import java.util.Scanner;

public class MainCC1 {

	public static void main(String[] args) throws IOException {
		
		Point point = new Point();
		
	
		/**** Tests Classe Point ****/
		
		System.out.println("Tests de la classe Point");
		
		// Création de deux points p1 et p2 ayant pour coordonnées p1(10,15) et p2(2,3)
		
		Point p1 = new Point(10,15);
		Point p2 = new Point(2,3);
		
		// Affichage des points p1 et p2
		
		System.out.println("Les coordonnées du point p1 sont: " + p1 + ", celles du point p2 sont: " + p2);
		
		
		// Calcul de la distance entre les points p1 et p2
		
		System.out.println("La distance entre le point p1 et le point p2 est : " + point.distance(p1, p2));
		
		
		//Création de deux nouveaux points p3 et p4 saisis par l'utilisateur

		Scanner sc = new Scanner(System.in);

		
		Point p3 = new Point();
		p3.saisie(sc);
		
		Point p4 = new Point();
		p4.saisie(sc);

		
		
		
		sc.close();
				
		//Affichage des deux nouveaux points p3 et p4
		
		System.out.println("P3: " + p3 + " P4: " + p4);
		
	
		
		
		/**** Tests Classe Segment ****/
		
		System.out.println("Tests de la Classe Segment:");
		
		// Création d'un nouveau segment s=[p1 p2]
		
		
		// Affichage du segment s
		
		
		//Calcul du milieu du segment s
		
		
		
		//Création d'un nouveau segment s1 saisi par l'utilisateur
		
		
		//Affichage du segment s1
		
		
					
		//Vérification si les longueurs entre s et s1 sont égales
		
		
		
		// Comparaison des segments s et s1
		
		
		// Modification du point p1 du segment s avec pour nouvelles coordonnées p1(13,15)
		
		
		// Calcul de la nouvelle longueur de s
		
		
		// Affichage du nouveau segment s
		
		
		// Nouvelle comparaison entre s et s1
	
		
		
		
	
		
	
	
	}
	
}

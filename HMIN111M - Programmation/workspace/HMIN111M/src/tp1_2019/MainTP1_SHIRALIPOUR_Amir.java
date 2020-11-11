package tp1_2019;

import java.util.Scanner;


public class MainTP1_SHIRALIPOUR_Amir {


	/********************** Partie méthodes *************************/

	/* méthode réalisant une conversion degrés Celsius vers degrés Farenheit
	 Entrée : un nombre réel tempC passé en paramètre
	 tempC représente une temperature exprimée en degrés Celsius
	 Résultat : un nombre réel résultat de la conversion en degrés Farenheit
	 Méthode : calcul de tempC * 1,8 + 32.  */

public static double celsius2Farenheit(double tempC) {
	return tempC * 1.8 + 32;	
}




/* méthode réalisant la conversion d'une durée en secondes en une chaîne
	 de caractères sous la forme ..H ..Mn ..Sec
	 Entrée : un nombre entier sec passé en paramètre
	 sec représente un nombre de secondes
	 Résultat : une chaîne de caractères sous la forme ..H ..Mn ..Sec
	 Méthode : (... à compléter ...) */


public static String secondes2ChaineHMnSec(int sec) {
	// partie à remplir
	int H,M,S;
	H = sec / 3600; 
	S = sec%3600;
	M=S/60;
	S =S%60;

	return H+"H "+M+"M "+S+"Sec"; 
}


/* Ci-dessous écrivez le code des autres méthodes dont la signature vous est donnée */


//moyenne(double n1, double n2, double n3) : double

public static double moyenne(double n1, double n2, double n3) {

	return (n1+n2+n3)/3; 
}




//moyennePonderee(double n1, double n2, double n3, double c1, double c2, double c3) : double

public static double moyennePonderee(double n1, double n2, double n3, double c1, double c2, double c3) {

	return (n1*c1+n2*c2+n3*c3)/(c1+c2+c3); 
}




//carteVermeil(int a, char g) : boolean

public static boolean carteVermeil(int a, char g) {

	boolean estFemme = (g=='F' || g=='f');
	boolean estHomme = (g=='H' || g=='h');

	return ((estFemme && (a >= 60)) || (estHomme && (a >= 65))); 
}




//conjugueFuturPremierGroupe(String inf) : String


public static String conjugueFuturPremierGroupe(String inf) {

	return ("La conjugaison du verbe "+ inf+" est la suivante:"+"\n"+ "Je "+inf+"ai"+"\n" + "Tu "+inf+"as"+"\n" + "Il/Elle "+inf+"a"+"\n" + "Nous "+inf+"ons"+"\n" + "Vous "+inf+"ez"+"\n" + "Ils/Elles "+inf+"ont"+"\n"); 
}





/************************Partie Main ************************/

/* Cette méthode main est la méthode principale
Le programme commence à s'exécuter à partir de là
et appelle des sous-programmes */


public static void main(String[] args) {

	/* Test de la conversion Celsius vers Farenheit */

	// Cas 1 : valeur de température ordinaire en été à Montpellier

	System.out.println("En été à Montpellier : 35 degrés celsius valent "+
			celsius2Farenheit(35)+" en degrés Farenheit");

	// Cas 2 : sur le même modèle, donner le code permettant de calculer la température d'ébullition de l'eau
	
	System.out.println("La température d'ébullition de l'eau est "+
			celsius2Farenheit(100)+" en degrés Farenheit");



	/* Ci-dessous vous appelerez la méthode durée avec les valeurs suivantes :*/

	//	 System.out.println("\n**** Test de la conversion Secondes vers ..H ..Mn ..Sec ****");


	// Cas 1 : valeur de 7384
	System.out.println("secondes2ChaineHMnSec (7384)= "+secondes2ChaineHMnSec(7384));


	// Cas 2 : valeur de 0
	System.out.println("secondes2ChaineHMnSec (0)   = "+secondes2ChaineHMnSec(0));


	// Cas 3 : valeur de 7200
	System.out.println("secondes2ChaineHMnSec (7200)= "+secondes2ChaineHMnSec(7200));


	// Cas 4 : valeur de 180
	System.out.println("secondes2ChaineHMnSec (180) = "+secondes2ChaineHMnSec(180));


	// Cas 5 : valeur de 4
	System.out.println("secondes2ChaineHMnSec (4)   = "+secondes2ChaineHMnSec(4));


	// Cas 6 : valeur de -128
	System.out.println("secondes2ChaineHMnSec (-128)= "+secondes2ChaineHMnSec(-128));





	/* Ci-dessous vous appelerez la méthode moyenne avec les valeurs suivantes :*/



	// cas 1 : moyenne de 0, 0, 0
	System.out.println("moyenne de 0, 0, 0    = "+moyenne(0,0,0));


	// cas 2 : moyenne de 10, 10, 10
	System.out.println("moyenne de 10, 10, 10 = "+moyenne(10,10,10));


	// cas 3 : moyenne de 20, 20, 20
	System.out.println("moyenne de 20, 20, 20 = "+moyenne(20,20,20));


	// cas 4 : moyenne de 12, 14, 16
	System.out.println("moyenne de 12, 14, 16 = "+moyenne(12,14,16));


	// cas 5 : moyenne de 7, 12, 8
	System.out.println("moyenne de 7, 12, 8   = "+moyenne(7,12,8));




	/* Ci-dessous vous appelerez la méthode moyennePonderee avec les valeurs suivantes :*/


	// cas 1 : moyenne de 0, 0, 0 avec 20, 20, 60
	System.out.println("moyennePonderee de 0, 0, 0 avec 20, 20, 60    = "+moyennePonderee(0,0,0,20,20,60));



	// cas 2 : moyenne de 10, 10, 10 avec 20, 20, 60
	System.out.println("moyennePonderee de 10, 10, 10 avec 20, 20, 60 = "+moyennePonderee(10,10,10,20,20,60));



	// cas 3 : moyenne de 20, 20, 20 avec 20, 20, 60
	System.out.println("moyennePonderee de 20, 20, 20 avec 20, 20, 60 = "+moyennePonderee(20,20,20,20,20,60));



	// cas 4 : moyenne de 12, 14, 16 avec 20, 20, 60
	System.out.println("moyennePonderee de 20, 20, 20 avec 20, 20, 60 = "+moyennePonderee(12,14,16,20,20,60));



	// cas 5 : moyenne de 12, 14, 16 avec 30, 30, 20
	System.out.println("moyennePonderee de 12, 14, 16 avec 30, 30, 20 = "+moyennePonderee(12,14,16,30,30,20));



	// cas 6 : moyenne de 7, 12, 8 avec 20, 20, 60
	System.out.println("moyennePonderee de 7, 12, 8 avec 20, 20, 60   = "+moyennePonderee(7,12,8,20,20,60));




	/* Ci-dessous vous appelerez la méthode carteVermeil avec les valeurs suivantes :*/


	// Cas 1 : femme de 40 ans
	System.out.println("Je suis une femme de 40 ans, est-ce que je gagne la carteVermeil? = "+carteVermeil(40,'f'));



	// Cas 2 : homme de 40 ans
	System.out.println("Je suis un  homme de 40 ans, est-ce que je gagne la carteVermeil? = "+carteVermeil(40,'h'));



	// Cas 3 : femme de 60 ans
	System.out.println("Je suis une femme de 60 ans, est-ce que je gagne la carteVermeil? = "+carteVermeil(60,'f'));



	// Cas 4 : homme de 60 ans	
	System.out.println("Je suis un  homme de 60 ans, est-ce que je gagne la carteVermeil? = "+carteVermeil(60,'h'));



	// Cas 5 : femme de 66 ans
	System.out.println("Je suis une femme de 66 ans, est-ce que je gagne la carteVermeil? = "+carteVermeil(66,'f'));



	// Cas 6 : homme de 66 ans
	System.out.println("Je suis un  homme de 66 ans, est-ce que je gagne la carteVermeil? = "+carteVermeil(66,'h'));




	/* Ci-dessous vous appelerez la méthode conjugueFuturPremierGroupe avec les valeurs suivantes :*/

	// Cas 1 : chanter
	System.out.println(conjugueFuturPremierGroupe("chanter"));	



	// Cas 2 : travailler
	System.out.println(conjugueFuturPremierGroupe("travailler"));	







	/************************ Utilisation du scanner pour entrer les valeurs ************************/ 


	/* On crée un Scanner pour tout le programme. Il représente le flux de ce qui est saisi au clavier 
Instruction à décommenter pour pouvoir l'utiliser */

	Scanner sc = new Scanner(System.in);



	// test de la complétion sémantique à faire ci-dessous




	/* Test des précédentes méthodes en demandant à l'utilisateur de saisir une valeur au clavier */

	// Conversion Celsius2Farenheit (Instructions ci-dessous à décommenter pour exemple)

	System.out.println("Veuillez entrer un nombre réel représentant une température en degrés Celsius");

	double tempCelsius = sc.nextDouble();

	System.out.println(tempCelsius+" degrés celsius valent "+ celsius2Farenheit(tempCelsius)+" en degrés Farenheit");


	// secondes2ChaineHMSec (Ecrire le code source ci-dessous en vous inspirant de ce qui a été fait pour la conversion de Celsius a Farenheit)

	System.out.println("Veuillez entrer un nombre entier représentant une durée en secondes pour le convertir en une chaîne de caractères: ");


	int sec = sc.nextInt();

	System.out.println(sec+" secondes valent "+ secondes2ChaineHMnSec(sec)+" une chaîne de caractères");


	// Moyenne (Ecrire le code source ci-dessous en vous inspirant de ce qui a été fait pour la conversion de Celsius a Farenheit)

	System.out.println("Veuillez entrer trois nombre double représentant trois notes pour voir la moyenne (après chaque nombre tape Entré): ");


	double n1 = sc.nextDouble();
	double n2 = sc.nextDouble();
	double n3 = sc.nextDouble();

	System.out.println("La moyenne de "+n1+" , "+n2+" et "+n3+ " = "+ moyenne(n1,n2,n3));


	// Moyenne pondérée (Ecrire le code source ci-dessous en vous inspirant de ce qui a été fait pour la conversion de Celsius a Farenheit)


	//moyennePonderee(double n1, double n2, double n3, double c1, double c2, double c3) : double

	System.out.println("Veuillez entrer trois nombre double représentant trois notes et aussi trois nombre double représentant le coefficient pour voir la moyenne ponderée (après chaque nombre tape Entré): ");


	double n11 = sc.nextDouble();
	double n21 = sc.nextDouble();
	double n31 = sc.nextDouble();
	double c1 = sc.nextDouble();
	double c2 = sc.nextDouble();
	double c3 = sc.nextDouble();


	System.out.println("La moyenne de "+n11+" avec le coefficient de "+c1+" , "+n21+" avec le coefficient de "+c2+" et "+n31+ " avec le coefficient de "+c3+" = "+ moyennePonderee(n11,n21,n31,c1,c2,c3));





	// Carte Vermeil (Ecrire le code source ci-dessous en vous inspirant de ce qui a été fait pour la conversion de Celsius a Farenheit)

	// Cas 1 : femme de 40 ans


	System.out.println("Veuillez entrer un nombre entier représentant l'âge et un caractère représentant le genre pour voir la possibilité d'avoir la carte vermeil: ");


	int a = sc.nextInt();
	char g = sc.next().charAt(0);

	if (g=='f') {

		System.out.println("Je suis une femme de "+a+" ans, est-ce que je gagne la carteVermeil? = "+carteVermeil(a,g));
	} else if (g=='h') {

		System.out.println("Je suis un homme de "+a+" ans, est-ce que je gagne la carteVermeil? = "+carteVermeil(a,g));

	} else {

		System.out.println("Vous avez entré un mouvais caractère");

	}


	// Conjugaison (Ecrire le code source ci-dessous en vous inspirant de ce qui a été fait pour la conversion de Celsius a Farenheit)


	System.out.println("Veuillez entrer un verbe du premier groupe pour voir la congugaison en future: ");

	String verbe = sc.next();
	System.out.println(conjugueFuturPremierGroupe(verbe));	










	sc.close();
}


}	


package tp2_2019;

import java.io.IOException;

// import java.util.jar.JarException;


import java.util.Scanner;

public class MainEtudiant {

	public static void main(String[] args) throws IOException {
		
		 
	/***************************************Constructeurs *******************************************/
		
			//Création d'un nouvel étudiant dont le nom est paul  
			Etudiant etud1 = new Etudiant("Paul");
		
			//En vous inspirant de l'exemple, écrire ci-dessous le code pour créer les autres étudiants  
			Etudiant etud2 = new Etudiant("Jean",24,1,2);
			Etudiant etud3 = new Etudiant("Abdoulkhader", 23, 2, 2);
			Etudiant etud4 = new Etudiant("Astrid", 26, 1, 3);
			Etudiant etud5 = new Etudiant("Paolo", 27, 1, 3);
			Etudiant etud6 = new Etudiant("Zoé", 26, 1, 1);

			// Nouvel etudiant 8
			Etudiant etud8 = new Etudiant("Pierre", 24, 1, 2);
			

		/***********************************Accesseurs*****************************************/
		
		/* Affichage des informations grâce à l'accesseur get */
		
	//Affichage du nom de etud1
			System.out.println("Le nom de l'étudiant1 est: " +etud1.getNom());
			
	//Ecrire ci-dessous les informations des autres étudiants (toutes les informations connues par étudiant)
			System.out.println("Le nom de l'étudiant2 est: " +etud2.getNom() + " et il a "+ etud2.getAge() +" ans");
			System.out.println("Le nom de l'étudiant3 est: " +etud3.getNom() + " et il a "+ etud3.getAge() +" ans");
			System.out.println("Le nom de l'étudiant4 est: " +etud4.getNom() + " et elle a "+ etud4.getAge() +" ans");
			System.out.println("Le nom de l'étudiant5 est: " +etud5.getNom() + " et il a "+ etud5.getAge() +" ans");
			System.out.println("Le nom de l'étudiant6 est: " +etud6.getNom() + " et elle a "+ etud6.getAge() +" ans, "
			+ "et elle a pris les notes suivantes: \nProgrammation = "+etud6.getNoteProg()+"\nSystème = "+etud6.getNoteSyst()+"\nStage = "+etud6.getNoteStage());
		
/* Modification d'information grâce à l'accesseur set */
		
	// Modification du nom de etud1 
			etud1.setNom("Paul-Henri");
			
	// Ecrire ci-dessous le code pour modifier l'âge de Jean
			etud2.setAge(25);
			
	//Ecrire ci-dessous le code pour modifier la note de programmation de Zoe
			etud6.setNoteProg(15);
			
	// Ecrire ci-dessous le code pour ajouter les notes des autres étudiants
			etud1.setNoteProg(16);
			etud1.setNoteSyst(15);
			etud1.setNoteStage(14);
			
			etud2.setNoteProg(8);
			etud2.setNoteSyst(7);
			etud2.setNoteStage(11);
			
			etud3.setNoteProg(10);
			etud3.setNoteSyst(14);
			etud3.setNoteStage(11);
			
			etud4.setNoteProg(12);
			etud4.setNoteSyst(5);
			etud4.setNoteStage(18);
			
			etud5.setNoteProg(2);
			etud5.setNoteSyst(10);
			etud5.setNoteStage(11);
			
	/********************************************************************************************/
	//-4 Amélioration des accesseurs et des constructeurs----------------------------------------/
	/********************************************************************************************/

	// — Dans MainEtudiant, testez la possibilité de changer la note de système de Zoé avec 22.	Vous devez obtenir un message d’erreur
			etud6.setNoteProg(22);
			System.out.println(etud6.getNoteProg());

	// — Dans MainEtudiant, testez la possibilité de créer un nouvel étudiant avec un code inscription égal à 3. Vous devez obtenir un message d’erreur
			System.out.println("------------------------------------------------------------");
			Etudiant etud10 = new Etudiant("Wen", 25, 22, 19, 19, 3, 2);
			System.out.println("Etudian 10 : "+etud10);
			
	// — Dans MainEtudiant, testez la possibilité de créer un nouvel étudiant avec un code pays	égal à 4. Vous devez obtenir un message d’erreur
			Etudiant etud11 = new Etudiant("Amir", 25, 19, 19, 19, 1, 4);
			System.out.println("Etudiant 11 : "+etud11);

/* Verification que les modifications ont bien été prises en compte */
		
	//Pour chaque étudiant modifié, écrire ci-dessous le code permettant d'afficher les nouvelles informations, grâce à l'accesseur get
		
			System.out.println("Le nom de l'étudiant1 est: " +etud1.getNom() + "   et il a "+ etud1.getAge() +"  ans, "
			+ "et elle a pris les notes suivantes: Programmation = "+etud1.getNoteProg()+" Système = "+etud1.getNoteSyst()+" Stage = "+etud1.getNoteStage());
			
			System.out.println("Le nom de l'étudiant2 est: " +etud2.getNom() + "         et il a "+ etud2.getAge() +" ans, "
			+ "et elle a pris les notes suivantes: Programmation = "+etud2.getNoteProg()+"  Système = "+etud2.getNoteSyst()+"  Stage = "+etud2.getNoteStage());
			
			System.out.println("Le nom de l'étudiant3 est: " +etud3.getNom() + " et il a "+ etud3.getAge() +" ans, "
			+ "et elle a pris les notes suivantes: Programmation = "+etud3.getNoteProg()+" Système = "+etud3.getNoteSyst()+" Stage = "+etud3.getNoteStage());
			
			System.out.println("Le nom de l'étudiant4 est: " +etud4.getNom() + "       et elle a "+ etud4.getAge() +" ans, "
			+ "et elle a pris les notes suivantes: Programmation = "+etud4.getNoteProg()+" Système = "+etud4.getNoteSyst()+"  Stage = "+etud4.getNoteStage());
			
			System.out.println("Le nom de l'étudiant5 est: " +etud5.getNom() + "        et il a "+ etud5.getAge() +" ans, "
			+ "et elle a pris les notes suivantes: Programmation = "+etud5.getNoteProg()+"  Système = "+etud5.getNoteSyst()+" Stage = "+etud5.getNoteStage());
			
			System.out.println("Le nom de l'étudiant6 est: " +etud6.getNom() + "          et elle a "+ etud6.getAge() +" ans, "
			+ "et elle a pris les notes suivantes: Programmation = "+etud6.getNoteProg()+" Système = "+etud6.getNoteSyst()+" Stage = "+etud6.getNoteStage());
			
			System.out.println("Le nom de l'étudiant8 est: " +etud8.getNom() + "       et elle/il a "+ etud8.getAge() +" ans, "
			 + etud8);

			

		/* ************************** Les méthodes *********************************** */
		
		
/* Utilisation de la méthode toString  */
			
	// Utilisation de la méthode toString pour afficher l'étudiant etud1
/*			System.out.println("-------------------Test----------------------------");
			
			Inscription inscTest = new Inscription();
			inscTest.setCodeInscription(1);
			inscTest.setCodePays(2);
			etud1.setInscription(inscTest);
			System.out.println("This is really just for test."+inscTest.toString());

			
			System.out.println("-------------------Test----------------------------");
*/
			System.out.println("Informations concernant l'étudiant 1: " + etud1);

			//Faire la même chose pour tous les étudiants et vérifier que les données sont correctes
			System.out.println("Informations concernant l'étudiant 2: " + etud2);
			System.out.println("Informations concernant l'étudiant 3: " + etud3);
			System.out.println("Informations concernant l'étudiant 4: " + etud4);
			System.out.println("Informations concernant l'étudiant 5: " + etud5);
			System.out.println("Informations concernant l'étudiant 6: " + etud6);
		
/* Utilisation de la méthode saisie */
		
	// Créer un nouvel étudiant etud7 grace au constructeur vide
			Etudiant etud7 = new Etudiant();
			
	// Ouvrir le scanner
			Scanner sc = new Scanner(System.in);
		
	//Utiliser la méthode saisie définie dans la classe Etudiant sur l'étudiant etud7 (vous choisissez les valeurs)
			etud7.saisie(sc);

	//Vérifier grâce à la méthode toString que les informations concernant etud7 ont bien été initialisées
			System.out.println("Informations concernant l'étudiant 7: " + etud7);

			// Nouvel etudiant 9
			Etudiant etud9 = new Etudiant();
			etud9.saisie(sc);
			System.out.println("Informations concernant l'étudiant 9: " + etud9);
			
		
/* Utilisation de la méthode moyenne */
			
	// Calcul et affichage de la moyenne de Paul-Henri. A décommenter pour exemple
				System.out.println("la moyenne de Paul-Henri est: " + etud1.moyenne());
			
	//Ecrire ci dessous le code pour calculer et afficher la moyenne des autres étudiants
				System.out.println("la moyenne de " +etud2.getNom()+ " est: " + etud2.moyenne());
				System.out.println("la moyenne de " +etud3.getNom()+ " est: " + etud3.moyenne());
				System.out.println("la moyenne de " +etud4.getNom()+ " est: " + etud4.moyenne());
				System.out.println("la moyenne de " +etud5.getNom()+ " est: " + etud5.moyenne());
				System.out.println("la moyenne de " +etud6.getNom()+ " est: " + etud6.moyenne());
				System.out.println("la moyenne de " +etud7.getNom()+ " est: " + etud7.moyenne());
			
	/* Utilisation de la méthode mention pour chaque étudiant. Code à écrire ci-dessous */	
				System.out.println("la mention de " +etud2.getNom()+ " est: " + etud2.moyenne());
				System.out.println("la mention de " +etud3.getNom()+ " est: " + etud3.moyenne());
				System.out.println("la mention de " +etud4.getNom()+ " est: " + etud4.moyenne());
				System.out.println("la mention de " +etud5.getNom()+ " est: " + etud5.moyenne());
				System.out.println("la mention de " +etud6.getNom()+ " est: " + etud6.moyenne());
				System.out.println("la mention de " +etud7.getNom()+ " est: " + etud7.moyenne());
		
	/* Utilisation de la méthode ligneResultat pour chaque étudiant. Code à écrire ci-dessous */
				System.out.println(etud1.ligneResultats());
				System.out.println(etud2.ligneResultats());
				System.out.println(etud3.ligneResultats());
				System.out.println(etud4.ligneResultats());
				System.out.println(etud5.ligneResultats());
				System.out.println(etud6.ligneResultats());
				System.out.println(etud7.ligneResultats());
				
	/***************************************************************************************************/
	//-----------------2.5 Test des méthodes (Promotion) dans la classe MainEtudiant -------------------/
	/***************************************************************************************************/

	// Créer une nouvelle promotion pour l’année 2019
				Promotion promo = new Promotion(2019);

	// Inscrire, dans cette promotion, les étudiants que vous avez créé dans le TP2 1 et TP2 2
				
				
				
				/* Why it doesn't work?
				for (int i = 0;i<=7;i++) {
					String newEtudI = "etud"+i;
					promotion2019.inscrire(newEtudI);
				} // fin de for
				*/
				
				promo.inscrire(etud1);
				promo.inscrire(etud2);
				promo.inscrire(etud3);
				promo.inscrire(etud4);
				promo.inscrire(etud5);
				promo.inscrire(etud6);
				promo.inscrire(etud7);
				promo.inscrire(etud8);
				promo.inscrire(etud9);
				promo.inscrire(etud10);
				promo.inscrire(etud11);
				
	// Afficher la liste des étudiants
				System.out.println("Students from promo(2019) are: "+promo.afficheEtudiants());

	// Afficher le nombre d’étudiants de la promotion
				System.out.println("Total number of students: "+promo.nbEtudiants());
				
	// Afficher le troisième étudiant inscrit dans la promotion
				System.out.println("student's number 3: "+promo.getEtudiant(2));

	/***************************************************************************************************/
	//---------------2.6 Lien entre les classes Etudiant, Inscription et la classe Promotion -----------/
	/***************************************************************************************************/

	// Écrire une méthode moyenneGénérale(): double, qui retourne la moyenne générale de la promotion
	// (vous devez utiliser la méthode moyenne de la classe Etudiant). Tester cette méthode dans MainEtudiant
				System.out.println("MoyenneGenerale: "+String.format("%.2f", promo.moyenneGenerale()));

	// — Ecrire une méthode afficheResultats(): void qui, pour chaque étudiant, affiche une
	// ligne contenant l’ensemble de ses résultats (vous devez utiliser la méthode ligneResultat
	// de la classe Etudiant) . Tester cette méthode dans MainEtudiant
				promo.afficheResultats();
				
	// — En utilisant la boucle while, créer une méthode recherche(String nom): Boolean,
	// qui retourne vrai si un étudiant est inscrit dans la promotion (on suppose qu’il n’y a pas
	// d’homonymes). Tester cette méthode dans MainEtudiant.

				System.out.println("Enter a name to look for in the list: ");
				String etudName = sc.next();
				System.out.println("You entered: "+etudName);

				if (promo.recherche(etudName)) {
					System.out.println("I found "+etudName+" in the list.");
				}
				else
					System.out.println("Sorry, I didn't found "+etudName+" in the list.");
				
	// — Ecrire une méthode listeAdmis():ListeEtudiants, qui stocke dans une nouvelle liste
	//les étudiants admis. Dans MainEtudiant, utiliser cette méthode pour retourner uniquement le nom et la moyenne des étudiants admis.
				
				for (int i =0;i<promo.listeAdmis().size();i++) {
					System.out.println("List of admitted: "+promo.listeAdmis().get(i).getNom()+" , AVG: "+String.format("%.2f", promo.listeAdmis().get(i).moyenne()));
				}

	//— Ecrire une méthode major(): String, qui retourne le nom du major de la promo-
	//tion (on suppose qu’il n’y a pas deux moyennes identiques. Tester cette méthode dans MainEtudiant
				System.out.println(promo.major());
				
				
	//Tester méthode nouveauxInscritsNonFrancophones() dans MainEtudiant pour afficher :
	//— Le nombre d’étudiant nouvellement inscrits et non francophones
				System.out.println("Le nombre d’étudiant nouvellement inscrits et non francophones est:"
				+promo.nouveauxInscritsNonFrancophones().size());
				
	//— Le nom et les informations concernant l’inscription de ces étudiants (utilisation de la
	//méthode toString de Inscription)
				System.out.println("\n liste des étudiant non francophone inscris pour la première fois:\n");
				for (int i = 0; i <promo.nouveauxInscritsNonFrancophones().size() ; i++) {
					 System.out.println(promo.nouveauxInscritsNonFrancophones().get(i).toString()+"\n");
				}


	} // fin de oid main
} // fin de MainEtudiant

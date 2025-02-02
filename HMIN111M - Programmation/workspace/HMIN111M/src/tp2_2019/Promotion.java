package tp2_2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/******************************************TP 2.3*******************************************************/
public class Promotion {

	/*******************************2.1  Partie attributs **********************************************/

	private int annee;
	private ArrayList<Etudiant> promoEtudiants = new ArrayList<>();


	/***************************************************************************************************/

	/******************************** 2.2 Partie Constructeurs *****************************************/

	// Créer un constructeur vide qui créé une nouvelle liste vide d’étudiants et initialise l’année a = 0


	public Promotion() {
		this.annee = 0;
	}

	// — Créer un constructeur qui prend en paramètre une année permettant d’initialiser l’attribut	année de la promotion, et qui crée une nouvelle liste vide d’étudiants

	public Promotion(int annee) {
		this.annee = annee;
	}

	/***************************************************************************************************/
	//-------------------------------------- 2.3 Les assesseurs ----------------------------------------/
	/******************************************Partie Accesseurs ***************************************/
	public int getAnnee() {
		return this.annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}




	/***************************************************************************************************/
    // -------------------2.4 Utilisation des méthodes prédéfinies dans la classe ArrayList ------------/
	/******************************************* Partie méthodes ***************************************/

	// Créer une méthode inscrire(Etudiant etud):void, qui permet d’inscrire un étudiant
	//dans la promotion, après vérification qu’il n’y soit pas déjà (utiliser la méthode add de
	//la classe ArrayList)

	public void inscrire(Etudiant etud) {
		if (this.promoEtudiants.contains(etud))
			System.out.println("Student:"+etud+" is already in the list.");
		else {
			this.promoEtudiants.add(etud);
		}

	}

	public int nbEtudiants() {

		return this.promoEtudiants.size();

	}
	
	// — Créer une méthode afficheEtudiants():String, qui après avoir vérifié que la promotion
	// n’est pas vide, retourne sous forme de chaı̂ne de caractère, la liste des étudiants de celle-ci

	public String afficheEtudiants() {

		Enumeration<Etudiant> EnumpromoEtudiants = Collections.enumeration(promoEtudiants);


		String res = "";
		while(EnumpromoEtudiants.hasMoreElements()) {

			res += EnumpromoEtudiants.nextElement();
			
		} // fin de while
		
		
		return res;
		}// fin de afficheEtudiants
	
	
	// — Créer une méthode getEtudiant(int i): Etudiant, qui retourne le ième étudiant de la liste.
	
	public Etudiant getEtudiant(int i) {
		if  (i<nbEtudiants()) {
			return promoEtudiants.get(i);
		} // fin de if
		else {
			System.out.println("The student number"+i+" is not exists.");
			return null;
		}
	} // fin de getEtudiant
	
	
	
	// — Améliorer la méthode getEtudiant afin de vérifier que le paramètre i correspond à un
	// indice existant de la liste (Utiliser la méthode nbEtudiant() définie précédemment). Re-
	// tourner null si ce n’est pas le cas, sinon retourner l’étudiant à cette indice.
	
	
	
	// Je l'ai déjà amélioré directement dans la partie précédente
	
	
	/***************************************************************************************************/
	//-----------------2.6 Lien entre les classes Etudiant, Inscription et la classe Promotion----------/
	/***************************************************************************************************/
	
	// — Écrire une méthode moyenneGénérale(): double, qui retourne la moyenne générale de
	// la promotion (vous devez utiliser la méthode moyenne de la classe Etudiant). Tester cette méthode dans MainEtudiant
	
	public double moyenneGenerale() {
		int i;
		double moyenneGenerale =0;

		for (i=0;i<nbEtudiants();i++) {
			moyenneGenerale += this.promoEtudiants.get(i).moyenne();
		}
		moyenneGenerale /= this.nbEtudiants();			
		return moyenneGenerale;
	}
	
	// — Ajouter une condition à la méthode moyenneGénérale() afin de vérifier que la promotion
	// contient des étudiants. Si la liste est vide, retourner la valeur 0 (on veut ici éviter la
	// division par 0), sinon retourner la moyenneGenerale de la promotion.
	
	public double moyenneGeneraleDeuxieme() {
		int i;
		double moyenneGenerale =0;

		for (i=0;i<nbEtudiants();i++) {
			moyenneGenerale += this.promoEtudiants.get(i).moyenne();
		}
		if (this.nbEtudiants() ==0){
			return 0;
		}else
			moyenneGenerale /= this.nbEtudiants();			
			return moyenneGenerale;
	}
	
	// — Ecrire une méthode afficheResultats(): void qui, pour chaque étudiant, affiche une
	// ligne contenant l’ensemble de ses résultats (vous devez utiliser la méthode ligneResultat
	// de la classe Etudiant) . Tester cette méthode dans MainEtudiant
	
	public void afficheResultats() {
		int i;
		for (i=0;i<nbEtudiants();i++) {
			System.out.println(this.promoEtudiants.get(i).ligneResultats());
		}//fin de for
	} //fin de afficheResultats
	
	// — En utilisant la boucle while, créer une méthode recherche(String nom): Boolean,
	// qui retourne vrai si un étudiant est inscrit dans la promotion (on suppose qu’il n’y a pas
	// d’homonymes). Tester cette méthode dans MainEtudiant.
	
	public boolean recherche(String nom) {
		int i;
		boolean res=false;
		for (i= 0; i<this.promoEtudiants.size();i++) {
			if (this.getEtudiant(i).getNom().toLowerCase().equals(nom.toLowerCase())) {
				res = true;
				break;
			}
			else
				res = false;
			
			
		}// fin de for       
		return res;
		
	}// fin de recherche(String nom)
	
	
	// — Ecrire une méthode listeAdmis():ListeEtudiants, qui stocke dans une nouvelle liste
	//les étudiants admis. Dans MainEtudiant, utiliser cette méthode pour retourner uniquement le nom et la moyenne des étudiants admis.
	public ArrayList<Etudiant> listeAdmis() {
		ArrayList<Etudiant> listeEtudiantsAdmis = new ArrayList<>();
		int i;
		for (i=0;i<this.nbEtudiants();i++) {
			if (this.getEtudiant(i).moyenne()>=10)
				listeEtudiantsAdmis.add(promoEtudiants.get(i));
		}//fin de for
		return listeEtudiantsAdmis;
	}//fin de listeAdmis
	
	//— Ecrire une méthode major(): String, qui retourne le nom du major de la promo-
	//tion (on suppose qu’il n’y a pas deux moyennes identiques. Tester cette méthode dans MainEtudiant
	public String major() {
		double max = 0;
		String name="notFind";
		for (int i= 0; i <listeAdmis().size(); i++) {
						if(listeAdmis().get(i).moyenne() > max){
			            max = listeAdmis().get(i).moyenne();
			            name=listeAdmis().get(i).getNom();
			        }//fin de if
			    }//fin de for
				return name+" have the maximum major of "+max;
			}//fin de major
	
	
	
	/*
	//— Ecrire une méthode majors(): ListeEtudiants, qui retourne la liste des étudiants
	//qui sont majors de promotion (un ou plusieurs). Tester cette méthode dans la classe
	//MainEtudiant, et afficher le ou les noms des majors et leur moyenne.
	public ArrayList<Etudiant> majors() {
		ArrayList<Etudiant> allMajors=new ArrayList<Etudiant>();
		double max = 0;
		for (int i= 0;i<listeAdmis().size();i++) {
			if (listeAdmis().get(i).moyenne() > max) {
		            max = listeAdmis().get(i).moyenne();
		            allMajors.add(listeAdmis().get(i));
		        }//fin de if
			else if (listeAdmis().get(i).moyenne() == max) {
				
				
				
				
				
			}
		    }//fin de for
			return allMajors;
		}//fin de major
			
			*/
	
	
	//— Écrire une méthode nouveauxInscritsNonFrancophones():ListeEtudiants, qui re-
	//tourne la liste des étudiants francophones dont c’est la première inscription. 
	public ArrayList<Etudiant> nouveauxInscritsNonFrancophones(){
		ArrayList<Etudiant> listeNonFrancoInscrisP=new ArrayList<Etudiant>();
		for (int i = 0; i < promoEtudiants.size(); i++) {
			if (promoEtudiants.get(i).getInscription().getCodeInscription()==1 && promoEtudiants.get(i).getInscription().getCodePays()==3) {
				listeNonFrancoInscrisP.add(promoEtudiants.get(i));
			}
		}
		return listeNonFrancoInscrisP;
		}
	
	

	/***************************************************************************************************/
	//----------------------------------- 3 Si vous êtes en avance ... ---------------------------------/
	/***************************************************************************************************/

	
	// Complétez la classe Promotion de manière à pouvoir :
		// — afficher un histogramme des moyennes de la promotion. Par exemple, si les étudiants
		// ont obtenu les moyennes suivantes Jacques 16,3, Justine 18, Germain 15,7, Hugues 12,2,
		// Sylvia 15,9, Gaston 11,4, Astrid 11, Kim 11,1, on affiche le diagramme suivant (limité
		// entre 10 et 20 ici mais vous devez le faire entre 0 et 20)
		// [10-11[
		// [11-12[ ***
		// [12-13[ *
		// [13-14[
		// [14-15[
		// [15-16[ **
		// [16-17[ *
		// [17-18[
		// [18-19[ *
		// [19-20]
		
		// — connaı̂tre les moyennes les plus fréquentes,
		// — en utilisant l’histogramme, déterminer combien de personnes ont une certaine moyenne (arrondie) donnée,
	









} // End of public class Promotion

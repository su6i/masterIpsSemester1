package tp2_2019;

import java.util.Scanner;





/*********************************TP 2.1***********************************************/

public class Etudiant {

	
	/****************** Partie attributs ****************************************/
	
	//L'attribut nom de l'étudiant
	private String nom;
	
	// Vous devez insérer ci-dessous les autres attributs (l'age et les 3 notes)
	
	private int age;
	private double noteProg,noteSyst,noteStage;
	private Inscription inscription;    // le lien entre la classe Etudiant et Inscription

	
	
	
	/***************************************************************************/
	
	
	
	/********************Partie Constructeurs ***************************/
	
	//Constructeur par défaut qui ne contient aucun attribut
	public Etudiant(){
		this.inscription = new Inscription();

	}
	
	
	//Constructeur qui contient seulement l'attribut nom 
	public Etudiant(String nom){
		this.setNom(nom);
		this.inscription = new Inscription();

	}
	
		
	//Vous devez ci-dessous définir le constructeur qui initialise tout sauf les notes de l'étudiant
	
	public Etudiant(String nom,int age){
		this.setNom(nom);
		this.setAge(age);
		this.inscription = new Inscription();

		}
	
	
	//Vous devez ci-dessous définir le constructeur qui initialise tout sauf l'age de l'étudiant
	
	public Etudiant(String nom,double noteProg,double noteSyst,double noteStage){
		this.setNom(nom);
		this.setNoteProg(noteProg);
		this.setNoteSyst(noteSyst);
		this.setNoteStage(noteStage);
		this.inscription = new Inscription();

		}
	
	
	//Vous devez ci-dessous définir le constructeur qui initialise tous les attributs
	

	public Etudiant(String nom,int age,double noteProg,double noteSyst,double noteStage){
		this.setNom(nom);
		this.setAge(age);
		this.setNoteProg(noteProg);
		this.setNoteSyst(noteSyst);
		this.setNoteStage(noteStage);
		this.inscription = new Inscription();

		}
	
	
	// le constructeur qui ajouter et/ou modifier les constructeurs
	
	public Etudiant(String nom, int age, int codeInsc, int codePays) {
		this.setNom(nom);
		this.setAge(age);
		this.inscription = new Inscription(codeInsc, codePays);
		}
	
	// le constructeur de la classe Inscription permettant de saisir les attributs codeInsc et codePays.

	public Etudiant(String nom, int age, double noteProg, double noteSyst, double noteStage, int codeInsc, int codePays) {
		
		this.setNom(nom);
		this.setAge(age);
		this.setNoteProg(noteProg);
		this.setNoteSyst(noteSyst);
		this.setNoteStage(noteStage);
		this.inscription = new Inscription(codeInsc, codePays);


		}
	

	// le constructeur de la classe Inscription permettant de saisir inscription et pas les attributs codeInsc et codePays.

	public Etudiant(String nom, int age, double noteProg, double noteSyst, double noteStage, Inscription inscription) {
		
		this.setNom(nom);
		this.setAge(age);
		this.setNoteProg(noteProg);
		this.setNoteSyst(noteSyst);
		this.setNoteStage(noteStage);
		this.setInscription(inscription);
		
		
		}
	
	/***********************************************************************/
	
	
	/*************************************Partie Accesseurs ***********************/
	
	//Scanner sc = new Scanner(System.in);

	
	/* Accesseurs de l'attribut nom : 
		getNom qui retourne la valeur du nom 
		setNom qui initialise la valeur du nom
	 */
	
	public String getNom() {
		return nom;
	}
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/* Vous devez ci-dessous créer les accesseurs pour les autres attributs : */
	
	//Accesseurs de l'age

	public int getAge() {
		return age;
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}
	
	//Accesseurs des notes
	
	public double getNoteProg() {
		return noteProg;
	}
	
	
	public void setNoteProg(double noteProg) {
		
		if (noteProg>0 && noteProg < 20) 
			this.noteProg = noteProg;
		else 
			System.out.println("You're entered " +this.noteProg+ " Please enter a valid number between 0 and 20");
	}

	//--
	
	public double getNoteSyst() {
		return noteSyst;
		
	}
	
	
	public void setNoteSyst(double noteSyst) {
		
		if (noteSyst>0 && noteSyst < 20) 
			this.noteSyst = noteSyst;
		else 
			System.out.println("You're entered " +this.noteSyst+ " Please enter a valid number between 0 and 20");

	}
	
	
	//--
	
	public double getNoteStage() {
		return noteStage;
	}
	
	
	public void setNoteStage(double noteStage) {
		
		if (noteStage>0 && noteStage < 20) 
			this.noteStage = noteStage;
		else 
			System.out.println("You're entered " +this.noteStage+ " Please enter a valid number between 0 and 20");

	}
	
	
	

	public Inscription getInscription() {

		return inscription;
		
	}


	public void setInscription(Inscription inscription) {
		
		this.inscription = inscription;  		
	}

	
	

	public void setEtudiant(Etudiant etudiant) {
		etudiant.setEtudiant(this);
	}


	
	
/***********************************************************************************/
	
	
	
	
	
/****************************** Partie méthodes ***************************************/	
	
	
	/* Méthode toString() qui permet d'afficher des informations concernant un étudiant. 
	Méthode à décommenter et à modifier ci-dessous */
		
	 // J'ai modifié la méthode toString afin de pouvoir afficher les informations concernant l’attribut inscription.

	
		 public String toString() {
			return ("Le nom de l'étudiant est " +this.getNom()+ 
				   " et son age est: " +this.getAge()+ " ans" + 
				   " les notes sont les suivantes: Programmation = " +this.getNoteProg()+ 
				   " System = " +this.getNoteSyst()+ 
				   " et Stage = " +this.getNoteStage()+
				   " type d'inscription = " + this.getInscription()
				   );
		 }
	
	
		
		 

	
	
	/* Méthode saisie qui permet à l'utilisateur de saisir les informations des étudiants et de les initialiser. 
	 Méthode à écrire intégralement en vous inspirant du TP1  */
		
		 public void saisie(Scanner sc) { //throws java.io.IOException{
			 
			 System.out.println("SVP entrez un nom pour un nouveau étudiant: ");
			 this.nom = sc.next();

			 System.out.println("Entrez l'age d'étudiant: "+this.nom);
			 this.age = sc.nextInt();

			 System.out.println("Please enter a valid number between 0 and 20 for the note de Programmation: "+this.nom);
			 
			 this.noteProg = sc.nextDouble();
			 while (this.noteProg<0 || this.noteProg>20){
				 
				 System.out.println("You're entered " +this.noteProg+ " Please enter a valid number between 0 and 20 for the note de Programmation: ");
				 this.noteProg = sc.nextDouble();

			 }

			 System.out.println("Please enter a valid number between 0 and 20 for the note de Système: "+this.nom);
			 
			 this.noteSyst = sc.nextDouble();
			 while (this.noteSyst<0 || this.noteSyst>20){
				 
				 System.out.println("You're entered " +this.noteSyst+ " Please enter a valid number between 0 and 20 for the note de Système: ");
				 this.noteSyst = sc.nextDouble();

			 }


			 System.out.println("Please enter a valid number between 0 and 20 for the note de Stage: "+this.nom);
			 
			 this.noteStage = sc.nextDouble();
			 while (this.noteStage<0 || this.noteStage>20){
				 
				 System.out.println("You're entered " +this.noteStage+ " Please enter a valid number between 0 and 20 for the note de Stage: ");
				 this.noteStage = sc.nextDouble();

			 }

			 
			 
			//    Créé l'objet inscription en utilisant le constructeur de Inscription avec les paramètres codeInsc et codePays saisis par l’utilisateur.
			 

			this.inscription.saisie(sc);


			 
			 
			 
			 
			 

			 
		}
	
	
	/* Méthode moyenne à décommenter et à remplir */
	
		
		 public double moyenne(){
		 	return (this.noteProg+this.noteStage+this.noteSyst)/3;
		 }
		 
	
	
	/* Méthode mention à écrire ci-dessous. 
	 Cette méthode utilise la méthode moyenne définie précédemment 
	 et retourne une chaine de caractère qui correspond à la mention de l'étudiant dont les valeurs possibles sont :
	 Ajourné, passable, AB, Bien, TB */
		 
		 public String mention(){
			 
			 
			 
			 if (moyenne()< 10){
				 return "Ajourné";
			 } else if (moyenne()< 12){
				 return "passable";
			 } else if (moyenne()< 14){
				 return "AB";
			 } else if (moyenne()< 16){
				 return "Bien";
			 } else {
				 return "TB";
			 } 
			 
			 
			 }

	
	
	
	
	/* Methode ligneResultat à écrire ci-dessous 
	 * Cette méthode utilise le résultat de moyenne et de mention
	 * et retourne une chaine de caractère précisant :
	 * le nom, la moyenne, la mention, et si l'étudiant est ajourné, la liste des modules obtenus
	 */
		 public String ligneResultats(){
			 String p ="", sy="", st="";
			 if (this.moyenne()>=10){
				 return ("Etudiant: " + this.getNom() + " Moyenne: " + this.moyenne() + " Mention: " + this.mention());
			 } else {
				 if (getNoteProg()>=10){
					 p="Programmation";
				 }
				 if (getNoteStage()>=10){
					 st="Stage";
				 }
				 if (getNoteSyst()>=10){
					 sy="Systeme";
				 }
				 return ("Etudiant: " + this.getNom() + " a echoué mais il a réussi dans les modules suivants: " +p+" "+sy+" "+st);

			 }
		 }

}



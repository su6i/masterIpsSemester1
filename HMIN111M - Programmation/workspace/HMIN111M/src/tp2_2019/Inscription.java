package tp2_2019;

import java.util.Scanner;

public class Inscription {
	
	
	/****************** Partie attributs ****************************************/

	private int codeInscription;
	private int codePays;
	
	private Etudiant etudiant;
//	
	
	/***************************************************************************/

	/********************Partie Constructeurs ***************************/

	//Constructeur par défaut qui ne contient aucun attribut
	public Inscription() {
		
				
	}
	
	//Constructeur qui contient seulement l'attribut codeInscription 
/*	public Inscription(int codeInscription){
		
	this.codeInscription = codeInscription;
	
	}

*/
	//Constructeur qui contient l'ensemble des attributs codePays et codeInscription
	public Inscription(int codeInscription, int codePays){
		
		this.setCodeInscription(codeInscription);
		this.setCodePays(codePays);

		}
	
	public Inscription(Etudiant etudiant,int codeInscription, int codePays){
		
		this.etudiant = etudiant;
		
		this.setCodeInscription(codeInscription);
		this.setCodePays(codePays);

		}

	
	/***********************************************************************/
	
	
	/*************************************Partie Accesseurs ***********************/
	
	/* Accesseurs de l'attribut codeInscription : 
	getCodeInscription qui retourne la valeur du codeInscription 
	setCodeInscription qui initialise la valeur du codeInscription
	 */

	public int getCodeInscription() {
		return codeInscription;
	}


	public void setCodeInscription(int codeInscription) {
		if (codeInscription == 1 || codeInscription == 2)
			this.codeInscription = codeInscription;
		else
			System.out.println("Error. Please enter 1 (first inscription) or 2 (reinscription) as codeInscription: ");
	}

	//Accesseurs du codePays

	public int getCodePays() {
		return codePays;
	}


	public void setCodePays(int codePays) {
		if (codePays ==1 || codePays == 2 || codePays == 3)
			this.codePays = codePays;
		else 
			System.out.println("Error. Please enter 1 (French student) or 2 (Foreign Francophone) or 3 (Foreign non-Francophone)");
	}

	//////  les accesseurs get et set pour l'attribut inscription de la classe Etudiant
	
	
	public Etudiant getEtudiant() {
		return this.etudiant;
	}


	public void setCodePays(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	
	
	
	
	
	
	
	public void setInscription(Inscription inscription) {
		etudiant = new Etudiant();
		etudiant.setInscription(this);
	}

	


	/***********************************************************************************/
	
	/****************************** Partie méthodes ***************************************/	


	public String nationalite() {
		
		if (this.getCodePays() == 1) return " French student";
		else if (this.getCodePays() == 2) return "Francophone foreign student";
		else if (this.getCodePays() == 3) return "non-Francophone foreign student";
		else return "not defined."; 
		
	}
	
	public String typeInscription() {
		
		if (this.getCodeInscription() == 1) return "first inscription";
		else if (this.getCodeInscription() == 2) return "reinscription";
		else return " not defined."; 

		
	}
	
	
	public String toString() {
		
		return ("("+this.typeInscription()+ " : " +this.nationalite()+")");
		
	}

	//----------------------------------------- You have to change it
	
	public void saisie(Scanner sc) { //throws java.io.IOException{

		System.out.println("Please enter 1 (first inscription) or 2 (reinscription) as codeInscription: ");
		do {
			int numberEntered = sc.nextInt();
			setCodeInscription(numberEntered);
			System.out.println("You're entered " +numberEntered);

		}
		while  (getCodeInscription() <1 || getCodeInscription()>2);


		System.out.println("Please enter 1 (French student) or 2 (Foreign Francophone) or 3 (Foreign non-Francophone)");
		do {
			int numberEntered = sc.nextInt();
			setCodePays(numberEntered);
			System.out.println("You're entered " +numberEntered);
			
		}
		while (getCodePays() <1 || getCodePays()>2);

//		 this.setInscription(new Inscription());

	 		 
	
	
	
	
	 }
	

	
	

}

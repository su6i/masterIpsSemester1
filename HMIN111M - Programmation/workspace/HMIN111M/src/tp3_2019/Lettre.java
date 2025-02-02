package tp3_2019;

public class Lettre extends ObjetPostal{
	
/*******************************************************************************************************************/
/*******************************************2-Eléments de base de la classe Lettre**********************************/

//Question 4 Créez une sous-classe Lettre de la classe ObjetPostal.
//	—  Introduisez dans la classe Lettre un attribut pour représenter le fait qu’une lettre peutˆetre urgente ou ordinaire.

	private boolean urgente;

/*******************************************************************************************************************/
/**************************************************Partie Constructeurs*********************************************/

//	—  Munissez la classe Lettre de tous les accesseurs et constructeurs qui vous semblent pertinents.

	public Lettre() {

	}
	
	
	public Lettre(String origine, String destination, int codePostal, double poids, 
			double volume, TauxRec tauxRecommandation, boolean urgente) {
		super(origine, destination, codePostal, poids, volume, tauxRecommandation);
		this.setUrgente(urgente);

	}

/*******************************************************************************************************************/
/**************************************************Partie Accesseurs************************************************/

	public boolean getUrgente() {
		return this.urgente;
	}
	
	public void setUrgente(boolean urgente) {
		this.urgente = urgente;		
	}

//	Question 4 —  Ecrivez une méthode String toString() qui retourne une chaîne comprenant tous lesattributs de manière `a connaître l’état d’un objet.

	@Override
	public String toString() {
		if (this.urgente)
			return super.toString()+" type: urgente";
		else
			return super.toString()+" type: ordinaire";
	}

//	4 - Tarif d’affranchissement
// I just redefined my addRate function and I don't need to change the original tarifAffranchissement.
	
	@Override
	public double addRates() {
		double addRate = super.addRates();
		if (this.urgente) {
			addRate += 0.3;
		}
		return addRate;
	}

	@Override
	public double tarifRemboursement() {
		double tarifRemboursement = 0.0;
		if (this.getTauxRecommandation().equals(TauxRec.moyen)) tarifRemboursement = 1.5; // Two ways are equal
		else if (this.getTauxRecommandation()==TauxRec.fort) tarifRemboursement = 15;	 // Two ways are equal
		return tarifRemboursement;
	}

	@Override
	public double tarifBase() {
		return 0.5;
	}

	
}//Lettre extends ObjetPostal()


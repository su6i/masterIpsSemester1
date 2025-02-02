package tp3_2019;

public class Colis extends ObjetPostal{

/*******************************************************************************************************************/
/**************************************************Attributs********************************************************/

//	—  Les colis possèdent les caractéristiques complémentaires suivantes que 
// vous représenterez par des attributs : une déclaration de contenu (texte), 
// une valeur déclarée (en euros).
	private String contenu;
	private double valeur;

/*******************************************************************************************************************/
/**************************************************constructeurs****************************************************/

//	—  Munissez la classe Colis de tous les accesseurs et constructeurs qui vous 
// semblent pertinents en les générant automatiquement avec Eclipse.

	public Colis() {

	}
	
	public Colis(String origine, String destination, int codePostal, double poids, 
			double volume, TauxRec tauxRecommandation, boolean urgente, String contenu, double valeur) {
		super(origine, destination, codePostal, poids, volume,  tauxRecommandation);
		this.contenu = contenu;
		this.valeur = valeur;

	}

/*******************************************************************************************************************/
/**************************************************accesseurs*******************************************************/



	public String getContenu() {
		return this.contenu;
	}
	
	public void setContenu(String contenu) {
		this.contenu = contenu;		
	}

	//----------------------------------------------------------------------------------
	public double getValeur() {
		return this.valeur;
	}
	
	public void setValeur(double valeur) {
		this.valeur = valeur;		
	}

/*******************************************************************************************************************/
/**************************************************méthodes*********************************************************/

//	—  Ecrivez une méthode String toString() qui retourne une chaîne comprenant 
	
	public String toString() {
		return super.toString()+" contenu: "+this.contenu+" "+this.valeur+"€";
	}
	
// 4 - Tarif d’affranchissement

	@Override
	public double addRates() {
		double surTax = 3;
		double addRate = super.addRates();
		if (super.getVolume()>1.8)
			addRate += surTax;
		return addRate;
	}

	@Override
	public double tarifRemboursement() {
		double tarifRemboursement = 0.0;
		if (this.getTauxRecommandation().equals(TauxRec.moyen)) tarifRemboursement = this.getValeur()/10; // Two ways are equal
		else if (this.getTauxRecommandation()==TauxRec.fort) tarifRemboursement = this.getValeur()/2;	 // Two ways are equal
		return tarifRemboursement;
	}

	@Override
	public double tarifBase() {
		// TODO Auto-generated method stub
		return 2;
	}

}// class Colis extends ObjetPostal

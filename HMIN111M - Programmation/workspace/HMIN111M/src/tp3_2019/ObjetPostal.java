package tp3_2019;

	
/********************************************************TP 3*******************************************************/
public abstract class ObjetPostal {

/************************************ 1. Elements de base de la classeObjetPostal **********************************/
/**************************************************  Partie attributs **********************************************/
// Nous commen ̧cons par les attributs, qui sont les suivants :
	// -  une origine,-  une destination,-  un code postal,
	private String origine;
	private String destination;
	private int codePostal;

	// -  un poids (en grammes),
	private double poids;

	
	// -  un volume (en m3),
	private double volume;

	// -  un taux de recommandation ( ́egal `a 0, 1 ou 2).
	private TauxRec tauxRecommandation;

	
//	Question 1. Créez une classeObjetPostalet munissez-la de tous les accesseurs 
//	et constructeurs qui vous semblent pertinents.

/*******************************************************************************************************************/
/************************************************ 2.2 Partie Constructeurs *****************************************/
	public ObjetPostal (){
				
	}
	
	public ObjetPostal (String origine, String destination, int codePostal, double poids, 
			double volume, TauxRec tauxRecommandation){
		
		this.origine = origine;
		this.destination = destination;
		this.codePostal = codePostal;
		this.poids = poids;
		this.volume = volume;
		this.tauxRecommandation = tauxRecommandation;
	}

/**************************************************  Partie Accesseurs **********************************************/

	public String getOrigine() {
		return this.origine;
	}
	
	public void setOrigine(String origine) {
		this.origine = origine;
	}
	//--------------------------------------------------------------
	
	public String getDestination() {
		return this.destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	//--------------------------------------------------------------
	public int getCodePostal() {
		return this.codePostal;
	}
	
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	//--------------------------------------------------------------
	public double getPoids() {
		return this.poids;
	}
	
	public void setPoids(double poids) {
		this.poids = poids;
	}
	//--------------------------------------------------------------
	public double getVolume() {
		return this.volume;
	}
	
	public void setVolume(double volume) {
		this.volume = volume;
	}
	//--------------------------------------------------------------
	public TauxRec getTauxRecommandation() {
		return this.tauxRecommandation;
	}
	
	public void setTauxRecommandation(TauxRec tauxRecommandation) {
		this.tauxRecommandation = tauxRecommandation;
	}
	//--------------------------------------------------------------

/*******************************************************************************************************************/
	//	Question 3. Ecrivez une méthode String toString() qui retourne une chaîne 
	//	comprenant tousles attributs de manière `a connaître l’etat d’un objet. 
	//	Puis testez-la sur les objets postaux quevous avez cr ́e ́es.
/*******************************************************************************************************************/
/**************************************************Partie méthodes**************************************************/

	@Override
	public String toString() {
		return ("L'origine: " 				+this.getOrigine()+ 
			   ", destination: " 			+this.getDestination()+  
			   ", Code Postal: " 			+this.getCodePostal()+ 
			   ", poids: " 					+this.getPoids()+" g"+ 
			   ",volume " 					+this.getVolume()+" m\u00B3"+
			   " et tauxRecommandation " 	+this.getTauxRecommandation()
			   );
	 }
	
//	4 - Tarif d’affranchissement
//Question 8—  Etudiez le calcul du tarif d’affranchissement des lettres et des colis pour repérer ce qui est commun `a tous les objets postaux 
	//et le placer dans la méthode tarifAffranchissement de la classe ObjetPostal.
	public double addRates() {
		double addRate = 0.0;
		if (this.getTauxRecommandation().equals(TauxRec.moyen)) addRate = 0.5; 			// Two ways are equal
		else if (this.getTauxRecommandation()==TauxRec.fort) addRate = 1.5;				// Two ways are equal
		return addRate;
	}
	
	public double tarifAffranchissement() {
		return this.tarifBase()+this.addRates();
	}// fin de tarifAffranchissement()
	 
//—  Puis redéfinissez cette méthode dans les deux sous-classes pour la spécialiser.

	abstract public double tarifRemboursement();
	abstract public double tarifBase();

/*******************************************************************************************************************/
/**************************************************3 Si vous êtes en avance*****************************************/




	} // End of public class Promotion

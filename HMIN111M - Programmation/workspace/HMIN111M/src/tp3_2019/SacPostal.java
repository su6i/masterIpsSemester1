package tp3_2019;

import java.util.ArrayList;

public class SacPostal {

/*******************************************************************************************************************/
/**************************************************Attributs********************************************************/

//—  Les colis possèdent les caractéristiques complémentaires suivantes que 
// vous représenterez par des attributs : une déclaration de contenu (texte), 
// une valeur déclarée (en euros).
	private ArrayList<ObjetPostal> listObj = new ArrayList<ObjetPostal>();
	private final double capacite;
		

/*******************************************************************************************************************/
/**************************************************constructeurs****************************************************/

	public SacPostal() {
		capacite = 0.5;
	}
	
	public SacPostal(double capacite) {
		if (capacite>0)
			this.capacite = capacite;
		else {
			System.out.println("Default capacity: 0.5m\u33A5");
			this.capacite=0.5;
		}
	}
	
		
		
/*******************************************************************************************************************/
/**************************************************accesseurs*******************************************************/

		
		
/*******************************************************************************************************************/
/**************************************************méthodes*********************************************************/

	public double volume() {
		double vol = 0;
		for (ObjetPostal o: listObj) {
			vol += o.getVolume();
		}
		return vol;
	}
	
} // fin de class SacPostal 

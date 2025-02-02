package tp3_2019;

public class MainObjetPostal {

	public static void main(String[] args) {


//	Question 2. Cr ́eez plusieurs objets postaux dans la fonction main d’une 
//	classe MainObjetPostal que vous devez créer.
/*
	ObjetPostal objPost1 = new ObjetPostal("Montpellier","Grenoble",38000,1.2,6,1);
	ObjetPostal objPost2 = new ObjetPostal("Montpellier","Nice",06000,1.3,8,2);		
	ObjetPostal objPost3 = new ObjetPostal("Montpellier","Paris",75000,3.2,6.8,0);		
	ObjetPostal objPost4 = new ObjetPostal("Montpellier","Annecy",74000,4.2,9.0,1);		
	ObjetPostal objPost5 = new ObjetPostal("Montpellier","Rennes",35000,4.5,6.9,2);		
	ObjetPostal objPost6 = new ObjetPostal("Montpellier","Marseille",13000,5.2,4.0,0);		
	ObjetPostal objPost7 = new ObjetPostal("Montpellier","Valence",26000,7.2,7.4,2);		
	ObjetPostal objPost8 = new ObjetPostal("Montpellier","Geneve",1200,9.7,8.7,1);		
	ObjetPostal objPost9 = new ObjetPostal("Montpellier","Milan",20000,1.8,3.0,0);	
	
	
		
	ArrayList<ObjetPostal> listMontpellier = new ArrayList<ObjetPostal>();
	listMontpellier.add(objPost1);
	listMontpellier.add(objPost2);
	listMontpellier.add(objPost3);
	listMontpellier.add(objPost4);
	listMontpellier.add(objPost5);
	listMontpellier.add(objPost6);
	listMontpellier.add(objPost7);
	listMontpellier.add(objPost8);
	listMontpellier.add(objPost9);
	 
*/
	
//	Question 3. Ecrivez une méthode String toString() 
/*
	for (int i = 1; i<listMontpellier.size(); i++){
		 System.out.println(listMontpellier.get(i).toString());
	}//fin de for

*/
		
// Question 5 - Créez et affichez dans votre main:
// —  une lettre ordinaire `a destination de la famille Kouk, igloo 2, 
// banquise nord (inventez lesvaleurs des autres attributs).
	ObjetPostal lettre1 = new Lettre("Montpellier","famille Kouk, igloo 2, banquise nord",20,1.8,5,TauxRec.faible,false);
	System.out.println("lettre1: "+lettre1.toString());
	
// —  une lettre urgente `a destination du chaman Sbouk, igloo 8, 
// banquise nord (inventez lesvaleurs des autres attributs).
	ObjetPostal lettre2 = new Lettre("Montpellier","chaman Sbouk, igloo 8, banquise nord",25,7.2,6,TauxRec.fort,true);	
	System.out.println("lettre2: "+lettre2.toString());

	
// Question 7 - Créez et affichez dans votre main:
	//—  un colis `a destination de la famille Miko, igloo 2, banquise ouest (inventez les valeurs desautres attributs).
	Colis colis1 = new Colis("Grenoble", "la famille Miko, igloo 2, banquise ouest", 10, 58.4, 65.2, TauxRec.fort, true, "du pain", 250);
	System.out.println("Colis1: "+colis1.toString());

//—  un colis `a destination du sculpteur Frodok, hangar 200, terres ouest (inventez les valeursdes autres attributs).
	Colis colis2 = new Colis("Annecy", "sculpteur Frodok, hangar 200, terres ouest", 15, 74.5, 54.0, TauxRec.moyen, false, "Livre", 52);
	System.out.println("Colis2: "+colis2.toString());
	
	
// Question 9 - Testez la m ́ethode sur tous les objets cr ́e ́es dans lemain.
	
	 System.out.println("Tarif affranchissement de lettre 1: "+lettre1.tarifAffranchissement()+"€");
	 System.out.println("Tarif affranchissement de lettre 2: "+lettre2.tarifAffranchissement()+"€");
	 System.out.println("Tarif affranchissement de colis 1: "+colis1.tarifAffranchissement()+"€");
	 System.out.println("Tarif affranchissement de colis 2: "+colis2.tarifAffranchissement()+"€");

// Question 2 - Testez la m ́ethode sur tous les objets cr ́e ́es dans lemain.	
	 
	 System.out.println("Lettre1:Taux: "+lettre1.getTauxRecommandation()+ " tarifRemboursement: "+lettre1.tarifRemboursement()+"€");
	 System.out.println("Lettre2:Taux: "+lettre2.getTauxRecommandation()+ " tarifRemboursement: "+lettre2.tarifRemboursement()+"€");
	 System.out.println( "Colis1:Taux: "+colis1.getTauxRecommandation()+ ", Valeur: "+colis1.getValeur() +", tarifRemboursement: "+colis1.tarifRemboursement()+"€");
	 System.out.println( "Colis2:Taux: "+colis2.getTauxRecommandation()+ ", Valeur: "+colis2.getValeur() +", tarifRemboursement: "+colis2.tarifRemboursement()+"€");

	}// fin de void main()

}//fin de MainObjetPostal

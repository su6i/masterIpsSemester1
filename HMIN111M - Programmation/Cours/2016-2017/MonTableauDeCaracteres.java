import java.util.Scanner;


public class MonTableauDeCaracteres{
	
	private char[] contenu;

	public MonTableauDeCaracteres() {
	}

	public MonTableauDeCaracteres(char[] contenu) {
		this.contenu = contenu;
	}

	public char[] getContenu() {
		return contenu;
	}

	public void setContenu(char[] contenu) {
		this.contenu = contenu;
	}

	public  void afficher()
	{
		if (contenu==null) 
			System.out.print("()"); 
		else
		{		System.out.print('[');
				for (int i=0; i<contenu.length; i=i+1)
					System.out.print(contenu[i]);	
				System.out.print(']');
		}
	}
	
	public  void saisirEtCreer(Scanner c)
	{
		System.out.print("taille dŽsirŽe ?");
		int taille = c.nextInt();
		contenu = new char[taille];
		for (int i=0; i<taille; i=i+1)
			{
				System.out.print("contenu["+i+"]");	
				contenu[i]=c.next().charAt(0);
			}
	}
	
	public int nbOccurrences(char c)
	{
		int nbOcc = 0;
		for (int i=0; i<contenu.length; i=i+1)
		{
			if (contenu[i] == c)
				nbOcc = nbOcc + 1;
		}
		return nbOcc;
	}	
	
	public  void inverser()
	{
		for (int i=0; i<contenu.length/2; i=i+1)
		{
			char temp = contenu[i];
			contenu[i] = contenu[contenu.length-1-i];
			contenu[contenu.length-1-i] = temp;
		}
	}
	
	public MonTableauDeCaracteres inverse()
	{
		char[] inverse = new char[contenu.length];
		for (int i=0; i<contenu.length; i=i+1)
		{
			inverse[i] = contenu[contenu.length-1-i];
		}
		return new MonTableauDeCaracteres(inverse);
	}
	
	public  boolean equals(MonTableauDeCaracteres autre)
	{
		if (contenu.length != autre.contenu.length)
			return false;
		for (int i=0; i< contenu.length; i=i+1)
			if (contenu[i] != autre.contenu[i])
				{
					return false;
				}
		return true;
	}

	public boolean palindrome()
	{
		for (int i=0; i<contenu.length/2; i=i+1)
		{
			if (contenu[i] != contenu[contenu.length-1-i])
				return false;
		}
		return true;
	}
	
	public boolean palindrome2()
	{		
		MonTableauDeCaracteres inverse = this.inverse();
		return this.equals(inverse);
	}

	public static void main(String[] args) {
		
		Scanner clavier = new Scanner(System.in);
		MonTableauDeCaracteres mt = new MonTableauDeCaracteres();
		mt.afficher();
		mt.saisirEtCreer(clavier);
		mt.afficher();	
		mt.inverser();
		mt.afficher();	
		MonTableauDeCaracteres mt2 = mt.inverse();
		mt2.afficher();
		//System.out.println(mt.equals(mt2));
		//System.out.println(mt.equals(mt));
		System.out.println(mt.palindrome());
		System.out.println(mt.palindrome());
		System.out.println(mt.nbOccurrences('a'));
	}
}

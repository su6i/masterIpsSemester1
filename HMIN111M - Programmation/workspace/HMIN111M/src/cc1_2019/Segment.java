package cc1_2019;


public class Segment {
	
	
	//attributs
	
	private double longueur = -1;
	
	private Point point1;
	private Point point2;

	
	
	//constructeurs
	
	public Segment(){

	}

	
	public Segment(Point point1, Point point2){
		
		this.point1 = new Point();
		this.point2 = new Point();
				

	}

	public Segment(double x1, double y1, double x2,double y2){
		
		this.point1.x = x1;
		this.point1.y = y1;
		
		this.point2.x = x2;
		this.point2.y = y2;
		
		

	}

	
	
	//accesseur
	
	
	
	//methods
	
	//toString
	//calculLongueur
	//milieuSegment():Point
	//longueurEgales(seg: Segment) : String
	//saisie (sc: Scanner)
	
	
	

} // end of class

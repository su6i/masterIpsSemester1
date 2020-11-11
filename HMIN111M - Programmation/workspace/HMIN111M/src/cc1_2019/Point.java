package cc1_2019;

import java.util.Scanner;

public class Point {

	//attributs

	private double x,y;


	//constructeurs

	public Point() {


	}

	public Point(double x, double y) {

		this.x = x;
		this.y = y;


	}


	// La partie accesseur 
	//accesseur X

	public double getX() {
		return x;
	}


	public void setX(double x) {

		this.x = x;

	}

	
	
	//accesseur Y
	public double getY() {
		return y;
	}


	public void setY(double y) {

		this.y = y;

	}



	//methods

	// toString
	
	 public String toString() {
		return ("Point (" +this.getX() + " , " +this.getY()+ " )");
	 }

	
	
	//distance (pt:Point) : double // distance(pt : Point) : double
	
	 public double distance(Point p1, Point p2){
		 
		 double p2p1x = p2.getX() - p1.getX();
		 double p2p1y = p2.getY() - p1.getY();
	 
		 
		 double distance = Math.sqrt(p2p1x*p2p1x + p2p1y*p2p1y);
		 return distance;
	 }

	 	
	// saisie (sc:Scanner)

	 
	 public void saisie(Scanner sc) { 

		 System.out.println("Entrez x : ");
		 this.setX(sc.nextDouble());

		 System.out.println("Entrez y : ");
		 this.setY(sc.nextDouble());
		 
		 

		 }

	 


} // end of class

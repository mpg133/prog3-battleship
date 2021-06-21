package model.ship;

import java.util.HashSet;
import java.util.Set;

import model.Coordinate;
import model.CoordinateFactory;


/**
 * The Class Coordinate2D.
 */
public class Coordinate2D extends Coordinate {

	/**
	 * Instantiates a new coordinate 2 D.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Coordinate2D(int x,int y) {
		super(2);
	}
	
	/**
	 * Instantiates a new coordinate 2 D.
	 *
	 * @param c the c
	 */
	public Coordinate2D(Coordinate2D c) {
		super(c);
		
	}
	
	/**
	 * Adjacent coordinates.
	 *
	 * @return the sets the
	 */
	public Set<Coordinate> adjacentCoordinates() {
		
	//8 coordenadas adjacentes
	Set<Coordinate> coordenadas = new HashSet<Coordinate>();
		
	int x=this.get(0);
	int y=this.get(1);

		
	for(int y1= y-1;y1<y+2;y1++) {//altura
			
		for(int x1= x-1;x1<x+2;x1++) {//este/oeste	
				
			if(x1==x && y1==y ) {
					
			}else {
				Coordinate aux= CoordinateFactory.createCoordinate(x,y);
				//CoordinateFactory.createCoordinate...
				coordenadas.add(aux);
			}
				
		}
			
	}
		return coordenadas;		

    }
	
	
	/**
	 * Copy.
	 *
	 * @return the coordinate 2 D
	 */
	public Coordinate2D copy() {
		
		Coordinate2D aux= new Coordinate2D(this);
		return aux;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String cad="";
		try {
			cad+=super.get(0)+", ";
			cad+=super.get(1);
		} catch (Exception e) {
				
		e.getMessage();
		
		}
		return "("+cad+")";
	}
	
}

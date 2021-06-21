package model.aircraft;

import java.util.HashSet;
import java.util.Set;

import model.Coordinate;
import model.CoordinateFactory;



/**
 * The Class Coordinate3D.
 */
public class Coordinate3D extends Coordinate {
	
	/**
	 * Instantiates a new coordinate 3 D.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public Coordinate3D(int x,int y, int z) {
		super(3);
		components[0]=x;
		components[1]=y;
		components[2]=z;
		
	}
	
	/**
	 * Instantiates a new coordinate 3 D.
	 *
	 * @param c the c
	 */
	public Coordinate3D(Coordinate3D c) {
		super(c);
	}
	

	
	/**
	 * Adjacent coordinates.
	 *
	 * @return the sets the
	 */
	public Set<Coordinate> adjacentCoordinates() {
		
		//26 coordenadas adjacentes
		Set<Coordinate> coordenadas = new HashSet<Coordinate>();
			
		int x=get(0);
		int y=get(1);
		int Z=get(2);
			
		for(int y1= y-1;y1<y+2;y1++) {//altura
				
			for(int x1= x-1;x1<x+2;x1++) {//este/oeste	
					for(int z=Z-1;z<Z+2;Z++) {
						if(x1==x && y1==y ) {
							
						}else {
							
							Coordinate aux=CoordinateFactory.createCoordinate(x,y,z);
							coordenadas.add(aux);
						}
					}
				
					
			}
				
		}
			return coordenadas;		

	}

	/**
	 * Copy.
	 *
	 * @return the coordinate
	 */
	public Coordinate copy() {
	
		Coordinate3D aux= new Coordinate3D(this);
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
			cad+=super.get(1)+", ";
			cad+=super.get(2);
		} catch (Exception e) {
				
		e.getMessage();
		
		}
		return "("+cad+")";
	}
		
	}


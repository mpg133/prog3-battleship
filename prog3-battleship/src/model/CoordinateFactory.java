package model;

import model.aircraft.Coordinate3D;
import model.ship.Coordinate2D;

public class CoordinateFactory {
	
	public static Coordinate createCoordinate(int... coords)throws Exception {
		Coordinate aux;
		if(coords.length==2) {
			aux= new Coordinate2D(coords[0],coords[1]);
			
		}else if(coords.length==3) {
			aux= new Coordinate3D(coords[0],coords[1],coords[2]);
		}else {
			throw new IllegalArgumentException();
			
		}
		return aux;
		
	}
}

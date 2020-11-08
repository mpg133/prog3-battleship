package model.ship;

import java.util.HashSet;
import java.util.Set;

import model.Coordinate;
import model.CoordinateFactory;

public class Coordinate2D extends Coordinate {

	public Coordinate2D(int x,int y) {
		super(2);
	}
	public Coordinate2D(Coordinate2D c) {
		super(c);
		
	}
	
	public Set<Coordinate> adjacentCoordinates() throws Exception {
		
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
	
	
	public Coordinate2D copy() {
		
		Coordinate2D aux= new Coordinate2D(this);
		return aux;
	}
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

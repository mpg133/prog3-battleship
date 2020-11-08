package model.aircraft;

import java.util.HashSet;
import java.util.Set;

import model.Coordinate;
import model.CoordinateFactory;
import model.ship.Coordinate2D;

public class Coordinate3D extends Coordinate {
	public Coordinate3D(int x,int y, int z) {
		super(3);
		
	}
	public Coordinate3D(Coordinate3D c) {
		super(c);
	}
	

	
	public Set<Coordinate> adjacentCoordinates() throws Exception {
		
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

	public Coordinate copy() {
	
		Coordinate3D aux= new Coordinate3D(this);
		return aux;
	}
	public String toString() {
		String cad="";
		try {
			cad+=super.get(0)+",";
			cad+=super.get(1)+", ";
			cad+=super.get(2);
		} catch (Exception e) {
				
		e.getMessage();
		
		}
		return "("+cad+")";
	}
		
	}


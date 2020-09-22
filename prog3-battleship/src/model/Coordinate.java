package model;

import java.util.Arrays;

/**
 * 
 * @Miguel Pérez Giménez 74395666G
 *
 * 
 */
public class Coordinate {

	private int[] components;
	
	public Coordinate(int x,int y){ 
		
		components=new int [2];
		components[0]=x;
		components[1]=y;
	}
	public Coordinate(Coordinate c) {
		
		components=new int [2];
		for(int i=0;i<components.length;i++) {
			components[i]=c.components[i];
		}
	}
	protected void set(int component,int value) {
		
		if(component>=0 && component<components.length) {
			 components[component]=value;
		}else {
			System.err.println("Error in Coordinate.set, component "+ component + " is out of range" );
		} 
	} 
	public final int get(int component) {
		if(component>=0 && component<components.length) {
			return components[component];
		}else {
			System.err.println("Error in Coordinate.set, component "+ component + " is out of range" );
		}
		return -1;
	}
	public final Coordinate add(Coordinate c) {
		Coordinate aux=new Coordinate(this);
		
		for(int i=0;i<components.length;i++) {
			int suma=aux.get(i)+c.get(i);
			aux.set(i, suma);
		}
		
			
		return aux;
		
	}
	public final Coordinate substract(Coordinate c) {
		Coordinate aux=new Coordinate(this);
		int resta;
		for(int i=0;i<components.length;i++) {
			
		
			if(c.get(i)<0 && c.get(i)<0) {
				 resta=aux.get(i)+c.get(i);
			}else if(aux.get(i)<0 && c.get(i)>0){
				resta=c.get(i)+aux.get(i);
			}else {
				resta=aux.get(i)-c.get(i);
			}
			
			System.out.println(resta);
			aux.set(i, resta);
		}
		
			
		return aux;
		
	
	}
	public String toString() {
		String cad="";
		
		for(int i=0;i<components.length;i++) {	
			if(i==components.length -1 ) {
				
				cad+=components[i];
			} else {
			cad+=components[i]+", ";
			}
		}
		
		return "("+cad+")";
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(components);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (!Arrays.equals(components, other.components))
			return false;
		return true;
	}
	
}

package model;

import java.awt.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The Class Coordinate.
 *
 * @Miguel P�rez Gim�nez 74395666G
 */
public class Coordinate {

	/** The components. */
	private int[] components;
	
	
	/**
	 * Instantiates a new coordinate.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Coordinate(int x,int y){ 
		
		components=new int [2];
		components[0]=x;
		components[1]=y;
	}
	
	/**
	 * Instantiates a new coordinate.
	 *
	 * @param c the c
	 */
	public Coordinate(Coordinate c) {
		//if(dim==3) {
			components=new int [2];
			for(int i=0;i<components.length;i++) {
				components[i]=c.components[i];
			}
		/*}else {
		components=new int [2];
		for(int i=0;i<components.length;i++) {
			components[i]=c.components[i];
		}*/
		
	}
	
	
	/**
	 * Sets the.
	 *
	 * @param component the component
	 * @param value the value
	 */
	protected void set(int component,int value) {
		
		if(component>=0 && component<components.length) {
			 components[component]=value;
		}else {
			System.err.println("Error in Coordinate.set, component "+ component + " is out of range" );
		} 
	} 
	
	/**
	 * Gets the.
	 *
	 * @param component the component
	 * @return the int
	 */
	public final int get(int component) {
		if(component>=0 && component<components.length) {
			return components[component];
		}else {
			System.err.println("Error in Coordinate.set, component "+ component + " is out of range" );
		}
		return -1;
	}
	
	
	/**
	 * Adjacent coordinates.
	 *
	 * @return the sets the
	 */
	//obtener coordenadas adjacentes a una coordenada
	
	  public  Set<Coordinate> adjacentCoordinates(){
	  //8 coordenadas adjacentes
		Set<Coordinate> coordenadas = new HashSet<Coordinate>();
		
		int x=this.get(0);
		int y=this.get(1);
		System.out.println(x+"-"+y);
		
		for(int y1= y-1;y1<y+2;y1++) {//altura
			
			for(int x1= x-1;x1<x+2;x1++) {//este/oeste	
				
				if(x1==x && y1==y ) {
					
				}else {
					Coordinate aux= new Coordinate(x1,y1);
					System.out.println(aux.get(0)+"+"+aux.get(1));
					coordenadas.add(aux);
				}
				
			}
			
				
		}
		return coordenadas;		

     }
	
	/**
	 * Devuelve una copia del objeto,
	 *  invocando al constructor de copia.
	 *
	 * @return the coordinate
	 */
	//Coordinate aux= new Coordinate(this);
	//return aux;
	public Coordinate copy() {
		Coordinate aux= new Coordinate(this);
		return aux;
	}
	
	/**
	 * Adds the.
	 *
	 * @param c the c
	 * @return the coordinate
	 */
	public final Coordinate add(Coordinate c) {
		Coordinate aux=new Coordinate(this);
		
		for(int i=0;i<components.length;i++) {
			int suma=aux.get(i)+c.get(i);
			aux.set(i, suma);
		}
		
			
		return aux;
		
	}
	
	/**
	 * Substract.
	 *
	 * @param c the c
	 * @return the coordinate
	 */
	public final Coordinate subtract(Coordinate c) {
		Coordinate aux=new Coordinate(this);
		Coordinate aux2;
		
		int resta=aux.get(0)-c.get(0);
		int resta2=aux.get(1)-c.get(1);
		
			aux2= new Coordinate (resta,resta2);
		
			
		return aux2;
		
	
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 *
	 *
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
		
	}*/
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(components);
		return result;
	}
	
	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
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

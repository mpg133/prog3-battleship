package model;

import java.awt.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import model.aircraft.Coordinate3D;
import model.ship.Coordinate2D;

/**
 * The Class Coordinate.
 *
 * @Miguel P�rez Gim�nez 74395666G
 */
public abstract class Coordinate {

	/** The components. */
	private int[] components;
	
	
	/**
	 * Instantiates a new coordinate.
	 *
	 * @param x the x
	 * @param y the y
	 */
	protected Coordinate(int dim){ 
		
		components=new int [dim];
		
		
	}
	
	/**
	 * Instantiates a new coordinate.
	 *
	 * @param c the c
	 */
	protected Coordinate(Coordinate c) {
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
	protected void set(int component,int value){
		
		if(component>=0 && component<components.length) {
			 components[component]=value;
		}else {
			throw new IllegalArgumentException();
		} 
	} 
	
	/**
	 * Gets the.
	 *
	 * @param component the component
	 * @return the int
	 */
	public final int get(int component){
		int ret;
		if(component>=0 && component<components.length) {
			ret= components[component];
		}else {
			throw new IllegalArgumentException();
		}
		return ret;
	}
	
	
	/**
	 * Adjacent coordinates.
	 *
	 * @return the sets the
	 * @throws Exception 
	 */
	//obtener coordenadas adjacentes a una coordenada
	
	  public  abstract Set<Coordinate> adjacentCoordinates() throws Exception;
	 
	
	/**
	 * Devuelve una copia del objeto,
	 *  invocando al constructor de copia.
	 *
	 * @return the coordinate
	 */
	//Coordinate aux= new Coordinate(this);
	//return aux;
	public abstract Coordinate copy();
		
	
	
	/**
	 * Adds the.
	 *
	 * @param c the c
	 * @return the coordinate
	 * @throws Exception 
	 */
	public final Coordinate add(Coordinate c){
		Coordinate aux=null;
		if(c==null) {
				throw new NullPointerException();
		}else {
		for(int i=0;i<components.length;i++) {
			int suma=this.get(i)+c.get(i);
			aux.set(i, suma);
		}
		}
			
		return aux;
		
	}
	
	/**
	 * Substract.
	 *
	 * @param c the c
	 * @return the coordinate
	 * @throws Exception 
	 */
	public final Coordinate subtract(Coordinate c){
		/*Coordinate aux;
		Coordinate aux2;
		
		int resta=aux.get(0)-c.get(0);
		int resta2=aux.get(1)-c.get(1);
		
			aux2= new Coordinate (resta,resta2);
		
			
		return aux2;
	*/	
		Coordinate aux=null;
		Objects.requireNonNull(c);
		
			
		
		for(int i=0;i<components.length;i++) {
				int resta=this.get(i)-c.get(i);
				aux.set(i, resta);
		}
			
		
		
			
		return aux;
		
	}
	
	
	
	
	
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

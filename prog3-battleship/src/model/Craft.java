package model;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import model.exceptions.CoordinateAlreadyHitException;

public abstract class Craft {
	/** The Constant BOUNDING_SQUARE_SIZE. */
	private  static final int BOUNDING_SQUARE_SIZE=5;
	/** The Constant HIT_VALUE. */
	private static final int HIT_VALUE=-1;
	
	/** The Constant CRAFT_VALUE. */
	private static final  int CRAFT_VALUE=1;
	
	/** The symbol. */
	private char symbol;
	
	/** The name. */
	private String name; 
	/** The orientation. */
	private Orientation orientation;
	
	/** The position. */
	private Coordinate position=null;
	
	/** The shape. */
	protected int[][] shape;
	/*{
		{ 0, 0, 0, 0, 0,               // NORTH    ·····
          0, 0, 1, 0, 0,               //          ··#··
          0, 0, 1, 0, 0,               //          ··#··
          0, 0, 1, 0, 0,               //          ..#..
          0, 0, 0, 0, 0},              //          ·····

        { 0, 0, 0, 0, 0,               // EAST     ·····
          0, 0, 0, 0, 0,               //          ·····
          0, 1, 1, 1, 0,               //          ·###·
          0, 0, 0, 0, 0,               //          ·····
          0, 0, 0, 0, 0},              //          ·····

        { 0, 0, 0, 0, 0,               // SOUTH    ·····
          0, 0, 1, 0, 0,               //          ··#··
          0, 0, 1, 0, 0,               //          ··#··
          0, 0, 1, 0, 0,               //          ..#..
          0, 0, 0, 0, 0},              //          ·····

        { 0, 0, 0, 0, 0,               // WEST     ·····
          0, 0, 0, 0, 0,               //          ·····
          0, 1, 1, 1, 0,               //          ·###·
          0, 0, 0, 0, 0,               //          ·····
          0, 0, 0, 0, 0}               //          ····· 
	};*/
	public Craft(Orientation o,char s,String n) {
		this.orientation=o;
		this.symbol=s;
		this.name=n;
		
	}
	public Coordinate getPosition() {
		if(position==null) {
			return null;
			
		}else {
			
		return position.copy();
		}
	}
	/**
	 * Sets the poistion.
	 *
	 * @param position the new poistion
	 * @throws Exception 
	 */
	public void setPosition(Coordinate position) throws Exception {
		Coordinate aux=CoordinateFactory.createCoordinate(position.get(0),position.get(1));
		this.position=aux;
	}
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the orientation.
	 *
	 * @return the orientation
	 */
	public Orientation getOrientation() {
		return orientation;
	}
	
	/**
	 * Gets the symbol.
	 *
	 * @return the symbol
	 */
	public char getSymbol() {
		return symbol;
	}
	/**
	 * Gets the shape.
	 *
	 * @return the shape
	 */
	public int[][] getShape() {
		return shape;
		
	}
	
	/**
	 * Gets the shape index.
	 *
	 * @param c the c
	 * @return the shape index
	 */
	public int getShapeIndex(Coordinate c) {
		Objects.requireNonNull(c);
		//c es coordenada relativa
		//valores entre 0 y BOUNDING_SQUARE(5) -1
		return c.get(1)*BOUNDING_SQUARE_SIZE+c.get(0);
	}
	
	/**
	 * Gets the absolute positions.
	 *
	 * @param c the c
	 * @return the absolute positions
	 * @throws Exception 
	 */
	//devuelve un conjunto de coordenadas absolutas(tablero) ocupadas por el barco
	public Set<Coordinate> getAbsolutePositions(Coordinate c) throws Exception {
		Objects.requireNonNull(c);
		HashSet<Coordinate> coordenadas = new HashSet<Coordinate>();
		
		for(int x=c.get(0);x<c.get(0)+BOUNDING_SQUARE_SIZE;x++) {
			for(int y=c.get(1);y<c.get(1)+BOUNDING_SQUARE_SIZE;y++) {
				Coordinate absoluta=CoordinateFactory.createCoordinate(x,y);
				
				Coordinate relativa =absoluta.subtract(c);
				if(shape[orientation.ordinal()][getShapeIndex(relativa)]==HIT_VALUE 
				|| shape[orientation.ordinal()][getShapeIndex(relativa)]==CRAFT_VALUE) {
					
					coordenadas.add(absoluta);
				}
			}
		}
		return coordenadas;
	}
	
	/**
	 * Gets the absolute positions.
	 *
	 * @return the absolute positions
	 * @throws Exception 
	 */
	public Set<Coordinate> getAbsolutePositions() throws Exception{
		if(position!=null) {
			return getAbsolutePositions(position);
		}else {
			return null;
		}
	}
	/**
	 * Hit.
	 *
	 * @param c the c
	 * @return true, if successful
	 * @throws Exception 
	 */
	public boolean hit(Coordinate c) throws Exception {
		
		//si c es una coordenada que ocupa el barco 
		//y no es alcanzada previamente
	
		if(position!=null) {
			
			Coordinate aux=c.subtract(position);
			if(shape[orientation.ordinal()][getShapeIndex(aux)]==CRAFT_VALUE) {
				//actualizamos estado del barco
				//shape[i]=-1
				shape[orientation.ordinal()][getShapeIndex(aux)]=HIT_VALUE;
				return true;
			}else {
				throw new CoordinateAlreadyHitException(c);
			}
			}
		
		return false;
	}
	
	/**
	 * Checks if is shot down.
	 *
	 * @return true, if is shot down
	 */
	public boolean isShotDown() {
		for(int x=0;x<25;x++) {
			if(shape[orientation.ordinal()][x]==CRAFT_VALUE) {
			return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if is hit.
	 *
	 * @param c the c
	 * @return true, if is hit
	 * @throws Exception 
	 */
	public boolean isHit(Coordinate c) {
		
		if(position!=null) {
			Coordinate aux=c.subtract(position);
			int x=shape[orientation.ordinal()][getShapeIndex(aux)];
			if(x==HIT_VALUE) {
				return true;
			}
		}	
		return false;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	/*Kontiki (SOUTH)
	 -----
	 |     |
	 |  #  |
	 |  •  |
	 |  #  |
	 |     |
	  -----
	*/
	public String toString() {
		String cad;
		cad=getName()+ " ";
		cad+="("+orientation+")"+"\n"+" -----"+"\n";
		for(int i=0;i<25;i++) {
			if(i%5==0) {
				cad+="|";
			}
			
			if(shape[orientation.ordinal()][i]==HIT_VALUE) {
				cad+="•";
			}else if(shape[orientation.ordinal()][i]==CRAFT_VALUE) {
				cad+=symbol;
			}else{
				cad+=" ";
			}
			if(i%5==4) {
				cad+="|\n";
				
			}
		}
		cad+=" -----";
		return cad;
	}
}

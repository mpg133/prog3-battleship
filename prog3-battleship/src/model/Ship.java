package model;

import java.util.HashSet;
import java.util.Set;


/**
 * The Class Ship.
 * Clase que representa un barco
 * y tiene orientación 
 */
public class Ship {
		
		/** The orientation. */
		private Orientation orientation;
		
		/** The position. */
		private Coordinate position=null;
		
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
		
		/** The shape. */
		private static int[][] shape = new int[][] {
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
		};
		
		
		
	/**
	 * Instantiates a new ship.
	 *
	 * @param orientation the orientation
	 * @param symbol the symbol
	 * @param name the name
	 */
	public Ship (Orientation orientation, char symbol, String name){
			this.orientation=orientation;
			this.symbol=symbol;
			this.name=name;
	}	
	
	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public Coordinate getPosition() {
		if(position==null) {
			return null;
			
		}else {
			
		return position.copy();
		}
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
	 * Sets the poistion.
	 *
	 * @param position the new poistion
	 */
	public void setPosition(Coordinate position) {
		Coordinate aux= new Coordinate(position);
		this.position=aux;
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
		//c es coordenada relativa
		//valores entre 0 y BOUNDING_SQUARE(5) -1
		return c.get(1)*BOUNDING_SQUARE_SIZE+c.get(0);
	}
	
	/**
	 * Gets the absolute positions.
	 *
	 * @param c the c
	 * @return the absolute positions
	 */
	//devuelve un conjunto de coordenadas absolutas(tablero) ocupadas por el barco
	public Set<Coordinate> getAbsolutePositions(Coordinate c) {
		HashSet<Coordinate> coordenadas = new HashSet<Coordinate>();
		
		for(int x=c.get(0);x<c.get(0)+BOUNDING_SQUARE_SIZE;x++) {
			for(int y=c.get(1);y<c.get(1)+BOUNDING_SQUARE_SIZE;y++) {
				Coordinate absoluta= new Coordinate(x,y);
				
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
	 */
	public Set<Coordinate> getAbsolutePositions(){
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
	 */
	public boolean hit(Coordinate c) {
		
		//si c es una coordenada que ocupa el barco 
		//y no es alcanzada previamente
	
		if(position!=null) {
			
			Coordinate aux=c.subtract(position);
			if(shape[orientation.ordinal()][getShapeIndex(aux)]==CRAFT_VALUE) {
				//actualizamos estado del barco
				//shape[i]=-1
				shape[orientation.ordinal()][getShapeIndex(aux)]=HIT_VALUE;
				return true;
		}}
		
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



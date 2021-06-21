package model.ship;

import java.util.Objects;

import model.Board;
import model.Coordinate;
import model.CoordinateFactory;
import model.Craft;



/**
 * The Class Board2D.
 */
public class Board2D extends Board {
	
	/**
	 * Instantiates a new board 2 D.
	 *
	 * @param size the size
	 */
	public Board2D(int size) {
		super(size);
	}
	 
	/**
	 * Check coordinate.
	 *
	 * @param c the c
	 * @return true, if successful
	 */
	public boolean checkCoordinate(Coordinate c) {
		Objects.requireNonNull(c);
		if(c.getClass()==Coordinate2D.class) {
	
			if((c.get(0)>=0 && c.get(0)<getSize() )&&(c.get(1)>=0 && c.get(1)<getSize() )) {
				return true;
			}else {
				return false;
			}
		}
		throw new IllegalArgumentException();
		

	}
	
	/**
	 * Show.
	 *
	 * @param unveil the unveil
	 * @return the string
	 */
	public String show(boolean unveil) {
		Craft ship;
		Coordinate aux;
		String cad=null;
		char cad2;
		char ns=NOTSEEN_SYMBOL;
		char hs=HIT_SYMBOL;
		char w=WATER_SYMBOL;
		for(int x=0;x<this.getSize();x++) {
			for(int y=0;y<getSize();y++) {
				aux=CoordinateFactory.createCoordinate(x,y);
				ship=getCraft(aux);
				if(ship==null) {
					if(unveil){
						cad2=w;
					}else {
						cad2=ns;
					}
				}else if(ship.isHit(aux)) {
					cad2=hs;
				}else {
					if(unveil) {
						cad2=ship.getSymbol();
					}else {
						cad2=ns;
					}
				}
				cad+=cad2;
				
			}
			if(x!=getSize()-1) {
				cad+="\n";
			}
			
		
		
		}
	
	
	return cad;
}
}

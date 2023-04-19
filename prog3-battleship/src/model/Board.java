package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.exceptions.CoordinateAlreadyHitException;

/**
 * The Class Board.
 */
public abstract class Board {
	
	/** The seen. */
	private Set<Coordinate> seen;
	
	
	/** The board. */
	private Map<Coordinate,Craft> board;
	
	/** The Constant HIT_SYMBOL. */
	public static final char HIT_SYMBOL='•';
	
	/** The Constant WATER_SYMBOL. */
	public static final char WATER_SYMBOL=' ';
	
	/** The Constant BOARD_SEPARATOR. */
	public static final char BOARD_SEPARATOR='|';
	
	/** The Constant NOTSEEN_SYMBOL. */
	public static final char NOTSEEN_SYMBOL='?';
	
	/** The Constant MAX_BOARD_SIZE. */
	private static final int MAX_BOARD_SIZE=20;
	
	/** The Constant MIN_BOARD_SIZE. */
	private static final int MIN_BOARD_SIZE=5;
	
	/** The size. */
	private int size;
	
	/** The num crafts. */
	private int numCrafts;
	
	/** The destroyed crafts. */
	private int destroyedCrafts;
	
	/**
	 * Instantiates a new board.
	 *
	 * @param size the size
	 */
	public Board(int size) {
		if(MIN_BOARD_SIZE<=size && size<=MAX_BOARD_SIZE) {
			
			this.size=size;
		}else {
			System.err.println("msg error");
			this.size=MIN_BOARD_SIZE;
		}
		this.board=new HashMap<Coordinate,Craft>();
		this.seen =new HashSet<Coordinate>();
		numCrafts=0;
		destroyedCrafts=0;
	}
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Check coordinate.
	 *
	 * @param c the c
	 * @return true, if successful
	 */
	public abstract boolean checkCoordinate(Coordinate c);
	
	/**
	 * Adds the craft.
	 *
	 * @param craft the craft
	 * @param position the position
	 * @return true, if successful
	 */
	/*{	}

	/**
	 * Adds the ship.
	 *
	 * @param ship the ship
	 * @param position the position
	 * @return true, if successful
	 */
	public boolean addCraft(Craft craft,Coordinate position) {
		
		
		//mira si esta fuera o esta ocupada
		for(Coordinate coords:craft.getAbsolutePositions(position)) {
			if(!checkCoordinate(coords)) {
				System.err.println("Error in Board.addShip, position "+coords+"is out of the board");
				return false;
			}else if(board.get(coords)!=null) {
				System.err.println("Error in Board.addShip, position "+coords+"is alredy ocupied");
				return false;
			}
		}
		//recorre vecindad
		Set<Coordinate> vecindad=getNeighborhood(craft,position);
		for(Coordinate coord:vecindad) {
			if(board.get(coord)!=null) {
				System.err.println("Error in board.addShip, position "+coord+" is next to another ship ");
				return false;
			}
		}
		//añade barco
		for(Coordinate coord:craft.getAbsolutePositions(position)) {
			board.put(coord, craft);
		}
		craft.setPosition(position);
		numCrafts++;
		return true;
	}
		
		/**
		 * Gets the ship.
		 *
		 * @param c the c
		 * @return the ship
		 */
		/*RECORRER MAPA
		 * Set<Coordinate> board2=board.keySet(); Set de coordenadas
			for(Coordinate coord: board2) {
			Ship s=board.get(coord);
			return s;
		}
		 */
	public Craft getCraft(Coordinate c) {
		
		
		
			return  board.get(c);
		
	}
		
	
	/**
	 * Checks if is seen.
	 *
	 * @param c the c
	 * @return true, if is seen
	 */
	public boolean isSeen(Coordinate c) {
		for(Coordinate coord:seen) {
			if(coord.equals(c)) {
				return true;
			}
		}
		return false;
	}

/**
 * 		Hit Simula el lanzamiento de un torpedo en una coordenada c del tablero.
 *
 * @param c the c
 * @return the cell status
 * @throws CoordinateAlreadyHitException the coordinate already hit exception
 */
	public CellStatus hit(Coordinate c) throws CoordinateAlreadyHitException {
		
		if(board.get(c)!=null) {//salida fuera del tablero
			if(!(checkCoordinate(c))) {
				System.err.println("Error in Board.hit, position is  out of limits");
				return CellStatus.WATER;
			}else {
				//si no hay ningun barco
				
				if(!board.get(c).hit(c)) {
					seen.add(c);
					return CellStatus.WATER;
				}
				//si en la coordenada hay un barco 
				else{
					//si esta destruido
					if(board.get(c).isShotDown()) {
						Set<Coordinate> vecindad=getNeighborhood(board.get(c));
						for(Coordinate coord:vecindad) {
							seen.add(coord);
						}
						destroyedCrafts++;
						seen.add(c);
						return CellStatus.DESTROYED;
					//sino
					}else {
						seen.add(c);
						return CellStatus.HIT;
					}
				}
			}
			
		}
		seen.add(c);
		return CellStatus.WATER;
	}
	
	/**
	 * Are all crafts destroyed.
	 *
	 * @return true, if successful
	 */
	public boolean areAllCraftsDestroyed() {
		return numCrafts==destroyedCrafts;
	}
    
    /**
     * Gets the neighborhood.
     *
     * @param craft the craft
     * @param position the position
     * @return the neighborhood
     */
    public Set<Coordinate> getNeighborhood(Craft craft, Coordinate position){
    	Set<Coordinate> aux= new HashSet<Coordinate>();
    	if(position==null) {return aux;}
    	Set<Coordinate> absolute= getCraft(position).getAbsolutePositions(position);
    	//recorrer SET
    	for(Coordinate coords:absolute) {
    		for(Coordinate coords2:coords.adjacentCoordinates()) {
    			if(!aux.contains(coords2)&&!absolute.contains(coords2) && checkCoordinate(coords2) ) {
    				aux.add(coords2);
    			}
    		}
    	}
    	return aux;
    	
    	
    }
    
    /**
     * Gets the neighborhood.
     *
     * @param craft the craft
     * @return the neighborhood
     */
    public Set<Coordinate> getNeighborhood(Craft craft){
    	return getNeighborhood(craft,craft.getPosition());
    }
    
    /**
     * Show.
     *
     * @param unveil the unveil
     * @return the string
     */
    public abstract String show(boolean unveil);
   
   /**
    * To string.
    *
    * @return the string
    */
   /* char ns=NOTSEEN_SYMBOL;
	char hs=HIT_SYMBOL;
	char w=WATER_SYMBOL;
	Ship ship;
	char cad2;
	Coordinate aux =new Coordinate(0,0);
	String cad="";
	//mostrar tablero completo
	
		
		for(int x=0;x<getSize() {
		}x++) {
			for(int y=0;y<getSize();y++) {
				aux.set(0, y);
				aux.set(x,0);
				ship=board.get(aux);
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
			if(x!=size-1) {
				cad+="\n";
			}
			
		
		
		}
	
	
	return cad;
}
    	
    
    /**
     * To string.
     *
     * @return the string
     */
    public String toString() {
    	return "Board "+size+"; crafts: "+numCrafts+"; destroyed: "+destroyedCrafts;
    }
}

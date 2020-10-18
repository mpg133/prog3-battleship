package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {
	private Set<Coordinate> seen;
	private Map<Coordinate,Ship> board;
	
	public static final char HIT_SYMBOL='•';
	public static final char WATER_SYMBOL=' ';
	public static final char NOTSEEN_SYMBOL='?';
	private static final int MAX_BOARD_SIZE=20;
	private static final int MIN_BOARD_SIZE=5;
	private int size;
	private int numCrafts;
	private int destroyedCrafts;
	public Board(int size) {
		if(MIN_BOARD_SIZE<=size && size<=MAX_BOARD_SIZE) {
			
			this.size=size;
		}else {
			System.err.println("msg error");
			this.size=MIN_BOARD_SIZE;
		}
		this.board=new HashMap<Coordinate,Ship>();
		this.seen =new HashSet<Coordinate>();
		numCrafts=0;
		destroyedCrafts=0;
	}
	public int getSize() {
		return size;
	}
	public boolean checkCoordinate(Coordinate c) {
		if((c.get(0)>0 && c.get(0)<size )&&(c.get(1)>0 && c.get(1)<size )) {
			return true;
		}else {
			return false;
		}
	}
	public boolean addShip(Ship ship,Coordinate position) {
		
		
		//mira si esta fuera o esta ocupada
		for(Coordinate coords:ship.getAbsolutePositions(position)) {
			if(!checkCoordinate(coords)) {
				System.err.println("Error in Board.addShip, position "+coords+"is out of the board");
				return false;
			}else if(board.get(coords)!=null) {
				System.err.println("Error in Board.addShip, position "+coords+"is alredy ocupied");
				return false;
			}
		}
		//recorre vecindad
		Set<Coordinate> vecindad=getNeighborhood(ship,position);
		for(Coordinate coord:vecindad) {
			if(board.get(coord)!=null) {
				System.err.println("Error in board.addShip, position "+coord+" is next to another ship ");
				return false;
			}
		}
		//añade barco
		for(Coordinate coord:ship.getAbsolutePositions(position)) {
			board.put(coord, ship);
		}
		ship.setPosition(position);
		numCrafts++;
		return true;
	}
		/*RECORRER MAPA
		 * Set<Coordinate> board2=board.keySet(); Set de coordenadas
			for(Coordinate coord: board2) {
			Ship s=board.get(coord);
			return s;
		}
		 */
	public Ship getShip(Coordinate c) {
		
		
		if(board.containsValue(c)) {
			return  board.;
		}else {
			return null;
		}
		}
		
	}
	public boolean isSeen(Coordinate c) {
		return false;
	}
	public CellStatus hit(Coordinate c) {
		return null;
	}
	public boolean areAllCraftDestroyed() {
		return false;
	}
    public Set<Coordinate> getNeighborhood(Ship ship, Coordinate position){
    	Set<Coordinate> aux= new HashSet<Coordinate>();
    	Set<Coordinate> absolute= ship.getAbsolutePositions(position);
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
    public Set<Coordinate> getNeighborhood(Ship ship){
    	return getNeighborhood(ship,ship.getPosition());
    }
    public String show(boolean unveil) {
    	return null;
    }
    public String toString() {
    	return null;
    }
}

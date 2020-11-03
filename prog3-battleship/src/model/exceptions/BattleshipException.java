package model.exceptions;

import model.Coordinate;

public abstract class BattleshipException extends Exception {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Coordinate coord;
public BattleshipException(Coordinate c) {
	this.coord=c;
}
public String getMessage() {
return getMessage();
}
}

package model.exceptions;

import model.Coordinate;

public class CoordinateAlreadyHitException extends BattleshipException {

/**
	 * 
	 */
private static final long serialVersionUID = 1L;
public CoordinateAlreadyHitException(Coordinate c) {
	super(c);
}
public String getMessage() {
	return "Warning!! is already hit";
}
}

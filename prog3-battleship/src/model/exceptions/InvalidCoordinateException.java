package model.exceptions;

import model.Coordinate;

public class InvalidCoordinateException extends BattleshipException {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public InvalidCoordinateException(Coordinate c) {
	super(c);
}
public String getMessage() {
	return "Warning!! is invalid";
}
}

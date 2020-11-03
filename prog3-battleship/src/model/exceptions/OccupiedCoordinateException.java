package model.exceptions;

import model.Coordinate;

public class OccupiedCoordinateException extends BattleshipException {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public OccupiedCoordinateException(Coordinate c) {
	super(c);
}
public String getMessage() {
	return "Warning!! is Occuped";
}
}
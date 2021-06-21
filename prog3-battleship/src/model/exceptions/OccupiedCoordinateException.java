package model.exceptions;

import model.Coordinate;


/**
 * The Class OccupiedCoordinateException.
 */
public class OccupiedCoordinateException extends BattleshipException {

/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

/**
 * Instantiates a new occupied coordinate exception.
 *
 * @param c the c
 */
public OccupiedCoordinateException(Coordinate c) {
	super(c);
}

/**
 * Gets the message.
 *
 * @return the message
 */
public String getMessage() {
	return "Warning!! is Occuped";
}
}
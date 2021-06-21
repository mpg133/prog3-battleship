package model.exceptions;

import model.Coordinate;


/**
 * The Class CoordinateAlreadyHitException.
 */
public class CoordinateAlreadyHitException extends BattleshipException {

/** The Constant serialVersionUID. */
private static final long serialVersionUID = 1L;

/**
 * Instantiates a new coordinate already hit exception.
 *
 * @param c the c
 */
public CoordinateAlreadyHitException(Coordinate c) {
	super(c);
}

/**
 * Gets the message.
 *
 * @return the message
 */
public String getMessage() {
	return "Warning!! is already hit";
}
}

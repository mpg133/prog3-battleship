package model.exceptions;

import model.Coordinate;


/**
 * The Class InvalidCoordinateException.
 */
public class InvalidCoordinateException extends BattleshipException {

/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

/**
 * Instantiates a new invalid coordinate exception.
 *
 * @param c the c
 */
public InvalidCoordinateException(Coordinate c) {
	super(c);
}

/**
 * Gets the message.
 *
 * @return the message
 */
public String getMessage() {
	return "Warning!! is invalid";
}
}

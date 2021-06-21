package model.exceptions;

import model.Coordinate;


/**
 * The Class BattleshipException.
 */
public abstract class BattleshipException extends Exception {

/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

/** The coord. */
private Coordinate coord;

/**
 * Instantiates a new battleship exception.
 *
 * @param c the c
 */
public BattleshipException(Coordinate c) {
	this.coord=c;
}

/**
 * Gets the message.
 *
 * @return the message
 */
public String getMessage() {
return getMessage()+coord;
}
}

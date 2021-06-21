package model.aircraft;

import model.Craft;
import model.Orientation;


/**
 * The Class Aircraft.
 */
public abstract class Aircraft extends Craft {
	
	/**
	 * Instantiates a new aircraft.
	 *
	 * @param o the o
	 * @param symbol the symbol
	 * @param name the name
	 */
	public Aircraft(Orientation o,char symbol,String name) {
		super(o,symbol,name);
	}
}

package model.aircraft;

import model.Orientation;


/**
 * The Class Bomber.
 */
public class Bomber extends Aircraft {

/**
 * Instantiates a new bomber.
 *
 * @param o the o
 */
public Bomber(Orientation o) {
	super(o,'⇶',"Bomber");
	shape=new int[][]{
	      { 0, 0, 0, 0, 0,
	    	0, 0, 1, 0, 0,	
	    	1, 1, 1, 1, 1,	
	    	1, 0, 1, 0, 1,
	    	0, 0, 1, 0, 0},
	      { 0, 1, 1, 0, 0,
		0, 0, 1, 0, 0,	
		1, 1, 1, 1, 0,	
		0, 0, 1, 0, 0,
		0, 1, 1, 0, 0},
	      { 0, 0, 1, 0, 0,
		1, 0, 1, 0, 1,	
		1, 1, 1, 1, 1,	
		0, 0, 1, 0, 0,
		0, 0, 0, 0, 0},
	      { 0, 0, 1, 1, 0,
		0, 0, 1, 0, 0,	
		0, 1, 1, 1, 1,	
		0, 0, 1, 0, 0,
		0, 0, 1, 1, 0}}; 

}
}

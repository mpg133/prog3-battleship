package model.ship;

import model.Orientation;
import model.Ship;

public class Battleship extends Ship {
	
	public Battleship(Orientation o) {
		super(o,'O',"Battleship");
		super.shape =new int[][] {
			  { 0, 0, 0, 0, 0,
			    0, 0, 1, 0, 0,	
			    0, 0, 1, 0, 0,	
			    0, 0, 1, 0, 0,
			    0, 0, 1, 0, 0},
			  
			  { 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0,	
				0, 1, 1, 1, 1,	
				0, 0, 0, 0, 0,
				0, 0, 0, 0, 0},
			  
			  { 0, 0, 0, 0, 0,
			    0, 0, 1, 0, 0,	
			    0, 0, 1, 0, 0,	
			    0, 0, 1, 0, 0,
			    0, 0, 1, 0, 0},
			  
			  { 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0,	
				0, 1, 1, 1, 1,	
				0, 0, 0, 0, 0,
				0, 0, 0, 0, 0}};
	}
	
		
	
}

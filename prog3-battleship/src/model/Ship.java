package model;

import java.util.Set;

public class Ship {
		private Orientation orientation;
		private Coordinate position=null;
		private  static final int BOUNDING_SQUARE_SIZE=5;
		private static final int HIT_VALUE=-1;
		private static final  int CRAFT_VALUE=1;
		private char symbol;
		private String name;
		private static int[][] shape = new int[][] {
			{0,0,0,0,0,
			 0,0,0,1,0,
			 0,0,0,1,0,//north
			 0,0,0,1,0,
			 0,0,0,0,0,
			},
			{0,0,0,0,0,
			 0,0,0,0,0,
			 0,1,1,1,0,//east
			 0,0,0,0,0,
			 0,0,0,0,0},
			{
		     0,0,0,0,0,
		     0,0,1,0,0,
		     0,0,1,0,0,//south
		     0,0,1,0,0,
		     0,0,0,0,0
			},
			{0,0,0,0,0,
			 0,0,0,0,0,
			 0,1,1,1,0,//west
			 0,0,0,0,0,
			 0,0,0,0,0}
		};
		
		
		
	public Ship (Orientation orientation, char symbol, String name){
			this.orientation=orientation;
			this.symbol=symbol;
			this.name=name;
	}	
	public Coordinate getPosition() {
		return new Coordinate(position);
		
	}
	public String getName() {
		return name;
	}
	public Orientation getOrientation() {
		return orientation;
	}
	public void setPoistion(Coordinate position) {
		
	}
	public int[][] getShape() {
		return shape;
		
	}
	public int getShapeIndex(Coordinate c) {
		//c es coordenada relativa
		//valores entre 0 y BOUNDING_SQUARE(5) -1
		return c.get(1)*BOUNDING_SQUARE_SIZE+c.get(0); 
	}
	public Set<Coordinate> getAbsolutePositions(Coordinate c) {
		return null;
		
	}
	public Set<Coordinate> getAbsolutePostions(){
		return null;
	}
	public boolean hit(Coordinate c) {
		
	}
	public boolean isShotDown() {
		
	}
	public boolean isHit(Coordinate c) {
		
	}
}



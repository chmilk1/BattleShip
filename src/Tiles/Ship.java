package Tiles;

public abstract class Ship extends Tile{
	int length;
	int bowRow;
	int bowCol;
	boolean horizontal;
	boolean[] hits = new boolean[length];
	String shipType;
	public String getShipType() {
		return shipType;
	}
	public int getBowRow() {
		return bowRow;
	}
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}
	public int getBowCol() {
		return bowCol;
	}
	public void setBowCol(int bowCol) {
		this.bowCol = bowCol;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean isSunk(){
		for (boolean part:hits) {
			if (!part) {
				return false;
			}
		}
		return true;
	}
	
	public boolean shootAt(int x, int y){
		if(horizontal && x == bowRow && y < bowCol+length && y > bowCol-1){
			System.out.println("Hit!");
			hits[bowCol+length-y] = true;
			return true;
		} else if(!horizontal && y == bowCol && x < bowRow+length && x > bowRow-1){
			System.out.println("Hit!");
			hits[bowCol+length-x] = true;
			return true;
		} 
		return false;
		
	}
	@Override
	public
	String toString(){
		return "" + shipType.toCharArray()[0];
	}

}

package Tiles;

import Execptions.CantPlaceShip;
import Logic.Board;

public abstract class Ship extends Tile {
	int length;
	int bowRow;
	int bowCol;
	boolean horizontal;
	boolean[] hits;
	String shipType;

	public Ship(int length, String sp) {
		this.length = length;
		this.shipType = sp;
		hits = new boolean[length];
	}

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

	public boolean isSunk() {
		// Debug Code
		for (int i = 0; i < hits.length; i++) {
			System.out.print(hits[i]);
		}
		for (boolean part : hits) {
			if (!part) {
				return false;
			}
		}

		return true;

	}

	public boolean shootAt(int x, int y) {
		if (horizontal && x == bowRow && y <= bowCol && y > bowCol - 1) {
			System.out.println("Hit!");
			hits[bowCol + length - y - 1] = true;
			return true;
		} else if (!horizontal && x == bowCol && y >= bowRow && y < bowRow - 1) {
			System.out.println("Hit!");
			hits[bowRow + length - x - 1] = true;
			return true;
		}
		return false;

	}

	public boolean okToPlaceShipHere(int x, int y, boolean horz, Board b) {
		boolean done = true;
		if (!(horz && !(x + length > b.getSize()) || !!horz && !(y + length > b.getSize()))) {
			for (int i = 0; i < length; i++) {

				if (horz) {
					if (b.isOccupied(x + i, y)) {
						done = false;
					}
				}
				if (!horz) {
					if (b.isOccupied(x, y + i)) {
						done = false;
					}
				}
			}
		} else {
			done = false;
		}
		return done;

	}

	public Board placeShip(int x, int y, boolean horz, Board b) {
		if (okToPlaceShipHere(x, y, horz, b)) {
			bowCol = x;
			bowRow = y;
			for (int i = 0; i < length; i++) {
				if (horz) {
					b.tile[x + i][y] = this;
				} else {
					b.tile[x][y + i] = this;
				}
			}
		} else {
			throw new CantPlaceShip("Can't Place Ship here");
		}
		return b;

	}

	@Override
	public String toString() {
		return "" + shipType.substring(0, 1);
	}

}

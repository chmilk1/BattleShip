package Logic;

import Tiles.Ship;
import Tiles.Tile;
import Tiles.Water;

public class Board {
	String player;
	public Tile[][] tile;
	boolean[][] hit;
	int ShotFired;
	int HitCount;
	int shipsSunk;
	int size = 10;
	boolean isGameOver;

	public Board(String player) {
		this.player = player;
		tile = new Tile[size][size];
		for (int x = 0; x < tile.length; x++) {
			for (int y = 0; y < tile[x].length; y++) {
				tile[x][y] = new Water();
			}
		}
		hit = new boolean[size][size];
		for (int x = 0; x < hit.length; x++) {
			for (int y = 0; y < hit[x].length; y++) {
				hit[x][y] = false;
			}
		}

	}

	public void shootAt(int x, int y) {
		boolean sunk = false;
		if (isOccupied(x, y)) {
			Ship s = (Ship) tile[x][y];
			sunk = s.shootAt(x, y);
			HitCount += 1;
		}
		if (sunk) {
			shipsSunk += 1;
			if (shipsSunk > 4) {
				isGameOver = true;
			}
		}
		hit[x][y] = true;
		ShotFired += 1;
	}

	public int getSize() {
		return size;
	}

	public int getShotFired() {
		return ShotFired;
	}

	public int getHitCount() {
		return HitCount;
	}

	public int getShipsSunk() {
		return shipsSunk;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public void showBoard() {
		System.out.println("AI's board");
		for (int x = 0; x < tile.length; x++) {
			System.out.println();
			for (int y = 0; y < tile[x].length; y++) {
				Tile til = tile[x][y];
				if (hit[x][y]) {
					System.out.print("* ");
				} else {
					System.out.print(til.toString() + " ");
				}
			}
		}
	}

	public boolean isOccupied(int x, int y) {
		if (tile[x][y] instanceof Ship) {
			return true;
		}
		return false;

	}
}

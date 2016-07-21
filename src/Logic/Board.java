package Logic;

import java.util.ArrayList;
import java.util.Random;

import Tiles.BattleShip;
import Tiles.Cruiser;
import Tiles.Destroyer;
import Tiles.Ship;
import Tiles.Sub;
import Tiles.Tile;
import Tiles.Water;

public class Board {
	Random rand = new Random();
	String player;
	public Tile[][] tile;
	boolean[][] hit;
	int ShotFired;
	int HitCount;
	int shipsSunk;
	int size = 10;
	boolean isGameOver;
	private ArrayList<Ship> ships = new ArrayList<Ship>();

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

	public void placeShipRandomly() {
		ships.add(new BattleShip());
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				ships.add(new Cruiser());
			}
			ships.add(new Sub());
			if (i < 3) {
				ships.add(new Destroyer());
			}
		}
		for (Ship s : ships) {
			boolean placed = false;
			while (!placed) {
				try {
					int x = rand.nextInt(10);
					int y = rand.nextInt(10);
					placeShip(x, y, rand.nextBoolean(), s);
					placed = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				// try catch
			}
			// while loop
		}
		// for each loop
	}

	public void placeShip(int x, int y, boolean horz, Ship s) {
		tile = s.placeShip(x, y, horz, this).tile;
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
		System.out.println();
		System.out.print("  ");
		for (int i = 0; i < 10; i++) {
		System.out.print(i + " ");	
		}
		for (int x = 0; x < tile.length; x++) {
			System.out.println();
			System.out.print(x +" ");
			for (int y = 0; y < tile[x].length; y++) {
				if (hit[x][y]) {
					if (tile[x][y] instanceof Ship) {
						Ship s = (Ship) tile[x][y];
						if (s.isSunk()) {
							System.out.print("X ");
						} else {
							System.out.print("$ ");
						}
					} else {
						System.out.print("* ");
					}
				} else {
					if (tile[x][y] instanceof Ship) {
						System.out.print("- ");
					} else {
						System.out.print(tile[x][y].toString() + " ");
					}

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

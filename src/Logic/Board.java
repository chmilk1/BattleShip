package Logic;

import Tiles.Tile;
import Tiles.Water;

public class Board {
	String player;
	Tile[][] tile;
	int ShotFired;
	int HitCount;
	int shipsSunk;
	int size = 10;

	public Board(String player) {
		this.player = player;
		tile = new Tile[size][size];
		for (int x = 0; x < tile.length; x++) {
			for (int y = 0; y < tile[x].length; y++) {
				tile[x][y] = new Water();
			}
		}

	}
	public void fire(int x, int y){
		
	}

	public void showBoard() {
		System.out.println("AI's board");
		for (Tile[] tiles : tile) {
			System.out.println();
			for (Tile tile : tiles) {
				System.out.print(tile.toString() + " ");
			}
		}
	}
}

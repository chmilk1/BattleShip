package Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Game {
	Board board1;
	boolean isOver = false;
	BufferedReader br;

	public static void main(String[] args) {
		Game main = new Game();
		try {
			main.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() throws IOException {
		board1 = new Board("AI");
		board1.placeShipRandomly();
		while (true) {
			board1.showBoard();
			isOver = false;
			System.out
					.println("commands: print, fire (ret then enter x, then ret and enter y), reset, showStats, help");
			while (!isOver) {
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println();
				System.out.println();
				String s = br.readLine();
				isOver = board1.isGameOver;
				if (s.equals("fire")) {
					try {
						fire();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (s.equals("print")) {
					board1.showBoard();
				} else if (s.equals("reset")) {
					reset(true);
				} else if (s.equals("showStats")) {
					JOptionPane.showMessageDialog(null,
							"Shots Fired:" + board1.getShotFired() + " Ships Sunk:" + board1.gotHit);
				} else if (s.equals("help")) {
					System.out.println(
							" Battleship commands: print, fire (ret then enter x, then ret and enter y), reset, showStats, help");
				} else if (s.equals("dev")) {
					dev();
				} else {
					System.out.println("Error: Not Valid Command, Tipe 'help' for commands");
				}

			}
			JOptionPane.showMessageDialog(null,
					"You Win! Shots Fired:" + board1.getShotFired() + " Ships Sunk:" + board1.gotHit);
			JOptionPane.showMessageDialog(null, "Restarting");
			JOptionPane.showMessageDialog(null, ".");
			JOptionPane.showMessageDialog(null, ". .");
			JOptionPane.showMessageDialog(null, ". . .");
			reset(false);
		}
	}

	private void dev() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				if (x == 9 && y == 9) {
					// so no insta win
				} else {
					board1.shootAt(x, y);
				}
			}
		}
		System.out.println("Cheater");

	}

	private void fire() throws Exception, Exception {
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		board1.shootAt(y, x);
		board1.showBoard();
	}

	private void reset(boolean ask) throws IOException {
		if(ask){
		System.out.println("Are you shure?");
		}
		if (br.readLine().equals("yes") || !ask) {
			board1 = new Board("AI");
			board1.placeShipRandomly();
			board1.showBoard();
		}

	}

}

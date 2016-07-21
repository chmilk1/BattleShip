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
private void run() throws IOException{
	board1 = new Board("AI");
	board1.placeShipRandomly();
	board1.showBoard();
	while(!isOver){
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println();
		System.out.println("commands: print, fire (ret then enter x, then ret and enter y), reset");
        String s = br.readLine();
        if (s.equals("fire")) {
			try {
				fire();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (s.equals("print")) {
			board1.showBoard();
		} else if (s.equals("reset")){
			reset();
		} 
       
	}
	JOptionPane.showMessageDialog(null, "You Win! Shots Fired:" + board1.getShotFired() + " Ships Sunk:" + board1.shipsSunk);
	JOptionPane.showMessageDialog(null, "Restarting");
	JOptionPane.showMessageDialog(null, ".");
	JOptionPane.showMessageDialog(null, ". .");
	JOptionPane.showMessageDialog(null, ". . .");
	run();
}
private void fire() throws Exception, Exception{
	int x = Integer.parseInt(br.readLine());
	int y = Integer.parseInt(br.readLine());
	board1.shootAt(y, x);
	board1.showBoard();
}
private void reset() throws IOException{
	System.out.println("Are you shure?");
	if (br.readLine().equals("yes")) {
		board1 = new Board("AI");
		board1.placeShipRandomly();
		board1.showBoard();
	}
	
}
	
}

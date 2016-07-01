package Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
	Board board1;
	boolean isOver = false;
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
	board1.showBoard();
	while(!isOver){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println();
		System.out.println("commands: printPlayer, fire [int x, int y]");
        String s = br.readLine();
        if (s.substring(0, 3).equalsIgnoreCase("fire")) {
			String sCut = s.substring(4,s.length());
			
		}
	}
}
public void fire(int x, int y){
	board1.fire(x,y);
}
	
public void print(){
	
}
}

package Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	board1.showBoard();
	while(!isOver){
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println();
		System.out.println("commands: printPlayer, fire (ret then enter x, then ret and enter y)");
        String s = br.readLine();
        if (s.equals("fire")) {
			try {
				fire();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
       
	}
}
public void fire() throws Exception, Exception{
	int x = Integer.parseInt(br.readLine());
	int y = Integer.parseInt(br.readLine());
	board1.shootAt(x, y);
}
	
public void print(){
	
}
}

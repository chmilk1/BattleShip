package Logic;

public class Game {
	Board board1;
	boolean isOver = false;
public static void main(String[] args) {
	Game main = new Game();
	main.run();
}
private void run(){
	board1 = new Board();
	board1.showBoard();
	while(!isOver){
		
	}
}
public void fire(int x, int y){
	board1.fire(x,y);
}
	
public void print(){
	
}
}

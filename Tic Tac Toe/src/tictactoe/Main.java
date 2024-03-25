package tictactoe;

public class Main {

	public static void main(String[] args) {
		
		char board[][] = {
				{' ', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', ' '}
		};
		
		TicTacToe ticTacToe = new TicTacToe(board);
		
		while(true) {
			ticTacToe.play();
		}
	}
}
 
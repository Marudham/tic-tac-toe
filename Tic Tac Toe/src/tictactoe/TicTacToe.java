package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	private char[][] board;
	private int size;
	private Scanner scan = new Scanner(System.in);
	private int computerWonCount = 0;
	private int playerWonCount = 0;
	
	public TicTacToe(char[][] board) {
		this.board = board;
		this.size = board.length;
	}
	
	public void play() {
//		printCount();
		print();
		while(true) {
			playerTurn();
			print();
			if(isGameFinished()) {
				printCount();
				break;
			}
			computerTurn();
			print();
			if(isGameFinished()) {
				printCount();
				break;
			}
		}
		reset();
	}

	private void reset() {
		char newBoard[][] = {
				{' ', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', ' '}
		};
		this.board = newBoard;
	}

	private void printCount() {
		System.out.println("=============");
		System.out.println("Won Count:");
		System.out.println("X : " + playerWonCount + " | " + "O : " + computerWonCount);
		System.out.println("=============");
	}

	private boolean isGameFinished() {
		if(didThisWon('X')) {
			System.out.println("Player won :)");
			playerWonCount++;
			return true;
		}
		
		if(didThisWon('O')) {
			System.out.println("Computer won :)");
			computerWonCount++;
			return true;
		}
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(board[i][j] == ' ') {
					return false;
				}
			}
		}
		System.out.println("Match Tie :/");
		return true;
	}

	private boolean didThisWon(char ch) {
		if(board[0][0] == ch && board[0][1] == ch && board[0][2] == ch ||
			board[1][0] == ch && board[1][1] == ch && board[1][2] == ch ||
			board[2][0] == ch && board[2][1] == ch && board[2][2] == ch ||
			board[0][0] == ch && board[1][0] == ch && board[2][0] == ch ||
			board[0][1] == ch && board[1][1] == ch && board[2][1] == ch ||
			board[0][2] == ch && board[1][2] == ch && board[2][2] == ch ||
			board[0][0] == ch && board[1][1] == ch && board[2][2] == ch ||
			board[0][2] == ch && board[1][1] == ch && board[2][0] == ch 
		) {
			return true;
		}
		return false;
	}

	private void computerTurn() {
		System.out.println("Computer Turn");
		int position;
		Random random = new Random();
		while(true) {
			position = random.nextInt(8) + 1;
			if(isValidPosition(position)) {
				break;
			}
		}
		insert(position, 'O');
	}

	private void playerTurn() {
		System.out.println("Your Turn");
		int input;
		while(true) {
			System.out.println("Where would you want play? (1-9)");
			input = scan.nextInt();
			if(isValidPosition(input)) {
				break;
			}else {
				System.out.println("Invalid move :/");
			}
		}
		insert(input, 'X');
	}
	
	private boolean isValidPosition(int position) {
		switch(position) {
			case 1 : return board[0][0] == ' ';
			case 2 : return board[0][1] == ' ';
			case 3 : return board[0][2] == ' ';
			case 4 : return board[1][0] == ' ';
			case 5 : return board[1][1] == ' ';
			case 6 : return board[1][2] == ' ';
			case 7 : return board[2][0] == ' ';
			case 8 : return board[2][1] == ' ';
			case 9 : return board[2][2] == ' ';
			default : return false;
		}
	}

	private void insert(int position, char ch) {
		switch(position) {
		case 1 : board[0][0] = ch;
		break;
		case 2 : board[0][1] = ch;
		break;
		case 3 : board[0][2] = ch;
		break;
		case 4 : board[1][0] = ch;
		break;
		case 5 : board[1][1] = ch;
		break;
		case 6 : board[1][2] = ch;
		break;
		case 7 : board[2][0] = ch;
		break;
		case 8 : board[2][1] = ch;
		break;
		case 9 : board[2][2] = ch;
		break;
		}
	}

	private void print() {
		System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
		System.out.println("---------");
		System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
		System.out.println("---------");
		System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
	}
}

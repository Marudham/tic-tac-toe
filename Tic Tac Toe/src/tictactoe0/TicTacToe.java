package tictactoe0;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	private char board[][]= {
								{' ', ' ', ' '},
								{' ', ' ', ' '},
								{' ', ' ', ' '}
							};
	private boolean gameOver = false;
	private char player;
	private int mode;
	private Scanner scan = new Scanner(System.in);
	
	public void play() {
		System.out.println("Welcome to marudham's game :-)");
		while(true) {
			menu();
			int choice = scan.nextInt();
			switch (choice) {
			case 1: mode = 1;
			playerToPlayer();
			break;
			case 2: mode = 2;
			playerToComputer();
			break;
			case 0: return;
			default: System.out.println("Invalid Choice, Let's try again.");
			}
		}
	}

	private void menu() {
		System.out.println("Enter 1 --> Player To Player.\nEnter 2 --> Player To Computer.");
		System.out.println("Enter 0 to quit.");
	}

	private void playerToComputer() {
		while(true) {
			print();
			playerTurn();
			if(gameOver) break;
			print();
			computerTurn();
			if(gameOver) break;
		}
		reset();
	}
	
	private void playerToPlayer() {
		player = 'X';
		while(!gameOver) {
			print();
			System.out.println("Player " + player + " turn: ");
			System.out.print("Enter a position (0-8): ");
			int position = scan.nextInt();
			if(validPosition(position)) {
				place(position, player);
				player = player == 'X' ? 'O' : 'X';
				isGameOver();
			}else {
				System.out.println("Invalid position. Try again..");
			}
		}
		reset();
	}

	private void computerTurn() {
		System.out.println("Computer's turn: ");
		Random random = new Random();
		int rand;
		do {
			rand = random.nextInt(9);
		}
		while(!validPosition(rand));
		place(rand, 'O');
		isGameOver();
	}
	
	private void playerTurn() {
		System.out.println("Player's turn: ");
		int position;
		do {
			System.out.print("Enter the position(0 - 8): ");
			position = scan.nextInt();
		}
		while(!validPosition(position));
		place(position, 'X');
		isGameOver();
	}
	
	private boolean validPosition(int position) {
		if (position >= 0 && position <= 2) {
			return board[0][position] == ' ';
		}else if (position >= 3 && position <= 5) {
			return board[1][position % 3] == ' ';
		}else if (position >= 6 && position <= 8) {
			return board[2][position % 3] == ' ';
		}
		return false;
	}
	
	private void place(int position, char c) {
		if (position >= 0 && position <= 2) {
			board[0][position] = c;
		}else if (position >= 3 && position <= 5) {
			board[1][position % 3] = c;
		}else if (position >= 6 && position <= 8) {
			board[2][position % 3] = c;
		}
	}

	private void isGameOver() {
		if(board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X' 
				|| board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') {
			gameOver(board[0][1]);
			gameOver = true;
			return;
		}else if(board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X' 
				|| board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') {
			gameOver(board[1][1]);
			gameOver = true;
			return;
		}else if(board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X' 
				|| board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') {
			gameOver(board[2][1]);
			gameOver = true;
			return;
		}else if(board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X' 
				|| board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') {
			gameOver(board[0][0]);
			gameOver = true;
			return;
		}else if(board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X' 
				|| board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') {
			gameOver(board[0][1]);
			gameOver = true;
			return;
		}else if(board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X' 
				|| board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') {
			gameOver(board[0][2]);
			gameOver = true;
			return;
		}else if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X' 
				|| board[0][2] == 'O' && board[1][1] == 'O' && board[2][2] == 'O'
				|| board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X'
				|| board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
			gameOver(board[1][1]);
			gameOver = true;
			return;
		}else {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(board[i][j] == ' ') {
						return;
					}
				}
			}
			gameOver('T');
			gameOver = true;
		}
	}

	private void gameOver(char c) {
		print();
		System.out.println("\n======================");
		if(c == 'X' && mode == 1) System.out.println("Player X Won :)");
		else if(c == 'O' && mode == 1) System.out.println("Player O Won :)");
		else if(c == 'X' && mode == 2) System.out.println("Player Won :)");
		else if(c == 'O' && mode == 2) System.out.println("Computer Won :)");
		else System.out.println("Match Tie :/");
		System.out.println("\n======================");
	}

	private void reset() {
		char newBoard[][] = {
				{' ', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', ' '}
		};
		board = newBoard;
		System.out.println("Board Reseted");
		gameOver = false;
	}

	private void print() {
		System.out.println("----------");
		System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
		System.out.println("----------");
		System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
		System.out.println("----------");
		System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
		System.out.println("----------");
	}
}

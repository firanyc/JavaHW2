package hw2.KhalimzadeF;

import java.util.Scanner;

public class  B9511 {

	// initialization of game board
	public static int[][] emptyBoard(){
		int [][] arr = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				arr[i][j] = '-';
		}
		return arr;
	}
	// row and column 
	public static int[] userInput(){
		int []arr = new int[2];
		System.out.println("enter row and column");
		Scanner input = new Scanner(System.in);
		arr[0] = input.nextInt();
		arr[1] = input.nextInt();
		return arr;
	}
	// checking the user input
	public static boolean checkAnswer(int []x, int[][]y) {
		if (x[0] < 0 || x[0] > 2 || x[1] < 0 || x[1] > 2) {
			System.out.println("Please, try again!");
			return false;
		}
		if(y[x[0]][x[1]] != '-') {
			System.out.println("Please, try again!");
			return false;
		}
		return true;	
	}	
	// update game board state for first user
	public static int[][] user1(int []x, int [][]y) {
		y[x[0]][x[1]] = 0;
		return y;		
	}
	// update game board state for second user
	public static int[][] user2(int []x, int[][]y){
		y[x[0]][x[1]] = 1;
		return y;	
	}
	
	public static void print(int [][] y) {
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (y[i][j] == 0)
					System.out.print(" X ");
				else if (y[i][j] == 1)
					System.out.print(" O ");
				else 
					System.out.print(" - ");
			} 
			System.out.println();
		}	
}
	// check winner status
	public static boolean winner(int [][] x) {
		for (int i = 0;i < 3; i++) {
			if (x[i][0] == x[i][1] && x[i][1] == x[i][2] && x[i][0] != '-')
				return true;
			if (x[0][i] == x[1][i] && x[1][i] == x[2][i] && x[0][i]!= '-')
				return true;
			if (x [0][2] == x[1][2] && x[1][2] == x[2][2] && x[0][2] != '-')
				return true;
			if (x [0][0] == x[1][1] && x[1][1] == x[2][2] && x[0][0]!= '-')
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		int [][] board = emptyBoard();
		int i = 0;
		while (i <= 9) {
			int [] check = userInput();
			if (i % 2 == 0) {
				if(checkAnswer(check, board)) {
					user1(check, board);
					i++;
				}
				else continue;
			}
			else if (i % 2 != 0) {
				if (checkAnswer(check, board)) {
					user2(check, board);
					i++;
				}
				else continue;
			}
			if (i > 4 && i <= 9 && winner(board)) {
				System.out.println("You Won!");
				print(board);
				break;
			}
			if (i == 9 &&!winner(board)) {
				print(board);
				System.out.println("Draw");
				break;
			}	
			print (board);
		}
	}			
}

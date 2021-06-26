package dfs;

//Leetcode
//Problem link-https://leetcode.com/problems/battleships-in-a-board/description/
//
//	Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.
//
//			Battleships can only be placed horizontally or vertically on board. 
//			In other words, they can only be made of the shape 1 x k (1 row, k columns) or 
//			k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or
//			vertical cell separates between two battleships (i.e., there are no adjacent battleships).
//
//			 
//
//			Example 1:
//
//
//			Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
//			Output: 2
//			Example 2:
//
//			Input: board = [["."]]
//			Output: 0
//

public class BattleshipsInaBoard {

	public static int countBattleships(char[][] board) {
		if(board==null || board.length==0)
			return 0;
		
		int count =0;
		int rows=board.length;
		int cols=board[0].length;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(board[i][j]=='X') {
					count++;
					dfs(board,i,j,rows,cols);
				}
			}
		}
		return count;
	}
	
	private static void dfs(char [][] board, int x, int y, int rows, int cols) {
		
		board[x][y]='.';
		if(isValid(x+1,y,rows,cols,board)) {
			dfs(board,x+1,y,rows,cols);
		}
		if(isValid(x,y+1,rows,cols,board)) {
			dfs(board,x,y+1,rows,cols);
		}
	}
	
	private static boolean isValid(int x, int y, int rows, int cols, char [][] board) {
		
		if(x>=0 && x<rows && y>=0 && y<cols && board[x][y]=='X')
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] [] board= {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'},{'.','.','.','.'}};
		System.out.println(countBattleships(board));
		}

	}



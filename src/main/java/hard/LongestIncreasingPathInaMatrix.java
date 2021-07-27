package hard;

import java.util.Arrays;

//LC 329
//Problem link- https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

//Given an m x n integers matrix, return the length of the longest increasing path in matrix.

//From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

//Example 1:


//Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
//Output: 4
//Explanation: The longest increasing path is [1, 2, 6, 9].
//Example 2:


//Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
//Output: 4
//Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
//Example 3:

//Input: matrix = [[1]]
//Output: 1

//We'll be using DFS + Memoization
public class LongestIncreasingPathInaMatrix {

	public int longestIncreasingPath(int[][] matrix) {

		int row = matrix.length;
		int col = matrix[0].length;
		int[][] longest = new int[row][col];
		boolean[][] visited = new boolean[row][col];
		for (int[] r : longest)
			Arrays.fill(r, 1);
		int max = 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				longest[i][j] = dfsWithMemoization(matrix, row, col, i, j, longest, visited);
				max = Math.max(max, longest[i][j]);
			}
		}
		return max;
	}

	private int dfsWithMemoization(int[][] matrix, int row, int col, int i, int j, int[][] longest,
			boolean[][] visited) {
		// TODO Auto-generated method stub

		if (visited[i][j])
			return longest[i][j];
		int currentValue = matrix[i][j];
		int maxFromThisNode = 1;
		if (isValid(matrix, i + 1, j, row, col, currentValue)) {
			int temp1 = longest[i][j] + dfsWithMemoization(matrix, row, col, i + 1, j, longest, visited);
			maxFromThisNode = Math.max(maxFromThisNode, temp1);
		}
		if (isValid(matrix, i - 1, j, row, col, currentValue)) {
			int temp2 = longest[i][j] + dfsWithMemoization(matrix, row, col, i - 1, j, longest, visited);
			maxFromThisNode = Math.max(maxFromThisNode, temp2);
		}
		if (isValid(matrix, i, j + 1, row, col, currentValue)) {
			int temp3 = longest[i][j] + dfsWithMemoization(matrix, row, col, i, j + 1, longest, visited);
			maxFromThisNode = Math.max(maxFromThisNode, temp3);
		}
		if (isValid(matrix, i, j - 1, row, col, currentValue)) {
			int temp4 = longest[i][j] + dfsWithMemoization(matrix, row, col, i, j - 1, longest, visited);
			maxFromThisNode = Math.max(maxFromThisNode, temp4);
		}

		visited[i][j] = true;
		return longest[i][j] = maxFromThisNode;
	}

	private boolean isValid(int[][] matrix, int i, int j, int row, int col, int currentValue) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j] <= currentValue)
			return false;
		return true;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		System.out.println(new LongestIncreasingPathInaMatrix().longestIncreasingPath(matrix));
	}
}

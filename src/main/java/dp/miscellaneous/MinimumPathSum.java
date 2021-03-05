package dp.miscellaneous;

public class MinimumPathSum {

	public int minPathSum(int[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;
		int row = grid.length;
		int col = grid[0].length;
		int[][] dp = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 && j == 0)
					dp[i][j] = grid[i][j];
				else
					dp[i][j] = Math.min(j == 0 ? Integer.MAX_VALUE : dp[i][j - 1],
							i == 0 ? Integer.MAX_VALUE : dp[i - 1][j]) + grid[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

		System.out.println(new MinimumPathSum().minPathSum(grid));
	}

}

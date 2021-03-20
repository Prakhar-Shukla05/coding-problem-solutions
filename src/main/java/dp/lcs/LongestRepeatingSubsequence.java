package dp.lcs;

public class LongestRepeatingSubsequence {

	public int LongestRepeatingSubsequence(String str) {
		// code here
		
		int p=str.length();
		int[][] dp = new int[p + 1][p + 1];
		int lrs = lrs(str, str, p, p, dp);
		return lrs;
	}


	private static int lrs(String x, String y, int m, int n, int[][] dp) {

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				if (x.charAt(i - 1) == y.charAt(j - 1) && i!=j) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

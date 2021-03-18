package dp.lcs;

//GeeksforGeeks
//Problem link - https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1#
//Given two sequences, find the length of longest subsequence present in both of them.
//Both the strings are of uppercase.
//Input:
//A = 6, B = 6
//str1 = ABCDGH
//str2 = AEDFHR
//Output: 3
//Explanation: LCS for input Sequences
//“ABCDGH” and “AEDFHR” is “ADH” of
//length 3.

public class LcsWithTopDown {

	private static int lcs(int p, int q, String s1, String s2) {

		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0)
			return 0;
		int[][] dp = new int[p + 1][q + 1];
		int lcs = lcsWithTopDownDP(s1, s2, p, q, dp);
		return lcs;
	}

	private static int lcsWithTopDownDP(String x, String y, int m, int n, int[][] dp) {

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int p = in.readInt();
		int q = in.readInt();
		String s1 = in.readString();
		String s2 = in.readString();
		out.printLine(lcs(p, q, s1, s2));
		out.close();
	}

}

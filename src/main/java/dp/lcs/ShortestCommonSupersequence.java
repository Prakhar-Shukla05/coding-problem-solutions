package dp.lcs;

//GeeksforGeeks
//Problem link-https://www.geeksforgeeks.org/shortest-common-supersequence/
//	Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
//	Examples:
//
//	Input:   str1 = "geek",  str2 = "eke"
//	Output: "geeke"	

public class ShortestCommonSupersequence {

	public static int shortestCommonSupersequence(String s1, String s2, int p, int q) {
		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0)
			return 0;
		int[][] dp = new int[p + 1][q + 1];
		int lcs = lcsWithTopDownDP(s1, s2, p, q, dp);
		return s1.length()+s2.length()-lcs;
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
		out.printLine(shortestCommonSupersequence(s1, s2,p,q));
		out.close();
	}

}

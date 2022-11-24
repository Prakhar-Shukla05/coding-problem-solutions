package dp.lcs;

import java.util.Arrays;

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
//ABCDGH and AEDFHR is �ADH� of
//length 3.

public class LongestCommonSubsequenceWithMemoization {

	private static int lcs(int p, int q, String s1, String s2) {

		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0)
			return 0;
		int[][] dp = new int[p + 1][q + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		int lcs = lcsRecursiveWithMemoization(s1, s2, p, q, dp);
		return lcs;
	}

	private static int lcsRecursiveWithMemoization(String x, String y, int m, int n, int[][] dp) {
		if (m == 0 || n == 0)
			return 0;

		if (dp[m][n] != -1)
			return dp[m][n];

		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return dp[m][n] = 1 + lcsRecursiveWithMemoization(x, y, m - 1, n - 1, dp);
		} else {
			return dp[m][n] = Math.max(lcsRecursiveWithMemoization(x, y, m, n - 1, dp),
					lcsRecursiveWithMemoization(x, y, m - 1, n, dp));
		}
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

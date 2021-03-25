package dp.mcm;

import java.util.Arrays;

import utility.InputReader;
import utility.OutputWriter;

//GFG
//Problem link- https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1
//
//Given a string str, a partitioning of the string is a palindrome partitioning 
//if every sub-string of the partition is a palindrome. 
//Determine the fewest cuts needed for palindrome partitioning of given string
//
//Input: str = "ababbbabbababa"
//Output: 3
//Explaination: After 3 partitioning substrings 
//are "a", "babbbab", "b", "ababa".

public class PalindromePartioningWithMemoizationOptimized {
	private static long startTime= System.currentTimeMillis();
	private static int solve(String s, int i, int j, int[][] dp, int[][] pal) {

		if (dp[i][j] != -1)
			return dp[i][j];
		
		if(pal[i][j]==0) {
			return dp[i][j]=0;
		}
		if (i > j)
			return dp[i][j] = 0;

		if (i == j)
			return dp[i][j] = 0;

		if (isPalindrome(s, i, j)) {
			dp[i][j]=0;
			return pal[i][j] = 0;
		}

		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int left=(dp[i][k] == -1 ? solve(s, i, k, dp, pal) : dp[i][k]);
			int right=(dp[k + 1][j] == -1 ? solve(s, k + 1, j, dp, pal) : dp[k + 1][j]);
			int temp = left+right + 1;
			if (temp < min)
				min = temp;
		}
		return dp[i][j] = min;
	}

	private static boolean isPalindrome(String s, int i, int j) {

		int start = i;
		int end = j;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

	static int palindromicPartition(String s) {

		if (s == null || s.length() == 0)
			return 0;
		int[][] dp = new int[s.length()+1][s.length()+1];
		for (int[] rows : dp)
			Arrays.fill(rows, -1);
		int[][] pal = new int[s.length()+1][s.length()+1];
		for (int[] rows : pal)
			Arrays.fill(rows, -1);
		return solve(s, 0, s.length() - 1, dp, pal);
	}

	public static void main(String[] args) {

		
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		String str = in.readString();
		long startTime= System.currentTimeMillis();
		out.printLine(str.length());
		out.printLine(palindromicPartition(str));
		long endTime= System.currentTimeMillis();
		out.printLine("It took " + (endTime - startTime) + " milliseconds");
		out.close();
	}
}

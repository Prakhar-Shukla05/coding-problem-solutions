package dp.lcs.palindromicsubsequence;

import utility.InputReader;
import utility.OutputWriter;

//Geeks for Geeks
//Problem link- https://practice.geeksforgeeks.org/problems/minimum-deletitions1648/1
//Given a string of S as input. Your task is to write a program to remove or delete
//the minimum number of characters from the string so that the resultant string is a palindrome.
//Input: S = "aebcbda"
//Output: 2
//Explanation: Remove characters 'e' 
//and 'd'.
public class MinimumDeletionsToMakePalindrome {

	static int minimumNumberOfDeletions(String S)
    {
		if (S == null || S.length() == 0 )
			return 0;
        int lps= lps(S);
        return S.length()-lps;
    }
	
	private static int lps(String s1) {

		if (s1 == null || s1.length() == 0 )
			return 0;
		int[][] dp = new int[s1.length()+ 1][s1.length() + 1];
		String s2= new StringBuilder(s1).reverse().toString();
		int lcs = lcsWithTopDownDP(s1, s2, s1.length(),s2.length() , dp);
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
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		//int p = in.readInt();
		//int q = in.readInt();
		String s1 = in.readString();
		//String s2 = in.readString();
		out.printLine(minimumNumberOfDeletions(s1));
		out.close();

	}
}

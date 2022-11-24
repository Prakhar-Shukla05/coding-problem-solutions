package dp.lcs;

//GeeksforGeeks
//Problem link-https://www.geeksforgeeks.org/longest-common-substring-dp-29/
//Given two strings X and Y, find the length of the longest common substring.
//Input : X = GeeksforGeeks, y = GeeksQuiz
//Output : 5 
//Explanation:
//The longest common substring is Geeks and is of length 5.
//
//Input : X = abcdxyz, y = xyzabcd
//Output : 4 
//Explanation:
//The longest common substring is abcd and is of length 4.
//
//Input : X = zxabcdezy, y = yzabcdezx
//Output : 6 
//Explanation:
//The longest common substring is abcdez and is of length 6.

public class LongestCommonSubstring {

	private static int longestCommonSubsstring(int p, int q, String s1, String s2) {

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
					dp[i][j] = 0;
				}
			}
		}
		
		int maxSubstring=Integer.MIN_VALUE;
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(maxSubstring<dp[i][j])
					maxSubstring=dp[i][j];
			}
		}
		return maxSubstring;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int p = in.readInt();
		int q = in.readInt();
		String s1 = in.readString();
		String s2 = in.readString();
		out.printLine(longestCommonSubsstring(p, q, s1, s2));
		out.close();

	}

}

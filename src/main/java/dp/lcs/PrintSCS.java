package dp.lcs;

//GFG
//Problem link-https://www.geeksforgeeks.org/print-shortest-common-supersequence/
//Given two strings X and Y, print the shortest string that has both X and Y as subsequences.
//If multiple shortest supersequence exists, print any one of them.
//
//Examples:
//
//	Input: X = "AGGTAB",  Y = "GXTXAYB"
//	Output: "AGXGTXAYB" OR "AGGXTXAYB" 
//	OR Any string that represents shortest
//	supersequence of X and Y
//
//	Input: X = "HELLO",  Y = "GEEK"
//	Output: "GEHEKLLO" OR "GHEEKLLO"
//	OR Any string that represents shortest 
//	supersequence of X and Y

public class PrintSCS {

	private static String printScs(String s1, String s2) {

		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0)
			return "";
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		String lcs = printScsWithTopDownDP(s1, s2, s1.length(), s2.length(), dp);
		return lcs;
	}

	private static String printScsWithTopDownDP(String x, String y, int m, int n, int[][] dp) {

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
		
		StringBuilder sb= new StringBuilder();
		int i=m;
		int j=n;
		while(i>0 && j>0) {
			if(x.charAt(i-1)==y.charAt(j-1)) {
				sb.append(x.charAt(i-1));
				i--;
				j--;
			}
			else {
				if(dp[i][j-1]>=dp[i-1][j]) {
					sb.append(x.charAt(i-1));
					i--;
					
				}
				else if(dp[i-1][j]>dp[i][j-1]) {
					
					sb.append(y.charAt(j-1));
					j--;
				}
			}
		}
		while(i>0) {
			sb.append(x.charAt(i));
			i--;
		}
		while(j>0) {
			sb.append(y.charAt(j));
			j--;
		}
		
        return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
//		int p = in.readInt();
//		int q = in.readInt();
		String s1 = in.readString();
		String s2 = in.readString();
		out.printLine(printScs(s1, s2));
		out.close();
	
}
}

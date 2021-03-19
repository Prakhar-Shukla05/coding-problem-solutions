package dp.lcs;

//GeeksforGeeks
//Problemlink- https://www.geeksforgeeks.org/printing-longest-common-subsequence/
//Given two sequences, print the longest subsequence present in both of them.
//Example:
//LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3. 

public class PrintLCS {
	
	private static String printlcs(int p, int q, String s1, String s2) {

		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0)
			return "";
		int[][] dp = new int[p + 1][q + 1];
		String lcs = printLcsWithTopDownDP(s1, s2, p, q, dp);
		return lcs;
	}

	private static String printLcsWithTopDownDP(String x, String y, int m, int n, int[][] dp) {

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
		while(i!=0 && j!=0) {
			if(x.charAt(i-1)==y.charAt(j-1)) {
				sb.append(x.charAt(i-1));
				i--;
				j--;
			}
			else {
				if(dp[i-1][j]>dp[i][j-1]) {
					i--;
				}
				else {
					j--;
				}
			}
		}
        return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int p = in.readInt();
		int q = in.readInt();
		String s1 = in.readString();
		String s2 = in.readString();
		out.printLine(printlcs(p, q, s1, s2));
		out.close();
	}

}

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

	private static String printScs(String str1, String str2) {

		if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0)
			return "";
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		String scs = printScsWithTopDownDP(str1, str2, str1.length(), str2.length(), dp);
		return scs;
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
					j--;
					
				}
				else if(dp[i-1][j]>dp[i][j-1]) {
				    i--;
				}
			}
		}
		
		
        String lcs= sb.reverse().toString();
        StringBuilder scs= new StringBuilder();
        int first=0;
        int second=0;
        for(char c: lcs.toCharArray()) {
        	while(x.charAt(first)!=c)
        		scs.append(x.charAt(first++));
        	while(y.charAt(second)!=c)
        		scs.append(y.charAt(second++));
        	
        	scs.append(c);
        	first++;
        	second++;
        }
        scs.append((x.substring(first))+(y.substring(second)));
        return scs.toString();
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

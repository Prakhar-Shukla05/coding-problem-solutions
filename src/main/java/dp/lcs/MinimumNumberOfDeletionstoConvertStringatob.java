package dp.lcs;

//GeeksforGeeeks
//Problem link- https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
//Given two strings str1 and str2. The task is to remove or insert the minimum number of characters from/in str1 so as to transform it into str2.
//It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
//Input: str1 = "heap", str2 = "pea"
//Output: 3
//Explanation: 2 deletions and 1 insertion
//p and h deleted from heap. Then, p is 
//inserted at the beginning One thing to 
//note, though p was required yet it was 
//removed/deleted first from its position 
//and then it is inserted to some other 
//position. Thus, p contributes one to the 
//deletion_count and one to the 
//insertion_count.

public class MinimumNumberOfDeletionstoConvertStringatob {

	public int minOperations(String str1, String str2) 
	{ 
		int [] [] dp = new int [str1.length()+1][str2.length()+1];
	    int lcs= lcsWithTopDownDP(str1, str2, str1.length(),str2.length(), dp);
	    return (str1.length()-lcs)+(str2.length()-lcs);
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
//		int p = in.readInt();
//		int q = in.readInt();
		String s1 = in.readString();
		String s2 = in.readString();
		out.printLine(new MinimumNumberOfDeletionstoConvertStringatob().minOperations(s1, s2));
		out.close();

	}

}

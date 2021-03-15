package dp.unboundedknapsack;

//Problem link:-https://practice.geeksforgeeks.org/problems/coin-change2448/1
/*
 * Given a value N, find the number of ways to make change for N cents, 
 * if we have infinite supply of each of S = { S1, S2, .. , SM } valued coins.
 * Input:
   n = 4 , m = 3
   S[] = {1,2,3}
   Output: 4
   Explanation: Four Possible ways are:
   {1,1,1,1},{1,1,2},{2,2},{1,3}.
 */
public class CoinChangeMaximumNumberOfWays {

	public long count(int S[], int m, int n) {
		if(S== null || m==0 )
			return 0;
		
		long maxNumberOfWays= unboundedKnapSack(S,n,m);
        return maxNumberOfWays;
		
	}
	
	private long unboundedKnapSack(int [] S, int n, int m) {
		
		long [] [] dp = new long[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 ) {
					dp[i][j]=0;
				}
				if(j==0) {
					dp[i][j]=1;
				}
			}
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(S[i-1]<=j) {
					dp[i][j]= dp[i][j-S[i-1]]+ dp[i-1][j];
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in= new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n=in.readInt();
        int m=in.readInt();
        int [] S = IOUtils.readIntArray(in, m);
        out.printLine(new CoinChangeMaximumNumberOfWays().count(S, m, n));
        out.close();

	}

}

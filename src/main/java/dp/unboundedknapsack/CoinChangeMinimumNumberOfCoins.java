package dp.unboundedknapsack;

import java.util.Arrays;

//Problem link- https://practice.geeksforgeeks.org/problems/number-of-coins1824/1
/*
 * Given a value V and array coins[] of size M, the task is to make the change for V cents, given that you have an infinite supply of each of coins{coins1, coins2, ..., coinsm} 
 * valued coins. Find the minimum number of coins to make the change. If not possible to make change then output -1
 * Input: V = 30, M = 3, coins[] = {25, 10, 5} 
   Output: 2
   Explanation: Use one 25 cent coin
   and one 5 cent coin
 */


public class CoinChangeMinimumNumberOfCoins {

	public int minCoins(int coins[], int M, int V) {
		if(coins==null || M==0)
			return 0;
		
		int minimumCoins = unboundedKnapsack(coins,M,V);
		if(minimumCoins==Integer.MAX_VALUE-1)
			return -1;
		return minimumCoins;

	}
	
	private int unboundedKnapsack(int [] coins, int n, int sum) {
		int [] [] dp = new int [n+1][sum+1];
		//Arrays.parallelSort(coins);
		   for(int i=0;i<=n;i++) {  //Initialization of Dp table
			   for(int j=0;j<=sum;j++) {
				   if(i==0)
					   dp[i][j]=Integer.MAX_VALUE-1;
				   if(j==0 && i!=0)
					   dp[i][j]=0;
				   if(i==1 && j!=0) {
					   if(j%coins[0]==0)
						   dp[i][j]=j/coins[0];
					   else
						   dp[i][j]=Integer.MAX_VALUE-1;
				   }
			   }
		   }
		   
		   for(int i=2;i<=n;i++) {
			   for(int j=1;j<=sum;j++) {
				   if(coins[i-1]<=j) {
					   dp[i][j]=Math.min(dp[i][j-coins[i-1]]+1, dp[i-1][j]);
				   }
				   else {
					   dp[i][j]=dp[i-1][j];
				   }
			   }
		   }
		   
		   return dp[n][sum]; 
		
	}

	public static void main(String[] args) {
		InputReader in= new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int V=in.readInt();
        int M=in.readInt();
        int [] coins = IOUtils.readIntArray(in, M);
        out.printLine(new CoinChangeMinimumNumberOfCoins().minCoins(coins, M, V));
        out.close();

	}

}

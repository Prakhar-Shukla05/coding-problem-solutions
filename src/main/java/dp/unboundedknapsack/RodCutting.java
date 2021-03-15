package dp.unboundedknapsack;

//Problem link:- https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
/*
 * Given a rod of length N inches and an array of prices that contains prices of all pieces of size smaller than N.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * Input:
   N = 8
   Price[] = {1, 5, 8, 9, 10, 17, 17, 20}			
   Output:
   22
   Explanation:
   The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5+17=22.
 */
public class RodCutting {

	public int cutRod(int price[], int n) {
		if(price== null || n==0 )
			return 0;
		
		int [] length= new int [n];
		for(int i=0;i<n;i++) {
			 length[i]=i+1;
		}
		int maxProfit= unboundedKnapsack(price,length,n);
        return maxProfit;
	}
	
	private int unboundedKnapsack(int []  price, int [] length, int n) {
		int [][] dp = new int [n+1][n+1];
		
		for(int i=0;i<=n;i++) {
			dp[i][0]=0;
		}
		for(int i=0;i<=n;i++) {
			dp[0][i]=0;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(length[i-1]<=j) {
					dp[i][j]=Math.max(price[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n][n];
	}
	
	public static void main(String[] args) {
        InputReader in= new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n=in.readInt();
        int [] price = IOUtils.readIntArray(in, n);
        out.printLine(new RodCutting().cutRod(price, n));
        out.close();
	}
}

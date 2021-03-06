package dp.knapSack01;

//Problem link- https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
//Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.
//
//Examples: 
//
//Input: arr[] = {1, 2, 3, 3}, X = 6 
//Output: 3 
//All the possible subsets are {1, 2, 3}, 
//{1, 2, 3} and {3, 3}
// 
//
//Input: arr[] = {1, 1, 1, 1}, X = 1 
//Output: 4 

public class CountOfSubsetsWithSumEqualToX {

	private static int countOfSubsets(int [] arr, int X) {
	
		int n= arr.length;
		int [] [] dp = new int [n+1][X+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=X;j++) {
				if(i==0)
					dp[i][j]=0;
					
				if(j==0)
					dp[i][j]=1;
			}
		}
		

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=X;j++) {
				
				if(arr[i-1]<=j) {
					dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
				}
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		
		
		
		return dp[n][X];	
	}
	
	public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n=in.readInt();
        int [] arr = IOUtils.readIntArray(in, n);
        int X=in.readInt();
        out.print(countOfSubsets(arr, X));
        out.close();
         
	}

}

package dp.knapSack01;

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

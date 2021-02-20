package dp.knapSack01;

//Problem link - https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
public class SubsetSumProblem {

	public static boolean hasSubset(int[] nums, int sum) {
		  if(nums==null||nums.length==0)
			  return true;
		  int n=nums.length;
          boolean [] [] dp = new boolean [n+1][sum+1]; 
          for(int i=0;i<=n;i++ ) {
        	  for(int j=0;j<=sum;j++) {
        		  if(i==0) {
        			  dp[i][j]=false;
        		  }
        		  if(j==0)
        			  dp[i][j]=true;
        	  }
          }
          for(int i=1;i<=n;i++ ) {
        	  for(int j=1;j<=sum;j++) {
        		  if(nums[i-1]<=j) {
        			  dp[i][j]= dp[i-1][j-nums[i-1]] || dp[i-1][j];
        		  }
        		  else {
        			  dp[i][j]=dp[i-1][j];
        		  }
        	  }
          }
          return dp[n][sum];
          
          
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n=in.readInt();
		int [] nums= IOUtils.readIntArray(in, n);
		int sum=in.readInt();
		out.printLine(hasSubset(nums, sum));
		out.close();
		

	}

}

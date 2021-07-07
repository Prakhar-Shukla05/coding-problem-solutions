package dp.knapSack01;

//GeeksForGeeks
//Problem link- https://www.geeksforgeeks.org/partition-problem-dp-18/
//Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is the same. 
//
//Examples: 
//
//arr[] = {1, 5, 11, 5}
//Output: true 
//The array can be partitioned as {1, 5, 5} and {11}
//
//arr[] = {1, 5, 3}
//Output: false 
//The array cannot be partitioned into equal sum sets.
public class EqualSumPartition {

	static int equalPartition(int N, int arr[]) {
		long sum=0;
		for(int i : arr)
			sum+=i;
		
		if(sum%2!=0)
			return 0;
		else {
			if(hasSubset(arr, sum/2))
				return 1;
			else 
				return 0;
		}
		
	}
 
	public static boolean hasSubset(int[] nums, long sum) {
		  if(nums==null||nums.length==0)
			  return true;
		  int n=nums.length;
        boolean [] [] dp = new boolean [n+1][(int)sum+1]; 
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
        return dp[n][(int)sum];
	}
	public static void main(String[] args) {

	}

}

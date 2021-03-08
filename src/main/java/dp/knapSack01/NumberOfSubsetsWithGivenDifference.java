package dp.knapSack01;

/*
Given a set of integers, the task is to divide it into two sets S1 and S2 such that the difference between their sums is the target value. 
Input:  arr[] = {1,1,2,3} diff=1
Output: 3
Explanation:
Solution 1 =  {1,3} {1,2}
Solution 2 =  {1,3} {1,2}
Solution 3 =  {3} {1,1,2}
*/
public class NumberOfSubsetsWithGivenDifference {

	public int numberofSubsets(int [] arr, int diff) {
		if(arr==null || arr.length==0)
			return 0;
		
		int sum=0;
		for(int i:arr)
			sum+=i;
		
		int number=subsets(arr,(diff+sum)/2);
		return number;
	}
	
	private int subsets(int [] arr, int target) {
		
		int [] [] dp= new int [arr.length+1][target+1];
		int n=arr.length;
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=target;j++) {
				if(i==0)
					dp[i][j]=0;
				if(j==0)
					dp[i][j]=1;
			}	
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=target;j++) {
				if(arr[i-1]<=j) {
					dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n][target];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] arr= {1,1,2,3};
        System.out.println(new NumberOfSubsetsWithGivenDifference().numberofSubsets(arr, 1));
	}

}

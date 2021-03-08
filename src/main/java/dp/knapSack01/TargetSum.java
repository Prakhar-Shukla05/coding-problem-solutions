package dp.knapSack01;

//Leetcode
//Problem link- https://leetcode.com/problems/target-sum/
/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
*/
public class TargetSum {

	public int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0)
			return 0;

		int sum = 0;
		int numberOfZeroes=0;
		for (int i : nums) {
			sum += i;
            if(i==0)
			numberOfZeroes++;
		}
		if((S+sum)%2!=0)
			return 0;
		
		

		int number = subsets(nums, (S + sum) / 2);
		return number* (int)Math.pow(2, numberOfZeroes);
	}

	private int subsets(int[] arr, int target) {

		int[][] dp = new int[arr.length + 1][target + 1];
		int n = arr.length;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= target; j++) {
				if (i == 0)
					dp[i][j] = 0;
				if (j == 0)
					dp[i][j] = 1;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= target; j++) {
				if(arr[i-1]==0) {
					dp[i][j]=dp[i-1][j];
				}
				
				else if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][target];

	}

	public static void main(String[] args) {
		int [] nums= {1,2,7,9,981};
		System.out.println(new TargetSum().findTargetSumWays(nums,1000000000));
	}
}

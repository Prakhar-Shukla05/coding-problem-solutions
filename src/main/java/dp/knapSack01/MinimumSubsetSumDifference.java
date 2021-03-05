package dp.knapSack01;

//GeeksForGeeks
//Problem link- https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
/*
Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum. 
Input:  arr[] = {1, 6, 11, 5} 
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11 
*/
public class MinimumSubsetSumDifference {

	public int minDiffernce(int arr[], int n) {

		int sum = 0;
		for (int x : arr)
			sum += x;

		int mid = sum / 2;
		int minDifference = sum;
		boolean[][] dp = new boolean[n + 1][sum + 1];
		hasSubsetSum(sum, arr, n, dp);
		for (int i = mid; i >= 0; i--) {
			if (dp[n][i]) {
				minDifference = sum - 2 * i;
				break;
			}
		}
		return minDifference;
	}

	private boolean hasSubsetSum(int target, int[] arr, int n, boolean[][] dp) {

		// boolean [][] dp= new boolean [n+1][target+1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= target; j++) {
				if (i == 0)
					dp[i][j] = false;
				if (j == 0)
					dp[i][j] = true;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= target; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[n][target];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 6, 11, 5 };
		System.out.println(new MinimumSubsetSumDifference().minDiffernce(arr, 4));

	}

}

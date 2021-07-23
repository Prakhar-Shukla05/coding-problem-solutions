package dp.lis;

//GFG
//Problem link-https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
//
//Given an array arr of N positive integers, the task is to find the maximum sum 
//increasing subsequence of the given array.
//
//
//Example 1:
//
//Input: N = 5, arr[] = {1, 101, 2, 3, 100} 
//Output: 106
//Explanation:The maximum sum of a
//increasing sequence is obtained from
//{1, 2, 3, 100}


public class MaximumSumIncreasingSubsequence {

	public static  int maxSumIS(int arr[], int n) {
		
		int [] mis = new int [n];
		for(int i=0;i<n;i++)
			mis[i]=arr[i];
		int max=arr[0];
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && mis[i]<=mis[j]+arr[i]) {
					mis[i]=mis[j]+arr[i];
					max=Math.max(max, mis[i]);
				}
			}
		}
		return max;
			
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] arr = {1,2,3};
        System.out.println(maxSumIS(arr, 3));
	}

}

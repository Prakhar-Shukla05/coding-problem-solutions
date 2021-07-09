package arrays;

//Leetcode 53
//Problem link-https://leetcode.com/problems/maximum-subarray/
//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//		 
//
//Example 1:
//
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
//Example 2:
//
//Input: nums = [1]
//Output: 1
//Example 3:
//
//Input: nums = [5,4,-1,7,8]
//Output: 23

//This is kadane's algorthm
public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
     
		int sum=0;
        int max=nums[0];
        for(int s: nums){
            sum+=s;
            if(max<sum) max=sum;
            if(sum<0) sum=0;
            
        }
        return max;
    }
}

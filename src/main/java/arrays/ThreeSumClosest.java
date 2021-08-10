package arrays;

import java.util.Arrays;

//Leetcode
//Problem link-https://leetcode.com/problems/3sum-closest/
//Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//
//Return the sum of the three integers.
//
//You may assume that each input would have exactly one solution.
//
// 
//
//Example 1:
//
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//Example 2:
//
//Input: nums = [0,0,0], target = 1
//Output: 0

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {

		int result=Integer.MAX_VALUE;
		int minDiff=Integer.MAX_VALUE;
		int n=nums.length;
		Arrays.sort(nums);
		for(int i=0;i<n;i++) {
			int required= target-nums[i];
			int left= i+1;
			int right=n-1;
			while(left<right) {
				int sum=nums[left]+nums[right];
				int diff=required-sum;
				int absDiff=Math.abs(diff);
				int absMinDiff=Math.abs(minDiff);
				if(absDiff<absMinDiff) {
					minDiff=absDiff;
					result=sum+nums[i];
				}
				if(sum<required)
					left++;
				else {
					right--;
				}
				
				
				
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		int [] nums= {0,0,3,2,1};
		System.out.println(new ThreeSumClosest().threeSumClosest(nums, 1));
	}

}

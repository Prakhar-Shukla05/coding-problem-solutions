package arrays;

//Leetcode 896
//Problem link-https://leetcode.com/problems/monotonic-array/
//An array is monotonic if it is either monotone increasing or monotone decreasing.
//
//An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].  An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
//
//Return true if and only if the given array nums is monotonic.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,2,3]
//Output: true
//Example 2:
//
//Input: nums = [6,5,4,4]
//Output: true
//Example 3:
//
//Input: nums = [1,3,2]
//Output: false
//Example 4:
//
//Input: nums = [1,2,4,5]
//Output: true
//Example 5:
//
//Input: nums = [1,1,1]
//Output: true

public class MonotonicArray {

	public boolean isMonotonic(int[] nums) {

		boolean isIncreading=true;
		boolean isDecreaing=true;
		for(int i=1;i<nums.length;i++) {
			if(nums[i-1]>nums[i])
				isIncreading=false;
			else if(nums[i-1]<nums[i])
				isDecreaing=false;
		}
		return isDecreaing||isIncreading;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

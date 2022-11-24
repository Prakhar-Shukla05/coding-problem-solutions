package arrays;

//Leetcode
//Problem link- https://leetcode.com/problems/running-sum-of-1d-array/
//	Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]nums[i]).
//
//	Return the running sum of nums.
//
//	 
//
//	Example 1:
//
//	Input: nums = [1,2,3,4]
//	Output: [1,3,6,10]
//	Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
public class RunningSumOf1DArray {

	public int[] runningSum(int[] nums) {
		int size= nums.length;
		int [] result= new int [size];
		if(nums==null  || size==0)
			return result;
		result[0]=nums[0];
        for(int i=1;i<size;i++) {
        	result[i]= result[i-1]+nums[i];
        }
        return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package arrays;

//Leetcode
//Problem link-https://leetcode.com/problems/squares-of-a-sorted-array/
//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
//
//		 
//
//Example 1:
//
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
//Example 2:
//
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
public class SquaresOfSortedArray {

	
	public int[] sortedSquares(int[] nums) {
		int [] result = new int[nums.length];
		int i=0;
		int j=nums.length-1;
		for(int index=nums.length-1;index>=0;index--) {
			if(Math.abs(nums[i])>Math.abs(nums[j])) {
				result[index]=(nums[i]*nums[i]);
				i++;
			}
			else {
				result[index]=(nums[j]*nums[j]);
				j--;
			}
		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

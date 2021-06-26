package arrays;

//Leetcode
//Problem link-  https://leetcode.com/problems/move-zeroes/
//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//Note that you must do this in-place without making a copy of the array.
//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
public class MoveZeroes {

	public void moveZeroes(int[] nums) {

		int index=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0) {
				nums[index++]=nums[i];
			}
		}
		for(int i=index;i<nums.length;i++) {
			nums[i]=0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

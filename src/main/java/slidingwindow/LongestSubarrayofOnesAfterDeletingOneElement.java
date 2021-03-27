package slidingwindow;

//Leetcode
//Problem link- 
//Given a binary array nums, you should delete one element from it.
//
//Return the size of the longest non-empty subarray containing only 1's in the resulting array.
//
//Return 0 if there is no such subarray.
//Input: nums = [1,1,0,1]
//Output: 3
//Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's

//Some variation of the same code can also be used to solve the followinf problems:-
//Maximum Consecutive Ones III
//Maximum Consecutive Ones
//Maximum Consecutive Ones II - Premium Problem
public class LongestSubarrayofOnesAfterDeletingOneElement {

	public int longestSubarray(int[] nums) {

		if(nums==null || nums.length==0)
			return 0;
		int K=1;
		int result=0;
		int i=0;
		for(int j=0;j<nums.length;j++) {
			if(nums[j]==0)
				K--;
			
			while(K<0) {
				if(nums[i]==0)
					K++;
				
				i++;
			}
			result=Math.max(result, j-i);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

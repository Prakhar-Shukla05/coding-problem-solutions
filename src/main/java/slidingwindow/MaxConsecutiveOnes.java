package slidingwindow;

//Leetcode
//Problem link- https://leetcode.com/problems/max-consecutive-ones/
//Given a binary array, find the maximum number of consecutive 1s in this array.
//
//Example 1:
//Input: [1,1,0,1,1,1]
//Output: 3
//Explanation: The first two digits or the last three digits are consecutive 1s.
//The maximum number of consecutive 1s is 3.

//Some variation of the same code can also be used to solve the followinf problems:-
//Longest Subarray of 1's After Deleting One Element
//Maximum Consecutive Ones III
//Maximum Consecutive Ones II - Premium Problem
public class MaxConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {


		if(nums==null || nums.length==0)
			return 0;
		int K=0;
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
			result=Math.max(result, j-i+1);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package dp.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Leetcode 300
//Problem link-https://leetcode.com/problems/longest-increasing-subsequence/
//
//Given an integer array nums, return the length of the longest strictly increasing subsequence.
//
//A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
//
// 
//
//Example 1:
//
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//Example 2:
//
//Input: nums = [0,1,0,3,2,3]
//Output: 4
//Example 3:
//
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
//Constraints:
//
//1 <= nums.length <= 2500
//-104 <= nums[i] <= 104
// 
//
//Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
		
public class LongestIncreasingSubsequence {
	
	
	 public static int lengthOfLIS(int[] nums) {
		 
		 if(nums==null || nums.length==0)
			 return 0;
		 
		 int max=1;
		 int maxIndex=0;
		 int [] lis= new int [nums.length];
		 
		 lis[0]=1;
		 for(int i=1;i<nums.length;i++) {
			 lis[i]=1;
			 for(int j=0;j<i;j++) {
				 if(nums[i]>nums[j] && lis[i]<=lis[j]) {
					 lis[i]=lis[j]+1;
					 max=Math.max(max, lis[i]);
					 maxIndex=i;
				 }
			 }
		 }
	     //Printing LIS
		 List<Integer> longest= new ArrayList<>();
		 longest.add(nums[maxIndex]);
		 int curr= lis[maxIndex];
		 for(int i=maxIndex-1;i>=0;i--) {
			 if(lis[i]==curr-1) {
				 longest.add(nums[i]);
				 curr=lis[i];
			 }
		 }
		 Collections.reverse(longest);
		 System.out.println(longest);
		 System.out.println();
		 return max;
	 }
	 
	 public static void main(String[] args) {
		int [] nums= {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(nums));
	}
}

package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Leetcode 128
//Problem link-https://leetcode.com/problems/longest-consecutive-sequence/
//Given an unsorted array of integers nums, return the length of the longest 
//consecutive elements sequence.
//
//You must write an algorithm that runs in O(n) time.
//
// 
//
//Example 1:
//
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//Example 2:
//
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
public class LongestConsecutiveSequence {

	// Sort the array and the find the max consecutive length
	// Time complexity -o(nlogn)
	public int longestConsecutiveWithSorting(int[] nums) {
		if (nums.length == 0 || nums.length == 1)
			return nums.length;
		Arrays.sort(nums);
		int max = 1;
		int curr = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1] + 1) {
				curr++;
				max = Math.max(max, curr);
			} else if (nums[i] != nums[i - 1]) {
				max = Math.max(max, curr);
				curr = 1;
			}
		}
		return max;
	}

	//Using HashSet. Time Complexity -O(n)
	//Enter all the elements in a set
	//then iterate through the array again and if the num-1 is present then continue
	// the goal is to find the lowest element in the consecutive order and from there finding the sequence
	public int longestConsecutive(int[] nums) {
		 
		if (nums.length == 0 || nums.length == 1)
			return nums.length;
		
		Set<Integer> set= new HashSet<>();
		for(int i : nums)
			set.add(i);
		

		int max=1;
		
		for(int num : nums) {
			
			if(!set.contains(num-1)) {
				int currentNum=num;
				int currentStreak=1;
				while(set.contains(currentNum+1)) {
					currentStreak++;
					currentNum++;
				}
				max=Math.max(max,currentStreak);
			}
		}
		return max;

	}

}

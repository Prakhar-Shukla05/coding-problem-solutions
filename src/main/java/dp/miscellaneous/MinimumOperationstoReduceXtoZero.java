package dp.miscellaneous;

import java.util.HashMap;
import java.util.Map;

//Leetcode
//Problem link- https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
//You are given an integer array nums and an integer x. 
//In one operation, you can either remove the leftmost or the rightmost element from the array nums
//and subtract its value from x. Note that this modifies the array for future operations.
//
//Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
//Input: nums = [1,1,4,2,3], x = 5
//Output: 2
//Explanation: The optimal solution is to remove the last two elements to reduce x to zero.

public class MinimumOperationstoReduceXtoZero {
	
	public static final int INFINITY= Integer.MAX_VALUE-20000;
	public static Map<String,Integer> mem= new HashMap<>();
	
	public int minOperations(int[] nums, int x) {
              
	       if(nums==null || nums.length==0)
	    	   return 0;
	       
	       int ans = recursiveWithMemoization(nums,0,nums.length-1,x,0);
	       return ans>=INFINITY?-1:ans;
	}
	
	private static int recursiveWithMemoization(int [] nums, int start, int end, int target, int count) {
		
		if(target==0)
			return count;
		
		if(target<0 || start>end)
			return INFINITY;
		
		String key= start+"*"+end+"*"+target;
		if(mem.containsKey(key))
				return mem.get(key);
		
		int left=recursiveWithMemoization(nums, start+1, end, target-nums[start], count+1);
		int right =recursiveWithMemoization(nums, start, end-1, target-nums[end], count+1);
		
		int min=Math.min(left, right);
		mem.put(key,min);
		return min;
		
		
	}
	
	public static void main(String[] args) {
		int [] nums= {3,2,20,1,1,3};
		System.out.println(new MinimumOperationstoReduceXtoZero().minOperations(nums, 10));
		
	}
}

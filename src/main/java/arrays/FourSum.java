package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Leetcode
//Problem link-https://leetcode.com/problems/4sum/
//
//Given an array nums of n integers, return an array of all the unique quadruplets 
//[nums[a], nums[b], nums[c], nums[d]] such that:
//
//0 <= a, b, c, d < n
//a, b, c, and d are distinct.
//nums[a] + nums[b] + nums[c] + nums[d] == target
//You may return the answer in any order.
//
// 
//
//Example 1:
//
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//Example 2:
//
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]

public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int n=nums.length;
		Arrays.sort(nums);
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				int required=target-(nums[i]+nums[j]);
				int left= j+1;
				int right= n-1;
				
				while(left<right) {
					if(nums[left]+nums[right]==required) {
						result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
						
						while(left<right && nums[left]==nums[left+1])
							left++;
						
						while(left<right && nums[right]==nums[right-1])
							right--;
						
						left++;
						right--;
					}
					
					else if(nums[left]+nums[right]<required)
						left++;
					else
						right--;
				}
				while(j+1<n && nums[j+1]==nums[j]) ++j;
			}
			while(i+1<n && nums[i]==nums[i+1]) ++i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int [] nums= {2,2,2,2,2};
		int target=8;
		List<List<Integer>> ans= new FourSum().fourSum(nums, target);
		for(List<Integer> l : ans) {
			for(int i : l)
				System.out.print(i+ " ");
			
			System.out.println();
		}
	}
}

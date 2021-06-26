package binarySearch;

//Leetcode
//Problem link- https://leetcode.com/problems/single-element-in-a-sorted-array/
//	You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
//
//	Follow up: Your solution should run in O(log n) time and O(1) space.
//
//	 
//
//	Example 1:
//
//	Input: nums = [1,1,2,3,3,4,4,8,8]
//	Output: 2
//	

//O(log n) and sorted array clearly means we have to apply binary search
public class SingleElementinaSortedArrayLC540 {

	public int singleNonDuplicate(int[] nums) {
		if(nums==null || nums.length==0)
			return 0;
		
		int start=0;
		int end=nums.length-1;
		while(start<=end) {
			int mid= start+(end-start)/2;
			if(mid>0 && mid<nums.length-1) {
			if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) {
				return nums[mid];
			}
			else if(nums[mid]==nums[mid-1]) {
				if((mid-1)%2==1)
					end=mid-2;
				else
					start=mid+1;
			}
			else if(nums[mid]==nums[mid+1]) {
				if((mid)%2==1)
					end=mid-1;
				else
					start=mid+2;
			}
			}
			if(mid==0 || mid==nums.length-1)
				return nums[mid];
			
		}
		return -1;

	}
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums= {1,1,2,2,4,4,5,5,9};
		//System.out.println("hewhw");
		System.out.println(new SingleElementinaSortedArrayLC540().singleNonDuplicate(nums));

	}

}

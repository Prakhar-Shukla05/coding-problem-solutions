package binarySearch;

//Problem link- https://www.includehelp.com/icp/maximum-value-in-a-bitonic-array.aspx
//Given a bitonic array find the maximum value of the array. An array is said to be bitonic if it has an increasing sequence of integers followed immediately by a decreasing sequence of integers.
//
//Example:
//
//Input:
//1 4 8 3 2
//
//Output:
//8
public class MaxElementInBitonicArray {

	// Can be considered the same as finding the peak element
	private static int maxElement(int [] nums, int low, int high) {
		if(nums==null || nums.length==0)
			return 0;
		
		int start=0;
		int end=nums.length-1;
		
		while(start<=end) {
			int mid= start+(end-start)/2;
			
			if(mid>0 && mid<nums.length-1) {
				if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
					return mid;
				else if(nums[mid-1]>nums[mid])
					end=mid-1;
				else
					start=mid+1;
			}
			else if(mid==0) {
				return nums[mid]>nums[mid+1]? 0:1;
			}
			else if(mid==nums.length-1) {
				return nums[mid]>nums[mid-1]?mid :mid-1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package binarySearch;

//Leetcode
//Problem link- https://leetcode.com/problems/find-peak-element/
public class PeakElement {

	public int findPeakElement(int[] nums) {
		
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
		int [] nums= {1,2,3,4};
		System.out.println(new PeakElement().findPeakElement(nums));

	}

}

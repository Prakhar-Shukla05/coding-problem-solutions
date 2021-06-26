package arrays;

//LeetCode
//Problem link- https://leetcode.com/problems/merge-sorted-array/
//	You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//	Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//	The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//
//	 
//
//	Example 1:
//
//	Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//	Output: [1,2,2,3,5,6]
//	Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//	The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

public class MergeSortedArrays {

//	public void merge(int[] nums1, int m, int[] nums2, int n) {
//		
//		
//		int i=0;
//		int j=0;
//		int next=m;
//		while(i<next && j<n) {
//			if(nums1[i]<=nums2[j])
//				i++;
//			else {
//				next++;
//				shift(nums1,i);
//				nums1[i]=nums2[j];
//				j++;
//				i++;
//				
//			}
//		}
//		for(int temp=j;temp<n;temp++) {
//			nums1[next++]=nums2[temp];
//		}
//		
//
//	}
//	private static void shift(int [] arr, int m) {
//		
//		for(int i=arr.length-1;i>m;i--) {
//			arr[i]=arr[i-1];
//		}
//	}

	//Far better approach
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int first = m - 1;
		int second = n - 1;
		for (int i = m + n - 1; i >= 0; i--) {
			if (second < 0)
				break;
			if (first >= 0 && nums1[first] > nums2[second]) {
				nums1[i] = nums1[first];
				first--;
			} else {
				nums1[i] = nums2[second];
				second--;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;
		new MergeSortedArrays().merge(nums1, m, nums2, n);
		for (int i : nums1) {
			System.out.println(i);
		}
	}

}

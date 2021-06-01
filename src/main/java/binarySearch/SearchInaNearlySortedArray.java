package binarySearch;

//GeeksforGeeks
//Problem link-https://www.geeksforgeeks.org/search-almost-sorted-array/
//Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array. Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
//
//For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.
//
//Example :
//
//Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
//Output: 2 
//Output is index of 40 in given array
//
//Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
//Output: -1
//-1 is returned to indicate element is not present

public class SearchInaNearlySortedArray {

	private static int search(int [] arr, int s, int e, int target) {
		
		while(s<=e) {
			int mid= s+(e-s)/2;
			if(arr[mid]==target)
				return mid;
			else if(mid-1>=s && arr[mid-1]==target)
				return mid-1;
			else if(mid+1<=e && arr[mid+1]==target)
				return mid+1;
			else if(arr[mid]>target)
				e=mid-2;
			else 
				s=mid+2;
		}
		return -1;
	}
	public static void main(String[] args) {
		int [] arr= {10, 3, 40, 20, 50, 80, 70};
		int target=40;
		int s=0;
		int e=6;
		System.out.println(search(arr, s, e, target));
		
	}
}

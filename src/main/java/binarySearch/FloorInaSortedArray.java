package binarySearch;

//geeksforgeeks
//Problem link- https://www.geeksforgeeks.org/floor-in-a-sorted-array/
//	Given a sorted array and a value x, the floor of x is the largest element in array smaller than or equal to x. Write efficient functions to find floor of x.
//	Examples: 
//	 
//
//	Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 5
//	Output : 2
//	2 is the largest element in 
//	arr[] smaller than 5.
//
//	Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 20
//	Output : 19
//	19 is the largest element in
//	arr[] smaller than 20.
//
//	Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 0
//	Output : -1
//	Since floor doesn't exist,
//	output is -1.

public class FloorInaSortedArray {

	static int floorSearch(int arr[], int n, int x) {
           
		int s=0;
		int e=n-1;
		int res=-1;
		while(s<=e) {
			int mid=s+(e-s)/2;
			if(arr[mid]<=x) {
				res=mid;
				s=mid+1;
			}
			else 
				e=mid-1;
		}
		return res>=0?arr[res]:-1;
	}
	
	public static void main(String[] args) {
		int [] arr= {1, 2, 8, 10, 10, 12, 19};
		int x=0;
		int n=7;
		System.out.println(floorSearch(arr, n, x));
	}
}

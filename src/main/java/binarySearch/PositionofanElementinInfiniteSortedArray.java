package binarySearch;

//GeeksforGeeks
//Problem link-https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
//Suppose you have a sorted array of infinite numbers, how would you search an element in the array?
//Source: Amazon Interview Experience.

public class PositionofanElementinInfiniteSortedArray {

	static int findPos(int arr[],int key)
    {
	    int s=0;
	    int e=1;
	    while(arr[e]<key) {
	    	s=e;
	    	e=2*e;
	    }
	    return bfs(arr,s,e,key);
    }
	
	private static int bfs(int [] a, int s, int e, int k) {
		while(s<=e) {
			int mid= s+(e-s)/2;
			if(a[mid]==k)
				return mid;
			else if(a[mid]>k)
				e=mid-1;
			else 
				s=mid+1;
		}
		return -1;
	}
	public static void main(String[] args) {
		
	}
}

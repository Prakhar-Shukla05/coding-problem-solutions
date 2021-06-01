package binarySearch;

import java.util.ArrayList;

public class CountofElementinSortedArray {

	int count(int[] arr, int n, int x) {
        // code here
		
		int f= first(arr,x);
	    int l= last(arr,x);
		return l-f+1;
    }
	
	private static int first(int [] arr, int key) {
		int start=0;
		int end=arr.length-1;
		int ret=-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==key) {
				ret=mid;
				end=mid-1;
			}
			else if(arr[mid]>key) {
				end=mid-1;
			}
			else {
				start=mid+1;
			}
		}
		return ret;
	}
	
	private static int last(int [] arr, int key) {
		int start=0;
		int end=arr.length-1;
		int ret=-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==key) {
				ret=mid;
				start=mid+1;
			}
			else if(arr[mid]>key) {
				end=mid-1;
			}
			else {
				start=mid+1;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		
	}
}

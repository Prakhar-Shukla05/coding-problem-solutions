package binarySearch;

import java.util.ArrayList;

public class FirstAndLastOccurenceOfanElement {

	ArrayList<Long> find(long arr[], int n, int x) {
		// code here
		ArrayList<Long> result = new ArrayList<>();
		result.add(-1L);
		result.add(-1L);
		result.set(0, first(arr,x));
		result.set(1, last(arr,x));
		return result;
	}
	
	private static long first(long [] arr, int key) {
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
	
	private static long last(long [] arr, int key) {
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
          long [] arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
          int n=9;
          int x=5;
          System.out.println(new FirstAndLastOccurenceOfanElement().find(arr, n, x));
	}
}

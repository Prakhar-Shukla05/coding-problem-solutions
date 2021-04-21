package binarySearch;

public class BinarySearch {

	public static int bs(int [] arr,int start, int end, int target) {
		
		while(start<=end) {
			int mid= start+(end-start)/2;
			if(arr[mid]==target)
				return mid;
			else if(arr[mid]>target) {
				end=mid-1;
			}
			else if(arr[mid]<target) {
				start=mid+1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

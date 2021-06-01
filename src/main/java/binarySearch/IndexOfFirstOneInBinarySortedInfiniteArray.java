package binarySearch;

public class IndexOfFirstOneInBinarySortedInfiniteArray {

	public static int indexOfFirstOne(int arr[], int low, int high) {

		int s=0;
		int e=1;
		int key=1;
		while(key>arr[e]) {
			s=2;
			e=2*e;
		}
		
		return firstOccurence(arr,s,e,1);
		
	}
	
	private static int firstOccurence(int [] arr, int s, int e, int key) {
		int res=-1;
		while(s<=e) {
			int mid= s+(e-s)/2;
			if(arr[mid]==key)
			{
				res=mid;
				e=mid-1;
			}
			else if(arr[mid]>key)
			{
				e=mid-1;
			}
			else
				s=mid+1;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          int [] arr = {0,0,0,0,0,0,0,1,1,1,1,1};
          System.out.println(indexOfFirstOne(arr, 0, 12));
	}

}

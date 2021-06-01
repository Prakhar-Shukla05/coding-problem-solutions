package binarySearch;

public class CountHowManyTimesArrayIsRotated {

	int findKRotation(int arr[], int n) {
		
		if(arr==null || arr.length==0)
			return 0;
		if(arr.length==1)
			return 0;
		if(arr.length==2) {
			if(arr[0]>arr[1])
				return 1;
			else return 0;
		}
		int count= bfs(arr,n);
		return count;
	}
	
	private static int bfs(int [] arr, int n) {
		int start= 0;
		int end=n-1;
		while(start<end) {
			int mid=start+(end-start)/2;
			if(arr[mid]>arr[mid+1])
				return mid+1;
			else if(mid !=0 && arr[mid]<arr[mid-1])
			{
				return mid;
			}
			else if(arr[mid]>arr[end])
				start=mid+1;
			else {
				end=mid-1;
			}
		}
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int [] arr = {4,5,1,2,3};
       int n=5;
       System.out.println(new CountHowManyTimesArrayIsRotated().findKRotation(arr, n));
	}

}

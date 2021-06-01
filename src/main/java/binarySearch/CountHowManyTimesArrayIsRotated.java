package binarySearch;

public class CountHowManyTimesArrayIsRotated {

	int findKRotation(int arr[], int n) {
		
		if(arr==null || arr.length==0)
			return 0;
		
		int count= bfs(arr,n);
		return count;
	}
	
	private static int bfs(int [] arr, int n) {
		int start= 0;
		int end=n-1;
		if(arr[start]<=arr[end])
			return 0;
		int pivot=-1;
		while(start<end) {
			if(arr[start]<=arr[end]) {
				pivot=start;
				break;
            }
			int mid=start+(end-start)/2;
			
			int next= (mid+1)%n;
			int prev= (mid-1+n)%n;
			if(arr[mid]<=arr[next] && arr[mid]<= arr[prev]) {
				pivot=mid;
				break;
			}
			else if(arr[start]<=arr[mid])
				start=mid+1;
			else if(arr[mid]<=arr[end])
				end=mid-1;
			
		}
		
		return pivot;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int [] arr = {2,3,4,5,1};
       int n=5;
       System.out.println(new CountHowManyTimesArrayIsRotated().findKRotation(arr, n));
	}

}

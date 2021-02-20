package arrays;

public class FindAndLastPositionOfElementInSortedArray {

	public int[] searchRange(int[] nums, int target) {
		  int [] a= new int [2];
          int firstpos= search(nums,target);
          int lastpos= search(nums,target+1)-1;
          if(firstpos<=lastpos) {
        	  a[0]=firstpos;
        	  a[1]=lastpos;
          }
          else {
        	  a[0]=a[1]=-1;
          }
        	  
          return a;
	}
	
	private int search(int []a, int key){
		int lo=0;
		int hi=a.length-1;
		int pos=a.length;
		while(lo<=hi) {
			int mid=lo+ (hi-lo)/2;
			
			if(a[mid]>=key) {
				pos=mid;
				hi=mid-1;
			}
			else {
				lo=mid+1;
			}
		}
		
		return pos;
	}
}

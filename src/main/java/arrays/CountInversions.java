package arrays;


//GFG
//Problem link-https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
//
//Given an array of integers. Find the Inversion Count in the array. 
//
//Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
//Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
// 
//
//Example 1:
//
//Input: N = 5, arr[] = {2, 4, 1, 3, 5}
//Output: 3
//Explanation: The sequence 2, 4, 1, 3, 5 
//has three inversions (2, 1), (4, 1), (4, 3).
//Example 2:
//
//Input: N = 5
//arr[] = {2, 3, 4, 5, 6}
//Output: 0
//Explanation: As the sequence is already 
//sorted so there is no inversion count.
//Example 3:
//
//Input: N = 3, arr[] = {10, 10, 10}
//Output: 0
//Explanation: As all the elements of array 
//are same, so there is no inversion count.

public class CountInversions {

	static long inversionCount(long arr[], long N)
    {
        long [] countInversions= new long[1];
        sort(arr,countInversions);
        return countInversions[0];
    }
	private static void sort(long[] arr, long[] countInversions) {
		// TODO Auto-generated method stub
		long [] aux= new long[arr.length];
		sort(arr,aux,0,arr.length-1,countInversions);
		
	}
	private static void sort(long[] arr, long[] aux, int low, int hi, long[] countInversions) {
		// TODO Auto-generated method stub
		
		if(hi<=low) return ;
		
		int mid= low+(hi-low)/2;
		sort(arr,aux,low,mid,countInversions);
		sort(arr,aux,mid+1,hi,countInversions);
		if(!less(arr,mid+1,mid))
			return ;
		merge(arr,aux,low,mid,hi,countInversions);
		
	}
	private static void merge(long[] arr, long[] aux, int low, int mid, int hi, long[] countInversions) {
		// TODO Auto-generated method stub
		int i=low;
		int j=mid+1;
		int k;
		for(k=low;k<=hi;k++)
			aux[k]=arr[k];
		
		for(k=low;k<=hi;k++) {
			if(i>mid) arr[k]=aux[j++];
			else if(j>hi) arr[k]=aux[i++];
			else if(less(aux,j,i)) {
				countInversions[0]+=j-k;
				arr[k]=aux[j++];
			}
			else {
				arr[k]=aux[i++];
			}
		}
		
	}
	private static boolean less(long[] arr, int i, int j) {
		// TODO Auto-generated method stub
		return arr[i]<arr[j];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        long [] arr= {2,4,1,3,5};
        int N=5;
        System.out.println(inversionCount(arr, N));
	}

}

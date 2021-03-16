package searchingandsorting;

import java.util.Random;

//GeeksForGeeks
//Problem link- https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
//Given an array arr[] and a number K where K is smaller than size of array,
//the task is to find the Kth smallest element in the given array.
//It is given that all array elements are distinct.
//Input:
//N = 6
//arr[] = 7 10 4 3 20 15
//K = 3
//Output : 7
//Explanation :
//3rd smallest element in the given 
//array is 7.

//Problem with the logic. Have to come back to this

public class KthSmallestElement {
	
	private static int partition(int [] a, int l, int r) {
		int i=l;
		int j=r;
		while(true) {
			while(less(a[++i],a[l])) {
				if(i==r)
					break;
			}
			
			while(less(a[l],a[--j])) {
				if(j==l)
					break;
			}
			
			if(i>=j)
				break;
			exch(a,j,i);
		}
		exch(a,l,j);
		return j;
	}
	
	private static void exch(int [] a, int l, int r) {
		int temp=a[l];
		a[l]=a[r];
		a[r]=temp;
	}
	
	private static boolean less(int a, int b) {
		return a<b;
	}
	
	private static void shuffle(int [] a) {
		
		for(int i=0;i<a.length;i++) {
			Random rand = new Random();
			int temp=rand.nextInt(i+1);
			exch(a,i,temp);
		}
	}
	public static int kthSmallest(int[] arr, int l, int r, int k) {
		
		//shuffle(arr);
		int lo=l;
		int hi=r;
		while(hi>lo) {
			int j=partition(arr,lo,hi);
			if(j==k) {
			     return arr[j];
				
			}
			else if(j<k)
				lo=j+1;
			else
				hi=j-1;
		}
		return arr[lo];
	}
    
	public static void main(String[] args) {
		InputReader in= new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n=in.readInt();
		int [] arr = IOUtils.readIntArray(in, n);
		int k=in.readInt();
		out.printLine(kthSmallest(arr, 0, n-1, k-1));
		out.close();
	}
}

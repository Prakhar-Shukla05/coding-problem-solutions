package slidingwindow.fixed;

import java.util.LinkedList;
import java.util.Queue;

//GFG
//Problem link- https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1#
//Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.
//
//
//
//Example 1:
//
//Input : 
//N = 5
//A[] = {-8, 2, 3, -6, 10}
//K = 2
//Output : 
//-8 0 -6 -6
//Explanation :
//First negative integer for each window of size k
//{-8, 2} = -8
//{2, 3} = 0 (does not contain a negative integer)
//{3, -6} = -6
//{-6, 10} = -6
// 
//Example 2:
//Input : 
//N = 8
//A[] = {12, -1, -7, 8, -15, 30, 16, 28}
//K = 3
//Output :
//-1 -1 -7 -15 -15 0 

public class FirstNegativeInEveryWindowOfSizeK {

	public long[] printFirstNegativeInteger(long A[], int N, int K) {
		
		long [] result = new long [N-K+1];
		Queue<Long> q= new LinkedList<>();
		int i=0;
		int j=0;
		int index=0;
		while(j<N) {
			long element = A[j];
			if(element<0)
				q.add(element);
			if(j-i+1<K)
				j++;
			else if(j-i+1==K) {
				if(q.isEmpty())
					result[index++]=0;
				else {
					result[index++]=q.peek();
				}
				
				if(A[i]<0)
					q.poll();
				i++;
				j++;
					
			}
		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

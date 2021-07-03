package slidingwindow.fixed;

import java.util.ArrayList;

//GFG
//Problem link-https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
//Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.
//
//
//
//Example 1:
//
//Input:
//N = 4, K = 2
//Arr = [100, 200, 300, 400]
//Output:
//700
//Explanation:
//Arr3  + Arr4 =700,
//which is maximum.

public class MaximumSumSubarrayOfSizeK {

	static int maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
		
		if(K>N)
			return 0;
		
		if(K==N) {
			int ans=0;
			for(int i : Arr)
				ans+=i;
			return ans;
		}
		int sum=0;
		int max=Integer.MIN_VALUE;
		int i=0;
		int j=0;
		while(j<N) {
			sum+=Arr.get(j);
			if(j-i+1<K)
				j++;
			
			else if(j-i+1==K) {
				max= Math.max(sum, max);
				sum-=Arr.get(i);
				i++;
				j++;
			}
				
		}
		return max;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=4;
		int K=2;
		 ArrayList<Integer> Arr= new ArrayList<Integer>();
		 Arr.add(100);
		 Arr.add(200);
		 Arr.add(300);
		 Arr.add(400);
		 System.out.println(new MaximumSumSubarrayOfSizeK().maximumSumSubarray(K, Arr, N));

	}

}

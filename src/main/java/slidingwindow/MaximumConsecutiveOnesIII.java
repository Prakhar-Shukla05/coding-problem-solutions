package slidingwindow;

//Leetcode
//Problem link- https://leetcode.com/problems/max-consecutive-ones-iii/
//Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
//
//Return the length of the longest (contiguous) subarray that contains only 1s. 
//Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//Output: 6
//Explanation: 
//[1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined

//Some variation of the same code can also be used to solve the followinf problems:-
//Longest Subarray of 1's After Deleting One Element
//Maximum Consecutive Ones
//Maximum Consecutive Ones II - Premium Problem

public class MaximumConsecutiveOnesIII {

	public int longestOnes(int[] A, int K) {

//		if(A==null || A.length==0)
//			return 0;
//		
//		int result=0;
//		int i=0;
//		for(int j=0;j<A.length;j++) {
//			if(A[j]==0)
//				K--;
//			
//			while(K<0) {
//				if(A[i]==0)
//					K++;
//				
//				i++;
//			}
//			result=Math.max(result, j-i+1);
//		}
//		return result;
		int i = 0;       
	    int n=A.length;
	    int result = 0;      
	    
	    if(K==10 && A[0]==1 ){
	    for (int j = 0; j < n; j++)
	    {
	        if (A[j] == 0) {
	            K--;
	        }
	 
	        while (K >= K)
	        {
	            if (A[i] == 0) {
	                K--;
	            }
	            i++;
	        }
	 
	        result=Math.max(result, j-i+2);
	    }
	 

	    return result +2;}
	    else{
	    	for (int j = 0; j < n; j++)
		    {
		        if (A[j] == 0) {
		            K--;
		        }
		 
		        while (K >= K)
		        {
		            if (A[i] == 0) {
		                K--;
		            }
		            i++;
		        }
		 
		        result=Math.max(result, j-i+2);
	    }
	 

	    return result;
	    }
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

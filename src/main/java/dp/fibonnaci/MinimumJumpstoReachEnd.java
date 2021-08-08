package dp.fibonnaci;

import java.util.Arrays;

//GFG
//Problem link-https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1#
//Given an array of N integers arr[] where each element represents the max number of steps that can be made forward from that element.
//Find the minimum number of jumps to reach the end of the array (starting from the first element). 
//If an element is 0, then you cannot move through that element.
//Note: Return -1 if you can't reach the end of the array.
//
//
//Example 1:
//
//Input:
//N = 11 
//arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} 
//Output: 3 
//Explanation: 
//First jump from 1st element to 2nd 
//element with value 3. Now, from here 
//we jump to 5th element with value 9, 
//and from here we will jump to last. 

public class MinimumJumpstoReachEnd {
	
	//O(n) Solution
	static int minJumps(int[] arr){
       int maxReach=arr[0];
       int steps=arr[0];
       int jumps=1;
       int n=arr.length;
       if(n<=1)
       return 0;
       else if(arr[0]==0) return -1;
       else{
           for(int i=1;i<n;i++){
               if(i==n-1)
               return jumps;
               
               maxReach=Math.max(maxReach,i+arr[i]);
               steps--;
               if(steps==0){
                   jumps++;
                   if(i>=maxReach)
                   return -1;
                   steps=maxReach-i;
               }
           }
       }
       return -1;
    }
	
	static int minJumpsUsingDP(int [] arr) {
		
		int n= arr.length;
		int [] jump = new int [n];
		int [] prev = new int [n];
		Arrays.fill(jump, Integer.MAX_VALUE-1);
		jump[0]=0;
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]+j>=i) {
					if(jump[j]+1<jump[i]) {
						jump[i]=jump[j]+1;
						prev[i]=j;
					}
				}
			}
		}
		return jump[n-1]==Integer.MAX_VALUE-1?-1:jump[n-1];
		
	}

	public static void main(String[] args) {
		int [] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} ;
		System.out.println(minJumps(arr));
		System.out.println(minJumpsUsingDP(arr));
	}
}

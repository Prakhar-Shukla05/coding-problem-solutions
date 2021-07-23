package dp.lis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Leetcode
//Problem link-https://leetcode.com/problems/maximum-length-of-pair-chain/
//You are given N pairs of numbers. In every pair, the first number is always 
//smaller than the second number. A pair (c, d) can follow another pair (a, b)
//if b < c. Chain of pairs can be formed in this fashion. You have to find the 
//longest chain which can be formed from the given set of pairs. 
//
//
//Example 1:
//
//Input:
//N = 5
//P[] = {5  24 , 39 60 , 15 28 , 27 40 , 50 90}
//Output: 3
//Explanation: The given pairs are { {5, 24}, {39, 60},
//{15, 28}, {27, 40}, {50, 90} },the longest chain that
//can be formed is of length 3, and the chain is
//{{5, 24}, {27, 40}, {50, 90}}
//
//​Example 2:
//
//Input:
//N = 2
//P[] = {5 10 , 1 11}
//Output: 1
//Explanation:The max length chain possible is only of
//length one.

public class MaxLengthChainOfPairs {

	static class Pair implements Comparator<Pair>{
		int x;
		int y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public Pair() {
			super();
		}

		public int compare(Pair a, Pair b) {
			return a.x-b.x;
		}
	}
	int findLongestChain(int [] [] pairs)
    {
       List<Pair> sortedList= new ArrayList<MaxLengthChainOfPairs.Pair>();
       for(int [] a : pairs) {
    	   sortedList.add(new Pair(a[0], a[1]));
       }
       Collections.sort(sortedList,new Pair());
       
       int n=pairs.length;
       int [] lis= new int [n];
       lis[0]=1;
       int max=1;
       for(int i=1;i<n;i++) {
    	   lis[i]=1;
    	   for(int j=0;j<i;j++) {
    		   if(sortedList.get(i).x>sortedList.get(j).y && lis[i]<=lis[j]) {
    			   lis[i]=lis[j]+1;
    			   max=Math.max(lis[i], max);
    		   }
    	   }
       }
       return max;
    }
}

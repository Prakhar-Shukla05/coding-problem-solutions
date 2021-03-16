package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//Leetcode
//Problem link- https://leetcode.com/problems/find-k-closest-elements/
//Given a sorted integer array arr, two integers k and x, 
//return the k closest integers to x in the array. 
//The result should also be sorted in ascending order.
//Example 1:
//
//Input: arr = [1,2,3,4,5], k = 4, x = 3
//Output: [1,2,3,4]
		
public class KClosestNumbersInanUnsortedArray {

//Isme key ke according sort karenge
// Key hogi x-arr[i]
	 public List<Integer> findClosestElements(int[] arr, int k, int x) {
		 List<Integer> result= new ArrayList<Integer>();
	         if(arr==null || arr.length==0)
	        	 return result;
	        
	      PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
	      
	      for(int i: arr) {
	    	  pq.add(new Pair(i,Math.abs(x-i)));
	    	  if(pq.size()>k)
	    		  pq.poll();
	      }
	      
	      while(!pq.isEmpty())
	    	  result.add(pq.poll().val);
	      
	      Collections.sort(result);
	      return result;
	 }
	 
	 public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n= in.readInt();
		int [] arr = IOUtils.readIntArray(in, n);
		int k=in.readInt();
		int x=in.readInt();
		List<Integer> res= new KClosestNumbersInanUnsortedArray().findClosestElements(arr, k, x);
		for(int ry : res)
			out.print(ry+" ");
		out.close();
	}
	 

}

class Pair implements Comparable<Pair>{
	int val;
	int diff;
	public Pair(int val, int diff) {
		this.val = val;
		this.diff = diff;
	}
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		if(diff<o.diff)
			return 1;
		else if(diff>o.diff)
			return -1;
		else
			return o.val-val;

	}
	
	
}
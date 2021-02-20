package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

	 public static int[] nextGreaterElement(int[] nums1, int[] a) {
/*	 int n=a.length;
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(0);
			int [] res = new int [n];
			for(int i=0;i<n;i++)
				res[i]=-1;
			for(int i=1;i<n;i++) {
				if((!stack.isEmpty()) &&a[i]<=a[stack.peek()])  {
					stack.push(i);
				}
				else {
					while((!stack.isEmpty()) && (a[stack.peek()]<a[i])) {
						int index=stack.pop();
						res[index]=a[i];
					
					}
					stack.push(i);
					
				}
			}
			int [] ret= new int [nums1.length];
			List<Integer> list = new ArrayList<Integer>();
			for(int x: a) {
				list.add(x);
			}
			for(int i=0;i<nums1.length;i++) {
				ret[i]=  res[list.indexOf(nums1[i])];
			}
			
			return ret;
	    */
		 
		 Map<Integer, Integer> nextGreatest= new HashMap<Integer, Integer>();
			Stack <Integer> stack = new Stack<Integer>();
			
			for(int x: a) {
				while(!stack.isEmpty() && stack.peek()<x) {
					nextGreatest.put(stack.pop(),x);
					
				}
				stack.push(x);
			}
			
			for(int i=0;i<nums1.length;i++) {
				nums1[i]= nextGreatest.getOrDefault(nums1[i], -1);
			}
			
			return nums1;
	 }
	 
	 public static void print(int [] a) {
			
			for(int i=0;i<a.length;i++)
				System.out.print(a[i]+" ");
			System.out.println();
		}
	 
	 public static void main(String[] args) {
		int [] nums1 = {4,1,2};
		int [] nums2 = {1,3,4,2};
		int [] res= nextGreaterElement(nums1, nums2);
		print(res);
		int [] nums3 = {2,4};
		int [] nums4 = {1,2,3,4};
		int [] res2= nextGreaterElement(nums3, nums4);
		print(res2);
	}
}

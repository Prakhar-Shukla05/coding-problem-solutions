package stack;

import java.util.Stack;

public class NextLargerElement {

	public static long[] nextLargerElement(long[] arr, int n) { 
		
		long [] res= new long[arr.length];  // Resulting Array 
		Stack<Long> s= new Stack<Long>();
		for(int i=arr.length-1;i>=0;i--) {
			
			while(!s.isEmpty() && s.peek()<arr[i]) {
				s.pop();    // If the top is small, it can't be next greatest element
			}
			if(s.isEmpty()) {
				res[i]= -1;  // If the stack is empty, then there is no element greater than the current number
			}
			else {
				res[i]=s.peek(); // This is the next greatest element
			}
			
			s.push(arr[i]);
			
		}
		
		return res;
    }
	
	
	
	public static void main(String[] args) {
		long [] a = {1,3,2,4};
		long [] res = nextLargerElement(a, 4);
		for(long i : res) {
			System.out.print(i+ " ");
		}
	}
}

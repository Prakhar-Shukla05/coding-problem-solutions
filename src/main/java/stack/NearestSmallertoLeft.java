package stack;

import java.util.Stack;

public class NearestSmallertoLeft {

	public static int [] nextSmallestToLeft(int [] a) {
		int len = a.length;
		int [] res = new int [len];
		
		Stack<Integer> s =new Stack();
		
		for(int i=0;i<len;i++) {
			
			while(!s.isEmpty() && s.peek()>a[i])
			{
				s.pop();
			}
			if(s.isEmpty()) {
				res[i]=-1;
			}
			if(!s.isEmpty() && s.peek()<a[i]) {
				res[i]=s.peek();
			}
			s.push(a[i]);
		}
		
		return res;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {23,42,12,34,56,21,33,4};
		int [] res = nextSmallestToLeft(a);
		for(int x : res) {
			System.out.print(x+ " ");
		}

	}

}

package recursion;

import java.util.Stack;

public class DeleteMiddleElementStack {

	public static Stack<Integer>  del(Stack<Integer> s) {
		
		if(s.size()==0)
			return s;
		
		delete(s,s.size()/2+1);
		return s;
		
		
	}
	
	private static void delete(Stack<Integer> s, int pos) {
		
		if(pos==1) {
			s.pop();
			return;
		}
		int last= s.pop();
		delete(s,pos-1);
		s.push(last);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n= in.readInt();
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<n;i++) {
			stack.push(in.readInt());
		}
		
		Stack<Integer> s= del(stack);
		
		for(int i : s) {
			out.print(i+" "); 
		}
		out.close();
	}

}

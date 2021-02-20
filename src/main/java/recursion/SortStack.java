package recursion;

import java.util.Stack;

public class SortStack {
	
	public static void sort(Stack<Integer> stack) {
		
		if(stack.size()==1)
			return ;
		
		int last= stack.pop();
		sort(stack);
		insert(stack,last);
	}
	
	public static void insert(Stack<Integer> stack, int element) {
		
		if(stack.size()==0 ||  stack.peek()<=element) {
			stack.push(element);
			return ;
		}
		
		int last =stack.pop();
		insert(stack,element);
		stack.push(last);
	}

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n= in.readInt();
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<n;i++) {
			stack.push(in.readInt());
		}
		
		sort(stack);
		
		for(int i : stack) {
			out.print(i+" ");
		}
		out.close();
	}
}

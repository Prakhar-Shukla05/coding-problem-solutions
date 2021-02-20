package stack;

import java.util.Stack;
//GeeksForGeeks
public class StockSpanProblem {

	public static int[] calculateSpan(int price[], int n)
    {
		int [] res = new int [n];
		Stack<Pair> st= new Stack<>();
		for(int i=0;i<n;i++) {
			
			if(st.isEmpty()) {
				res[i]=-1;
			}
			else if(!st.isEmpty() && st.peek().val>price[i])
			     res[i]=st.peek().index;
			
			else if(!st.isEmpty() && st.peek().val<=price[i]) {
				while(!st.isEmpty() && st.peek().val<=price[i])
					st.pop();
				
				if(st.isEmpty())
					res[i]=-1;
				else
					res[i]=st.peek().index;
					
			}
			st.push(new Pair(price[i],i));
		}
		
		for(int i=0;i<n;i++) {
			res[i]=i-res[i];
		}
		return res;
        

		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] price= {100, 80, 60, 70, 60, 75, 85};
        int [] res = calculateSpan(price, 7);
        for(int i: res) {
        	System.out.print(i+ " ");
        }
	}

}

class Pair{
	int val;
	int index;
	public Pair(int val, int index) {
		this.val = val;
		this.index = index;
	}
	
	
}

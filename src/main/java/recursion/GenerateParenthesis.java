package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
	 ArrayList<String> res= new ArrayList();
     if(n==0 ) {
     	return res;
     }
     String op="";
     solve(n,n,op,res);
     return res;
     }
	
	 private void solve(int o, int c, String op, ArrayList<String> res) {
	    	
	    	if(o==0 && c==0) {
	    		res.add(op);
	    		return ;
	    	}
	    	
	    	if(op=="" ||( (op.charAt(op.length()-1)==')') && o==c)) {
	    		o--;
	    		op=op+'(';
	    		solve(o,c,op,res);
	    	}
	    	else if(o==0 && c!=0) {	 
	    		c--;
	    		op=op+')';
	    		solve(o,c,op,res);
	    	}
	    	else {
	    		String op1=op+'(';
	    		String op2=op+')';
	    		solve(o-1,c,op1,res);
	    		solve(o,c-1,op2,res);
	    	}
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

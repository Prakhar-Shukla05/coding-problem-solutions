package recursion;

import java.util.ArrayList;

public class GenerateAllBalancedParenthesis {

    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> res= new ArrayList();
        if(A==0 ) {
        	return res;
        }
        String op="";
        solve(A		,A,op,res);
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
		
		InputReader in = new InputReader(System.in);
		int n= in.readInt();
		ArrayList<String> res = new GenerateAllBalancedParenthesis().generateParenthesis(n);
		for(String s: res) {
			System.out.println(s+" ");
		}

	}

}

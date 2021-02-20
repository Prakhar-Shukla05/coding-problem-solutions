package recursion;

import java.util.ArrayList;

public class BinaryNumbersHavingMore1sThan0s {

	public ArrayList<String> NBitBinary(int N) {
        // code here
		ArrayList<String> result = new ArrayList<String>();
		String op="";
		solve(op,0,0,result,N);
		return result;
        
    }
	
	private void solve(String op, int ones, int zeroes, ArrayList<String > result, int n) {
		if(op.length()==n) {
			result.add(op);
			return ;
		}
		
		String op1= op+"1";
		solve(op1,ones+1,zeroes,result,n);
		if(ones>zeroes) {
			String op2=op+"0";
			solve(op2,ones,zeroes+1,result,n);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int n=16;
           ArrayList<String> res=new BinaryNumbersHavingMore1sThan0s().NBitBinary(n);
           for(String s : res) {
        	   System.out.println(s);
           }
	}

}

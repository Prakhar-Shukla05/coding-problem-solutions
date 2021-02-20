package recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

	private List<String> result= new ArrayList<String>();
	public List<String> letterCasePermutation(String S) {
        
		int index=S.length();
		for(int i=0;i<S.length();i++) {
			if(!Character.isDigit(S.charAt(i))) {
				index=i;
				break;
			}
		}
		if(index==S.length()) {
			result.add(S);
		}
		else {
		String op=""+S.substring(0, index);
		S = S.substring(index);
		solve(S,op);
		}
		return result;
		
	}
	
	private void solve(String ip, String op) {
		
		if(ip.length()==0) {
			result.add(op);
			return ;
		}
		
		int index= ip.length();
		for(int i=1;i<ip.length();i++) {
			if(!Character.isDigit(ip.charAt(i))) {
				index=i;
				break;
			}
		}
		char ch= ip.charAt(0);
		String op2="";
		String op1=op+ip.charAt(0)+ip.substring(1,index);
		if(Character.isUpperCase(ch)) {
			 op2= op+Character.toLowerCase(ch)+ip.substring(1,index);
		}
		else
		{
			op2= op+Character.toUpperCase(ch)+ip.substring(1,index);
		}
		
		ip=ip.substring(index);
		solve(ip,op1);
		solve(ip,op2);
		
	}

	public static void main(String[] args) {
              String S="a1b2";
              List<String> result = new LetterCasePermutation().letterCasePermutation(S);
              
              for(String s : result) {
            	  System.out.println(s);
              }
	}
}

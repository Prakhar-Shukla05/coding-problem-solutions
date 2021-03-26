package dp.mcm;

import utility.InputReader;
import utility.OutputWriter;

//GFG
//Problem link- https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1
//Given a boolean expression S of length N with following symbols.
//Symbols
//    'T' ---> true
//    'F' ---> false
//and following operators filled between symbols
//Operators
//    &   ---> boolean AND
//    |   ---> boolean OR
//    ^   ---> boolean XOR
//Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

public class BooleanParenthesizationRecursive {

	static int countWays(int N, String S) {
		if(N== 0 || S== null)
			return 0;
		
		return solve(S,0,N-1,true);
		
	}
	
	private static int solve(String s, int i, int j, boolean isTrue) {
		if(i>j)
			return 0;
		if(i==j) {
			if(isTrue==true)
				return s.charAt(i)=='T'?1:0;
			else
				return s.charAt(i)=='F'?1:0;
		}
		
		int ans=0;
		for(int k=i+1;k<=j-1;k+=2) {
			System.out.println("for k : "+k +" isTrue : "+isTrue);
			int lt=solve(s,i,k-1,true);
			System.out.println("lt : "+lt);
			int lf=solve(s,i,k-1,false);
			System.out.println("lf : "+lf);
			int rt=solve(s,k+1,j,true);
			System.out.println("rt : "+rt);
			int rf=solve(s,k+1,j,false);
			System.out.println("rf : "+rf);
			
			if(s.charAt(k)=='&') {
				if(isTrue==true) {
					ans+=lt*rt;
				}
				else if(isTrue==false) {
					ans+=(lt*rf)+(lf*rt)+(lf*rf);
				}
			}
			else if(s.charAt(k)=='|') {
				if(isTrue==true) {
					ans+=(lf*rt)+(lt*rf)+(lt*rt);
				}
				else {
					ans+=lf*rf;
					}
			}
			
			else if(s.charAt(k)== '^') {
				if(isTrue==true) {
					ans+=(lf*rt)+(lt*rf);
				}
				else {
					ans+=(lf*rf)+(lt*rt);
				}
			}
		}
		return ans%1003;
	}

	public static void main(String[] args) {

		InputReader in= new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n= in.readInt();
		String s= in.readString();
		out.printLine(countWays(n, s));
		out.close();
	}

}

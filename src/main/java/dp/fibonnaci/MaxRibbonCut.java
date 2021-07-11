package dp.fibonnaci;

import java.util.Arrays;

import utility.InputReader;
import utility.OutputWriter;

//Codeforces
//Problem link-https://codeforces.com/problemset/problem/189/A
//Polycarpus has a ribbon, its length is n. He wants to cut the ribbon in a way that fulfils the following two conditions:
//
//After the cutting each ribbon piece should have length a, b or c.
//After the cutting the number of ribbon pieces should be maximum.
//Help Polycarpus and find the number of ribbon pieces after the required cutting.
//
//Input
//The first line contains four space-separated integers n, a, b and c (1 ≤ n, a, b, c ≤ 4000) — the length of the original ribbon and the acceptable lengths of the ribbon pieces after the cutting, correspondingly. The numbers a, b and c can coincide.
//
//Output
//Print a single number — the maximum possible number of ribbon pieces. It is guaranteed that at least one correct ribbon cutting exists.
public class MaxRibbonCut {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in= new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
	
		int n=in.readInt();
		int [] dp= new int [n+1];
		Arrays.fill(dp, -1);
		int a=in.readInt();
		int b=in.readInt();
		int c=in.readInt();
		out.printLine(solveUsingTopDownDP(n,a,b,c,dp));
		out.printLine(solveUsingBottomUpDP(n,a,b,c));
		out.close();
	}

	private static int solveUsingBottomUpDP(int n, int a, int b, int c) {
		// TODO Auto-generated method stub
		
		int [] dp= new int[n+1];
		dp[0]=0;
		
		for(int i=1;i<=n;i++) {
			int cuta=Integer.MIN_VALUE;
			int cutb=Integer.MIN_VALUE;
			int cutc=Integer.MIN_VALUE;
			
			if(i>=a)
				cuta=dp[i-a];
			if(i>=b)
				cutb=dp[i-b];
			if(i>=c)
			    cutc=dp[i-c];
			
			dp[i]=1+Math.max(cuta, Math.max(cutb, cutc));
		}
		return dp[n];
	}

	private static int solveUsingTopDownDP(int n, int a, int b, int c, int[] dp) {
		// TODO Auto-generated method stub
		if(n==0)
			return 0;
		
		if(n<0)
			return Integer.MIN_VALUE;
		
		if(dp[n]!=-1)
			return dp[n];
		return dp[n]=1 + Math.max(solveUsingTopDownDP(n-a, a, b, c, dp), Math.max(solveUsingTopDownDP(n-b, a, b, c, dp), solveUsingTopDownDP(n-c, a, b, c, dp)));
	}

}

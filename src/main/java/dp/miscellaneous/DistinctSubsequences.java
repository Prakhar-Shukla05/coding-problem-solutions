package dp.miscellaneous;

import java.util.Arrays;

//InterviewBit
//Problem link- https://www.interviewbit.com/problems/distinct-subsequences/
//Given two sequences A, B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.
//Input 1:
//    A = "abc"
//    B = "abc"
//    
//Output 1:
//    1
//
//Explanation 1:
//    Both the strings are equal.
//
//Input 2:
//    A = "rabbbit" 
//    B = "rabbit"
//
//Output 2:
//    3
//
//Explanation 2:
//    These are the possible removals of characters:
//        => A = "ra_bbit" 
//        => A = "rab_bit" 
//        => A = "rabb_it"
//        
//    Note: "_" marks the removed character.

public class DistinctSubsequences {

	public int numDistinct(String A, String B) {
		
		if(A==B)
			return 1;
		else {
			int [][] dp = new int [A.length()][B.length()];
			for(int [] row  : dp) {
				Arrays.fill(row, -1);
			}
			return recursive(A,B,0,0,dp);
		}
	}
	
	private static int recursive(String a, String b, int i, int j, int [][] dp) {
		
		
		
		if(j==b.length())
			return 1;
		if(i==a.length())
			return 0;
		
		if(dp[i][j]!=-1)
			return dp[i][j];
		if(a.charAt(i)!=b.charAt(j)) {
			return dp[i][j]=recursive(a,b,i+1,j,dp);
		}
		else {
			return dp[i][j]=recursive(a, b, i+1, j+1, dp)+ recursive(a, b, i+1, j, dp);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		String A=in.readString();
		String B= in.readString();
		out.printLine(new DistinctSubsequences().numDistinct(A, B));
		out.close();

	}

}

package dp.mcm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import utility.InputReader;
import utility.OutputWriter;

public class BooleanParenthesizationWithMemoization {

	
	static int countWays(int N, String S) {
		if (N == 0 || S == null)
			return 0;

		//Map<String, Integer> dp = new HashMap<>();
		int  [] [][ ]dp = new int [N+1][N+1][2];
		for(int [ ][] two : dp) {
			for(int  []  one : two) {
				Arrays.fill(one, -1);
			}
		}
		return solve(S, 0, N - 1, true, dp);

	}

	private static int solve(String s, int i, int j, boolean isTrue,/* Map<String, Integer>*/ int [][][] dp) {

		if (i > j) {
			if(isTrue)
				return dp[i][j][0]=0;
			else
				return dp[i][j][1]=0;
		}
		if (i == j) {
			if (isTrue == true)
				return dp[i][j][0]=s.charAt(i) == 'T' ? 1 : 0;
			else
				return dp[i][j][1]=s.charAt(i) == 'F' ? 1 : 0;
		}
//		String key = Integer.toString(i) + "*" + Integer.toString(j) + "*" + Boolean.toString(isTrue);
//
//		if (dp.containsKey(key))
//			return dp.get(key);
		
		if(isTrue && dp[i][j][0]!=-1) {
			return dp[i][j][0];
		}
		else if(!isTrue && dp[i][j][1]!=-1)
			return dp[i][j][1];
		int ans = 0;
		for (int k = i + 1; k <= j - 1; k += 2) {
			int lt = dp[i][k-1][0]==-1?dp[i][k-1][0]=solve(s, i, k - 1, true, dp):dp[i][k-1][0];
			int lf = dp[i][k-1][1]==-1?dp[i][k-1][1]=solve(s, i, k - 1, false, dp):dp[i][k-1][1];
			int rt = dp[k+1][j][0]==-1?dp[k+1][j][0]=solve(s, k + 1, j, true, dp):dp[k+1][j][0];
			int rf = dp[k+1][j][1]==-1?dp[k+1][j][1]=solve(s, k + 1, j, false, dp):dp[k+1][j][1];
//			 int lf,rf,lt,rt;
//		        if(dp[i][k-1][0]!=-1)
//		            lt=dp[i][k-1][0];
//		        else
//		        {
//		            lt = solve(s, i, k - 1, true,dp);
//		            dp[i][k-1][0]=lt;
//		        }
//		            
//		        if(dp[i][k-1][1]!=-1)
//		            lf=dp[i][k-1][1];
//		        else
//		        {
//		            lf = solve(s, i, k - 1, false,dp);
//		            dp[i][k-1][1]=lf;
//		        }
//		            
//		        if(dp[k+1][j][1]!=-1)
//		            rf=dp[k+1][j][1];
//		        else
//		        {
//		            rf = solve(s, k + 1, j, false,dp);
//		            dp[k+1][j][1]=rf;
//		        }
//		            
//		        if(dp[k+1][j][0]!=-1)
//		            rt=dp[k+1][j][0];
//		        else
//		        {
//		            rt = solve(s, k + 1, j, true,dp);
//		            dp[k+1][j][0]=rt;
//		        }
			if (s.charAt(k) == '&') {
				if (isTrue == true) {
					ans += lt * rt;
				} else if (isTrue == false) {
					ans += (lt * rf) + (lf * rt) + (lf * rf);
				}
			} else if (s.charAt(k) == '|') {
				if (isTrue == true) {
					ans += (lf * rt) + (lt * rf) + (lt * rt);
				} else {
					ans += lf * rf;
				}
			}

			else if (s.charAt(k) == '^') {
				if (isTrue == true) {
					ans += (lf * rt) + (lt * rf);
				} else {
					ans += (lf * rf) + (lt * rt);
				}
			}
		}
		if(isTrue)
		return dp[i][j][0]=(ans%1003);
		else
		return dp[i][j][1]=(ans%1003);
	}

	public static void main(String[] args) {

		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n = in.readInt();
		String s = in.readString();
		out.printLine(countWays(n, s));
		out.close();
	}
}

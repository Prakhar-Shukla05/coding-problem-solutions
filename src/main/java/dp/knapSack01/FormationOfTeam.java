package dp.knapSack01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FormationOfTeam {

	private static int bestTeam(int n, int k, int [] type, int [] experience) {
		
		int [] [] dp = new int [n+1][k+1];
		for(int [] row :dp)
			Arrays.fill(row, -1);
		int [] wt= new int[n];
		for(int i=0;i<n;i++)
			wt[i]=1;
		Set<Integer> set= new HashSet<>();
		int answer= solve(type,experience,n,k,dp,set,wt);
		return answer;
	}
	
	private static int solve(int [] type, int [] experience, int n, int k, int [] [] dp, Set<Integer> set, int [] wt) {
		if(n==0 || k==0)
		{
			return 0;
			
		}
		if(dp[n][k]!=-1)
			return dp[n][k];
		
		if(wt[n-1]<=k) {
			Set<Integer> s = new HashSet<Integer>(set);
			
			int prevSize=s.size();
			s.add(type[n-1]);
			int newSize=s.size();
			int addition = (prevSize!=newSize)? ((newSize*newSize)-(prevSize*prevSize)):0;
			int val = Math.max(experience[n-1]+addition+solve(type, experience, n-1, k-wt[n-1], dp, s, wt), solve(type,experience,n-1,k,dp,set,wt));
			dp[n][k]=val;
			return dp[n][k];
		}
		else {
			int val=solve(type,experience,n-1,k,dp,set,wt);
			dp[n][k]=val;
			return dp[n][k];
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int k=3;
		int [] type= {1,1,2,2,3};
		int [] experience = {9,7,6,5,1};
		System.out.println(bestTeam(n,k,type,experience));

	}

}

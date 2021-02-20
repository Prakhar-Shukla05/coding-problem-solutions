	package dp;

public class ClimbingStairs {

	public int climbStairs(int n) {
		// This function takes the argument n- the number of steps it takes to reach the top and returns the number of distinct
		//ways it takes to reach the top
		if(n<3)
			return n;
		int [] dp = new int [n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			

	}

}

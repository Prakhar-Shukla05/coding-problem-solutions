package dp;

public class HouseRobber {

	public static int rob(int[] nums) {
	       
	        int [] dp = new int [nums.length+1];
	        dp[0]=0;
	        dp[1]=nums[1];
	        for(int i=1;i<nums.length;i++){
	            dp[i+1]= Math.max(dp[i],dp[i-1]+nums[i]);
	        }
	        
	        return dp[nums.length];
	    }
	
	public static void main(String[] args) {
		int [] n= {2,7,9,3,1};
		System.out.println(rob(n));
	}
}

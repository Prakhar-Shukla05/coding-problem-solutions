package dp.miscellaneous;

public class CombinationSumIV {

	public int combinationSum4(int[] nums, int target) {
           
		if(nums==null || nums.length==0)
			return 0;
		
		int [] dp = new int [target+1];
		
		dp[0]=1;
		/*
		for(int i=1;i<=target;i++) {
			for(int x: nums) {
				if(i-x>=0)
				 dp[i]+=dp[i-x];
			}
		}
		return dp[target];
		*/
		
		for(int i=0;i<target;i++) {
			for(int x : nums) {
				if(i+x<=target)
				dp[i+x]+=dp[i];
			}
		}
		
		return dp[target];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		int [] nums= {1,2,3};
		System.out.println(new CombinationSumIV().combinationSum4(nums, 4));
	}

}

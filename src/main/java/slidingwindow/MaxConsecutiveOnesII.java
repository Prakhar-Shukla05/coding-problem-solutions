package slidingwindow;

//Leetcode
//Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
public class MaxConsecutiveOnesII {

	public int findMaxConsecutiveOnes(int[] nums) {


		if(nums==null || nums.length==0)
			return 0;
		int K=0;
		int result=0;
		int i=0;
		for(int j=0;j<nums.length;j++) {
			if(nums[j]==0)
				K--;
			
			while(K<0) {
				if(nums[i]==0)
					K++;
				
				i++;
			}
			result=Math.max(result, j-i+1);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

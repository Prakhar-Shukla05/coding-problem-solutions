package arrays;

public class SubArrayProductLessThanK {

	public int numSubarrayProductLessThanK(int[] nums, int k) {
//        int count=0;
//        long product=1;
//        int n=nums.length;
//        for(int i=0;i<n;i++) {
//        	for(int j=i;j<n;j++) {
//        		for(int l=i;l<=j;k++) {
//        		  	product*=nums[l];
//        		}
//        		if(product<l)
//        			count++;
//        		product=1;
//        	}
//        }
//		return count;
		if(k<=1)
			return 0;
		int count=0;
		int prod=1;
		int left=0;
		int right=0;
		
		while(right<nums.length) {
			prod*=nums[right];
			
			while(prod>=k) {
				prod/=nums[left];
				left++;
			}
			count+=right-left+1;
			right++;
		}
		return count;
//		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums= {10, 5, 2, 6};
		int l=3;
          System.out.println(new SubArrayProductLessThanK().numSubarrayProductLessThanK(nums, l));      
	}

}

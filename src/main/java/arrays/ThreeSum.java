package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Leetcode
//Problem link- https://leetcode.com/problems/3sum/submissions/

public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
          List<List<Integer>> result = new ArrayList();
          if(nums==null)
        	  return result;
          Arrays.parallelSort(nums);
          int n=nums.length;
          for(int i=0;i<n;i++) {
        	  int required= 0-nums[i];
        	  
        	  int left=i+1;
        	  int right=n-1;
        	  
        	  while(left<right) {
        		  
        		  if(nums[left]+nums[right]==required) {
        			  result.add(Arrays.asList(nums[i],nums[left],nums[right]));
        			  
        			  while(left<right && nums[left]==nums[left+1])
        				  left++;
        			  while(left<right && nums[right]==nums[right-1])
        				  right--;
        			  
        			  left++;
        			  right--;
        		  }
        		  
        		  else if(nums[left]+nums[right]>required)
        			  right--;
        		  else
        			  left++;
        	  }
          }
          
          
          
          
		  return result;
	}
	
	public static void main(String[] args) {
		
		int [] nums= {-1,0,1,2,-1,-4};
		
		System.out.println(threeSum(nums));
	}
}

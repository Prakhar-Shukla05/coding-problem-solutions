package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> result = new ArrayList();
		if(nums==null || nums.length==0) {
			return result;
			
			
		}
		List<Integer> current = new ArrayList<Integer>();
		solve(nums,0,result,current);
		return result;
	}
	
	private void solve(int [] nums, int index, List<List<Integer>> result, List<Integer> list)
	{
		
		if(index==nums.length) {
			result.add(list);
			return ;
		}
		
		for(int i=index;i<nums.length;i++) {
			List<Integer> temp= new ArrayList<Integer>(list);
			temp.add(nums[i]);
			solve(nums,index+1,result,temp);
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}

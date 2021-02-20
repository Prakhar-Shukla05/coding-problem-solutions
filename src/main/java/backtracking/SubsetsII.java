package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {

		Arrays.parallelSort(nums);
		List<List<Integer>> result = new ArrayList();
		
		dfs(0,nums,result,new ArrayList());
		return result;
	}
	
	private void dfs(int index, int [] nums, List<List<Integer>> result, List<Integer> current) {
		
		result.add(new ArrayList<>(current));
		
		for(int i=index;i<nums.length;i++) {
			if(i>index && nums[i]==nums[i-1])
				continue;
			current.add(nums[i]);
			dfs(i+1, nums,result, current);
			current.remove(current.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int [] nums = {1,2,2};
		List<List<Integer>> res= new SubsetsII().subsetsWithDup(nums);
		for(List<Integer> l : res) {
			System.out.println(l);
		}
		
	}
}

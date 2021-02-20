package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		dfs(0,nums,result,new ArrayList<>());
		return result;
	}
	
	private void dfs(int index, int [] nums, List<List<Integer>> result, List<Integer> current) {
		
		result.add(new ArrayList<>(current));
		

		for(int i=index;i<nums.length;i++) {
			current.add(nums[i]);
			dfs(i+1, nums,result, current);
			//current.remove(current.size()-1);
			current.remove(Integer.valueOf(nums[i]));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,2,3};
		List<List<Integer>> res= new Subsets().subsets(nums);
		for(List<Integer> i  : res) {
			for(int x : i) {
				System.out.print(x);
			}
			System.out.println();
		}

	}

}

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> result = new ArrayList();
        boolean [] used = new boolean[nums.length];
		dfs(nums, result, new ArrayList(),used);
		return result;
	}
	
private void dfs(int [] nums, List<List<Integer>> result, List<Integer> current, boolean [] used) {
		
	    if(current.size()==nums.length) {
		result.add(new ArrayList<>(current));
		return ;
	    }
		

		for(int i=0;i<nums.length;i++) {	
			if(used[i]) continue;
			current.add(nums[i]);
			used[i]= true;
			dfs( nums,result, current, used);
			current.remove(current.size()-1);
			used[i]= false;
			//current.remove(nums[i]);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,2,3};
		List<List<Integer>> res = new Permutations().permute(nums);
		for (List<Integer> i : res) {
				System.out.print(i);
			
			System.out.println();
		}
	}

}

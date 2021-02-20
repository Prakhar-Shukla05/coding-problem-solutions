package backtracking;

import java.util.ArrayList;
import java.util.List;

//Leetcode
//Problem link- https://leetcode.com/problems/combination-sum/
public class CombinationSumI {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList();

		dfs(0, candidates, result, new ArrayList(), target);
		return result;
	}

	private void dfs(int index, int[] candidates, List<List<Integer>> result, List<Integer> current, int target) {

		if (target < 0)
			return;
		if (target == 0) {
			result.add(new ArrayList<>(current));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			current.add(candidates[i]);
			dfs(i , candidates, result, current, target - candidates[i]);
			current.remove(current.size() - 1);
			// current.remove(i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 10, 1, 2, 7, 6, 1, 5 };
		List<List<Integer>> res = new CombinationSumI().combinationSum(nums, 8);
		for (List<Integer> i : res) {
			System.out.println(i);

		//	System.out.println();
		}

	}

}

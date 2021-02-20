package backtracking;

import java.util.ArrayList;
import java.util.List;

//Leetcode
//Problem link - https://leetcode.com/problems/combination-sum-iii
public class CombinationSumIII {

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList();

		dfs(1, k, result, new ArrayList(), n);
		return result;
	}
	
	private void dfs(int index, int k, List<List<Integer>> result, List<Integer> current, int n) {

		if (n < 0)
			return;
		if (n == 0) {
			if(current.size()==k) {
			result.add(new ArrayList<>(current));
			return;
			}
		}
		for (int i = index; i <= 9; i++) {
			
			current.add(i);
			dfs(i+1, k, result, current, n -i);
			current.remove(current.size() - 1);
			// current.remove(i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res= new CombinationSumIII().combinationSum3(2, 18);
		for(List<Integer> i  : res) {
			
			System.out.println(i);
		}
		
	}

}

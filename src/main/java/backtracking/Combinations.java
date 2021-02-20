package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList();

		dfs(1, result, new ArrayList(),n,k);
		return result;
	}

	private void dfs(int index, List<List<Integer>> result, List<Integer> current, int n, int k) {

		if(current.size()==k) {
		result.add(new ArrayList<>(current));
		return ;
		}
		for (int i = index; i <= n; i++) {
			current.add(i);
			dfs(i + 1, result, current,n,k);
			// current.remove(current.size()-1);
			current.remove(current.size()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int [] nums = {1,2,3};
		List<List<Integer>> res= new Combinations().combine(4, 2);
		for(List<Integer> i  : res) {
			for(int x : i) {
				System.out.print(x);
			}
			System.out.println();
		}
	}

}

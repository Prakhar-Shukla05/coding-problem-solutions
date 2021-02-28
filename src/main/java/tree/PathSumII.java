package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
           
		List<List<Integer>>  paths = new ArrayList<>();
		buildPath(root,targetSum,new ArrayList<Integer>(),paths);
		return paths;
	}
	
	private void buildPath(TreeNode root, int targetSum, List<Integer> current, List<List<Integer>> paths) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

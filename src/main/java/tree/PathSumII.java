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
		
		if(root==null)
			return ;
		
		current.add(root.val);
		
		if(targetSum-root.val==0 && root.left==null && root.right==null) {
			paths.add(current);
			return ;
			
		}
		
		buildPath(root.left,targetSum-root.val,new ArrayList<>(current), paths);
		buildPath(root.right,targetSum-root.val,new ArrayList<>(current), paths);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package tree;

//Leetcode
//Problem link- https://leetcode.com/problems/path-sum/description/	
public class PathSum {
//       
//		public boolean hasPathSum(TreeNode root, int targetSum) {
//			List<Integer> paths = new ArrayList<>();
//			if(root==null)
//				return false;
//			int current = root.val;
//			
//			if (root.left == null && root.right == null) {
//				paths.add(current);
//			}
//	
//			if (root.left != null) {
//				constructPaths(root.left, current, paths);
//	
//			}
//	
//			if (root.right != null) {
//				constructPaths(root.right, current, paths);
//			}
//	
//			return paths.contains(targetSum);
//	
//		}
//		
//		private void constructPaths(TreeNode root, int current, List<Integer> paths) {
//			current+=root.val;
//			if (root.left == null && root.right == null) {
//				paths.add(current);
//				return ;
//			}
//			if (root.left != null) {
//				constructPaths(root.left, current, paths);
//	
//			}
//			if (root.right != null) {
//				constructPaths(root.right, current, paths);
//			}
//	
//		}

	// Simple solution using DP

	public boolean hasPathSum(TreeNode root, int targetSum) {
         
		if(root==null)
			return false;
		
		else if(root.left==null && root.right== null && targetSum-root.val==0)
			return true;
		else {
			return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

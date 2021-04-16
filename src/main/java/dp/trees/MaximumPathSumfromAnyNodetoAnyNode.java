package dp.trees;

//Leetcode
//Problem link- https://leetcode.com/problems/binary-tree-maximum-path-sum/
//A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
//
//The path sum of a path is the sum of the node's values in the path.
//
//Given the root of a binary tree, return the maximum path sum of any path.
//
//Input: root = [-10,9,20,null,null,15,7]
//Output: 42
//Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

public class MaximumPathSumfromAnyNodetoAnyNode {

	private static int result= Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
           
		if(root==null)
			return  0;
		
		solve(root);
		return result;
		
	}
	
	private static int solve(TreeNode root) {
		if(root==null)
			return 0;
		int left= solve(root.left);
		int right= solve(root.right);
		int temp=Math.max(Math.max(left, right)+root.val, root.val);
		int ans=Math.max(temp, left+right+root.val);
		result= Math.max(result, ans);
		return temp;
	}
	
	public static void main(String[] args) {
		TreeNode root= new TreeNode(-10);
		root.left= new TreeNode(9);
		root.right= new TreeNode(20);
		root.right.left= new TreeNode(15);
		root.right.right= new TreeNode(7);
		System.out.println(new MaximumPathSumfromAnyNodetoAnyNode().maxPathSum(root));
	}

}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

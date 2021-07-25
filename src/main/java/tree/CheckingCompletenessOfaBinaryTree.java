package tree;

import java.util.LinkedList;
import java.util.Queue;

//Leetcode 958
//Problem link-https://leetcode.com/problems/check-completeness-of-a-binary-tree/
//
//Given the root of a binary tree, determine if it is a complete binary tree.
//
//In a complete binary tree, every level, except possibly the last, is completely
//filled, and all nodes in the last level are as far left as possible. It can have 
//between 1 and 2h nodes inclusive at the last level h.
//
// 
//
//Example 1:
//
//
//Input: root = [1,2,3,4,5,6]
//Output: true
//Explanation: Every level before the last is full (ie. levels with node-values 
//		{1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
//Example 2:
//
//
//Input: root = [1,2,3,4,5,null,7]
//Output: false
//Explanation: The node with value 7 isn't as far left as possible.

public class CheckingCompletenessOfaBinaryTree {

//	Level order traversal karne par jab null mile toh uske baad nhi milni chahiye node
//	Agar mili toh false hai

	public boolean isCompleteTree(TreeNode root) {

		if(root==null)
			return true;
		
		Queue<TreeNode> q= new LinkedList<>();
		q.offer(root);
		boolean alreadySeenNull=false;
		while(!q.isEmpty()) {
			TreeNode get= q.peek();
			q.poll();
			if(get==null)
				alreadySeenNull=true;
			else {
				if(alreadySeenNull) return false;
				q.offer(get.left);
				q.offer(get.right);
			}
		}
		return true;
	}

	
	
	public static void main(String[] args) {
	TreeNode root= new TreeNode(1);
	root.left=new TreeNode(2);
	root.right= new TreeNode(3);
	root.right.right= new TreeNode(8);
	root.left.left= new TreeNode(5);
	System.out.println(new CheckingCompletenessOfaBinaryTree().isCompleteTree(root));
	}
}

package tree.bst;

//GFG
//Problem link-https://practice.geeksforgeeks.org/problems/check-for-bst/1
//Given a binary tree. Check whether it is a BST or not.
//Note: We are considering that BSTs can not contain duplicate Nodes.
//
//Example 1:
//
//Input:
//    2
// /    \
//1      3
//Output: 1 
//Explanation: 
//The left subtree of root node contains node 
//with key lesser than the root node’s key and 
//the right subtree of root node contains node 
//with key greater than the root node’s key.
//Hence, the tree is a BST.
public class CheckForBST {

	boolean isBST(Node root) {
		// code here.
		boolean result=false;
		if(root==null)
			return true;
		
		return solve(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private static boolean solve(Node root, int left, int right) {
		
		if(root==null)
			return true;
		
		if(root.data<right && root.data>left) {
			return solve(root.left,left,root.data) && solve(root.right,root.data,right);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

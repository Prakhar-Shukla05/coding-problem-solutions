package tree;

//Leetcode
//Problem Link- https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {

	public static  boolean isValidBST(TreeNode root) {

		if(root==null)
			return true;
		
		return checkBST(root,null, null);
	}
	
	private static boolean checkBST(TreeNode node, Integer left, Integer right) {
		
		if(node == null)
			return true;
		
		if(left!= null && node.val<=left ||  right!=null && node.val>=right)
			return false;
		
		return checkBST(node.left, left, node.val) && checkBST(node.right, node.val, right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

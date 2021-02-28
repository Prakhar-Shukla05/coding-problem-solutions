package tree;

//Leetcode
//Problem link- https://leetcode.com/problems/invert-binary-tree/
public class InvertABinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;

		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);

		root.left = right;
		root.right = left;

		return root;

	}

	public static void main(String[] args) {

	}
}

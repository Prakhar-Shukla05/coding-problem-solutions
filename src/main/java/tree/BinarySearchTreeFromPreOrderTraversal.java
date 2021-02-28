package tree;

import java.util.Arrays;

//Leetcode
//Problem link- https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
public class BinarySearchTreeFromPreOrderTraversal {

	public TreeNode bstFromPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0)
			return null;

		TreeNode root = new TreeNode(preorder[0]);

		if (preorder.length == 1)
			return root;

		int index = preorder.length;
		for (int i = 0; i < preorder.length; i++) {
			if (preorder[i] > preorder[0]) {
				index = i;
				break;
			}
		}
		root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, index));
		root.right = bstFromPreorder(Arrays.copyOfRange(preorder, index, preorder.length));

		return root;

	}

	public static void main(String[] args) {
            int [] preorder= {8,5,1,7,10,12};
            TreeNode root= new BinarySearchTreeFromPreOrderTraversal().bstFromPreorder(preorder);
	}
}

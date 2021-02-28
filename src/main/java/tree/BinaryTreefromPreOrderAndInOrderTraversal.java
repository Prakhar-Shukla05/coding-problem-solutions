package tree;

//Leetcode
//Problem link- https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class BinaryTreefromPreOrderAndInOrderTraversal {
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
	      
		 return buildTree(preorder,inorder, 0,0,inorder.length-1);
	  }
	 
	 private TreeNode buildTree(int [] preorder, int [] inorder, int preOrderStart, int inOrderStart, int inOrderEnd) {
		 
		 if(inOrderStart>inOrderEnd || preOrderStart>=inorder.length)
			 return null;
		 
		 TreeNode root= new TreeNode(preorder[preOrderStart]);
		 int i=0;
		 for( i=inOrderStart;i<=inOrderEnd;i++) {
			 if(root.val==inorder[i]){
				 break;
			 }
		 }
		 
		 root.left=buildTree(preorder, inorder, preOrderStart+1, inOrderStart, i-1);
		 root.right= buildTree(preorder, inorder, preOrderStart+ i-inOrderStart+1, i+1, inOrderEnd);
		 
		 return root;
	 }
	 
}

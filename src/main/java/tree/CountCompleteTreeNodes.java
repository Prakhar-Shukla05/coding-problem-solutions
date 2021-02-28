package tree;

//Leetcode
//Problem Link- https://leetcode.com/problems/count-complete-tree-nodes/
public class CountCompleteTreeNodes {

	public int countNodes(TreeNode root) {
         if(root==null)
        	 return 0;
         
         int leftLevels=1;
         TreeNode left= root.left;
         while(left!=null) {
        	 leftLevels++;
        	 left=left.left;
         }
         
         int rightLevels=1;
         TreeNode right = root.right;
         while(right!=null) {
        	 rightLevels++;
        	 right=right.right;
         }
         
         if(leftLevels==rightLevels) {
        	 return (int)(Math.pow(2, leftLevels))-1;
         }
         else {
        	 return 1+countNodes(root.left)+countNodes(root.right);
         }
	}

	public static void main(String[] args) {

	}
}

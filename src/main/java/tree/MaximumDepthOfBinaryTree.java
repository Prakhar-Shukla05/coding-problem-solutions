package tree;

//Leetcode 
//Problem Link - https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {


    public int maxDepth(TreeNode root) {
         
    	 if(root==null)
             return 0;
         int left= maxDepth( root.left);
         int right = maxDepth( root.right);
         
         return Math.max(left,right)+1;    	
    	
    	
    }
    
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

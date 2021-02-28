package tree;

public class KthSmallestElementInABST {
    
	 public static int kthSmallest(TreeNode root, int k) {
	        
	        int [] res = new int [2];
	        inorder(root,res,k);
	        
	        
	        return res[1];
	    }
	    
	    private static void inorder(TreeNode node, int [] res, int k){
	        
	        if(node==null)
	            return;
	        
	        inorder(node.left,res,k);
	        if(++res[0]==k){
	            res[1]=node.val;
	            return ;
	        }
	        
	        inorder(node.right,res,k);
	    }
	    
	public static void main(String[] args) {
		 
	}
}
/*
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
*/
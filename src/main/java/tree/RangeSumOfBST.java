package tree;


//Leetcode
//Problem link -https://leetcode.com/problems/range-sum-of-bst/
public class RangeSumOfBST {

	int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
    	
    	if(root==null)
    		return sum;
    	
    	dfs(root,low,high);
    	return sum;
    }
    
    private void dfs(TreeNode node, int low, int high){
    	if(node!=null) {
    		if(node.val>=low && node.val<=high) {
    			sum+=node.val;
    		}
    		
    		if(node.left!= null && node.val>low)
    			dfs(node.left, low, high);
    		
    		if(node.right!= null && node.val<high)
    			dfs(node.right, low, high);
    	}
    }
    	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

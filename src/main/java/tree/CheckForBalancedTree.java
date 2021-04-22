package tree;

public class CheckForBalancedTree {

	boolean isBalanced(Node root)
    {
		if(root==null)
			return true;
		
		int lh= height(root.left);
		int rh= height(root.right);
		if(Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right))
			return true;
		return false;
    }	
	
	private static int height(Node root) {
		
		if(root==null)
			return 0;
		
		int left= height(root.left);
		int right= height(root.right);
		
		return Math.max(left, right)+1;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	}

}

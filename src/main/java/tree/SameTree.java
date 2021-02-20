package tree;

public class SameTree {
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
             
		if(p==null || q==null)
			return p==q;
		
		return isItSame(p,q);
	}
	
	private boolean isItSame(TreeNode p, TreeNode q) {
		if(p==null || q==null)
			return p==q;
		
		if(p.val!=q.val)
			return false;
		
		return isItSame(p.left,q.left) && isItSame(p.right,q.right);
	}
	
}

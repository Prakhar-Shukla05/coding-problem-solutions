package tree;

//Leetcode 
//Problem link- https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfAnotherTree {

	public static boolean isSubtree(TreeNode s, TreeNode t) {

		if(s==null)
			return false;
		else if(isSameTree(s,t))
			return true;
		else {
			return isSameTree(s.left,t) || isSameTree(s.right,t);
		}
	}
	
	private static boolean isSameTree(TreeNode a, TreeNode b) {
		
		if(a==null || b== null)
			return a==null && b== null ;
		
		else if(a.val==b.val)
			return isSameTree(a.left,b.left) && isSameTree(a.right,b.right);
		
		else 
			return false;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TreeNode s= new TreeNode(1);
        TreeNode temp=s;
        for(int i=1;i<=10;i++) {
        	temp.left=null;
        	temp.right= new TreeNode(1);
        	if(i!=10)
        		temp=temp.right;
        }
        temp.left= new TreeNode(2);
        
        TreeNode t= new TreeNode(1);
        temp=t;
        for(int i=1;i<=5;i++) {
        	temp.left=null;
        	temp.right= new TreeNode(1);
        	if(i!=10)
        		temp=temp.right;
        }
        temp.left= new TreeNode(2);
        
        System.out.println(isSubtree(s, t));
        
	}

}

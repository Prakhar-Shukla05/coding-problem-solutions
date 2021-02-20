package recursion;

public class LongestUniversalPath {

	public int longestUnivaluePath(TreeNode root) {

		if (root == null) {
			return 0;
		}

		TreeNode prev = new TreeNode(1001);
		return longest(root, prev);

	}

	private int longest(TreeNode root, TreeNode prev) {

		if ((root == null || root.val != prev.val ) && prev.val!= 1001) {
			return 0;
		}

		int left = longest(root.left, root);
		int right = longest(root.right, root);

		return Math.max(left, right) ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left=new TreeNode(4);
		root.left.left= new TreeNode(1);
		root.left.right= new TreeNode(1);
		root.right= new TreeNode(5);
		root.right.right= new TreeNode(5);
		int len= new LongestUniversalPath().longestUnivaluePath(root);
		System.out.println(len);
	}

}

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
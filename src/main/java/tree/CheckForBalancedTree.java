package tree;

public class CheckForBalancedTree {

	boolean isBalanced(Node root)
    {
		if(root==null)
			return true;
		
		boolean answer=true;
		height(root,answer);
		return answer;
    }
	
	private static int height(Node root, boolean result) {
		
		if(root==null)
			return 0;
		
		int left= height(root.left,result);
		int right= height(root.right,result);
		if(Math.abs(left-right)>1)
		{
			result=false;
		}
		return Math.max(left, right)+1;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(9);
		root.left= new Node(7);
		root.right= null;
		root.left.left= new Node(8);
		root.left.right= new Node(10);
		root.right.left= null;
		root.right.right= new Node(6);
		root.left.left.left= new Node(4);
		root.left.left.right= null;
		root.left.right.left= new Node(6);
		root.left.right.right= new Node(10);
		root.left.left.left.left= null;
		root.left.left.left.right= new Node(8);
		System.out.println(new CheckForBalancedTree().isBalanced(root));

	}

}

package tree;

//Leetcode
//Problem link- https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
//Good Question
public class BinaryTreeLongestConsecutiveSubsequence {

	public int longestConsecutive(TreeNode root) {
		
		if(root==null)
			return 0;
		
		int [] maxSequence= new int [1];
		findestLongestSequence(root,0,0,maxSequence);
		return maxSequence[0];	
	}
	
	private void findestLongestSequence(TreeNode root, int count, int target, int [] maxSequence) {
		if(root==null)
			return ;
		
		else if(root.val==target)
			count++;
		else
			count=1;
		
		maxSequence[0]=Math.max(maxSequence[0], count);
		findestLongestSequence(root.left,count,root.val+1,maxSequence);
		findestLongestSequence(root.right,count,root.val+1,maxSequence);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode  root= new TreeNode(1);
		root.left= new TreeNode(4);
		root.right=new TreeNode(2);
		root.right.right= new TreeNode(3);
		System.out.println(new BinaryTreeLongestConsecutiveSubsequence().longestConsecutive(root));

	}

}

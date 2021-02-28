package tree;

import java.util.LinkedList;
import java.util.Queue;

//Leetcode
//Problem link- https://leetcode.com/problems/deepest-leaves-sum/
public class DeepestLeavesSum {

	public int deepestLeavesSum(TreeNode root) {
            	
		if(root==null)
			return 0;
		
		int res=bfs(root);
		return res;
	}
	
	private int bfs(TreeNode root) {
		 int res=0;
			Queue<TreeNode> q= new LinkedList<TreeNode>();
			q.offer(root);
			//Queue<TreeNode> in= new LinkedList<TreeNode>();
			while(!q.isEmpty()) {
				//in.clear();
	            res=0;
				for(TreeNode t: q) {
					res+=t.val;
				}
				int size=q.size();
	            for(int i=0;i<size;i++){
					TreeNode temp=q.poll();
					if(temp.left!=null)
						q.offer(temp.left);
					if(temp.right!=null)
						q.offer(temp.right);
				}
				
			}
			
			return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//            lfnkafkafna
		
	}

}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }  
 *     }
 */
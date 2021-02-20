package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//import javax.swing.tree.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res= new ArrayList<>();
		if(root==null)
			return res;
		
		Queue<TreeNode> queue= new LinkedList<>();
		
		queue.add(root);
		List<Integer> first= new ArrayList<>();
		first.add(root.val);
		res.add(first);
		while(!queue.isEmpty()) {
			TreeNode temp=queue.peek();
			List<Integer> inner = new ArrayList<>();
			int size=queue.size();
			while(size-->0) {
				temp=queue.poll();
				if(temp!=root)
				inner.add(temp.val);
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
			if(inner.size()>0)
			res.add(inner);
		}
		
		
		return res;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root= new TreeNode(3);
		root.left= new TreeNode(9);
		root.right= new TreeNode(20);
		root.right.left= new TreeNode(15);
		root.right.right= new TreeNode(7);
		
		List<List<Integer>> answer = new BinaryTreeLevelOrderTraversal().levelOrder(root);
		for(List<Integer>i : answer) {
			for(int x : i) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
		
		

	}

}
/**
 * Definition for a binary tree node.
 * */
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
 
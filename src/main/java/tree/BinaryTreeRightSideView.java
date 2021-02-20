package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> res = new ArrayList<>();
		if(root==null) {
			return res;
		}
		
		res.add(root.val);
		
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			int size=q.size();
			while(size-->0) {
				TreeNode temp=q.poll();
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
				
			}
			if(!q.isEmpty())
			res.add(q.getLast().val);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.left.right= new TreeNode(5);
		root.right=new TreeNode(3);
		root.right.right= new TreeNode(4);
		
		List<Integer> res= new BinaryTreeRightSideView().rightSideView(root);
		for(int a : res) {
			System.out.print(a+" ");
		}
	}

}

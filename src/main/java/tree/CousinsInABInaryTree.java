package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CousinsInABInaryTree {

	public boolean isCousins(TreeNode root, int x, int y) {

		if(root==null)
			return false;
		
		Map<Integer, TreeNode> parentMapping = new HashMap<>();
		
		Queue<TreeNode> q= new LinkedList<>();
		Queue<Integer> val= new LinkedList<>();
		q.add(root);
		val.add(root.val);
		while(!q.isEmpty()) {
			int size=q.size();
			if(val.contains(x) || val.contains(y)) {
				if(!val.contains(x) || !val.contains(y))
					return false;
				
				return parentMapping.get(x)!=parentMapping.get(y);
			}
			for(int i=0;i<size;i++) {
				TreeNode temp=q.remove();
				int value= val.remove();
				if(temp.left!=null)
				{
					parentMapping.put(temp.left.val,temp);
					q.add(temp.left);
					val.add(temp.left.val);
				}
				
				if(temp.right!=null) {
					parentMapping.put(temp.right.val,temp);
					q.add(temp.right);
					val.add(temp.right.val);
				}
				
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(3);
		root.right.right=new TreeNode(5);
		
		System.out.println(new CousinsInABInaryTree().isCousins(root, 5, 4));
	}

}

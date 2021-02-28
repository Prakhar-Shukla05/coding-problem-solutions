package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BinaryTreePaths {

//  Slower Solution using DFS
//	public List<String> binaryTreePaths(TreeNode root) {
//           
//           List<String> result = new ArrayList<>();
//           if(root==null)
//        	   return result;
//           String current =root.val+"";
//           if(root.left!=null)
//           constructList(root.left,result,current);
//           if(root.right!=null)
//           constructList(root.right,result,current);
//           
//           return result;
//           
//	}
//	
//	private void constructList(TreeNode node, List<String> result,String current) {
//		
//		if(node.left==null && node.right== null) {
//			current+="->"+node.val;
//			result.add(current);
//			return ;
//		}
//		
//		current+="->"+node.val;
//		if(node.left!=null)
//		constructList(node.left, result, current);
//		if(node.right!=null)
//		constructList(node.right, result, current);
//	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
        if(root==null)
     	   return result;
		StringBuilder sb = new StringBuilder();
		Stack<java.util.Map.Entry<TreeNode, Integer>> stack = new Stack<>();
		stack.push(new java.util.AbstractMap.SimpleEntry<>(root, 0));
		while (!stack.isEmpty()) {
			Map.Entry<TreeNode, Integer> curKvp = stack.pop();
			TreeNode current = curKvp.getKey();
            sb.setLength(curKvp.getValue());
			sb.append(current.val);
			if (current.left == null && current.right == null) {
				result.add(sb.toString());
			} else {
				sb.append("->");
				int len = sb.length();
				if (current.left != null)
					stack.push(new java.util.AbstractMap.SimpleEntry<>(current.left, len));
				if (current.right != null)
					stack.push(new java.util.AbstractMap.SimpleEntry<>(current.right, len));
			}
		}
		return result; 
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);

		List<String> sa = new BinaryTreePaths().binaryTreePaths(root);
		for (String s : sa) {
			System.out.println(s);
		}
	}
}

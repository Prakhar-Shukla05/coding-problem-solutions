package tree;

import java.util.ArrayList;
import java.util.List;

//Leetcode
//Problem link - https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRootToLeafeNumbers {

     
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		List<Integer> paths= new ArrayList<>();
		if (root.left == null && root.right == null) {
			paths.add(root.val);
		}
        int current=root.val;
		if (root.left != null) {
			addPath(root.left, current, paths);
		}

		if (root.right != null) {
			addPath(root.right, current, paths);
		}
		int sum=0;
		for(int c: paths)
			sum+=c;

		return sum;

	}

	private void addPath(TreeNode node, int current, List<Integer> paths) {
		current= (current*10)+node.val;

		if (node.left == null && node.right == null) {
			paths.add(current);
			return;
		}

		if (node.left != null) {
			addPath(node.left, current, paths);
		}

		if (node.right != null) {
			addPath(node.right, current, paths);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(0);

		System.out.println(new SumRootToLeafeNumbers().sumNumbers(root));
	}

}

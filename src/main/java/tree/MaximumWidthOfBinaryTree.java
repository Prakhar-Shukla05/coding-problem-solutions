package tree;

import java.util.HashMap;
import java.util.Map;

//Leetcode 662
//Problem link-https://leetcode.com/problems/maximum-width-of-binary-tree/
//
//Given the root of a binary tree, return the maximum width of the given tree.
//
//The maximum width of a tree is the maximum width among all levels.
//
//The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.
//
//It is guaranteed that the answer will in the range of 32-bit signed integer.
//
// 
//
//Example 1:
//
//
//Input: root = [1,3,2,5,3,null,9]
//Output: 4
//Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
//Example 2:
//
//
//Input: root = [1,3,null,5,3]
//Output: 2
//Explanation: The maximum width existing in the third level with the length 2 (5,3).
//Example 3:
//
//
//Input: root = [1,3,2,5]
//Output: 2
//Explanation: The maximum width existing in the second level with the length 2 (3,2).
//Example 4:
//
//
//Input: root = [1,3,2,5,null,null,9,6,null,null,7]
//Output: 8
//Explanation: The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).

public class MaximumWidthOfBinaryTree {

	int maxWidth;
	Map<Integer, Integer> leftmostPosition;
	public int widthOfBinaryTree(TreeNode root) {
		
		if(root==null)
			return 0;
		
		maxWidth=0;
		leftmostPosition= new HashMap<Integer, Integer>();
		getWidth(root,0,1);
        return maxWidth;
	}
	private void getWidth(TreeNode root, int depth, int position) {
		// TODO Auto-generated method stub
		if(root==null)
			return ;
		leftmostPosition.computeIfAbsent(depth, x->position);
		maxWidth=Math.max(maxWidth, position-leftmostPosition.get(depth)+1);
		getWidth(root.left, depth+1, position*2);
		getWidth(root.right, depth+1, position*2+1);
		
	}

}

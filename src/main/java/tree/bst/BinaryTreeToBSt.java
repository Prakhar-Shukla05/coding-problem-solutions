package tree.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
//GeeksforGeeks
//Problem link-https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1
//Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original structure of Binary Tree intact.
//
//
//Example 1:
//
//Input:
//      1
//    /   \
//   2     3
//Output: 1 2 3
//
//Example 2:
//
//Input:
//          1
//       /    \
//     2       3
//   /        
// 4       
//Output: 1 2 3 4
//Explanation:
//The converted BST will be
//
//        3
//      /   \
//    2     4
//  /
// 1

public class BinaryTreeToBSt {

	Node binaryTreeToBST(Node root) {
		
		List<Integer> inorder= new ArrayList<>();
		inorder(root,inorder);
		Collections.sort(inorder);
		int [] index= {0};
		//AtomicInteger index= new AtomicInteger(0);
		populateTree(root,inorder,index);
		return root;
	}
	
	private static void inorder(Node root, List<Integer> inorder) {
		
		if(root!=null) {
			inorder(root.left,inorder);
			inorder.add(root.data);
			inorder(root.right,inorder);
		}
	}
	
	private static void populateTree(Node root, List<Integer> inorder, int [] index ) {
		
		if(root!=null) {
			populateTree(root.left,inorder,index);
			root.data=inorder.get(index[0]);
			index[0]++;
			populateTree(root.right,inorder,index);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

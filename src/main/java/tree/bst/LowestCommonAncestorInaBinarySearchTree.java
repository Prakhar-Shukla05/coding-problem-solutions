package tree.bst;

//GeeksForGeeks
//Problem link-https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
//Given a Binary Search Tree (with all values unique) and two node values. Find the Lowest Common Ancestors of the two nodes in the BST.
//
//Example 1:
//
//Input:
//              5
//           /    \
//         4       6
//        /         \
//       3           7
//                    \
//                     8
//n1 = 7, n2 = 8
//Output: 7
//
//Example 2:
//
//Input:
//     2
//   /   \
//  1     3
//n1 = 1, n2 = 3
//Output: 2

public class LowestCommonAncestorInaBinarySearchTree {
	

	Node LCA(Node root, int n1, int n2) {
		
		if(root==null)
			return root;
		
		if(n1<root.data  && n2<root.data)
			return LCA(root.left,n1,n2);
		else if(n1>root.data  && n2>root.data)
			return LCA(root.right,n1,n2);
		
		return root;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

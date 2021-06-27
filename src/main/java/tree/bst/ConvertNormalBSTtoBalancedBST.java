package tree.bst;

import java.util.ArrayList;
import java.util.List;

//GeeksforGeeks
//Problem link-https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/
//Given a BST (Binary Search Tree) that may be unbalanced, convert it into a balanced BST that has minimum possible height.
//
//Examples :
//
//Input:
//       30
//      /
//     20
//    /
//   10
//Output:
//     20
//   /   \
// 10     30
//
//
//Input:
//         4
//        /
//       3
//      /
//     2
//    /
//   1
//Output:
//      3            3           2
//    /  \         /  \        /  \
//   1    4   OR  2    4  OR  1    3   OR ..
//    \          /                   \
//     2        1                     4 
//
//Input:
//          4
//        /   \
//       3     5
//      /       \
//     2         6 
//    /           \
//   1             7
//Output:
//       4
//    /    \
//   2      6
// /  \    /  \
//1    3  5    7 

public class ConvertNormalBSTtoBalancedBST {

	private static Node buildTree(Node root) {
		
		List<Integer> inorder= new ArrayList<>();
		inorderTraversal(root,inorder);
		root= populateTree(root,inorder,0,inorder.size()-1);
		return root;
	}
	
	private static void inorderTraversal(Node root, List<Integer> inorder) {
		
		if(root!=null) {
			inorderTraversal(root.left,inorder);
			inorder.add(root.data);
			inorderTraversal(root.right,inorder);
		}
	}
	
	private static Node populateTree(Node root, List<Integer> inorder, int start, int end) {
		if(start>end)
			return null;
		
		int mid = start+(end-start)/2;
		if(root==null)
			root= new Node(inorder.get(mid));
		else
		    root.data= inorder.get(mid);
		root.left= populateTree(root.left,inorder,start,mid-1);
		root.right= populateTree(root.right,inorder, mid+1,end);
		return root;
	
	}
 

	private static void preOrder(Node node) 
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Node root= new Node(4);
        root.left=new Node(3);
        root.left.left= new Node(2);
        root.left.left.left=new Node(1);
        root.right= new Node(5);
        root.right.right= new Node(6);
        root.right.right.right= new Node(7);
 
        root= buildTree(root);
        preOrder(root);
	}

}

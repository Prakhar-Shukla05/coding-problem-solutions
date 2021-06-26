package dp.trees;

//GeeksforGeeks
//Problem link- https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
//Given a Binary Tree, find diameter of it.
//The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
//Input:
//    1
//  /  \
// 2    3
//Output: 3

public class DiameterOfABinaryTree {

	static int result =1;
	static int diameter(Node root) {
		
		if(root==null) {
			return 0;
		}
		solve(root);
		return result;
    }
	
	private static int solve(Node root) {
		
		if(root==null)
			return 0;
		
		int l= solve(root.left);
		int r= solve(root.right);
		int temp= Math.max(l, r)+1;	
		int ans= Math.max(temp, 1+l+r);
		result= Math.max(ans,result);
		return temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node
{
   int data;
   Node left, right;

   Node(int item)
   {
       data = item;
       left = right = null;
   }
} 
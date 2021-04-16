package dp.trees;

//GeeksforGeeks
//Problem link-https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
//Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.
//
//
//Example 1:
//
//Input :      
//           3                               
//         /    \                          
//       4       5                     
//      /  \      
//    -10   4                          
//Output: 16
//Explanation :
//Maximum Sum lies between leaf node 4 and 5.
//4 + 4 + 3 + 5 = 16.
//Example 2:
//
//Input :    
//            -15                               
//         /      \                          
//        5         6                      
//      /  \       / \
//    -8    1     3   9
//   /  \              \
//  2   -3              0
//                     / \
//                    4  -1
//                       /
//                     10  
//Output :  27
//Explanation:
//The maximum possible sum from one leaf node 
//to another is (3 + 6 + 9 + 0 + -1 + 10 = 27)

public class MaximumPathSumFromLeafToLeafNode {

	private static int result;
	public int maxPathSum(Node root) {
           
		if(root==null)
			return  0;
		result= Integer.MIN_VALUE;
		solve(root);
		return result;
		
	}
	
	private static int solve(Node root) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return root.data;
		int left= solve(root.left);
		int right= solve(root.right);
		if(root.left!=null && root.right!=null)
		{
		
		int temp=Math.max(left, right)+root.data;
		//int ans=Math.max(temp, left+right+root.data);
		result= Math.max(result, left+right+root.data);
		return temp;
		}
		else {
			return root.left==null? root.data+right : root.data	+left; 
		}
		
	}
	
	public static void main(String[] args) {
		Node root= new Node(-9);
		root.left= new Node(6);
		root.right= new Node(-10);
		//root.right.left= new Node(15);
		//root.right.right= new Node(7);
		System.out.println(new MaximumPathSumFromLeafToLeafNode().maxPathSum(root));
	}
	
	

}


package tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//GeeksforGeeks
//Problem link- https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
//Given a binary tree, print the bottom view from left to right.
//A node is included in bottom view if it can be seen when we look at the tree from bottom.
//
//                      20
//                    /    \
//                  8       22
//                /   \        \
//              5      3       25
//                    /   \      
//                  10    14
//
//For the above tree, the bottom view is 5 10 3 14 25.
//If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.
//
//                      20
//                    /    \
//                  8       22
//                /   \     /   \
//              5      3 4     25
//                     /    \      
//                 10       14
//
//For the above tree the output should be 5 10 4 14 25.
// 
//
//Example 1:
//
//Input:
//       1
//     /   \
//    3     2
//Output: 3 1 2
//Explanation:
//First case represents a tree with 3 nodes
//and 2 edges where root is 1, left child of
//1 is 3 and right child of 1 is 2.
//
//Thus nodes of the binary tree will be
//printed as such 3 1 2.
//Example 2:
//
//Input:
//         10
//       /    \
//      20    30
//     /  \
//    40   60
//Output: 40 20 60 30

public class BottomViewOfaTree {
		static ArrayList<Integer> bottomView(Node root)
	    {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        if(root==null)
	        	return result;
	        
	        Map<Integer,Pair>map = new TreeMap<Integer,Pair>();
	        solve(root,0,0,map);
	        
	        Set<Integer> s= map.keySet();
	        for(int i : s) {
	        	result.add(map.get(i).data);
	        }
	        
	        return result;
	        
	        
	        
	    }
		
		private static void solve(Node root,int height, int level, Map<Integer,Pair> map) {
			
			if(root==null)
				return ;
			
			if(!map.containsKey(level))
				map.put(level, new Pair(root.data,height));
			else {
			Pair p= map.get(level);
			if(p.height<height) {
				map.put(level, new Pair(root.data, height));
			}
			}
			
			solve(root.left,height+1,level-1,map);
			solve(root.right,height+1,level+1,map);
			
		}
		public static void main(String[] args) {
			Node root = new Node(1);
			root.left= new Node(2);
			root.left.left= new Node(4);
			root.left.right=new Node(5);
			root.right= new Node(3);
			root.right.left= new Node(6);
			root.right.right= new Node(7);
			ArrayList<Integer> ans= bottomView(root);
			System.out.println(ans);
		}
}

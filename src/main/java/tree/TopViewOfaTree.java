package tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//GeeksforGeeks
//Problem link-https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
//Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree
//
//1
///     \
//2       3
///  \    /   \
//4    5  6   7
//
//Top view will be: 4 2 1 3 7
//Note: Print from leftmost node to rightmost node.
//
//Example 1:
//
//Input:
//1
///    \
//2      3
//Output: 2 1 3
//Example 2:
//
//Input:
//10
///      \
//20        30
///   \    /    \
//40   60  90    100
//Output: 40 20 10 30 100

public class TopViewOfaTree {

	static ArrayList<Integer> topView(Node root)
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
		if(p.height>height) {
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
		ArrayList<Integer> ans= topView(root);
		System.out.println(ans);
	}
}

class Pair{
	int data;
	int height;
	public Pair(int data, int height) {
		this.data = data;
		this.height = height;
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

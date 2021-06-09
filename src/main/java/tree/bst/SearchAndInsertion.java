package tree.bst;

import java.util.*;
public class SearchAndInsertion {
	
	class Node {
		int val;
		Node left;
		Node right;
		
		public Node(int val) {
			this.val = val;
			this.left=null;
			this.right=null;
			
		}
		
		
	}
	
	
	
	
	private  Node root= null;
	
	private boolean search(Node x) {
		return search(x,root);
	}
	private boolean search(Node x,Node root) {
		if(x.val==root.val)
			return true;
		
		if(x.val<root.val)
			return search(x,root.left);
		else
			return search(x,root.right);
	}
	
	private Node insert(Node x) {
		return insert(x,root);
		
	}
	
	private Node insert(Node x, Node root) {
	            
		if(root==null) {
			root = new Node(x.val);
			return root;
		}
		
		if(x.val<=root.val) {
			root.left= insert(x,root.left);
		}
		else
			root.right=insert(x,root.right);
		
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

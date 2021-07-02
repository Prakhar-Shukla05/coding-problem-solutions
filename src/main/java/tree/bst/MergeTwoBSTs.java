package tree.bst;

import java.util.ArrayList;
import java.util.List;

//GeeksforGeeks
//Problem link-
//You are given two balanced binary search trees e.g., AVL or Red Black Tree. 
//Write a function that merges the two given balanced BSTs into a balanced binary search tree.
//Let there be m elements in first tree and n elements in the other tree.
//Your merge function should take O(m+n) time.

public class MergeTwoBSTs {

	private static Node mergeTrees(Node one, Node two) {
		
		List<Integer> inorderOne = new ArrayList<>();
		List<Integer> inorderTwo = new ArrayList<>();
		inorder(one,inorderOne);
		inorder(two,inorderTwo);
		List<Integer> mergedInorder= mergeLists(inorderOne,inorderTwo);
		Node root= populateTree(one,mergedInorder,0,mergedInorder.size()-1);
		return root;
		
	}
	
	
	private static Node populateTree(Node root, List<Integer> mergedInorder, int i, int j) {
		// TODO Auto-generated method stub
		
		if(i>j)
			return null;
		
		int mid= i+(j-i)/2;
		
		if(root==null) {
			root= new Node(mergedInorder.get(mid));
			
		}
		else {
			root.data=mergedInorder.get(mid);
		}
		
		root.left= populateTree(root.left, mergedInorder, i, mid-1);
		root.right= populateTree(root.right, mergedInorder, mid+1, j);
		
		return root;
	}


	private static List<Integer> mergeLists(List<Integer> inorderOne, List<Integer> inorderTwo) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<>();
		int size1= inorderOne.size();
		int size2= inorderTwo.size();
		int i=0;
		int j=0;
		while(i < size1 && j< size2) {
			if(inorderOne.get(i)<=inorderTwo.get(j)) {
				result.add(inorderOne.get(i));
				i++;
			}
			else {
				result.add(inorderTwo.get(j));
				j++;
			}
		}
		while(i<size1) {
		       result.add(inorderOne.get(i));
		       i++;
		}
		
		while(j<size2) {
			result.add(inorderTwo.get(j));
			j++;
		}
		return result;
		
	}


	private static void inorder(Node one, List<Integer> inorderOne) {
		// TODO Auto-generated method stub
		if(one!=null) {
			inorder(one.left,inorderOne);
			inorderOne.add(one.data);
			inorder(one.right,inorderOne);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node one = new Node(100);
        one.left = new Node(50);
        one.right = new Node(300);
        one.left.left = new Node(20);
        one.left.right = new Node(70);
        Node two = new Node(80);
        two.left = new Node(40);
        two.right = new Node(120);
        Node root= mergeTrees(one, two);
        System.out.println("The Inorder traversal of the merged BST is: ");
        inorder(root);
        

	}


	private static void inorder(Node node) {
		// TODO Auto-generated method stub
		 if(node==null)
		        return;
		         
		    inorder(node.left);
		    System.out.print(node.data + " ");
		    inorder(node.right);
		
	}

}

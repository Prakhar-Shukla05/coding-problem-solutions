package tree.bst;

//GFG
//Problem link-https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
//There is BST given with root node with key part as integer only. You need to find the inorder successor and predecessor of a given key. In case, if the either of predecessor or successor is not found print -1.
//
//Input:
//The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains n denoting the number of edges of the BST. The next line contains the edges of the BST. The last line contains the key.
//
//Output:
//Print the predecessor followed by successor for the given key. If the predecessor or successor is not found print -1.
//
//Constraints:
//1<=T<=100
//1<=n<=100
//1<=data of node<=100
//1<=key<=100
//
//Example:
//Input:
//2
//6
//50 30 L 30 20 L 30 40 R 50 70 R 70 60 L 70 80 R
//65
//6
//50 30 L 30 20 L 30 40 R 50 70 R 70 60 L 70 80 R
//100
//
//Output:
//60 70
//80 -1

public class InorderPredecessorAndSuccessor {

	
	public static void findPreSuc(Node root,Node p, Node s, int key) {
		
		if(root==null)
			return ;
		
		if(root.data==key) {
			p= findPredecessor(root.left,p);
		    s= findSuccessor(root.right,s);
		}
		else if(root.data<key) {
		   p=root;
		   findPreSuc(root.right,p,s,key);
		}
		else {
			s=root;
		    findPreSuc(root.left,p,s,key);
		}
		
	}
    
	private static Node findPredecessor(Node root, Node p) {
		if(root==null)
			return p;
		
		p=root;
		return findPredecessor(root.right,p);
	}

	
	private static Node findSuccessor(Node root, Node s) {
		if(root==null)
			return s;
		s=root;
		return findSuccessor(root.left,s);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Node root= new Node(10);
         root.left= new Node(5);
         root.left.left= new Node(2);
         root.left.right= new Node(6);
         root.right= new Node(12);
         root.right.left= new Node(11);
         root.right.right= new Node(15);
         Node p=null;
         Node s= null;
         findPreSuc(root, p,s,8);
        // System.out.println(p.val);
         //System.out.println(s.val);
	}

}


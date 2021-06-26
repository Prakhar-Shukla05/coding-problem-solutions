package tree.bst;

public class PopulateInorderSuccessorOfAllNodes {

	static class Node {
	    int data;
	    Node left, right,next;
	    
	    public Node(int data){
	        this.data = data;
	    }
	}
	
	public static void populateNext(Node root) {
		if(root==null)
			return ;
		
		if(root.left==null && root.right== null && root.next!=null)
			return ;
		if(root.right==null && root.next == null) {
			
		}
		
		if(root.left!=null) {
			root.left.next=root;
		}
		
		if(root.right!=null) {
			root.next=root.right;
		}
		
		populateNext(root.left) ;
		populateNext(root.right);
	}
	private static 	void printTree(Node node, String prefix)
	 {
	    if(node == null) return;

	    if(node.next!=null)
	    System.out.println(prefix + " + " + node.data+ " * "+ node.next.data);
	    printTree(node.left , prefix + " ");
	    printTree(node.right , prefix + " ");
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left= new Node(8);
		root.left.left= new Node(3);
		root.right= new Node(12);
		populateNext(root);
		printTree(root,"");
      
	}

}

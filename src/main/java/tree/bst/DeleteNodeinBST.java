package tree.bst;

//Leetcode 450
//Problem link- https://leetcode.com/problems/delete-node-in-a-bst/
//Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
//Return the root node reference (possibly updated) of the BST.
//
//Basically, the deletion can be divided into two stages:
//
//Search for a node to remove.
//If the node is found, delete the node.
//Follow up: Can you solve it with time complexity O(height of tree)?
//
// 
//
//Example 1:
//
//
//Input: root = [5,3,6,2,4,null,7], key = 3
//Output: [5,4,6,2,null,null,7]
//Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
//One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
//Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

public class DeleteNodeinBST {

	public TreeNode deleteNode(TreeNode root, int key) {
             if(root==null)
            	 return null;
             
             root=solve(root,key);
             return root;
	}

	private static TreeNode solve(TreeNode root, int key) {
		 
		if(root==null)
			return root;
		
		if(root.val==key) {
			if(root.left==null && root.right==null)
			{
				root=null;
				
			}
			else if(root.left== null || root.right==null) {
				if(root.left!=null) {
					root=root.left;
				}
				else {
					root=root.right;
				}
			}
			
			else {
				TreeNode inOrderSuccessor=root.right;
				//TreeNode parentOfinOrderSuccessor= root;
				while(inOrderSuccessor.left!=null) {
				  //  parentOfinOrderSuccessor=inOrderSuccessor;
				    inOrderSuccessor=inOrderSuccessor.left;
				}/*
				root.val=inOrderSuccessor.val;
				if(inOrderSuccessor.right!=null) {
					
				}
				else if(parentOfinOrderSuccessor!=root){
				parentOfinOrderSuccessor.left=null;
				}
				else if(parentOfinOrderSuccessor==root) {
					parentOfinOrderSuccessor.right=null;
				}
				*/
			    //int todelete= root.val;
				root.val=inOrderSuccessor.val;
				root.right=solve(root.right,root.val);
				
			}
		}
		else if(root.val<key) {
			root.right=solve(root.right,key);
		}
		else {
			root.left=solve(root.left,key);
		}
		return root;
	}
	
	private static 	void printTree(TreeNode node, String prefix)
	 {
	    if(node == null) return;

	    System.out.println(prefix + " + " + node.val);
	    printTree(node.left , prefix + " ");
	    printTree(node.right , prefix + " ");
	 }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 TreeNode root= new TreeNode(10);
         root.left= new TreeNode(5);
         root.left.left= new TreeNode(2);
         root.left.right= new TreeNode(6);
         root.right= new TreeNode(12);
         root.right.left= new TreeNode(11);
         root.right.right= new TreeNode(15);
         root.right.right.left= new TreeNode(14);
         root= new DeleteNodeinBST().deleteNode(root, 12);
         printTree(root,"");
         

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	}

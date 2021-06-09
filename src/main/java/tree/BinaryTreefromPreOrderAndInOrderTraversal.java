package tree;

import java.util.HashMap;
import java.util.Map;

//Leetcode
//Problem link- https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class BinaryTreefromPreOrderAndInOrderTraversal {
	private int current=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0)
            return null;
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        TreeNode root= buildTree(preorder,inorder,0,preorder.length-1,map);
        return root;
    }
    
    private TreeNode buildTree(int [] preorder, int [] inorder, int leftIndex, int rightIndex, Map<Integer,Integer> map){
        if(rightIndex<leftIndex)
            return null;
        TreeNode root= new TreeNode(preorder[current++]);
        if(rightIndex==leftIndex)
            return root;
        int inorderIndex= map.get(root.val);
        root.left= buildTree(preorder,inorder,leftIndex,inorderIndex-1,map);
        root.right=buildTree(preorder,inorder,inorderIndex+1,rightIndex,map);
        return root;
    }
    
    public static void main(String[] args) {
		int [] preorder= {1,2,4,5,3,6};
		int [] inorder= {4,2,5,1,6,3};
		TreeNode root = new BinaryTreefromPreOrderAndInOrderTraversal().buildTree(preorder, inorder);
		System.out.println(root.val);
	}
}

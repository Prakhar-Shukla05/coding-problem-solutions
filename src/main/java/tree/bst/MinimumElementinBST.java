package tree.bst;

import tree.bst.SearchAndInsertion.Node;

public class MinimumElementinBST {

	int minValue(Node node)
    {
		if(node.left==null) {
			return node.val;
		}
		else {
			return minValue(node.left);
		}
     
		
    }
	
	
}
	
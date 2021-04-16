package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseLevelOrderTraversal {

	public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(node==null)
			return result;
		
		Queue<Node>q = new LinkedList<>();
		q.add(node);
	    result.add(node.data);
		while(!q.isEmpty()) {
			int size=q.size();
			while(size-->0) {
			Node temp= q.poll();
			if(temp.right!=null) {
				q.add(temp.right);
				result.add(temp.right.data);
				
			}
			if(temp.left!=null) {
				q.add(temp.left);
				result.add(temp.left.data);
			}
			size--;
			}
			
		}
		Collections.reverse(result);
		return result;
		
        
    }
}

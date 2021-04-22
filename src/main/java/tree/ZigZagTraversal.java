package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {

	
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    ArrayList<Integer> result= new ArrayList<>();
	    if(root==null)
	    	return result;
	    
	    Queue<Node> queue= new LinkedList<>();
	    boolean reversed=false;
	    queue.add(root);
	    while(!queue.isEmpty()) {
	    	ArrayList<Integer> level= new ArrayList<>();
	    	int size=queue.size();
	    	while(size>0) {
	    		Node temp= queue.poll();
	    		level.add(temp.data);
	    		if(temp.left!=null)
	    			queue.add(temp.left);
	    		if(temp.right!=null)
	    			queue.add(temp.right);
	    		size--;
	    	}
	    	if(reversed) {
	    		Collections.reverse(level);
	    		for(int i : level)
	    			result.add(i);
	    	}
	    	else {
	    		for(int i: level)
	    			result.add(i);
	    	}
	    	reversed=!reversed;
	    }
	    return result;
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

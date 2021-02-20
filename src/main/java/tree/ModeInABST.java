package tree;

import java.util.ArrayList;
import java.util.List;

public class ModeInABST {

	private Integer	 prev= null;
	private int count=1;
	private int max=0;
	
	public int[] findMode(TreeNode root) {
		
		List<Integer> modes = new ArrayList<>();
              
        traverse(root, modes);
        
        int [] result= new int[modes.size()];
        for(int i=0;i<modes.size();i++) {
        	result[i]=modes.get(i);
        }
        
        return result;
	}
	
	private void traverse(TreeNode node, List<Integer> modes) {
		
		if(node==null)
			return;
		
		traverse(node.left,modes);
		
		if(prev!=null) {
			
			
			if(prev==node.val)
			{
				count++;
			}
			else {
				count=1;
			}
		}
		
		if(count>max) {
			max=count;
			modes.clear();
			modes.add(node.val);
		}
		
		if(count==max) {
			modes.add(node.val);
		}
		
		prev= node.val;
		
		traverse(node.right,modes);
	}
}

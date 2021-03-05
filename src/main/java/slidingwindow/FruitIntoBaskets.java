package slidingwindow;

import java.util.HashMap;
import java.util.Map;

//Leetcode
//Problem link- https://leetcode.com/problems/fruit-into-baskets/description/
public class FruitIntoBaskets {

	public int totalFruit(int[] tree) {

		if(tree==null || tree.length==0)
			return 0;
		
		int maxFruits = 1;
		Map<Integer,Integer> map= new HashMap<>();
		
	    int i=0;
	    int j=0;
	    while(j<tree.length) {
	    	
	    	if(map.size()<=2) {
	    		map.put(tree[j],j++);
	    	}
	    	if(map.size()>2)
	    	{
	    		int min=tree.length-1;
	    		for(int x: map.values()) {
	    			min=Math.min(min, x);
	    		}
	    		i=min+1;
	    		map.remove(tree[min]);
	    	}
	    	maxFruits=Math.max(maxFruits,j-i );
	    }
        
		return maxFruits;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] tree= {3,3,3,1,2,1,1,2,3,3,4};
		System.out.println(new FruitIntoBaskets().totalFruit(tree));

	}

}

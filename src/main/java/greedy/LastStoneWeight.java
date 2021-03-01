package greedy;

import java.util.Collections;
import java.util.PriorityQueue;

//Leetcode
//Problem Link- https://leetcode.com/problems/last-stone-weight/
public class LastStoneWeight {

	public int lastStoneWeight(int[] stones) {
              
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int stone : stones)
			pq.add(stone);
		
		while(pq.size()>1) {
			int first= pq.remove();
			int second=pq.remove();
			if(first!=second)
				pq.add(first-second);
		}
		
		return pq.isEmpty()?0:pq.remove();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

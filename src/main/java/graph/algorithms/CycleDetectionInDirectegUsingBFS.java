package graph.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//GFG
//Problem link-https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
//Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
//
//
//Example 1:
//
//Input:
//
//
//
//Output: 1
//Explanation: 3 -> 3 is a cycle

//Use Kahn's Algorithm in this approach

public class CycleDetectionInDirectegUsingBFS {

	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		//int[] topo = new int[V];
		int[] indegree = new int[V];
 
		//int index=0;
		for (int i = 0; i < V; i++) {
			for (Integer it : adj.get(i)) {
				indegree[it]++;
			}
		}
		
		Queue<Integer> q= new LinkedList<>();
		for(int i=0;i<V;i++) {
			if(indegree[i]==0)
				q.add(i);
		}
		int count =0;
		while(!q.isEmpty()) {
			int top= q.poll();
			//topo[index++]=top;
			count++;
			for(Integer it : adj.get(top)) {
				indegree[it]--;
				if(indegree[it]==0)
					q.add(it);
			}
		}
		if(count==V)
			return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

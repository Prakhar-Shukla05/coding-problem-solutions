package graph.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//GFG
//Problem link-https://www.geeksforgeeks.org/topological-sorting/
//Given a Directed Graph with V vertices and E edges, Find any Topological Sorting of that Graph.

public class TopologicalSortUsingBFS {

	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

		int[] topo = new int[V];
		int[] indegree = new int[V];
 
		int index=0;
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
		
		while(!q.isEmpty()) {
			int top= q.poll();
			topo[index++]=top;
			for(Integer it : adj.get(top)) {
				indegree[it]--;
				if(indegree[it]==0)
					q.add(it);
			}
		}
		
		
		return topo;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

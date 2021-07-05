package graph.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//GFG
//Problem link-https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
//
//Given an unweighted graph, a source, and a destination, we need to find the 
//shortest path from source to destination in the graph in the most optimal way

public class ShortestPathInUndirectedGraphWithUnitDistance {

	private void shortestPath(ArrayList<ArrayList<Integer>> adj, int N, int src) {
		
		int [] distance = new int [N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[src]=0;
		Queue<Integer> q= new LinkedList<>();
		q.add(src);
		while(!q.isEmpty()) {
			int node = q.poll();
			for(Integer it : adj.get(node)) {
			      if(distance[node]+1<distance[it]) {
			    	  distance[it]=distance[node]+1;
			    	  q.add(it);
			      }
			}
		}
		
		for(int i=0;i<N;i++) {
			System.out.print(distance[i]+ " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

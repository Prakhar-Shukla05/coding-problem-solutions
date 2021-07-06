package graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//GFG
//Problem link-
//Given a weighted directed graph with n nodes and m edges. Nodes are labeled from
//0 to n-1, the task is to check if it contains a negative weight cycle or not.
//Note: edges[i] is defined as u, v and weight.
//
//Example 1:
//
//Input: n = 3, edges = {{0,1,-1},{1,2,-2},
//{2,0,-3}}
//Output: 1
//Explanation: The graph contains negative weight
//cycle as 0->1->2->0 with weight -1,-2,-3,-1
//
//Example 2:
//
//Input: n = 3, edges = {{0,1,-1},{1,2,-2},
//{2,0,3}}
//Output: 0
//Explanation: The graph does not contain any
//negative weight cycle.

//Use Bellman Ford Algorithm
public class NegativeWeightCycle {

	static class Node{
		private int u;
		private int v;
		private int w;
		public int getU() {
			return u;
		}
		public int getV() {
			return v;
		}
		public int getW() {
			return w;
		}
		public Node(int u, int v, int w) {
			super();
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		
	}
	
	public static int isNegativeWeightCycle(int n, int[][] edges) {
	
		List<Node> adj= new ArrayList<Node>();
		
		for(int i=0;i<n;i++) {
			adj.add(new Node(edges[i][0], edges[i][1], edges[i][2]));
		}
		return bellmanFord(adj,n,0);
	}

	private static int bellmanFord(List<Node> edges, int N, int src)
    {
		
		int [] distance = new int [N];
		Arrays.fill(distance, (int)1e5);
		distance[src]=0;
		
		for(int i=1;i<N;i++) {
			for(Node n : edges) {
				int u=n.getU();
				int v=n.getV();
				int w=n.getW();
				if(distance[u]+w<distance[v])
					distance[v]=distance[u]+w;
				
			}
		}
		
		//boolean flag=false;
		
		for(Node n : edges) {
			int u=n.getU();
			int v=n.getV();
			int w=n.getW();
			if(distance[u]+w<distance[v]) {
				//flag=true;
				return 1;
			   // System.out.println("Negative cycle");
				//distance[v]=distance[u]+w;
			}
		}
		
		return 0;
		/*
		if(!flag) {
			for(int i=0;i<N;i++) {
				System.out.println(distance[i]);
			}
		}*/
	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

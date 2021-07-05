package graph.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//GFG
//Problem link-https://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/
//Given a Weighted Directed Acyclic Graph and a source vertex in the graph, find 
//the shortest paths from given source to all other vertices.

public class ShortestPathInDirectedAcyclicGraph {

	public void shortesPath(int src, ArrayList<ArrayList<Edge>> adj, int N) {
         
		Stack<Integer> s= new Stack<>();
		int [] topo=topoSort(adj,N,s);
		int [] distance=new int [N];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[src]=0;
		
		for(int i=0;i<N;i++) {
			if(distance[topo[i]]!=Integer.MAX_VALUE) {
				int node=topo[i];
				for(Edge e: adj.get(i)) {
					int d=e.getD();
					int w=e.getW();
					if(distance[node]+w<distance[d])
						distance[d]=distance[node]+w;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			System.out.println(distance[i]+" ");
		}
		
	}
	
	private int [] topoSort(ArrayList<ArrayList<Edge>> adj,int N, Stack<Integer> s) 
	{ 
		
		int [] topo= new int [N];
		boolean [] visited= new boolean[N];
		for(int i=0;i<N;i++) {
			if(!visited[i])
				dfs(i,adj,s,visited);
		}
		int index=0;
		while(!s.isEmpty()) {
			topo[index++]=s.pop();
		}
		return topo;
		
	}

	private void dfs(int i, ArrayList<ArrayList<Edge>> adj, Stack<Integer> s,
			boolean [] visited) {
		// TODO Auto-generated method stub
		
		visited[i]=true;
		for(Edge e: adj.get(i)) {
			int next=e.getD();
			if(!visited[next])
				dfs(next,adj,s,visited);
		}
		s.push(i);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Edge {

	private int d;
	private int w;

	public Edge(int d, int w) {
		super();
		this.d = d;
		this.w = w;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

}
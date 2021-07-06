package graph.algorithms;

import java.util.ArrayList;
import java.util.Stack;

//A directed graph is strongly connected if there is a path between all pairs of
//vertices. A strongly connected component (SCC) of a directed graph is a maximal 
//strongly connected subgraph. For example, there are 3 SCCs in the following graph.

//1. Sort the nodees in order of finishing time i.e. topological sort
//2. Tranpose the graph (Reverse the edges)
//3. Perform dfs according to finishing time

public class KosarajuAlgoForStronglyConnectedComponents {

	public void kosaRaju(ArrayList<ArrayList<Integer>> adj, int n) {

		Stack<Integer> st= new Stack<Integer>();
		boolean visited[]= new boolean[n];
		for(int i=0;i<n;i++) {
			if(!visited[i])
				dfs(i,st,adj,visited);
		}
		ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<n;i++)
			transpose.add(new ArrayList<Integer>());
		
		for(int i=0;i<n;i++) {
			visited[i]=false;
			for(Integer it : adj.get(i)) {
				transpose.get(it).add(i);
			}
		}
		
		while(!st.isEmpty()) {
			int top= st.peek();
			st.pop();
			if(!visited[top]) {
				System.out.print("SCC is: ");
				revDfs(top,visited,transpose);
				System.out.println();
			}
		}
	}

	private void revDfs(int top, boolean[] visited, ArrayList<ArrayList<Integer>> transpose) {
		// TODO Auto-generated method stub
		visited[top]=true;
		System.out.print(top+" ");
		for(Integer it : transpose.get(top)) {
			if(!visited[it])
				revDfs(it,visited,transpose);
		}
		
	}

	private void dfs(int i, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj
			,boolean [] visited) {
		// TODO Auto-generated method stub
		visited[i]=true;
	
		for(Integer it : adj.get(i)) {
			if(!visited[it])
				dfs(it,st,adj,visited);
		}
		st.push(i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   
		    int n = 5;
	        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
			
			for (int i = 0; i < n; i++) 
				adj.add(new ArrayList<Integer>());
				
			adj.get(0).add(1);
			adj.get(1).add(2);
			adj.get(2).add(0);
			adj.get(1).add(3);
			adj.get(3).add(4);
			new KosarajuAlgoForStronglyConnectedComponents().kosaRaju(adj, n);

	}

}

package graph.problems;

import java.util.ArrayList;
import java.util.Stack;

//GFG
//Problem link- https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
//Strongly Connected Components (Kosaraju's Algo) 
//Medium Accuracy: 49.73% Submissions: 25612 Points: 4
//Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
//Find the number of strongly connected components in the graph.

public class KosarajuAlgo {

	public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
		Stack<Integer> st = new Stack<Integer>();
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				dfs(i, st, adj, visited);
		}
		ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < V; i++)
			transpose.add(new ArrayList<Integer>());

		for (int i = 0; i < V; i++) {
			visited[i] = false;
			for (Integer it : adj.get(i)) {
				transpose.get(it).add(i);
			}
		}

		int ans=0;
		while (!st.isEmpty()) {
			int top = st.peek();
			st.pop();
			if (!visited[top]) {
				//System.out.print("SCC is: ");
				ans++;
				revDfs(top, visited, transpose);
				//System.out.println();
			}
		}
		return ans;
	}
	private void revDfs(int top, boolean[] visited, ArrayList<ArrayList<Integer>> transpose) {
		// TODO Auto-generated method stub
		visited[top] = true;
		//System.out.print(top + " ");
		for (Integer it : transpose.get(top)) {
			if (!visited[it])
				revDfs(it, visited, transpose);
		}

	}

	private void dfs(int i, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[i] = true;

		for (Integer it : adj.get(i)) {
			if (!visited[it])
				dfs(it, st, adj, visited);
		}
		st.push(i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(0);
		adj.get(1).add(3);
		adj.get(3).add(4);
		
		System.out.println(new KosarajuAlgo().kosaraju(n, adj));

	}

}

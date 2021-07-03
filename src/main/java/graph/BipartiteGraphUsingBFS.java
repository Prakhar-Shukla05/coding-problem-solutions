package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//GeeksForGeeks
//Problem link-https://practice.geeksforgeeks.org/problems/bipartite-graph/1
//Given an adjacency list of a graph adj  of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.
//
//
//Example 1:
//
//Input: 
//
//Output: 1
//Explanation: The given graph can be colored 
//in two colors so, it is a bipartite graph.
//Example 2:
//
//Input:
//
//Output: 0
//Explanation: The given graph cannot be colored 
//in two colors such that color of adjacent 
//vertices differs. 
// 
//
//Your Task:
//You don't need to read or print anything. Your task is to complete the function isBipartite() which takes V denoting no. of vertices and adj denoting adjacency list of graph and returns a boolean value true if graph is bipartite otherwise returns false.
// 
//
//Expected Time Complexity: O(V)
//Expected Space Complexity: O(V)
//
//Constraints:
//1 ≤ V, E ≤ 105

public class BipartiteGraphUsingBFS {

	public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
		
		int [] color= new int [V];
		Arrays.fill(color, -1);
		
		for(int i=0;i<V;i++) {
			if(color[i]==-1) {
				if(!checkForBipartite(i,adj,color))
					return false;
			}
		}
		return true;
	}

	private boolean checkForBipartite(int src, ArrayList<ArrayList<Integer>> adj, int[] color) {
		// TODO Auto-generated method stub
		Queue<Integer> q= new LinkedList<>();
		q.add(src);
		color[src]=1;
		while(!q.isEmpty()) {
			int top= q.poll();
			for(Integer it : adj.get(top)) {
				if(color[it]==-1) {
					color[it]=1-color[top];
					q.add(it);
				}
				else if(color[it]==color[top])
					return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	int n = 7;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
			
		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(2).add(3);
		adj.get(3).add(2);

		adj.get(4).add(3);
		adj.get(3).add(4);

		adj.get(4).add(5);
		adj.get(5).add(4);

		adj.get(4).add(6);
		adj.get(6).add(4);

		adj.get(1).add(6);
		adj.get(6).add(1);
	*/	
		
		int n = 3;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
		
		adj.get(0).add(1);
		adj.get(1).add(0);
		
		adj.get(1).add(2);
		adj.get(2).add(1);
		
		BipartiteGraphUsingBFS obj = new BipartiteGraphUsingBFS(); 
		if(obj.isBipartite(n,adj) == true) System.out.println("Yes Bipartite"); 
		else System.out.println("Not Bipartite"); 
	}

}

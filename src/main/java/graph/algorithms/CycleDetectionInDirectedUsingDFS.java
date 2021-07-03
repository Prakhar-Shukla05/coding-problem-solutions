package graph.algorithms;

import java.util.ArrayList;
import java.util.Scanner;

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

public class CycleDetectionInDirectedUsingDFS {

	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		// code here
		boolean [] visited= new boolean[V];
		boolean [] dfsVisited= new boolean[V];
		
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				if(cycleExistsUsingDFS(i,visited,dfsVisited,adj))
					return true;
			}
		}
		return false;
	}

	private boolean cycleExistsUsingDFS(int src, boolean[] visited, boolean[] dfsVisited,
			ArrayList<ArrayList<Integer>> adj) {
		// TODO Auto-generated method stub
		visited[src]=true;
		dfsVisited[src]=true;
		
		for(Integer it : adj.get(src)) {
			
			if(!visited[it]) {
				if(cycleExistsUsingDFS(it, visited, dfsVisited, adj))
					return true;
			}
			else if(visited[it] & dfsVisited[it])
				return true;
		}
		
		dfsVisited[src]=false;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        
	        while(t-- > 0)
	        {
	            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	            int V = sc.nextInt();
	            int E = sc.nextInt();
	            for(int i = 0; i < V+1; i++)
	                list.add(i, new ArrayList<Integer>());
	            for(int i = 0; i < E; i++)
	            {
	                int u = sc.nextInt();
	                int v = sc.nextInt();
	                list.get(u).add(v);
	            }
	            if(new CycleDetectionInDirectedUsingDFS().isCyclic(V, list) == true)
	                System.out.println("1");
	            else System.out.println("0");
	        }
	}

}

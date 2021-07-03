package graph.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//GeeksforGeeks
//Problem link-https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
//Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 
//
//Example 1:
//
//Input:   
//
//Output: 1
//Explanation: 1->2->3->4->1 is a cycle.
//Example 2:
//
//Input: 
//
//Output: 0
//Explanation: No cycle in the graph.
// 
//
//Your Task:
//You dont need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices and adjacency list 
//as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not.

public class CycleDetectionInUndirectedUsingBFS {

	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		
		boolean [] visited = new boolean[V];
		//int [] parent= new int[V];
		//Arrays.fill(parent, -1);
		
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				if(checkCycleUsingBFS(i,adj,visited))
					return true;
			}
		}
		return false;
	}
	
	private boolean checkCycleUsingBFS(int current, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		
		Queue<Node> q = new LinkedList<>();
		visited[current]=true;
		q.add(new Node(current, -1));
		
		while(!q.isEmpty()) {
			Node top = q.poll();
			int val= top.val;
			int par=top.parent;
			for(Integer it : adj.get(top.val)) {
				if(!visited[it]) {
					q.add(new Node(it, val));
					//parent[it]=val;
					visited[it]=true;
				}
				else if(par!=it) {
					return true;
					
				}
			}
			
			
		}
		return false;
		}

	public static void main(String[] args) throws IOException {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int T = Integer.parseInt(br.readLine().trim());
	        while(T-->0)
	        {
	            String[] s = br.readLine().trim().split(" ");
	            int V = Integer.parseInt(s[0]);
	            int E = Integer.parseInt(s[1]);
	            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
	            for(int i = 0; i < V; i++)
	                adj.add(i, new ArrayList<Integer>());
	            for(int i = 0; i < E; i++){
	                String[] S = br.readLine().trim().split(" ");
	                int u = Integer.parseInt(S[0]);
	                int v = Integer.parseInt(S[1]);
	                adj.get(u).add(v);
	                adj.get(v).add(u);
	            }
	            
	            CycleDetectionInUndirectedUsingBFS cyc=  new CycleDetectionInUndirectedUsingBFS();
	            System.out.println(cyc.isCycle(V, adj));
	        }

	}

}

class Node{
	
	int val;
	int parent;
	public Node(int val, int parent) {
		super();
		this.val = val;
		this.parent = parent;
	}
	
	
	
}

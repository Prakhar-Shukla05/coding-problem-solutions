package graph.problems;

import java.util.ArrayList;
import java.util.List;

//Leetcode 1192
//Problem link- https://leetcode.com/problems/critical-connections-in-a-network/
//
//There are n servers numbered from 0 to n - 1 connected by undirected server-to-server
//connections forming a network where connections[i] = [ai, bi] represents a 
//connection between servers ai and bi. Any server can reach other servers 
//directly or indirectly through the network.
//
//A critical connection is a connection that, if removed, will make some servers
//unable to reach some other server.
//
//Return all critical connections in the network in any order.
//
// 
//
//Example 1:
//
//
//
//Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
//Output: [[1,3]]
//Explanation: [[3,1]] is also accepted.

//This is a find the bridges in a graph problem

public class CriticalConnectionsInaNetwork {

	public List<List<Integer>> criticalConnections(int n, 
			List<List<Integer>> connections) {
              
		List<List<Integer>> criticalPoints= new ArrayList<List<Integer>>();
		List<List<Integer>> adj= new ArrayList<List<Integer>>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<Integer>());
		}
		for(List<Integer> l : connections) {
			int u=l.get(0);
			int v=l.get(1);
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
		boolean []  visited= new boolean[n];
		int [] tin= new int [n];
		int [] low= new int [n];
		int timer=0;
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				dfs(i,-1,timer,adj,visited,tin,low,criticalPoints);
			}
		}
		return criticalPoints;
	}

	private void dfs(int src, int parent, int timer, List<List<Integer>> adj
			, boolean[] visited, int[] tin, int[] low,
			List<List<Integer>> criticalPoints) {
		// TODO Auto-generated method stub
		visited[src]=true;
		tin[src]=low[src]=timer++;
		
		for(Integer it: adj.get(src)) {
			
			if(it==parent)
				continue;
			
			if(!visited[it]) {
				dfs(it,src,timer,adj,visited,tin,low,criticalPoints);
				
				low[src]= Math.min(low[src], low[it]);
				
				if(low[it]>tin[src]) {
					List<Integer> l= new ArrayList<Integer>();
					l.add(src);
					l.add(it);
					criticalPoints.add(l);
				}
				
			}
			else {
				low[src]=Math.min(low[src], tin[it]);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}

package graph.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//GeeksForGeeks
//Problem link-https://www.geeksforgeeks.org/detect-cycle-undirected-graph/

public class CycleDetectionInUndirectedUsingDFS {

	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

		boolean[] visited = new boolean[V];
		//int[] parent = new int[V];
		//Arrays.fill(parent, -1);

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
			//	visited[i] = true;
				//parent[i] = -1;
				if (checkCycleUsingDFS(i,-1, adj, visited))
					return true;
			}
		}
		return false;
	}

	private boolean checkCycleUsingDFS(int src, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[src]=true;

		for (Integer it : adj.get(src)) {
			{
				if (!visited[it]) {
					//parent[it] = src;
					if(checkCycleUsingDFS(it,src, adj, visited))
						return true;
				} else if (it!=parent) {
					return true;
				}
			}
		}
		return false;

	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
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
	            
	            CycleDetectionInUndirectedUsingDFS cyc=  new CycleDetectionInUndirectedUsingDFS();
	            System.out.println(cyc.isCycle(V, adj));
	        }


	}

}

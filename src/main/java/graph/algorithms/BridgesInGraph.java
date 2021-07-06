package graph.algorithms;

import java.util.ArrayList;

public class BridgesInGraph {

	void printBridges(ArrayList<ArrayList<Integer>> adj, int n)
    {
        boolean vis[] = new boolean[n]; 
        int tin[] = new int[n];
        int low[] = new int[n]; 

        int timer = 0; 
        for(int i = 0;i<n;i++) {
        	if(!vis[i]) {
        		dfs(i, -1, vis, tin, low, adj, timer); 
        	}
        }
    }
	
	private void dfs(int i, int parent, boolean[] vis, int[] tin, int[] low, ArrayList<ArrayList<Integer>> adj, int timer) {
		// TODO Auto-generated method stub
		
		vis[i]=true;
		tin[i]=low[i]=timer++;
		
		for(Integer it : adj.get(i)) {
			
			if(it==parent)
				continue;
			
			if(!vis[it])
			{
				//edge i-it is a forward edge
				dfs(it,i,vis,tin,low,adj,timer);
				
				low[i]=Math.min(low[i], low[it]);
				
				if(low[it]>tin[i]) {
					System.out.println(i+ "->"+ it);
				}
			}
			else {
				//Since it is visited, edge i-it is a back edge
				//Back edge completes a cycle. It connects a node to its ancestor.
				// It can never be a bridge
				low[i]=Math.min(low[i], tin[it]);
			}
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
			
		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(0).add(2);
		adj.get(2).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(1).add(3);
		adj.get(3).add(1);

		adj.get(3).add(4);
		adj.get(4).add(3);
			
		BridgesInGraph obj = new BridgesInGraph(); 
		obj.printBridges(adj, n); 

	}

}

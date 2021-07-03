package graph.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

//GFG
public class BipartiteGraphUsingDFS {

	public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {

		int[] color = new int[V];
		Arrays.fill(color, -1);

		for (int i = 0; i < V; i++) {
			if (color[i] == -1) {
				if (!checkForBipartite(i,0, adj, color))
					return false;
			}
		}
		return true;
	}

	private boolean checkForBipartite(int src,int initial, ArrayList<ArrayList<Integer>> adj, int[] color) {
		// TODO Auto-generated method stub
		color[src]=1-initial;
		
		for(Integer it : adj.get(src)) {
			
			if(color[it]==-1) {
				if(!checkForBipartite(it,color[src], adj, color))
					return false;
			}
			else if(color[it]==color[src]) {
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
		
		BipartiteGraphUsingDFS obj = new BipartiteGraphUsingDFS(); 
		if(obj.isBipartite(n,adj) == true) System.out.println("Yes Bipartite"); 
		else System.out.println("Not Bipartite"); 
	}

}

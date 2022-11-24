package graph.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//A vertex in an undirected connected graph is an articulation point (or cut vertex)
//iff removing it (and edges through it) disconnects the graph. Articulation points
//represent vulnerabilities in a connected network single points whose failure
//would split the network into 2 or more components. They are useful for 
//designing reliable networks. 

public class ArticulationPoints {

	public Set<Integer> getArticulationPoints(ArrayList<ArrayList<Integer>> adj
			, int n){
		
		boolean [] visited= new boolean[n];
		int [] tin= new int [n];
		int [] low= new int [n];
		
		Set<Integer> articulationPoints= new HashSet<Integer>();
		int timer=0;
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				dfs(i,-1,adj,timer,visited,tin,low,articulationPoints);
			}
		}
		return articulationPoints;
	}
	private void dfs(int src, int parent, ArrayList<ArrayList<Integer>> adj, int timer,boolean[] visited, int[] tin, int[] low,
			Set<Integer> articulationPoints) {
		
		visited[src]=true;
		tin[src]=low[src]=timer++;
		int child=0;
		
		for(Integer it: adj.get(src)) {
			
			if(parent==it)
				continue;
			
			if(!visited[it]) {
				dfs(it,src,adj,timer,visited,tin,low,articulationPoints);
				child++;
				low[src]= Math.min(low[src], low[it]);
				
				if(low[it]>=tin[src] && parent!=-1)
					articulationPoints.add(src);
			}
			else {
				low[src]=Math.min(low[src],tin[it] );
				}
		}
		
		if(parent==-1 && child>1)
			articulationPoints.add(src);
		
		
		
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
		
		Set<Integer> result= new ArticulationPoints().getArticulationPoints(adj, n);
		for(int i : result)
			System.out.print(i+ " ");

	}

}

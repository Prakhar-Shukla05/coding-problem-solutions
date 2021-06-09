package graph;

import java.util.ArrayList;

public class DFSTraversal {

	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here
		 ArrayList<Integer> result = new ArrayList<>();
	        boolean [] visited= new boolean[V];
	     
	     for(int i=0;i<V;i++) {
	    	 if(!visited[i]) {
	    		 dfs(i,adj,result,visited);
	    	 }
	     }
	     return result;
	}
	
	private void dfs(int current, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result,boolean [] visited) {
		
		result.add(current);
		visited[current]=true;
	     for(int i=0;i<adj.get(current).size();i++) {
	    	 int in = adj.get(current).get(i);
	    	 if(!visited[in])
	    	 {
	    		 dfs(in,adj,result,visited); 
	    	 }
	     }
	}
	public static void main(String[] args) {
		 ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>();
         int v= 5;
         for(int i=0;i<v;i++)
         adj.add(new ArrayList<Integer>());
         
         adj.get(0).add(1);
         adj.get(0).add(2);
         adj.get(0).add(4);
         adj.get(4).add(3);
         System.out.println(new BFSTraversal().bfsOfGraph(v, adj));
         
	}

}

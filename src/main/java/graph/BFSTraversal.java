package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//GeeksForGeeks
//Problem link-https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
//Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
//Note: One can move from node u to node v only if there's an edge from u to v and find the BFS traversal of 
//the graph starting from the 0th vertex, from left to right according to the graph. 
//Also, you should only take nodes directly or indirectly connected from Node 0 in consideration
//Input:
//
//Output: 0 1 2 3 4
//Explanation: 
//0 is connected to 1 , 2 , 3.
//2 is connected to 4.
//so starting from 0, it will go to 1 then 2
//then 3.After this 2 to 4, thus bfs will be
//0 1 2 3 4.

public class BFSTraversal {

	
	public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> result = new ArrayList<>();
        boolean [] visited= new boolean[V];
        
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<V;i++) {
        	if(!visited[i]) {
        		visited[i]=true;
        		queue.add(i);
        		bfs(i,adj,result,visited,queue);
        	}
        }
        return result;
        	
    }
	
	private void bfs(int x, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result,boolean [] visited, Queue<Integer> q) {
		//visited[x]=true;
		//q.add(x);
		while(!q.isEmpty()) {
			int top= q.poll();
			result.add(top);
			for(int i=0;i<adj.get(top).size();i++) {
				int in= adj.get(top).get(i);
				//System.out.println(in);
				if(!visited[in]) {
				    q.add(in);
				    visited[in]=true;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>();
          int v= 5;
          for(int i=0;i<v;i++)
          adj.add(new ArrayList<Integer>());
          
          adj.get(0).add(1);
          adj.get(0).add(2);
          adj.get(0).add(3);
          adj.get(2).add(4);
          System.out.println(new BFSTraversal().bfsOfGraph(v, adj));
          
	}

}

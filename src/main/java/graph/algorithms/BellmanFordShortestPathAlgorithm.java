package graph.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

//Given a graph and a source vertex src in graph, find shortest paths from src to
//all vertices in the given graph. The graph may contain negative weight edges.
//We have discussed Dijkstra’s algorithm for this problem. Dijkstra’s algorithm is
//a Greedy algorithm and time complexity is O(VLogV) (with the use of Fibonacci heap).
//Dijkstra doesn’t work for Graphs with negative weight edges, Bellman-Ford works
//for such graphs. Bellman-Ford is also simpler than Dijkstra and suites well for
//distributed systems. But time complexity of Bellman-Ford is O(VE), which is 
//more than Dijkstra. 

public class BellmanFordShortestPathAlgorithm {

	static class Node{
		private int u;
		private int v;
		private int w;
		public int getU() {
			return u;
		}
		public int getV() {
			return v;
		}
		public int getW() {
			return w;
		}
		public Node(int u, int v, int w) {
			super();
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		
	}
	
	void bellmanFord(ArrayList<Node> edges, int N, int src)
    {
		
		int [] distance = new int [N];
		Arrays.fill(distance, (int)1e5);
		distance[src]=0;
		
		for(int i=1;i<N;i++) {
			for(Node n : edges) {
				int u=n.getU();
				int v=n.getV();
				int w=n.getW();
				if(distance[u]+w<distance[v])
					distance[v]=distance[u]+w;
				
			}
		}
		
		boolean flag=false;
		
		for(Node n : edges) {
			int u=n.getU();
			int v=n.getV();
			int w=n.getW();
			if(distance[u]+w<distance[v]) {
				flag=true;
			    System.out.println("Negative cycle");
				//distance[v]=distance[u]+w;
			    break;
			}
		}
		
		if(!flag) {
			for(int i=0;i<N;i++) {
				System.out.println(distance[i]);
			}
		}
	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          
		int n = 6;
        ArrayList<Node> adj = new ArrayList<Node>();
		
			
		adj.add(new Node(3, 2, 6));
		adj.add(new Node(5, 3, 1));
		adj.add(new Node(0, 1, 5));
		adj.add(new Node(1, 5, -3));
		adj.add(new Node(1, 2, -2));
		adj.add(new Node(3, 4, -2));
		adj.add(new Node(2, 4, 3));
        new BellmanFordShortestPathAlgorithm().bellmanFord(adj, n, 0);
	}

}

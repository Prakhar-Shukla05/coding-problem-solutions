package graph.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Krushkals algorithm to find MST

public class KrushKalsAlgorithm {
	
	class Node implements Comparator<Node>{
		private int u;
		private int v;
		private int w;
		public Node() {
			super();
		}
		public Node(int u, int v, int w) {
			super();
			this.u = u;
			this.v = v;
			this.w = w;
		}
		public int getU() {
			return u;
		}
		public int getV() {
			return v;
		}
		public int getW() {
			return w;
		}
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			if(o1.getW()<o2.getW())
				return -1;
			else if(o2.getW()<o1.getW())
				return 1;
			return 0;
		}
		
		
	}

	private  int findParent(int p, int [] parent) {
		if(p==parent[p])
			return p;
		else 
			return parent[p]=findParent(parent[p],parent);
	}
	private void KruskalAlgo(ArrayList<Node> adj, int N,KrushKalsAlgorithm obj) {
		Collections.sort(adj, obj.new Node());
		
		ArrayList<Node> mst= new ArrayList<Node>();
		int cost=0;
		
		int [] parent= new int[N];
		int [] rank= new int [N];
		for(int i=0;i<N;i++)
			parent[i]=i;
		
		for(Node n : adj) {
			if(findParent(n.getU(),parent)!=findParent(n.getV(),parent)) {
				cost+=n.getW();
				mst.add(n);
				union(n.getU(),n.getV(),parent,rank);
			}
			
		}
		System.out.println("The minimum cost is : "+ cost);
	}

	private void union(int u, int v, int[] parent, int[] rank) {
		// TODO Auto-generated method stub
		
		int uroot= findParent(u,parent);
		int vroot= findParent(v,parent);
		
		if(rank[uroot]<rank[vroot]) {
			parent[uroot]=vroot;
		}
		else if(rank[uroot]>rank[vroot]) {
			parent[vroot]=uroot;
		}
		else {
			parent[vroot]=uroot;
			rank[uroot]++;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    int n = 5;
	        ArrayList<Node> adj = new ArrayList<Node>();
	        KrushKalsAlgorithm obj = new KrushKalsAlgorithm(); 
				
			adj.add(obj.new Node(0, 1, 2));
			adj.add(obj.new Node(0, 3, 6));
			adj.add(obj.new Node(1, 3, 8));
			adj.add(obj.new Node(1, 2, 3));
			adj.add(obj.new Node(1, 4, 5));
			adj.add(obj.new Node(2, 4, 7));

		
			
			KruskalAlgo(adj, n, obj);
	}

}


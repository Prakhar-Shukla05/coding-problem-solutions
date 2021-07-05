package graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//GFG
//Problem link-https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
//Given a weighted, undirected and connected graph of V vertices and E edges. 
//The task is to find the sum of weights of the edges of the Minimum Spanning Tree.

public class MinimumSpanningTree {

	class Node implements Comparator<Node>{
		
		private int d;
		private int w;
		 

		public Node(int d, int w) {
			super();
			this.d = d;
			this.w = w;
		}


		public Node() {
			super();
		}

		

		public int getD() {
			return d;
		}


		public int getW() {
			return w;
		}


		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			if(o1.getW()<o2.getW())
				return -1;
			else if(o1.getW()>o2.getW())
				return 1;
			return 0;
		}
		
	}
	static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int [] key= new int [V];
        boolean [] mst= new boolean[V];
        int [] parent = new int [V];
        
        Arrays.fill(parent, -1);
        Arrays.fill(key, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq= new PriorityQueue<MinimumSpanningTree.Node>(V,new Node());
        key[0]=0;
        pq.add(new Node(0, key[0]));
        while(!pq.isEmpty()) {
        	Node node= pq.poll();
        	int u=node.getD();
        	mst[u]=true;
        	for(ArrayList<Integer> al : adj.get(u)) {
        		int d=al.get(0);
        		int w=al.get(1);
        		if(mst[d]==false && w<key[d]) {
        			parent[d]=u;
        			key[d]=w;
        			pq.add(new Node(d, key[d]));
        		}
        		
        	}
        }
        int sum=0;
        for(int i=1;i<V;i++) {
        	int par=parent[i];
        	//ArrayList<ArrayList<Integer>> l= adj.get(par);
        	for(ArrayList<Integer> l :adj.get(par)) {
        		if(l.get(0)==i)
        			sum+=l.get(1);
        	}
        }
        return sum;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}

}


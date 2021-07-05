package graph.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

	void primsAlgo(ArrayList<ArrayList<PrimNode>> adj, int N)
    {
		
		int [] key=new int[N];
		boolean [] mst= new boolean[N];
		int [] parent=new int [N];
		Arrays.fill(mst, false);
		Arrays.fill(key, (int)1e5);
		Arrays.fill(parent, -1);
		
		PriorityQueue<PrimNode> pq= new PriorityQueue<PrimNode>(N,new PrimNode());
		
		key[0]=0;
		pq.add(new PrimNode(key[0],0));
		
		while(!pq.isEmpty()) {
			PrimNode minimal= pq.poll();
			int u=minimal.getV();
			mst[u]=true;
			for(PrimNode p : adj.get(u)) {
				if(mst[p.getV()]==false && p.getW()<key[p.getV()] ) {
					parent[p.getV()]=u;
					key[p.getV()]=p.getW();
					pq.add(new PrimNode(p.getV(), key[p.getV()]));
				}
				
			}
		}
		for(int i = 1;i<N;i++) {
        	System.out.println(parent[i] + " - " + i); 
        }
		
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
        ArrayList<ArrayList<PrimNode> > adj = new ArrayList<ArrayList<PrimNode> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<PrimNode>());
			
		adj.get(0).add(new PrimNode(1, 2));
		adj.get(1).add(new PrimNode(0, 2));
		
		adj.get(1).add(new PrimNode(2, 3));
		adj.get(2).add(new PrimNode(1, 3));
		
		adj.get(0).add(new PrimNode(3, 6));
		adj.get(3).add(new PrimNode(0, 6));
		
		adj.get(1).add(new PrimNode(3, 8));
		adj.get(3).add(new PrimNode(1, 8));
		
		adj.get(1).add(new PrimNode(4, 5));
		adj.get(4).add(new PrimNode(1, 5));
		
		adj.get(2).add(new PrimNode(4, 7));
		adj.get(4).add(new PrimNode(2, 7));
		
		PrimsAlgorithm obj = new PrimsAlgorithm(); 
		obj.primsAlgo(adj, n); 

	}

}

class PrimNode implements Comparator<PrimNode>{
	
	private int v;
	private int w;
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public PrimNode() {
		super();
	}
	public PrimNode(int v, int w) {
		super();
		this.v = v;
		this.w = w;
	}
	@Override
	public int compare(PrimNode o1, PrimNode o2) {
		// TODO Auto-generated method stub
		if(o1.getW()<o2.getW())
			return -1;
		else if(o1.getW()>o2.getW())
			return 1;
		return 0;
	}
	
	
}
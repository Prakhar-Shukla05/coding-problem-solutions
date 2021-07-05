package graph.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithmforShortestPathInUndirected {

	public void shortestPath(int s, ArrayList<ArrayList<DijkstraNode>> adj, int N) {
		
		int [] distance = new int [N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		PriorityQueue<DijkstraNode> pq= new PriorityQueue<DijkstraNode>(N,new DijkstraNode());
		pq.add(new DijkstraNode(s, 0));
		
		while(!pq.isEmpty()) {
			DijkstraNode node = pq.poll();
			
			for(DijkstraNode n : adj.get(node.getDsc())) {
				
				if(distance[node.getDsc()]+ n.getWt()<distance[n.getDsc()]) {
					distance[n.getDsc()]=distance[node.getDsc()]+ n.getWt();
					pq.add(new DijkstraNode(n.getDsc(),distance[n.getDsc()]));
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			System.out.println(distance[i]+ " ");
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
        ArrayList<ArrayList<DijkstraNode> > adj = new ArrayList<ArrayList<DijkstraNode>>();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<DijkstraNode>());
			
		adj.get(0).add(new DijkstraNode(1, 2));
		adj.get(1).add(new DijkstraNode(0, 2));
		
		adj.get(1).add(new DijkstraNode(2, 4));
		adj.get(2).add(new DijkstraNode(1, 4));
		
		adj.get(0).add(new DijkstraNode(3, 1));
		adj.get(3).add(new DijkstraNode(0, 1));
		
		adj.get(3).add(new DijkstraNode(2, 3));
		adj.get(2).add(new DijkstraNode(3, 3));
		
		adj.get(1).add(new DijkstraNode(4, 5));
		adj.get(4).add(new DijkstraNode(1, 5));
		
		adj.get(2).add(new DijkstraNode(4, 1));
		adj.get(4).add(new DijkstraNode(2, 1));
		
		DijkstraAlgorithmforShortestPathInUndirected obj = new DijkstraAlgorithmforShortestPathInUndirected(); 
		obj.shortestPath(0, adj, n); 

	}

}

class DijkstraNode implements Comparator<DijkstraNode>{

	private int dsc;
	private int wt;
	

	public int getDsc() {
		return dsc;
	}


	public void setDsc(int dsc) {
		this.dsc = dsc;
	}


	public int getWt() {
		return wt;
	}


	public void setWt(int wt) {
		this.wt = wt;
	}

    public DijkstraNode() {   

    }
	public DijkstraNode(int dsc, int wt) {
		super();
		this.dsc = dsc;
		this.wt = wt;
	}


	@Override
	public int compare(DijkstraNode o1, DijkstraNode o2) {
		// TODO Auto-generated method stub
		if(o1.getWt()<o2.getWt())
			return -1;
		else if(o1.getWt()>o2.getWt())
			return 1;
		return 0;
	}
	
}

package graph.algorithms;

public class DisjointSet {

	private int [] parent;
	private int [] rank;
	
	
	public DisjointSet(int n) {
		parent=new int[n+1];
		rank= new int [n+1];
		for(int i=1;i<=n;i++) {
			parent[i]=i;
		}
	}
	
	private int findParent(int node) {
		if(node == parent[node])
			return node;
		
		return parent[node]=findParent(parent[node]); // This is path compression
	}

    private void union(int p, int q) {
    	int rootp=findParent(p);
    	int rootq=findParent(q);
    	if(rootp==rootq) return ;
    	
    	if(rank[rootp]<rank[rootq]) {
    		parent[rootp]=rootq;
    	}
    	else if(rank[rootp]>rank[rootq]) {
    		parent[rootq]=rootp;
    	}
    	else{
    		parent[rootq]=rootp;
    		rank[rootp]++;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

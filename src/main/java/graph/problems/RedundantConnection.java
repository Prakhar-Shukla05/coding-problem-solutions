package graph.problems;

//Leetcode 684

//Problem link-https://leetcode.com/problems/redundant-connection/
//In this problem, a tree is an undirected graph that is connected and has no cycles.
//
//You are given a graph that started as a tree with n nodes labeled from 1 to n,
//with one additional edge added. The added edge has two different vertices chosen
//from 1 to n, and was not an edge that already existed. The graph is represented 
//as an array edges of length n where edges[i] = [ai, bi] indicates that there is 
//an edge between nodes ai and bi in the graph.
//
//Return an edge that can be removed so that the resulting graph is a tree of n nodes.
//If there are multiple answers, return the answer that occurs last in the input.
//		
//
//		Example 1:
//
//
//			Input: edges = [[1,2],[1,3],[2,3]]
//			Output: [2,3]
//		

//We can solve this using Disjoint Set data structure
public class RedundantConnection {

	private int findPar(int p, int [] parent) {
		if(p==parent[p])
			return p;
		else
			return parent[p]=findPar(parent[p],parent);
	}
	
	private void union(int p, int q,int [] parent,int [] rank) {
		int pr=findPar(p,parent);
		int qr=findPar(q,parent);
		if(pr==qr) return ;
		if(rank[pr]<rank[qr]) {
			parent[pr]=qr;
		}
		else if(rank[pr]>rank[qr]) {
			parent[qr]=pr;
		}
		else {
			parent[qr]=pr;
			rank[pr]++;
		}
		
		
	}
	public int[] findRedundantConnection(int[][] edges) {
		
		int n= edges.length;
		int [] parent = new int [n+1];
		int [] rank = new int [n+1];
		for (int i=0;i<=n;i++) {
			parent[i]=i;
		}
		int [] res= new int [2];
		for(int [] edge : edges) {
			int u=edge[0];
			int v=edge[1];
			if(findPar(u,parent)==findPar(v,parent)) {
				res[0]=u;
				res[1]=v;
				
			}
			union(u,v,parent,rank);
		}
		return res;

	}

}

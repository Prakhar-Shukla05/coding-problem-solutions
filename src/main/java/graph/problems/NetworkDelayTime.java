package graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

//Leetcode 743
//Problem link-https://leetcode.com/problems/network-delay-time/
//
//You are given a network of n nodes, labeled from 1 to n. You are also given times,
//a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the 
//source node, vi is the target node, and wi is the time it takes for a signal to 
//travel from source to target.
//
//We will send a signal from a given node k. Return the time it takes for all the 
//n nodes to receive the signal. If it is impossible for all the n nodes to receive
//the signal, return -1.

//Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//Output: 2

//This is a problem to find the shortest path
public class NetworkDelayTime {
	
	private final int INFINITE = (int)1e5;
	public int networkDelayTime(int[][] times, int n, int k) {
		
        List<List<NetworkDelayEdge>> adj= new ArrayList<List<NetworkDelayEdge>>();
        for(int i=0;i<=n;i++) {
        	adj.add(new ArrayList<NetworkDelayEdge>());
        }
        for(int [] arr : times) {
        	int u=arr[0];
        	int v= arr[1];
        	int w=arr[2];
        	adj.get(u).add(new NetworkDelayEdge(v, w));
        }
//		Stack<Integer> st = new Stack<Integer>();
//		boolean [] visited= new boolean[n+1];
//		for(int i=1;i<=n;i++) {
//			if(!visited[i]) {
//				topoSort(i,adj,visited,st);
//			}
//		}
//		
//		int [] dist= new int[n+1];
//		Arrays.fill(dist, INFINITE);
//		//Arrays.fill(visited, false);
//		dist[k]=0;
//		while(!st.isEmpty()) {
//			int top= st.pop();
//			if(dist[top]!=-1) {
//				for(NetworkDelayEdge e : adj.get(top)) {
//					if(dist[top]+e.getW()<dist[e.getV()]) {
//						dist[e.getV()]=dist[top]+e.getW();
//					}
//				}
//			}
//		}
//		
//		int max=0;
//		for(int i=1;i<=n;i++) {
//			if(dist[i]==INFINITE)
//				return -1;
//			if(dist[i]>max) max=dist[i];
//		}
//		return max;
//		Will not work as the problem also has directed cyclic graphs. Have to use Dijkstra's algorithm
		
		int [] dist= new int [n+1];
		Arrays.fill(dist, INFINITE);
		dist[k]=0;
		PriorityQueue<NetworkDelayEdge> pq= new PriorityQueue<NetworkDelayEdge>(n, new NetworkDelayEdge());
		pq.add(new NetworkDelayEdge(k,0));
		
		while(!pq.isEmpty()) {
			int minimal=pq.poll().getV();
			
			for(NetworkDelayEdge e : adj.get(minimal)) {
				if(dist[minimal]+e.getW()<dist[e.getV()])
				{
					dist[e.getV()]=dist[minimal]+e.getW();
					pq.add(new NetworkDelayEdge(e.getV(), dist[e.getV()]));
				}
			}
		}
		int max=0;
		for(int i=1;i<=n;i++) {
			if(dist[i]==INFINITE)
				return -1;
			if(dist[i]>max) max=dist[i];
		}
		return max;
		
	}

	private void topoSort(int i, List<List<NetworkDelayEdge>> adj, boolean[] visited, Stack<Integer> st) {
		// TODO Auto-generated method stub
		visited[i]=true;
		
		for(NetworkDelayEdge e : adj.get(i)) {
			if(!visited[e.getV()]) {
				topoSort(e.getV(),adj,visited,st);
			}
		}
		st.push(i);
		
		
	}
	
	public static void main(String[] args) {
		int [][] time= {{1,2,1}};
        int n=2;
        int k=1;
        System.out.println(new NetworkDelayTime().networkDelayTime(time, n, k));
	}
}

class NetworkDelayEdge implements Comparator<NetworkDelayEdge>{
	//private int u;
	private int v;
	private int w;
	public NetworkDelayEdge(int v, int w) {
		super();
		//this.u = u;
		this.v = v;
		this.w = w;
	}
	
	public NetworkDelayEdge() {
		super();
	}

	public int getV() {
		return v;
	}
	public int getW() {
		return w;
	}

	@Override
	public int compare(NetworkDelayEdge o1, NetworkDelayEdge o2) {
		// TODO Auto-generated method stub
		if(o1.getW()<o2.getW())
			return -1;
		else if(o1.getW()>o2.getW())
			return 1;
		return 0;
	}
	
	
}
package graph.problems;

import java.util.ArrayList;
import java.util.List;

//Hackerearth
//Given an Apple tree in form of a graph. There are N vertices connected by N-1 edges. Every vertex has an apple on it. 
//Every edge has a value associated with it. Value defines the force it can absorb. Apple on some vertex X falls if force reaching it is non zero.
//
//If some force F is applied on vertex X. it travels downwards and is reduced by value associated with the edge. 
//Given queries each containing two integers U and U. you need to find two integers X and F such that that needs to be applied on vertex X so 
//that all the applies on the path from vertex U to V fall down. F is the minimum force
//
//Note: For vertex containing more than one children Force remains same, ie it is not distributed.
//
//Input Format
//
//First line: N denoting number of vertices.
//
//Each of the next. N - 1 lines contain three integers U. V and W. defining edge between vertex U&U with resistance value
//
//W
//Next line Q: Number of Queries
//
//Each of the next lines: Two integers U. V.
//
//Output Format
//
//For each query, print in new line two space separated integers X and F(vertex and force required) respectively.
//
//Sample Input
//
//6
//1 3 2
//3 5 4
//1 2 3
//2 6 5
//2 4 7
//2
//4 6
//6 3
//
//Sample Output
//2 8
//1 9

public class PushApples {

	private  List<List<AppleNode>> graph;
	public static class Pair{
		public int first;
		public int second;
	}
	
	public static Pair getAns(int N, int u, int v, int ui[], int vi[], int wi[]) {
		
		Pair res= new Pair();
		boolean [] visited= new boolean[N];
		return res;
	}
	
	private  void generateGraph(int [] ui, int [] vi, int wi[], int N) {
		graph=new ArrayList<>();
		for(int i=0;i<N;i++) {
			graph.add(new ArrayList<AppleNode>());
			}
		for(int i=0;i<N;i++) {
			graph.get(vi[i]).add(new AppleNode(ui[i], wi[i]));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class AppleNode{
	public int dest;
	public int value;
	public AppleNode(int dest, int value) {
		super();
		this.dest = dest;
		this.value = value;
	}
	
	
}
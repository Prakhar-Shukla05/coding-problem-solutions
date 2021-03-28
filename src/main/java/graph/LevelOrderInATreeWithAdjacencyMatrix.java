package graph;

import java.util.LinkedList;
import java.util.Queue;
import utility.*;
//Hackerrank
//BFS Problem

//Level order traversal of a tree is obtained by doing a breadth first search on it.
//
//You are given a tree with N nodes and N-1 edges. Each edge is bidirectional and connects two nodes.
//
//The nodes of the tree are indexed from 1 to N and you can consider 1 to be the root of the tree.
//
//You are given an integer d. Your task is to print the number of nodes that are present at the dth level of the tree.
//
//It is guaranteed that atleast one node will be present at the dth level.
//
//Input
//
//First line contains n the number of nodes
//Next n - 1 lines each contain two integers u and v such that there is an edge between u and v
//Last line contains the integer d
//
//Output
//
//Print one number, the count of nodes at dth level of the tree
//
//Sample Input 0
//
//20
//11 1
//1 2
//13 3
//15 4
//17 5
//11 6
//2 7
//1 8
//15 9
//4 10
//15 12
//5 13
//2 14
//17 15
//15 16
//11 17
//15 18
//9 19
//16 20
//2
//Sample Output 0
//
//3

public class LevelOrderInATreeWithAdjacencyMatrix {

	private static void bfs(int s, int[][] adj, int[] dist, boolean[] visited, Queue<Integer> q, int n) {
		visited[s] = true;
		dist[s] = 1;
		q.add(s);
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int i = 1; i <= n; i++) {
				if (adj[x][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					dist[i] = dist[x] + 1;
				}
			}
		}

	}

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n = in.readInt();
		int temp = n;
		int[][] adj = new int[n + 1][n + 1];
		int[] dist = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		while (temp-- > 1) {
			int x = in.readInt();
			int y = in.readInt();
			adj[x][y] = 1;
			adj[y][x] = 1;
		}

		bfs(1, adj, dist, visited, q, n);

		int d = in.readInt();
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] == d)
				count++;
		}
		out.printLine(count);
		out.close();
	}

}

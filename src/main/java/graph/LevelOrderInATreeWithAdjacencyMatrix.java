package graph;

import java.util.LinkedList;
import java.util.Queue;
import utility.*;
//Hackerrank
//BFS Problem
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

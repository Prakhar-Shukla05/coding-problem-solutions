package graph;

import utility.*;
public class UnreachableNodesWithAdjacencyMatrix {

	private static void dfs(int s, int[][] adj, boolean[] visited, int n) {

		visited[s] = true;
		for (int i = 1; i <= n; i++) {
			if (adj[s][i] == 1 && !visited[i]) {
				dfs(i, adj, visited, n);
			}
		}
	}

	public static void main(String[] args) {
		//
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n = in.readInt();
		int m = in.readInt();
		int[][] adj = new int[n + 1][n + 1];
		// int [] dist = new int [n+1];
		boolean[] visited = new boolean[n + 1];
		// Queue<Integer> q = new LinkedList<>();
		while (m-- > 0) {
			int x = in.readInt();
			int y = in.readInt();
			adj[x][y] = 1;
			adj[y][x] = 1;
		}
		int source = in.readInt();
		dfs(source, adj, visited, n);
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i])
				count++;
		}

		out.printLine(count);
		out.close();
	}

}

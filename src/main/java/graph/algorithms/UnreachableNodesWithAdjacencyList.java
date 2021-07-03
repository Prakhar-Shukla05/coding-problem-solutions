package graph.algorithms;

import java.util.ArrayList;
import java.util.List;
import utility.*;
//Hackerrank
//DFS Problem
public class UnreachableNodesWithAdjacencyList {

	private static void dfs(int s, List<List<Integer>> adj, boolean[] visited, int n) {
		visited[s] = true;

		for (int i = 0; i < adj.get(s).size(); i++) {
			int next = adj.get(s).get(i);
			// adj.get(s).remove(i);
			if (!visited[next])
				dfs(next, adj, visited, n);

		}
	}

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n = in.readInt();
		int m = in.readInt();
		List<List<Integer>> adj = new ArrayList<List<Integer>>(n + 1);
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		boolean[] visited = new boolean[n + 1];
		while (m-- > 0) {
			int x = in.readInt();
			int y = in.readInt();
			adj.get(x).add(y);
			adj.get(y).add(x);
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

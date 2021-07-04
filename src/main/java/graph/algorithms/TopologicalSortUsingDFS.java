package graph.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

//GFG
//Problem link-https://www.geeksforgeeks.org/topological-sorting/
//Given a Directed Graph with V vertices and E edges, Find any Topological Sorting of that Graph.

public class TopologicalSortUsingDFS {

	Stack<Integer> st;

	int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
		// add your code here
		int[] result = new int[V];
		boolean[] visited = new boolean[V];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfs(i, visited, adj);
			}
		}
		int index = 0;
		while (!st.isEmpty()) {
			result[index++] = st.pop();
		}
		return result;
	}

	private void dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
		// TODO Auto-generated method stub
		visited[i] = true;

		for (Integer it : adj.get(i)) {

			if (!visited[it]) {
				dfs(it, visited, adj);
			}
		}

		st.push(i);

	}

	static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
		int[] map = new int[V];
		for (int i = 0; i < V; i++) {
			map[res[i]] = i;
		}
		for (int i = 0; i < V; i++) {
			for (int v : list.get(i)) {
				if (map[i] > map[v])
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			String st[] = read.readLine().trim().split("\\s+");
			int edg = Integer.parseInt(st[0]);
			int nov = Integer.parseInt(st[1]);

			for (int i = 0; i < nov + 1; i++)
				list.add(i, new ArrayList<Integer>());

			int p = 0;
			for (int i = 1; i <= edg; i++) {
				String s[] = read.readLine().trim().split("\\s+");
				int u = Integer.parseInt(s[0]);
				int v = Integer.parseInt(s[1]);
				list.get(u).add(v);
			}

			int[] res = new TopologicalSortUsingDFS().topoSort(nov, list);

			if (check(list, nov, res) == true)
				System.out.println("1");
			else
				System.out.println("0");
		}

	}

}

package dfs;

public class PathWithMinimumEffort {

	public static int minimumEffortPath(int[][] heights) {
		int s = 0;
		int e = Integer.MAX_VALUE;
		int ans = Integer.MAX_VALUE;
		int n = heights.length;
		int m = heights[0].length;
		// boolean [][]visited = new boolean[100][100]; Ye galti kar raha tha
		while (s <= e) {
			int mid = s + (e - s) / 2;
			boolean[][] visited = new boolean[n][m];
			if (dfs(0, 0, mid, n, m, heights, visited)) {
				ans = Math.min(ans, mid);
				e = mid - 1;
			} else
				s = mid + 1;

		}
		return ans;
	}

	private static boolean dfs(int i, int j, int mid, int n, int m, int[][] h, boolean[][] v) {

		if (i == n - 1 && j == m - 1)
			return true;

		v[i][j] = true;
		boolean op = false;
		if (i > 0 && !v[i - 1][j] && Math.abs((h[i][j]) - (h[i - 1][j])) <= mid)
			op = op || dfs(i - 1, j, mid, n, m, h, v);

		if (j > 0 && !v[i][j - 1] && Math.abs((h[i][j]) - (h[i][j - 1])) <= mid)
			op = op || dfs(i, j - 1, mid, n, m, h, v);

		if (i < n - 1 && !v[i + 1][j] && Math.abs((h[i][j]) - (h[i + 1][j])) <= mid)
			op = op || dfs(i + 1, j, mid, n, m, h, v);

		if (j < n - 1 && !v[i][j + 1] && Math.abs((h[i][j]) - (h[i][j + 1])) <= mid)
			op = op || dfs(i, j + 1, mid, n, m, h, v);

		return op;

	}

	public static void main(String[] args) {
		int[][] h1 = { { 1, 2, 3 }, { 3, 8, 4 }, { 5, 3, 5 } };
		System.out.println(minimumEffortPath(h1));
		// int [] [] h2 = {[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]}
		int[][] h2= {{1,10,6,7,9,10,4,9}};
		System.out.println(minimumEffortPath(h2	));
	}
}

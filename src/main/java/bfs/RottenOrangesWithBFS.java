package bfs;

import java.util.LinkedList;
import java.util.Queue;

//import com.sun.tools.javac.util.List;

public class RottenOrangesWithBFS {

	public int orangesRotting(int[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;

		int count = 0;
		// boolean set =true;
		int fresh = 0;
		int convert = 0;
		Queue<Integer> row = new LinkedList<Integer>();
		Queue<Integer> col = new LinkedList<Integer>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					row.offer(i);
					col.offer(j);
				}
				if (grid[i][j] == 1)
					fresh++;
			}

		}

		while (!row.isEmpty() && convert < fresh) {
			int size = row.size();
			while (size > 0) {
				int r = row.poll();
				int c = col.poll();

				// boolean che= isValid(r+1,c,grid.length,grid[0].length);
				// int ch1= grid[r+1][c];
				if (isValid(r + 1, c, grid.length, grid[0].length) && grid[r + 1][c] == 1) {
					row.offer(r + 1);
					col.offer(c);
					convert++;
					grid[r + 1][c] = 2;
				}
				if (isValid(r, c + 1, grid.length, grid[0].length) && grid[r][c + 1] == 1) {
					row.offer(r);
					col.offer(c + 1);
					convert++;
					grid[r][c + 1] = 2;
				}
				if (isValid(r - 1, c, grid.length, grid[0].length) && grid[r - 1][c] == 1) {
					row.offer(r - 1);
					col.offer(c);
					convert++;
					grid[r - 1][c] = 2;
				}
				if (isValid(r, c - 1, grid.length, grid[0].length) && grid[r][c - 1] == 1) {
					row.offer(r);
					col.offer(c - 1);
					convert++;
					grid[r][c - 1] = 2;
				}

				size--;

			}
			count++;
		}
		if (fresh == convert)
			return count;
		else
			return -1;
	}

	private static boolean isValid(int x, int y, int row, int col) {
		return x >= 0 && x < row && y >= 0 && y < col;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 2 } };
		System.out.println(new RottenOrangesWithBFS().orangesRotting(grid));
	}

}

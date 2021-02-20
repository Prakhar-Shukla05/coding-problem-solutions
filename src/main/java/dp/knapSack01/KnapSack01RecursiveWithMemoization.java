package dp.knapSack01;

import java.util.Arrays;

//GeeksForGeeks
public class KnapSack01RecursiveWithMemoization {

	private static int[][] t;

	static int knapSack(int W, int wt[], int val[], int n) {

		t = new int[n + 1][W + 1];
		for (int[] row : t) {
			Arrays.fill(row, -1);
		}
		return knapSackRecursiveWithMemoization(W, wt, val, n);

	}

	private static int knapSackRecursiveWithMemoization(int W, int[] wt, int[] val, int n) {

		if (n == 0 || n == 0)
			return 0;

		if (t[n][W] != -1) {
			return t[n][W];
		}
		if (wt[n - 1] <= W) {
			t[n][W] = Math.max(val[n - 1] + knapSackRecursiveWithMemoization(W - wt[n - 1], wt, val, n - 1),
					knapSackRecursiveWithMemoization(W, wt, val, n - 1));
			return t[n][W];
		} else {
			t[n][W] = knapSackRecursiveWithMemoization(W, wt, val, n - 1);
			return t[n][W];
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

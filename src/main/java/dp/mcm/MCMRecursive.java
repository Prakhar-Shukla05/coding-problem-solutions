package dp.mcm;

import utility.IOUtils;
import utility.InputReader;
import utility.OutputWriter;

public class MCMRecursive {

	private static int solve(int[] arr, int i, int j) {
		if (i >= j)
			return 0;
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int temp = solve(arr, i, k) + solve(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
			if (temp < min)
				min = temp;
		}
		return min;
	}

	static int matrixMultiplication(int N, int arr[]) {

		if (arr == null || arr.length == 0)
			return 0;
		int i = 1;
		int j = N - 1;
		return solve(arr, i, j);
	}

	public static void main(String[] args) {

		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n = in.readInt();
		int[] arr = IOUtils.readIntArray(in, n);
		out.print(matrixMultiplication(n, arr));
		out.close();
	}
}

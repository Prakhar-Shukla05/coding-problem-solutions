package dp.mcm;

import java.util.Arrays;

import utility.IOUtils;
import utility.InputReader;
import utility.OutputWriter;

public class MCMRecursiveWithMemoization {

	private static int solve(int[] arr, int i, int j, int [] [] dp) {
		if (i >= j)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int temp = solve(arr, i, k,dp) + solve(arr, k + 1, j,dp) + (arr[i - 1] * arr[k] * arr[j]);
			if (temp < min)
				min = temp;
		}
		return dp[i][j]=min;
	}

	static int matrixMultiplication(int N, int arr[]) {

		if (arr == null || arr.length == 0)
			return 0;
		int i = 1;
		int j = N - 1;
		int [] [] dp = new int [N][N];
		for(int [] rows : dp)
			Arrays.fill(rows, -1);
		return solve(arr, i, j, dp);
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

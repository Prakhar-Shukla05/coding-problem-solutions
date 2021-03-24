package dp.mcm;

import utility.IOUtils;
import utility.InputReader;
import utility.OutputWriter;

//GeeksforGeeks
//Problem link - https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
//Given a sequence of matrices, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications. 
//The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1) where the ith matrix has the dimensions (arr[i-1] x arr[i]).
//Input: N = 5
//arr = {40, 20, 30, 10, 30}
//Output: 26000
//Explaination: There are 4 matrices of dimension 
//40x20, 20x30, 30x10, 10x30. Say the matrices are 
//named as A, B, C, D. The efficient way is 
//(A*(B*C))*D. The number of operations are 20*30*10 
//+ 40*20*10 + 40*10*30 = 26000.

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

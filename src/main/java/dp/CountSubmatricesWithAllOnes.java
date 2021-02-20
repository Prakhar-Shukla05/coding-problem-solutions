package dp;

import java.util.Arrays;

public class CountSubmatricesWithAllOnes {

//	public int numSubmat(int[][] mat) {
//
//		int r = mat.length;
//		int c = mat[0].length;
//		int[][] aux = new int[r][c];
//		for (int i = 0; i < r; i++) {
//			int x = 0;
//			for (int j = c - 1; j >= 0; j--) {
//
//				if (mat[i][j] == 1) {
//					x++;
//				} else {
//					x = 0;
//				}
//				aux[i][j] = x;
//			}
//		}
//
//		int ans = 0;
//		for (int i = 0; i < r; i++) {
//			for (int j = 0; j < c; j++) {
//				int min = Integer.MAX_VALUE;
//				for (int k = i; k < r; k++) {
//					min = Math.min(min, aux[k][j]);
//					ans += min;
//				}
//			}
//		}
//		return ans;
//
//	}

	public int numSubmat(int[][] mat) {
		int M = mat.length, N = mat[0].length;

		int res = 0;
		for (int up = 0; up < M; ++up) {
			int[] h = new int[N];
			Arrays.fill(h, 1);
			for (int down = up; down < M; ++down) {
				for (int k = 0; k < N; ++k)
					h[k] &= mat[down][k];
				res += countOneRow(h);
			}
		}

		return res;
	}

	private int countOneRow(int[] A) {

		int res = 0, length = 0;
		for (int i = 0; i < A.length; ++i) {
			length = (A[i] == 0 ? 0 : length + 1);
			res += length;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		System.out.println(new CountSubmatricesWithAllOnes().numSubmat(mat));

	}

}

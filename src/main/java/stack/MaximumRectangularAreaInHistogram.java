package stack;

import java.util.Scanner;
import java.util.Stack;

public class MaximumRectangularAreaInHistogram {

	public static long getMaxArea(long hist[], long n) {
		// your code here
		long res = Long.MIN_VALUE;
		Stack<PairMAH> s = new Stack<>();
		long[] nsl = new long[(int) n];// To store the index of next smallest element to the left
		long[] nsr = new long[(int) n];// To store the index of next largest element to the right
		int pseudoIndex = -1;// for nsl, let's assume that the height of bar at index -1 is 0
		for (int i = 0; i < n; i++) {

			if (s.isEmpty()) {
				nsl[i] = pseudoIndex;
			}

			else if (!s.isEmpty() && s.peek().val < hist[i])
				nsl[i] = s.peek().ind;

			else if (!s.isEmpty() && s.peek().val >= hist[i]) {
				while (!s.isEmpty() && s.peek().val >= hist[i])
					s.pop();

				if (s.isEmpty())
					nsl[i] = pseudoIndex;
				else
					nsl[i] = s.peek().ind;

			}
			s.push(new PairMAH(hist[i], i));
		}
		s.clear();
		pseudoIndex = (int) n;// for nsr, let's assume that the height of bar at index n is 0
		for (int i = (int) n - 1; i >= 0; i--) {
			if (s.isEmpty()) {
				nsr[i] = pseudoIndex;
			}

			else if (!s.isEmpty() && s.peek().val < hist[i])
				nsr[i] = s.peek().ind;

			else if (!s.isEmpty() && s.peek().val >= hist[i]) {
				while (!s.isEmpty() && s.peek().val >= hist[i])
					s.pop();

				if (s.isEmpty())
					nsr[i] = pseudoIndex;
				else
					nsr[i] = s.peek().ind;

			}
			s.push(new PairMAH(hist[i], i));
		}

		long[] width = new long[(int) n];

		for (int i = 0; i < (int) n; i++) {
			width[i] = nsr[i] - nsl[i] - 1;
		}

		for (int i = 0; i < (int) n; i++) {
			if (res < width[i] * hist[i])
				res = width[i] * hist[i];
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long[] hist = new long[(int) n];
		for (int i = 0; i < n; i++) {
			hist[i] = sc.nextLong();
		}
		System.out.println(getMaxArea(hist, n));
		sc.close();
	}

}

class PairMAH {
	long val;
	int ind;

	public PairMAH(long val, int ind) {
		this.val = val;
		this.ind = ind;
	}

}

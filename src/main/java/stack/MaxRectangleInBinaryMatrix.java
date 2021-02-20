package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//InterviewBit
public class MaxRectangleInBinaryMatrix {

	public static int MAH(List<Integer> l) {
		int n = l.size();
		int[] nsl = new int[n];
		int[] nsr = new int[n];

		Stack<PairBin> s = new Stack<>();
		int pseudoIndex = -1;
		for (int i = 0; i < n; i++) {

			if (s.isEmpty()) {
				nsl[i] = pseudoIndex;
			}

			else if (!s.isEmpty() && s.peek().val < l.get(i)) {
				nsl[i] = s.peek().ind;
			} else {
				while (!s.isEmpty() && s.peek().val >= l.get(i)) {
					s.pop();
				}

				if (s.isEmpty())
					nsl[i] = pseudoIndex;
				else
					nsl[i] = s.peek().ind;
			}
			s.push(new PairBin(l.get(i), i));
		}
		s.clear();
		pseudoIndex = n;
		for (int i = n - 1; i >= 0; i--) {
			if (s.isEmpty()) {
				nsr[i] = pseudoIndex;
			}

			else if (!s.isEmpty() && s.peek().val < l.get(i))
				nsr[i] = s.peek().ind;

			else if (!s.isEmpty() && s.peek().val >= l.get(i)) {
				while (!s.isEmpty() && s.peek().val >= l.get(i))
					s.pop();

				if (s.isEmpty())
					nsr[i] = pseudoIndex;
				else
					nsr[i] = s.peek().ind;

			}
			s.push(new PairBin(l.get(i), i));
		}

		int[] width = new int[n];

		for (int i = 0; i < n; i++) {
			width[i] = nsr[i] - nsl[i] - 1;
		}
		int res = 0;
		for (int i = 0; i < (int) n; i++) {
			if (res < width[i] * l.get(i))
				res = width[i] * l.get(i);
		}

		return res;
	}

	public static int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
		List<Integer> l = new ArrayList<>();
		if (A == null || A.size() == 0)
			return 0;
		int row = A.size();
		int col = A.get(0).size();
		for (int i = 0; i < col; i++) {
			l.add(A.get(0).get(i));
		}
		int max = MAH(l);
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (A.get(i).get(j) != 0) {
					l.set(j, l.get(j) + A.get(i).get(j)); 
				} else {
					l.set(j, 0);
				}
			}
			max = Math.max(max, MAH(l));
		}
		return max;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>(n);
		for (int i = 0; i < n; i++) {
			l.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				l.get(i).add(sc.nextInt());
			}
		}

		System.out.println(maximalRectangle(l));
		sc.close();
	}
}

class PairBin {
	int val;
	int ind;

	public PairBin(int val, int ind) {
		this.val = val;
		this.ind = ind;
	}

}
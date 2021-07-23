package dp.lcs;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

//GeeksforGeeks
//Problem link - https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1#
//Given two sequences, find the length of longest subsequence present in both of them.
//Both the strings are of uppercase.
//Input:
//A = 6, B = 6
//str1 = ABCDGH
//str2 = AEDFHR
//Output: 3
//Explanation: LCS for input Sequences
//“ABCDGH” and “AEDFHR” is “ADH” of
//length 3.

public class LongestCommonSubsequenceRecursive {

	private static int lcs(int p, int q, String s1, String s2) {

		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0)
			return 0;

		int lcs = lcsRecursive(s1, s2, p, q);
		return lcs;
	}

	private static int lcsRecursive(String x, String y, int m, int n) {

		if (m == 0 || n == 0)
			return 0;

		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return 1 + lcsRecursive(x, y, m - 1, n - 1);
		} else {
			return Math.max(lcsRecursive(x, y, m, n - 1), lcsRecursive(x, y, m - 1, n));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int p = in.readInt();
		int q = in.readInt();
		String s1 = in.readString();
		String s2 = in.readString();
		out.printLine(lcs(p, q, s1, s2));
		out.close();

	}

}

class InputReader {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	public double readDouble() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		double res = 0;
		while (!isSpaceChar(c) && c != '.') {
			if (c == 'e' || c == 'E')
				return res * Math.pow(10, readInt());
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		}
		if (c == '.') {
			c = read();
			double m = 1;
			while (!isSpaceChar(c)) {
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, readInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				m /= 10;
				res += (c - '0') * m;
				c = read();
			}
		}
		return res * sgn;
	}

	public long readLong() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public String next() {
		return readString();
	}

	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	public void printLine(Object... objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}

	public void flush() {
		writer.flush();
	}

}

class IOUtils {
	public static int[] readIntArray(InputReader in, int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++)
			array[i] = in.readInt();
		return array;
	}

	public static long[] readLongArray(InputReader in, int n) {
		long[] array = new long[n];
		for (int i = 0; i < n; i++)
			array[i] = in.readLong();
		return array;
	}
}

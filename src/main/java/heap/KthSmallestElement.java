package heap;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

//port InputReader.SpaceCharFilter;

//GeeksForGeeks
//Problem link- https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
//Given an array arr[] and a number K where K is smaller than size of array,
//the task is to find the Kth smallest element in the given array.
//It is given that all array elements are distinct.
//Input:
//N = 6
//arr[] = 7 10 4 3 20 15
//K = 3
//Output : 7
//Explanation :
//3rd smallest element in the given 
//array is 7.

//Problem with the logic. Have to come back to this

public class KthSmallestElement {
	
	/* Using quickselect
	private static int partition(int [] a, int l, int r) {
		int i=l;
		int j=r;
		while(true) {
			while(less(a[++i],a[l])) {
				if(i==r)
					break;
			}
			
			while(less(a[l],a[--j])) {
				if(j==l)
					break;
			}
			
			if(i>=j)
				break;
			exch(a,j,i);
		}
		exch(a,l,j);
		return j;
	}
	
	private static void exch(int [] a, int l, int r) {
		int temp=a[l];
		a[l]=a[r];
		a[r]=temp;
	}
	
	private static boolean less(int a, int b) {
		return a<b;
	}
	
	private static void shuffle(int [] a) {
		
		for(int i=0;i<a.length;i++) {
			Random rand = new Random();
			int temp=rand.nextInt(i+1);
			exch(a,i,temp);
		}
	}
	public static int kthSmallest(int[] arr, int l, int r, int k) {
		
		//shuffle(arr);
		int lo=l;
		int hi=r;
		while(hi>lo) {
			int j=partition(arr,lo,hi);
			if(j==k) {
			     return arr[j];
				
			}
			else if(j<k)
				lo=j+1;
			else
				hi=j-1;
		}
		return arr[lo];
	}
    */
	
	public static int kthSmallest(int[] arr, int l, int r, int k) {
		PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
		for(int i : arr) {
			pq.add(i);
			if(pq.size()>k)
				pq.poll();
		}
		return pq.poll();
		
	}

	
	public static void main(String[] args) {
		InputReader in= new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n=in.readInt();
		int [] arr = IOUtils.readIntArray(in, n);
		int k=in.readInt();
		out.printLine(kthSmallest(arr, 0, n-1, k));
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


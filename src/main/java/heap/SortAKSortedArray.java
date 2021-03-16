package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class SortAKSortedArray {

	private static List<Integer> sortArray(int []arr, int n, int k){
		List<Integer> input = Arrays.stream(arr).boxed().collect(Collectors.toList());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		List<Integer> res= new ArrayList<>();
		for(int i : input) {
			pq.add(i);
			if(pq.size()>k)
				res.add(pq.poll());
		}
		
		while(!pq.isEmpty()) {
			res.add(pq.poll());
		}
		return res;
	}
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);

		int t = in.readInt();
		while (t-- > 0) {
			int n = in.readInt();
			int k = in.readInt();
			int[] arr = IOUtils.readIntArray(in, n);
			List<Integer> res = sortArray(arr,n,k);
			for (int i : res) {
				out.print(i + " ");
			}
			out.printLine();

		}
		out.close();
	}
}

	package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int word : nums) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				int f1 = map.get(i1);
				int f2 = map.get(i2);
				return f1 - f2;
			}
		});

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.add(entry.getKey());
			if (pq.size() > k)
				pq.remove();

		}
		
		int [] result = new int [k];
		int index=0;
		while(!pq.isEmpty()) {
			result[index++]=pq.remove();
		}
		
		return result; 

	}
}

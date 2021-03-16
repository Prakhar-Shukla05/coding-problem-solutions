package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElements {

	public static ArrayList<Integer> kLargest(int arr[], int n, int k) {
		ArrayList<Integer> res= new ArrayList<>();
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		for(int i : arr) {
			pq.add(i);
			if(pq.size()>k)
				pq.poll();
		}
		//Collections.sort(pq);
		while(!pq.isEmpty()) {
			res.add(pq.poll());
		}
		//Collections.sort(res);
		Collections.reverse(res);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] arr = {1, 23 ,12, 9, 30, 2 ,50};
        List<Integer> ans=kLargest(arr, 7, 3);
        for(int a : ans) {
        	System.out.print(a+ " ");
        }
	}
	

}

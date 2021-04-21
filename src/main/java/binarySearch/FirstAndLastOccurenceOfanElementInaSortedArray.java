package binarySearch;

import java.util.ArrayList;

public class FirstAndLastOccurenceOfanElementInaSortedArray {

	ArrayList<Long> find(long arr[], int n, int x) {
		ArrayList<Long> result = new ArrayList<>();
		if (arr == null)
			return result;
		if (arr.length == 1) {
			if (arr[0] == x) {
				result.add(0L);
				result.add(0L);
				return result;
			}
		}
		result.add(bfs(arr, 0, n - 1, x, true));
		if (result.get(0) == -1) {
			result.add(-1L);
		} else {
			result.add(bfs(arr, 0, n - 1, x + 1, false) - 1);
		}
		return result;
	}

	public static long bfs(long[] arr, int start, int end, int target, boolean same) {

		long ans = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				ans = mid;
				end = mid - 1;
			} else if (arr[mid] > target) {
				ans = mid;
				end = mid - 1;
			} else if (arr[mid] < target) {
				start = mid + 1;
			}
		}
		return same ?  (arr[(int) ans] == target ? ans : -1) : ans==-1?end+1:ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = { 1, 3, 5, 5, 5, 5, 67, 67, 123, 125 };
		System.out.println(new FirstAndLastOccurenceOfanElementInaSortedArray().find(arr, 10, 125));

	}

}

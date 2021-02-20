package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

	public static int longestSubarray(int[] nums, int limit) {
		int start = 0;
		int end = 0;
		Deque<Integer> inc = new ArrayDeque<Integer>();
		Deque<Integer> dec = new ArrayDeque<Integer>();
		int ans = 0;
		while (end < nums.length) {
			int num = nums[end];

			while (!inc.isEmpty() && nums[inc.getLast()] >= num) {
				inc.removeLast();
			}
			inc.addLast(end);
			while (!dec.isEmpty() && nums[dec.getLast()] <= num) {
				dec.removeLast();
			}
			dec.addLast(end);

			int max = nums[dec.getFirst()];
			int min = nums[inc.getFirst()];

			if (max - min > limit) {
				start++;
				if (inc.getFirst() < start)
					inc.removeFirst();
				if (dec.getFirst() < start)
					dec.removeFirst();
			} else {
				ans = Math.max(ans, end - start + 1);
				end++;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 4,2,2,2,4,4,2,5,5,5,5,2 };
		int limit = 2;
		System.out.println(longestSubarray(nums, limit));

	}

}

package binarySearch;

public class SearchInaRotatedSortedArray {

	public int search(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return 0;

		int s = 0;
		int e = nums.length - 1;
		if (nums[s] <= nums[e])
			return bfs(nums, 0, nums.length - 1, target);

		int pivot = -1;
		while (s <= e) {
			if (nums[s] <= nums[e]) {
				pivot = s;
				break;
			}
			int mid = s + (e - s) / 2;
			int next = (mid + 1) % nums.length;
			int prev = (mid - 1 + nums.length) % nums.length;
			if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
				pivot = mid;
				break;
			} else if (nums[s] <= nums[mid])
				s = mid + 1;
			else if (nums[mid] <= nums[e])
				e = mid - 1;
		}

		if (nums[pivot] == target)
			return pivot;
		if (nums[0] <= target && nums[pivot - 1] >= target)
			return bfs(nums, 0, pivot - 1, target);
		else
			return bfs(nums, pivot + 1, nums.length - 1, target);
	}

	private static int bfs(int[] a, int s, int e, int t) {
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (a[mid] == t)
				return mid;
			else if (a[mid] > t)
				e = mid - 1;
			else
				s = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 1 };
		int target = 3;
		System.out.println(new SearchInaRotatedSortedArray().search(nums, target));

	}

}

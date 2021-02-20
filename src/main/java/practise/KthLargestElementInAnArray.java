package practise;

import java.util.Random;

public class KthLargestElementInAnArray {

	public int findKthLargest(int[] nums, int k) {
        k= nums.length-k;
		shuffle(nums);
        int lo = 0;
		int hi = nums.length - 1;
		int par = 0;
		while (hi > lo) {
			par = partition(nums, lo, hi);
			if (par >k)
				hi = par - 1;
			else if (par < k)
				lo = par + 1;
			else
				return nums[k];

		}
		return nums[k];
	}

	private void shuffle(int[] a) {
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) {
			int index = rand.nextInt(i + 1);
			exch(a, i, index);
		}
	}

	private void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private boolean less(Comparable i, Comparable j) {
		return i.compareTo(j) < 0;
	}

	private int partition(int[] a, int lo, int hi) {

		int i = lo;
		int j = hi+1;
		while (true) {
			while (less(a[++i], a[lo])) {
				//i++;
				if (i == hi)
					break;
			}

			while (less(a[lo], a[--j])) {
				//j--;
				if (j == lo)
					break;
			}

			if (i >= j)
				break;
			exch(a, i, j);

		}

		exch(a, lo, j);
		return j;

	}

	public static void main(String[] args) {
		KthLargestElementInAnArray obj = new KthLargestElementInAnArray();
         int [] arr= {3,2,1,5,4,6};
         System.out.println(obj.findKthLargest(arr, 2));
         //int [] brr= {2,1,3,5,4,6};
         //System.out.println(obj.partition(brr, 3, 5));
         
	}

}

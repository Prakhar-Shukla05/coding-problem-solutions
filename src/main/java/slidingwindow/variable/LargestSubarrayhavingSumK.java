package slidingwindow.variable;

import java.util.HashMap;

//GFG
//Problem link-https://www.geeksforgeeks.org/longest-sub-array-sum-k/
//Given an array arr[] of size n containing integers. The problem is to find the length of the longest sub-array having sum equal to the given value k.
//Examples: 
// 
//
//Input : arr[] = { 10, 5, 2, 7, 1, 9 }, 
//            k = 15
//Output : 4
//The sub-array is {5, 2, 7, 1}.
//
//Input : arr[] = {-5, 8, -14, 2, 4, 12},
//            k = -5
//Output : 5

//If the array has only positive elements, then we can apply variable size sliding window algorithm
//But here the array has both positive and negative numbers, thus we will use a hashmap
//Both the algorthms are given in the code

public class LargestSubarrayhavingSumK {

	//Will only work for positive numbers
	private static int largestSubarrayWithSumKbySlidingWindow(int [] arr, int k) {

		int n=arr.length;
		int i=0;
		int j=0;
		int sum=0;
		int ans=0;
		while(j<n) {
			sum+=arr[j];
			if(sum<k) j++;
			else if(sum==k) {
				ans=Math.max(ans, j-i+1);
				j++;
			}
			else {
				while(sum>k) {
					sum-=arr[i];
					i++;
					if(sum==k){
	                        ans = Math.max(ans,(j-i+1));
					 }
				}
				j++;
			}
		}
		return ans;
	}

	private static int largestSubarrayWithSumKbyHashMap(int [] arr, int k) {

		// HashMap to store (sum, index) tuples
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0, n=arr.length;

        // traverse the given array
        for (int i = 0; i < n; i++) {

             // accumulate sum
             sum += arr[i];

             // when subarray starts from index '0'
             if (sum == k)
                 maxLen = i + 1;

             // make an entry for 'sum' if it is
             // not present in 'map'
             if (!map.containsKey(sum)) {
                 map.put(sum, i);
             }

             // check if 'sum-k' is present in 'map'
             // or not
             if (map.containsKey(sum - k)) {

                 // update maxLength
                 if (maxLen < (i - map.get(sum - k)))
                     maxLen = i - map.get(sum - k);
             }
        }

        return maxLen;       
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr=  { -5, 8, -14, 2, 4, 12 };
		int k=-5;
		//System.out.println(largestSubarrayWithSumKbySlidingWindow(arr, k));
		System.out.println(largestSubarrayWithSumKbyHashMap(arr, k));

	}

}
package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Leetcode 56
//Problem link-https://leetcode.com/problems/merge-intervals/
//Given an array of intervals where intervals[i] = [starti, endi], merge all 
//overlapping intervals, and return an array of the non-overlapping intervals that
//cover all the intervals in the input.
//
//		 
//
//Example 1:
//
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//Example 2:
//
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.

public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		
		List<int []> list= new ArrayList<>();
		if(intervals==null || intervals.length==0)
			return list.toArray(new int [0][]);
		
		Arrays.sort(intervals,(a,b)->a[0]-b[0]);
		
		int start=intervals[0][0];
		int end= intervals[0][0];
		
		for(int [] arr : intervals) {
			
			if(arr[0]<=end) {
				end= Math.max(end, arr[1]);
			}
			else {
				list.add(new int []{start,end});
				start=arr[0];
				end=arr[1];
			}
		}
		list.add(new int [] {start,end});
		return list.toArray(new int [0][]);

	}

}

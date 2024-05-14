package arrays.twentyfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Leetcode 56 Medium
//Problem link-https://leetcode.com/problems/merge-intervals/
//Given an array of intervals where intervals[i] = [starti, endi], merge all
//overlapping intervals, and return an array of the non-overlapping intervals that
//cover all the intervals in the input.
//Example 1:
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//Example 2:
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.

public class MergeIntervals {

  public int[][] merge(int[][] intervals) {
    List<Integer> nonOverlappingIntervals = new ArrayList<>();
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    nonOverlappingIntervals.add(intervals[0][0]);
    nonOverlappingIntervals.add(intervals[0][1]);

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] <= nonOverlappingIntervals.get(nonOverlappingIntervals.size() - 1)) {
        nonOverlappingIntervals.set(nonOverlappingIntervals.size() - 1,
          Math.max(intervals[i][1], nonOverlappingIntervals.get(nonOverlappingIntervals.size() - 1)));
      } else {
        nonOverlappingIntervals.add(intervals[i][0]);
        nonOverlappingIntervals.add(intervals[i][1]);
      }
    }
    return convertListToArray(nonOverlappingIntervals);
  }

  private int[][] convertListToArray(List<Integer> nonOverlappingIntervals) {
    int[][] result = new int[nonOverlappingIntervals.size() / 2][2];
    for (int i = 0; i < nonOverlappingIntervals.size(); i += 2) {
      result[i / 2][0] = nonOverlappingIntervals.get(i);
      result[i / 2][1] = nonOverlappingIntervals.get(i + 1);
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    System.out.println(Arrays.deepToString(new MergeIntervals().merge(intervals)));
  }
}

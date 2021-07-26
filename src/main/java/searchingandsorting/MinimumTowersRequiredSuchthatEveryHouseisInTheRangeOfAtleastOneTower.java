package searchingandsorting;

import java.util.Arrays;

//GFG
//Problem link-https://www.geeksforgeeks.org/minimum-number-of-towers-required-such-that-every-house-is-in-the-range-of-at-least-one-tower/
//Given a map of the city and the network range, the task is to determine the minimum number of the tower so that every house
//is within range of at least one tower. Each tower must be installed on top of an existing house.
//Examples: 
// 
//
//Input: range : 1
//       house : 1 2 3 4 5
//Output: 2
//
//Input: range : 2
//       house : 7 2 4 6 5 9 12 11 
//Output: 3

public class MinimumTowersRequiredSuchthatEveryHouseisInTheRangeOfAtleastOneTower {
	
	private static int minTowers(int range, int [] houses) {
		
		Arrays.sort(houses);
		int i=0;
		int numberOfTowers=0;
		int n=houses.length;
		while(i<n) {
			
			int location= houses[i]+range;
			numberOfTowers++;
			while(i<n && houses[i]<=location) {
				i++;
			}
			
			
			i--;
				
			location= houses[i]+range;
			while(i<n && houses[i]<=location )
				i++;
		}
		
		return numberOfTowers;
		
	}
	
	public static void main(String[] args) {
		int house[] = { 7, 2, 4, 6, 5, 9, 12, 11 };
	    int range = 2;
	    System.out.println(minTowers(range, house));
	}

}

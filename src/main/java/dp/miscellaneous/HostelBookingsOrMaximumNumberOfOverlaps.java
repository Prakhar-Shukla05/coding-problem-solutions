package dp.miscellaneous;

import java.util.Arrays;

//A hotel manager has to process N advance bookings of rooms for the next season.
//
//His hotel has K rooms.
//
//Bookings contain an arrival date and a departure date.
//
//He wants to find out whether there are enough rooms in the hotel to satisfy the demand.
//
//Write a program that solves this problem in time O(N log N) .
//
//Input Format
//
//First line contains two integers N and K.
//N is the number of bookings and K is the number of hotel rooms.
//Next N lines contain 2 integers each, the arrival and departure date for ith booking.
//
//Constraints
//
//1 <= N <= 105
//1 <= K <= 105
//1 <= arrivalDay, departureDay <= 105
//
//Output Format
//
//Output "yes" if all the bookings can be processed and "no" otherwise.
//
//Sample Input 0
//
//3 1
//1 2
//3 6
//5 8
//Sample Output 0
//
//no
//Explanation 0
//
//2 rooms are needed on days 5 and 6 while there are only 1 room.

public class HostelBookingsOrMaximumNumberOfOverlaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n=in.readInt();
		int m=in.readInt();
		int [] a = new int [n];
		int [] d = new int [n];
		for(int i=0;i<n;i++) {
			a[i]=in.readInt();
			d[i]=in.readInt();
		}
		Arrays.sort(a);
		Arrays.sort(d);
//		for(int i : a) {
//			out.print(i+" ");
//		}
//		out.printLine();
//		for(int i : d) {
//			out.print(i+ " ");
//		}
		int required=0;
		int occupied=0;
		int i=0;
		int j=0;
		while(i<n&&j<n) {
			if(a[i]<=d[j]) {
				occupied++;
				required=Math.max(occupied, required);
				i++;
			}
			else {
				occupied--;
				j++;
			}
		}
		
		out.printLine(required<=m?"yes":"no");
		out.close();

	}

}

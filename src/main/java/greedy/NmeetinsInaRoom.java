package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//GFG
//Problem link- https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
//There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i and F[i] is finish time of meeting i.
//What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time? Also note start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
//
//Input:
//			N = 6
//			S[] = {1,3,0,5,8,5}
//			F[] = {2,4,6,7,9,9}
//			Output: 
//			4
//			Explanation:
//			Four meetings can be held with
//			given start and end timings.

public class NmeetinsInaRoom {
	
	
	
	
	public static int maxMeetings(int start[], int end[], int n){
		
		List<Meeting> meetings= new ArrayList<>();
		for(int i=0;i<n;i++) {
			meetings.add(new Meeting(start[i], end[i], i+1));
		}
		MeetingComparator mc= new MeetingComparator();
		Collections.sort(meetings, mc);
		List<Integer> result = new ArrayList<Integer>();
		int limit= meetings.get(0).getEnd();
		result.add(meetings.get(0).getPos());
		for(int i=1;i<n;i++) {
			if(meetings.get(i).getStart()>limit) {
				limit=meetings.get(i).getEnd();
				result.add(meetings.get(i).getPos());
			}
			
		}
		return result.size();	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6;
		int [] start = {1,3,0,5,8,5};
		int [] end= {2,4,6,7,9,9};
		System.out.println(maxMeetings(start, end, n));

	}

}
class MeetingComparator implements Comparator<Meeting>{

	@Override
	public int compare(Meeting o1, Meeting o2) {
		// TODO Auto-generated method stub
	     if(o1.getEnd()<o2.getEnd())
	    	 return -1;
	     else if(o1.getEnd()>o2.getEnd())
	    	 return 1;
	     else if(o1.getPos()<o2.getPos())
	    	 return -1;
	     else
	    	 return 1;
	}
	
}
class Meeting {
	private int start;
	private int end;
	private int pos;
	
	public Meeting(int start, int end, int pos) {
		this.start = start;
		this.end = end;
		this.pos = pos;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
	
	
	
	
}
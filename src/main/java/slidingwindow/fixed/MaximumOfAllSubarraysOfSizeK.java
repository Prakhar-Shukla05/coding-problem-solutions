package slidingwindow.fixed;

import java.util.Deque;
import java.util.LinkedList;

//InterviewBit
//Problem link-https://www.interviewbit.com/problems/sliding-window-maximum/
//
//
//is moving from the very left of the array to the very right. 
//
//You can only see the w numbers in the window. Each time the sliding window moves 
//
//rightwards by one position. You have to find the maximum for each window. 
//
//The following example will give you more clarity.
//
//The array A is [1 3 -1 -3 5 3 6 7], and B is 3.
//
//Window position	Max
//———————————-	————————-
//[1  3  -1] -3  5  3  6  7	3
//1 [3  -1  -3] 5  3  6  7	3
//1  3 [-1  -3  5] 3  6  7	5
//1  3  -1 [-3  5  3] 6  7	5
//1  3  -1  -3 [5  3  6] 7	6
//1  3  -1  -3  5 [3  6  7]	7
//Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].
//
//Note: If B > length of the array, return 1 element with the max of the array.
//
//
//
//
//Input Format
//
//The first argument given is the integer array A.
//The second argument given is the integer B.
//Output Format
//
//Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1]
//For Example
//
//Input 1:
//    A = [1, 3, -1, -3, 5, 3, 6, 7]
//    B = 3
//Output 1:
//    C = [3, 3, 5, 5, 6, 7]

public class MaximumOfAllSubarraysOfSizeK {

	public int[] slidingMaximum(final int[] A, int B) {
		int [] ans= new int [A.length-B+1];
		int i=0;
		int j=0;
		Deque<Integer> dq= new LinkedList<Integer>();
		int index=0;
		while(j<A.length) {
			if(dq.isEmpty())
				dq.addLast(A[j]);
		    else if(!dq.isEmpty()&& A[j]>dq.getLast()) {
				while(!dq.isEmpty() && dq.getLast()<A[j])
					dq.pollLast();
				dq.addLast(A[j]);
			}
		    else {
		    	dq.addLast(A[j]);
		    }
			if(j-i+1<B) j++;
			
			else if(j-i+1==B) {
				ans[index++]=dq.getFirst();
				
				if(A[i]==dq.getFirst())
					dq.pollFirst();
				
				i++;
				j++;
			}
			
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] ans= {648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368 };
		int k=9;
		int [] res= new MaximumOfAllSubarraysOfSizeK().slidingMaximum(ans, k);
		int [] expected = {745, 745 ,775 ,775 ,876, 876 ,876 ,876 ,876 ,876 ,876 ,951 ,951 ,951 ,951, 951 ,951 ,951 ,951 ,951 ,882 ,882 ,882 ,882 ,935 ,935 ,935 ,935 ,935 ,935 ,935 ,935 ,935 ,892 ,892 ,892 ,900 ,900 ,900 ,937, 937 ,937 };
		for(int i=0;i<res.length;i++) {
			if(res[i]!=expected[i])
				System.out.println("Wrong");
		}
		System.out.println("Correct");

	}

}

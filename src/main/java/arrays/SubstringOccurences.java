package arrays;

import utility.InputReader;
import utility.OutputWriter;

//Bug has a string S and a smaller string T. Bug needs to find how many times T occurs in S as a substring. Help him with the task.
//
//Input Format
//
//First line contains the string S. Second line contains the string T.
//
//Constraints
//
//1 <= |S| <= 100 1 <= |T| <= |S|
//
//Output Format
//
//Output the number of times T occurs in S.
//
//Sample Input 0
//
//bugsbunnywritesbuggycodes
//bug
//Sample Output 0
//
//2
//Explanation 0
//
//bugs comes twice in the string S.

public class SubstringOccurences {

	private static int count(String s1, String s2) {
		
		if(s1.contains(s2))
			return 1+ count(s1.replaceFirst(s2,"*"),s2);
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		String s1= in.readString();
		String s2= in.readString();
		out.printLine(count(s1,s2));
		out.close();
			
	}

}

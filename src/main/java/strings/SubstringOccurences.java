package strings;

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

	
	private static int countwithKmpSearch(char [] text, char [] pattern) {
		
		int [] lps= computeLpsArray(pattern);
		
		int i=0;
		int res=0;
		int j=0;
		int n=text.length;
		int m=pattern.length;
		while(i<n) {
			
			if(pattern[j]==text[i]) {
				i++;
				j++;
			}
			
			if(j==m) {
				j=lps[j-1];
				res++;
//				if(lps[j]!=0) {
//					i=++next_i;	
//				}
//				j=0;
			}
			else if(i<n && pattern[j]!=text[i]) {
				
				if(j!=0) {
					j=lps[j-1];
				}
				else {
					i++;
				}
			}
		}
		return res;
	}
	
	private static int [] computeLpsArray(char [] pattern) {
		int index=0;
		int i=1;
		int n=pattern.length;
		int [] lps= new int [n];
		lps[0]=0;
		while(i<n) {
			if(pattern[i]==pattern[index]) {
				lps[i]=index+1;
				index++;
				i++;
			}
			else {
				if(index!=0) {
					index=lps[index-1];
				}
				else {
					lps[i]=0;
					i++;
				}
			}
		}
		return lps;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		String s1= in.readString();
		String s2= in.readString();
		out.printLine(countwithKmpSearch(s1.toCharArray(),s2.toCharArray()));
		out.close();
			
	}

}

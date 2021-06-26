package strings;

import java.util.Stack;

//Leetcode 1910
//Problem link- https://leetcode.com/contest/biweekly-contest-55/problems/remove-all-occurrences-of-a-substring/
//Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:
//
//Find the leftmost occurrence of the substring part and remove it from s.
//Return s after removing all occurrences of part.
//
//A substring is a contiguous sequence of characters in a string.
//
// 
//
//Example 1:
//
//Input: s = "daabcbaabcbc", part = "abc"
//Output: "dab"
//Explanation: The following operations are done:
//- s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
//- s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
//- s = "dababc", remove "abc" starting at index 3, so s = "dab".
//Now s has no occurrences of "abc".
//Example 2:
//
//Input: s = "axxxxyyyyb", part = "xy"
//Output: "ab"
//Explanation: The following operations are done:
//- s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
//- s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
//- s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
//- s = "axyb", remove "xy" starting at index 1 so s = "ab".
//Now s has no occurrences of "xy".

public class RemoveAllOccurencesofASubstring {

	public static String removeOccurrences(String s, String part) {
          
		if(part==null || part.length()==0 || part.length()>s.length())
			return s;
		
		/* First apporach
		while(s.contains(part)) {
			 s= s.replace(part, "");
		}
		return s;
		*/
		
		//Second apporach
		//Whenever we have to remove some part and concatenate the rest, there is a good chance stack will be involved.
		
		Stack<Character> st= new Stack<>();
		StringBuilder toCheck= new StringBuilder();
		for(char c : s.toCharArray()) {
			st.push(c);
			if(st.size()>=part.length()) {
				int size=part.length();
				//int index=size-1;
				while(size-->0) {
					toCheck.append(st.pop());
				}
				if(!toCheck.reverse().toString().equals(part)) {
					 size=part.length();
					  for(int i= 0;i<toCheck.length();i++) {
						  st.push(toCheck.charAt(i));
					  }
				}
				toCheck= new StringBuilder();
			}
		}
		toCheck=new StringBuilder();
		for(char c : st) {
			toCheck.append(c);
		}
		return toCheck.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "axxxxyyyyb";
		String part= "xy";
		System.out.println(removeOccurrences(s, part));

	}

}

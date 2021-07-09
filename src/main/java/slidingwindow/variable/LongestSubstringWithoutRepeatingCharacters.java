package slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

//Leetcode 3
//Problem link-https://leetcode.com/problems/longest-substring-without-repeating-characters/
//
//Given a string s, find the length of the longest substring without repeating characters.
//
//
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//Example 4:
//
//Input: s = ""
//Output: 0

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		
		int i=0,j=0,max=0;
		Map<Character,Integer> map= new HashMap<>();
		char [] sa= s.toCharArray();
		while(j<s.length()) {
			map.put(sa[j],map.getOrDefault(sa[j], 0)+1);
			if(map.size()>j-i+1) j++; // This condition will never be satisfied
			else if(map.size()==j-i+1) {
				max=Math.max(max, j-i+1);
				j++;
			}
			else {
				while(map.size()<j-i+1) {
					map.put(sa[i], map.getOrDefault(sa[i], 0)-1);
					if(map.get(sa[i])==0) map.remove(sa[i]);
					i++;
					if(map.size()==j-i+1) {
						max=Math.max(max, j-i+1);
					}
				}
				j++;
			}
		}
		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="pwwkew";
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));

	}

}

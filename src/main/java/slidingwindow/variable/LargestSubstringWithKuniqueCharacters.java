package slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

//GFG
//Problem link-https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
//Given a string you need to print the size of the longest possible substring that has exactly K unique characters.
//If there is no possible substring then print -1.
//
//Example 1:
//
//Input:
//S = "aabacbebebe", K = 3
//Output: 7
//Explanation: "cbebebe" is the longest 
//substring with K distinct characters.
//​Example 2:
//
//Input: 
//S = "aaaa", K = 2
//Output: -1
//Explanation: There's no substring with K
//distinct characters.

public class LargestSubstringWithKuniqueCharacters {

	public int longestkSubstr(String s, int k) {
	       
		int i=0,j=0,max=-1;
		Map<Character,Integer> map= new HashMap<>();
		char [] sa= s.toCharArray();
		while(j<s.length()) {
			map.put(sa[j],map.getOrDefault(sa[j], 0)+1);
			if(map.size()<k) j++;
			else if(map.size()==k) {
				max=Math.max(max, j-i+1);
				j++;
			}
			else {
				while(map.size()>k) {
					map.put(sa[i], map.getOrDefault(sa[i], 0)-1);
					if(map.get(sa[i])==0) map.remove(sa[i]);
					i++;
					if(map.size()==k) {
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
		String s= "aabacbebebe";
		System.out.println(new LargestSubstringWithKuniqueCharacters().longestkSubstr(s, 3));
	}

}

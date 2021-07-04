package slidingwindow.fixed;

import java.util.HashMap;
import java.util.Map;

//GFG
//Problem link-https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
//Given a word pat and a text txt. Return the count of the occurences of anagrams of the word in the text.
//
//Example 1:
//
//Input:
//txt = forxxorfxdofr
//pat = for
//Output: 3
//Explanation: for, orf and ofr appears
//in the txt, hence answer is 3.
//Example 2:
//
//Input:
//txt = aabaabaa
//pat = aaba
//Output: 4
//Explanation: aaba is present 4 times
//in txt.

public class CountOccurencesOfAnagrams {

// Generate a map of all character occurances of the 2nd string, i.e char and its count.
// The window size becomes the length of 2nd string, as the anangrams wil also 
// be of this length, amd another variable count denotes the distinct characters 
// left in a sliding window.
// In a window if the current character is present in map, then decrease its 
// count, and if the count becomes 0, decrease the 'count' variable.
// If the window size is lesser than k just move forward the window
// When the window is hit ->
// If the count is 0, it means all the characters needed for its anagram is here
// in it, therefore increase your answer
// To remove the last part (arr[i] part) so that the window can be shifted ->
// If the s[i] is present in map then increase its count and if it changes from 
// 0->1 then increase the 'count' variable

	
	int search(String pat, String txt) {
	
		int k=pat.length();
		Map<Character,Integer> map= new HashMap<>();
		for(char c : pat.toCharArray()) {
			map.put(c,map.getOrDefault(c, 0)+1);
		}
		int count= map.size();
		int i=0;
		int j=0;
		int ans=0;
		while(j<txt.length()) {
			
			char toCheck= txt.charAt(j);
			if(map.containsKey(toCheck)){
				map.put(toCheck, map.get(toCheck)-1);
				if(map.get(toCheck)==0)
					count--;
			}
			
			if(j-i+1<k) j++;
			
			else if(j-i+1==k) {
				if(count==0)
					ans++;
				
				char toCheckNew= txt.charAt(i);
				if(map.containsKey(toCheckNew)) {
					map.put(toCheckNew, map.getOrDefault(toCheckNew, 0)+1);
					if(map.get(toCheckNew)==1)
						count++;
				}
				i++;
				j++;
				
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt="aabaabaa";
		String pat="aaba";
		System.out.println(new CountOccurencesOfAnagrams().search(pat, txt));

	}

}

package dp.lcs.palindromicsubsequence;

//Leetcode and GFG
//Problem link LC- https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/	
//Problem link GFG- https://leetcode.com/problems/longest-palindromic-substring/
//Given a string s, return the longest palindromic substring in s.
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.

public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {

		if(s==null || s.length()==0)
			return "";
		int len=s.length();
		boolean [] [] dp = new boolean [len][len];
		
		int maxLength=1;
		for(int i=0;i<len;i++)
			dp[i][i]=true;
		
		int start=0;
		for(int i=0;i<len-1;i++) {
			if(s.charAt(i)==s.charAt(i+1)) {
				dp[i][i+1]=true;
				start=i;
				maxLength=2;
			}
		}
		
		for(int k=3;k<=len;k++) {
			for(int i=0;i<=len-k;i++) {
				int j=i+k-1;
				
				if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j)) {
					dp[i][j]=true;
					start=i;
					maxLength=k;
				}
			}
		}
		
		return s.substring(start,start+maxLength);
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="forgeeksskeegfor";
		System.out.println(longestPalindrome(s));

	}

}

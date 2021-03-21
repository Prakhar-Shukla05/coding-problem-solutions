package dp.miscellaneous;

import java.util.HashMap;
import java.util.Map;

//Leetcode
//Problem link-https://leetcode.com/problems/interleaving-string/
//	
//	Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
//
//	An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
//
//	s = s1 + s2 + ... + sn
//	t = t1 + t2 + ... + tm
//	|n - m| <= 1
//	The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
//	Note: a + b is the concatenation of strings a and b.
//
//	Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//	Output: true

public class InterleavingString {

	private static Map<String, Boolean> mem = new HashMap<>();

	public boolean isInterleave(String s1, String s2, String s3) {

		if (s1.length() + s2.length() != s3.length())
			return false;

		return recursiveCheck(s1, s2, s3, s1.length(), s2.length(), s3.length(), 0, 0, 0);
	}

	private static boolean recursiveCheck(String s1, String s2, String s3, int len1, int len2, int len3, int p1, int p2,
			int p3) {
        mem.clear();
        
        if(p3==len3) {
        	return (p1==len1 && p2==len2)?true:false;
        }
        
        String key= p1+"*"+p2+"*"+p3;
        
        if(mem.containsKey(key)) {
        	return mem.get(key);
        }
        
        if(p1==len1) {
        	boolean temp= s2.charAt(p2)==s3.charAt(p3)?recursiveCheck(s1, s2, s3, len1, len2, len3, p1, p2+1, p3+1):false;
        	mem.put(key,temp);
        	return temp;
        }
        
        if(p2==len2) {
        	boolean temp= s1.charAt(p1)==s3.charAt(p3)?recursiveCheck(s1, s2, s3, len1, len2, len3, p1+1, p2, p3+1):false;
        	mem.put(key,temp);
        	return temp;
        }
        
        boolean left=false,right=false;
        if(s1.charAt(p1)==s3.charAt(p3)){
        	left=recursiveCheck(s1, s2, s3, len1, len2, len3, p1+1, p2, p3+1);
        }
        if(s2.charAt(p2)==s3.charAt(p3)) {
        	right=recursiveCheck(s1, s2, s3, len1, len2, len3, p1, p2+1, p3+1);
        }
        
        boolean temp= left | right;
        mem.put(key, temp);
        return temp;
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in= new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		String s1=in.readString();
		String s2=in.readString();
		String s3=in.readString();
		System.out.println(new InterleavingString().isInterleave(s1, s2, s3));

	}

}

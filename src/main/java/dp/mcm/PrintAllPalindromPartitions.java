package dp.mcm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utility.InputReader;
import utility.OutputWriter;

//Leetcode and Interview Bit	
//Problem link- https://leetcode.com/problems/palindrome-partitioning/
//Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
//
//A palindrome string is a string that reads the same backward as forward.
//Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
		
public class PrintAllPalindromPartitions {

	
	public List<List<String>> partition(String s) {
           List<List<String>> res= new ArrayList<>();
           List<String> palindrome= new ArrayList<>();
           if(s==null || s.length()==0)
        	   return res;
           
           solve(s,0,s.length(),res,palindrome);
           return res;
	}
	
	private static void solve(String s, int index, int len, List<List<String>> res,List<String> palindrome ) {
		
		if(index==len) {
			res.add(new ArrayList<>(palindrome));
			return ;
		}
		
		for(int i=index;i<len;i++) {
			if(isPalindrome(s,index,i)) {
				palindrome.add(s.substring(index,i+1));
				solve(s,i+1,len,res,palindrome);
				palindrome.remove(palindrome.size()-1);
			}
		}
		
	}
	
	
	private static boolean isPalindrome(String s, int start, int end) {
	      while(start<end) {
	            if(s.charAt(start++)!=s.charAt(end--))
	            	return false;
	      }
	      return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		String s = in.readString();
		out.printLine(new PrintAllPalindromPartitions().partition(s));
        out.close();
	}

}

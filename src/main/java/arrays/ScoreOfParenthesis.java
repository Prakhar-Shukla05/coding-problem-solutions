package arrays;

import java.util.Stack;

public class ScoreOfParenthesis {

	
	public int scoreOfParentheses(String S) {
           
		int score=0;
		Stack<Integer> st= new Stack<Integer>();
		for(char c :S.toCharArray()) {
			if(c=='(') {
				st.push(score);
				score=0;
			}
			else
				score= st.pop()+Math.max(2*score, 1);
		}
		return score;
	}
	
	
}

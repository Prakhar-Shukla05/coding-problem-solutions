package bfs;

import java.util.ArrayList;
import java.util.List;

//Leetcode
//Problem link- https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

public class LetterCombinationsOfAPhoneNumber {

	public List<String> letterCombinations(String digits) {
		List<String> combinations = new ArrayList<String>();
		if (digits == null || digits.length() == 0)
			return combinations;

		String[] map = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		recursiveApproach(combinations, digits, "", 0, map);
		return combinations;
	}

	private void recursiveApproach(List<String> combinations, String digits, String current, int index, String[] map) {

		if (index == digits.length()) {
			combinations.add(current);
			return;
		}

		String letters = map[digits.charAt(index) - '0'];

		for (int i = 0; i < letters.length(); i++) {
			recursiveApproach(combinations, digits, current + letters.charAt(i), index + 1, map);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

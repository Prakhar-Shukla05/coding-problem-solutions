package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> bannedWords = new HashSet<>();
		Map<String,Integer> map= new HashMap<>();
	/*	Map<String, Integer> map = new TreeMap<>(new Comparator<String>() {
			
			@Override
			public int compare(String word1, String word2) {
				int f1=map.get(word1);
				int f2=map.get(word2);
				return f1-f2;
			}
		});
      */  
		
		for(String word: banned) {
			bannedWords.add(word);
		}
		
		String [] words=paragraph.toLowerCase().split("\\W+");
		
		for(String word: words) {
			if(!bannedWords.contains(word)) {
				map.put(word, map.getOrDefault(word, 0)+1);
			}
		}
		
		int max=0;
		String result="";
		
		for(String word: map.keySet()) {
			if(map.get(word)>max) {
				max=map.get(word);
				result=word;
			}
		}
		return result;
		
	}
}


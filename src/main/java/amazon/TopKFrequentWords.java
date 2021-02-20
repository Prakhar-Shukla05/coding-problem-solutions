package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {
          List<String> result = new ArrayList<>();
          Map<String, Integer> map= new HashMap<String, Integer>();
          for(String word: words) {
        	  map.put(word, map.getOrDefault(word, 0)+1);
          }
          
          PriorityQueue<String> pq = new PriorityQueue<>(new Comparator <String>() {
          
        	  @Override
        	  public int compare(String w1, String w2) {
        		  int f1 = map.get(w1);
        		  int f2 = map.get(w2);
        		  if(f1==f2) return w2.compareTo(w1);
        		  else
        			  return f1-f2;
        	  }
          });
          
          for(Map.Entry<String, Integer> entry : map.entrySet()) {
        	  pq.add(entry.getKey());
        	  if(pq.size()>k) pq.remove();
          }
          
          while(!pq.isEmpty())
        	  result.add(pq.remove());
          
          Collections.reverse(result);
          
          return result;
	}

	public static void main(String[] args) {

	}
}


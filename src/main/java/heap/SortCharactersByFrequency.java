package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class SortCharactersByFrequency {
	public String frequencySort(String s) {
           HashMap<Character,Integer> map= new HashMap();
           char [] ca= s.toCharArray();
           for(char c: ca) {
        	   map.put(c, map.getOrDefault(c, 0)+1);
           }
           
           PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
        	  
        	   @Override
        	   public int compare(Character c1, Character c2) {
        		   int f1= map.get(c1);
        		   int f2= map.get(c2);
        		   return f2-f1;
        	   }
           });
           
           for(Map.Entry<Character, Integer> entry: map.entrySet()) {
        	   pq.add(entry.getKey());
           }
           
           String result="";
           while(!pq.isEmpty()) {
        	   char pulled=pq.poll();
        	   int frequency=map.get(pulled);
        	   for(int i=1;i<=frequency;i++)
        		   result+=pulled;
           }
           
           return result;
	}
}

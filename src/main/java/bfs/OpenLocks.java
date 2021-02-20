package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLocks {

	 public int openLock(String[] deadends, String target) {
	        Set<String> deadEnds= new HashSet<String>();
	        Set<String> visited= new HashSet<String>();
	        for(String deadEnd: deadends)
	            deadEnds.add(deadEnd);
	        int level=0;
	        visited.add("0000");
	        Queue<String> queue= new LinkedList();
	        queue.offer("0000"); 
	        
	        while(!queue.isEmpty()){
	            int size=queue.size();
	            while(size>0){
	           String current= queue.poll();
	           // queue.poll();
	            if(deadEnds.contains(current)){
	                size--;
	                continue;
	            }
	            
	            if(target.equals(current))
	                return level;
	            
	            StringBuilder sb= new StringBuilder(current);
	            
	            for(int i=0;i<4;i++){
	                char currentPos= sb.charAt(i);
	                String s1= sb.substring(0,i)+ (currentPos== '9'? 0: currentPos-'0' +1) + sb.substring(i+1);
	                String s2= sb.substring(0,i)+ (currentPos== '0'? 9: currentPos-'0' -1) + sb.substring(i+1); 
	                
	                if(!visited.contains(s1) && !deadEnds.contains(s1)){
	                    visited.add(s1);
	                    queue.offer(s1);
	                }
	                if(!visited.contains(s2) && !deadEnds.contains(s2)){
	                    visited.add(s2);
	                    queue.offer(s2);
	                }
	            }
	           
	            size--;
	        }
	            level++;
	            
	        }
	        
	        return -1;
	        
	    }
	 
	 public static void main(String[] args) {
		String [] d1= {"8888"};
		System.out.println(new OpenLocks().openLock(d1, "0099"));
	}
	
}

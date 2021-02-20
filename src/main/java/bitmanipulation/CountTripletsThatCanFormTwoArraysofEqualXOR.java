package bitmanipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTripletsThatCanFormTwoArraysofEqualXOR {

    public static int countTriplets(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<Integer,List<Integer>>();
        map.put(0,new ArrayList<>(-1));
        int num=0;
        int ans=0;
        for(int i: arr) {
        	 num ^=i;
        	 if(map.containsKey(num)) {
        		 
        		 for(int a : map.get(num)) {
        			 ans+=i-a-1;
        		 }
        	 }
        	// map.put(num,map.getOrDefault(num, new ArrayList())add(i));
        }
        return 0;
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

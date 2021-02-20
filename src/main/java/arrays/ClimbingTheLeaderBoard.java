package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Hackerrank Question

public class ClimbingTheLeaderBoard {

	
	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		// Write your code here
         List<Integer> result = new ArrayList<Integer>();
         int n=ranked.size();
         int [] rank = new int [n];
         rank [0]=1;
         for(int i=1;i<n;i++) {
        	 if(ranked.get(i)!=ranked.get(i-1))
        		 rank [i]= rank [i-1]+1;
        	 else
        		 rank [i]= rank [i-1];
         }
         
        Integer [] r2 = new Integer[n];
        r2=ranked.toArray(r2);
         
         for(int i : player) {
        	 if(i>ranked.get(0)) {
        		 result .add(1);
        		 //ranked.add(0, i);
        		 //updateArray(rank, ranked, r2);
        		 continue ;
        	 }
        	 else if(i< ranked.get(n-1)) {
        		 result.add(rank[n-1]+1);
        		 //ranked.add( i);
        		 //updateArray(rank, ranked,r2);
        		 continue;
        	 }
        	 
        	  int index=  firstApperanceGreater(r2,0,n-1,i);
        	  //ranked.add(index, i);
        	  result.add(rank[index]);
        	  //updateArray(rank, ranked,r2);
        	  
         }
         return result;
         
	}
	
	private static void updateArray(int [] rank, List<Integer> ranked, Integer [] r2) {
		 int n=ranked.size();
         rank = new int [n];
         rank [0]=1;
         for(int i=1;i<n;i++) {
        	 if(ranked.get(i)!=ranked.get(i-1))
        		 rank [i]= rank [i-1]+1;
        	 else
        		 rank [i]= rank [i-1];
         }
         
         r2 = new Integer[n];
         r2=ranked.toArray(r2);
         
	}
	
	private static int firstApperanceGreater(Integer [] a,int s, int e, int t) {
		
		int index=e+1;
		while(s<=e) {
			int m= s+ (e-s)/2;
			if(a[m]<=t)
			{
				index = m;
				e=m-1;
			}
			else {
				s=m+1;
			}
		}
		return index;
		
	}
    
	public static void print(List<Integer> l) {
		for(int o : l) {
			System.out.print(o+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] r= {100, 100, 50, 40, 40, 20, 10};
		Integer [] s= {5, 25, 50, 120};
		
		List<Integer> sc = new ArrayList<>(Arrays.asList(s));
		
		List<Integer> ra = new ArrayList<>(Arrays.asList(r));
		
		List<Integer> result = climbingLeaderboard(ra, sc);
		
		print(result);
		
		
		

	}

}

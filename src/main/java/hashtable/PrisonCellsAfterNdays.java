package hashtable;

import java.util.Arrays;
import java.util.HashSet;

public class PrisonCellsAfterNdays {

	public int[] prisonAfterNDays(int[] cells, int N) {
           HashSet<String> visited = new HashSet<String>();
           int days=0;
           boolean cycle=false;
           
           for(int i=0;i<N;i++) {
        	   
        	   int [] next = nextPermutation(cells);
//        	   String prestr= next.toString();
//        	   System.out.println("pretr is : "+prestr);
        	   String str= Arrays.toString(next);
        	//   System.out.println("str is : "+str);
        	   if(!visited.contains(str)) {
        		   visited.add(str);
        		  days++;
        	   }
        	   else
        	   {
        		   cycle=true;
        		   break;
        	   }
        	   cells=next;
           }
           
           if(cycle) {
        	   N%=days;
        	   for(int i=0;i<N;i++) {
        		   cells= nextPermutation(cells);
        	   }
           }
           return cells;
		
	}
	
	private int [] nextPermutation(int [] cells) {
		int [] res= new int [cells.length];
		res[0]=0;
		res[cells.length-1]=0;
		
		for(int i=1;i<cells.length-1;i++) {
			res[i] = cells[i-1] ==  cells[i+1] ?1 :0;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []  cells ={1,0,0,1,0,0,1,0};
		int N= 1000000000;
		int [] res = new PrisonCellsAfterNdays().prisonAfterNDays(cells, N);
		
//		for(int i : res) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		//System.out.println(new PrisonCellsAfterNdays().prisonAfterNDays(cells, N));

	}

}

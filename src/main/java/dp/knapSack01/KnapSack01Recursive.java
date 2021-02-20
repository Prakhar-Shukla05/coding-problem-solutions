package dp.knapSack01;

//GeeksForGeeks
//Dp without memoization or tabular form
//will give TLE
public class KnapSack01Recursive {

	 static int knapSack(int W, int wt[], int val[], int n) 
	    { 
		      if(n==0 || n==0)
		    	  return 0;
		      
		      if(wt[n-1]<=W) {
		    	  return Math.max(val[n-1]+knapSack(W-wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1));
		      }
		      else
		    	  return knapSack(W, wt, val, n-1);
	    } 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

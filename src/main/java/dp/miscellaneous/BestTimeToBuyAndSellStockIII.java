package dp.miscellaneous;

import utility.IOUtils;
import utility.InputReader;
import utility.OutputWriter;

//Leetcode
//Problem link- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
//You are given an array prices where prices[i] is the price of a
//given stock on the ith day.
//
//Find the maximum profit you can achieve. 
//You may complete at most two transactions.
//
//Note: You may not engage in multiple transactions
//simultaneously (i.e., you must sell the stock before you buy again).
//Input: prices = [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

//Wrong answer
//Cannot be solved by MCM

public class BestTimeToBuyAndSellStockIII {

	public int maxProfit(int[] prices) {
		
		if(prices==null || prices.length==0 || prices.length==1 )
			return 0;
		if(prices.length==2) {
			return Math.max(0, prices[1]-prices[0]);
		}
		
		int i=0;
		int j=prices.length-1;
		return solve(prices,i,j);

	}
	
	private static int solve(int [] prices, int i, int j) {
		
		if(i>j || i==j)
			return 0;
		if(j-i==1)
			return Math.max(0, prices[j]-prices[i]);
		
		int maxProfit=0;
		for(int k=i+1;k<j;k++) {
			int temp=solve(prices,i,k)+solve(prices,k+1,j)+Math.max(0, prices[k+1]-prices[k]);
			maxProfit= Math.max(temp, maxProfit);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n=in.readInt();
		int [] prices= IOUtils.readIntArray(in, n);
		out.printLine(new BestTimeToBuyAndSellStockIII().maxProfit(prices));
		out.close();
	}

}

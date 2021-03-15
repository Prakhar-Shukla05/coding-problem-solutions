package arrays;

import java.util.Stack;

//Leetcode
//Problem link- https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//Seems like an Application of Next Largest Element to the right from Stack
/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

 */
public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
          if(prices==null || prices.length==0) {
        	  return 0;
          }
          int n=prices.length;
          int [] lr= new int [n];
          Stack<Integer> st= new Stack<>();
          for(int i=n-1;i>=0;i--) {
        	  if(st.isEmpty()) {
        		  lr[i]=-1;
        	  }
        	  
        	  else {
        		  if(st.peek()>prices[i])
        		  lr[i]=st.peek();
        	  
              if(!st.isEmpty() && prices[i]>st.peek()) {
            	  while(!st.isEmpty() && st.peek()<prices[i])
            		  st.pop();
            	  if(st.isEmpty())
            		  lr[i]=-1;
            	  st.push(prices[i]);
              }
        	  
          }
          }
          
          int maxProfit=0;
          for(int i=0;i<n;i++) {
        	  if(lr[i]!=-1) {
        		  maxProfit= Math.max(maxProfit, lr[i]-prices[i]);
        	  }
          }
          return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] prices= {7,1,5,3,6,4};
		System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));

	}

}

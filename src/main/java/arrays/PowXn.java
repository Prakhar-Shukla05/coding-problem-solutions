package arrays;

//Leetcode
//Problem link-https://leetcode.com/problems/powx-n/
//Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
//
//
//
//Example 1:
//
//Input: x = 2.00000, n = 10
//Output: 1024.00000

public class PowXn {

	public double myPow(double x, int n) {
		
		double result= 1.0;
		long nn=n;
		if(nn<0) {
	     n=-1*n;
		}
		while(nn!=0) {
			if(nn%2!=0) {
				result=result*x;
				nn--;
			}
			else {
				x=x*x;
				nn=nn/2;
			}
		}
		if(n<0) {
			result= (double)1.0/(double)result;
		}
        return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

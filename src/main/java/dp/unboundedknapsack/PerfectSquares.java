package dp.unboundedknapsack;

//Leetcode 279 
//Problem link-https://leetcode.com/problems/perfect-squares/
//
//Given an integer n,return the least number of perfect square numbers that sum to n.
//
//A perfect square is an integer that is the square of an integer;in other words,
//it is the product of some integer with itself.For example,1,4,9,and 16 are perfect
//squares while 3 and 11 are not.
//Example 1:
//
//    Input:
//	n=12 
//	Output:3 
//	Explanation:12=4+4+4. 
//Example 2:
//
//    Input:
//	n=13 
//	Output:2 
//	Explanation:13=4+9.

public class PerfectSquares {

	public int numSquares(int n) {
		
		int limit= (int)Math.ceil(Math.sqrt(n));
		return solve(n,limit);

	}

	private int solve(int n, int limit) {
		// TODO Auto-generated method stub
		int [] value= new int [limit];
		int [] wt= new int[limit];
		for(int i=0;i<limit;i++) {
			value[i]=1;
			wt[i]=(i+1)*(i+1);
		}
		int ans= unboundedKnapsack(n,limit,value,wt);
		return ans;
	}

	private int unboundedKnapsack(int n, int limit, int [] value, int [] wt) {
		
		int [][] dp= new int [limit+1][n+1];
		for(int i=0;i<=limit;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0)
					dp[i][j]=Integer.MAX_VALUE-1;
				if(j==0 && i!=0)
					dp[i][j]=0;
				if(i==1 && j!=0)
				{
					if(j%value[0]==0)
						dp[i][j]=j/value[0];
					else
						dp[i][j]=Integer.MAX_VALUE-1;
				}
				
			}
		}
		
		for(int i=2;i<=limit;i++) {
			for(int j=1;j<=n;j++) {
				if(wt[i-1]<=j) {
					dp[i][j]=Math.min(value[i-1]+dp[i][j-wt[i-1]],dp[i-1][j] );
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		
		return dp[limit][n];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n=1;
        System.out.println(new PerfectSquares().numSquares(n));
	}

}

//Another approach
//#include<bits/stdc++.h>
//using namespace std;
//#define ll long long int
//const ll mod=1e9+7;
//#define take_input freopen("input.txt","r",stdin),freopen("output.txt","w",stdout);
//#define fast ios_base::sync_with_stdio(false),cin.tie(0),cout.tie(0);
//unordered_map<ll,ll> mp;
//ll go(ll n,ll mx)
//{
//	if(n==0)
//	{
//		return 0;
//	}
//	if(n<0)
//		return 0;
//	if(mp.count(n))
//		return mp[n];
//	ll res=INT_MAX;
//	for(ll i=1;i<=mx;i++)
//	{
//		if(i*i<=n)
//		res=min(res,1+go(n-i*i,mx));
//	}
//	return mp[n]=res;
//}
//int main()
//{
//	// take_input;
//	fast;
//	ll n;
//	cin>>n;
//	ll mx=ceil(sqrt(n));
//	cout<<go(n,mx);
//}

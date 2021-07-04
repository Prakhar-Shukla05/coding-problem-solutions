package graph.problems;import arrays.FindAndLastPositionOfElementInSortedArray;

//Leetcode 997
//Problem link-https://leetcode.com/problems/find-the-town-judge/
//In a town, there are n people labelled from 1 to n.  There is a rumor that
//one of these people is secretly the town judge.
//
//If the town judge exists, then:
//
//The town judge trusts nobody.
//Everybody (except for the town judge) trusts the town judge.
//There is exactly one person that satisfies properties 1 and 2.
//You are given trust, an array of pairs trust[i] = [a, b] representing that the 
//person labelled a trusts the person labelled b.
//
//If the town judge exists and can be identified, return the label of the town 
//judge.  Otherwise, return -1.
//
// 
//
//Example 1:
//
//Input: n = 2, trust = [[1,2]]
//Output: 2
//Example 2:
//
//Input: n = 3, trust = [[1,3],[2,3]]
//Output: 3
//Example 3:
//
//Input: n = 3, trust = [[1,3],[2,3],[3,1]]
//Output: -1
//Example 4:
//
//Input: n = 3, trust = [[1,2],[2,3]]
//Output: -1
//Example 5:
//
//Input: n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
//Output: 3

public class FIndTheTownJudge {

	public int findJudge(int n, int[][] trust) {
		
		/*if(trust==null)
			return -1;
		
		if(trust.length==0 && n==1)
			return 1;
		*/
		int [] in= new int [n+1];
		int [] out = new int [n+1];
		for(int [] a : trust) {
			out[a[0]]++;
			in[a[1]]++;
		}
		
		for(int i=1;i<=n;i++) {
			if(in[i]==n-1 && out[i]==0)
				return i;
		}
		return -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=1;
		int [][] trust= {};
		System.out.println(new FIndTheTownJudge().findJudge(n, trust));

	}

}

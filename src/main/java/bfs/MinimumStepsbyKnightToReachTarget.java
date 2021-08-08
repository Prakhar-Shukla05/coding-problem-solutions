package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//GFG
//Problem link-https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1
//Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.
//Note:
//The initial and the target position co-ordinates of Knight have been given accoring to 1-base indexing.
//
//Example 1:
//
//Input:
//N=6
//knightPos[ ] = {4, 5}
//targetPos[ ] = {1, 1}
//Output:
//3
//Explanation:
//	Knight takes 3 step to reach from 
//	(4, 5) to (1, 1):
//	(4, 5) -> (5, 3) -> (3, 2) -> (1, 1).

public class MinimumStepsbyKnightToReachTarget {

	private int [] dx= {1,2,-1,-1,1,-2,-2,2};
	private int [] dy= {2,1,-2,2,-2,-1,1,-1};
	private final int INFINITE= 1000007;
	public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
		// Code here
		int xStart=KnightPos[0];
		int yStart=KnightPos[1];
		int xTarget=TargetPos[0];
		int yTarget=TargetPos[1];
		
		if(xStart==xTarget && yStart==yTarget)
			return 0;
		int [] [] minDistance = new int[N+1][N+1];
		for(int [] row  : minDistance)
			Arrays.fill(row, INFINITE);
		Queue<KnightCoordinate> q= new LinkedList<>();
		q.offer(new KnightCoordinate(xStart, yStart));
		minDistance[xStart][yStart]=0;
		
		while(!q.isEmpty()) {
			KnightCoordinate top= q.peek();
			q.poll();
			int currentX=top.x;
			int currentY=top.y;
			//System.out.println("For src "+ currentX+ " "+currentY+" :");
			
			
			for(int i=0;i<8;i++) {
				if(isValid(currentX+dx[i],currentY+dy[i],minDistance,N,currentX,currentY)) {
					minDistance[currentX+dx[i]][currentY+dy[i]]=1+minDistance[currentX][currentY];
					q.add(new KnightCoordinate(currentX+dx[i], currentY+dy[i]));
					//System.out.println("For x "+ (currentX+dx[i])+ " y "+ (currentY+dy[i])+ " Value is "+ minDistance[currentX+dx[i]][currentY+dy[i]]);
					if(currentX+dx[i]==xTarget && currentY+dy[i]==yTarget) {
						return minDistance[currentX+dx[i]][currentY+dy[i]];
					}
				}
			}
		}
		
		return -1;
	}
	private boolean isValid(int i, int j, int[][] minDistance, int n, int xsrc, int ysrc) {
		// TODO Auto-generated method stub
		if(i<=0 || i>n || j<=0 || j>n || minDistance[i][j]<1+minDistance[xsrc][ysrc])
		return false;
		return true;
	}
	
	public static void main(String[] args) {
		int N=6;
        int knightPos[ ] = {4, 5};
        int targetPos[ ] = {1, 1};
        System.out.println(new MinimumStepsbyKnightToReachTarget().minStepToReachTarget(knightPos, targetPos, N));
	}
}

class KnightCoordinate {
	int x;
	int y;

	public KnightCoordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
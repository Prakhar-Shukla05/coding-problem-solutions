package graph.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode 210
//Problem link- https://leetcode.com/problems/course-schedule-ii/
//
//	There are a total of numCourses courses you have to take, labeled from 0 to
//	numCourses - 1. You are given an array prerequisites where 
//	prerequisites[i] = [ai, bi] indicates that you must take course bi first if
//	you want to take course ai.
//
//	For example, the pair [0, 1], indicates that to take course 0 you have to 
//	first take course 1.
//	Return the ordering of courses you should take to finish all courses. If
//	there are many valid answers, return any of them. If it is impossible to
//	finish all courses, return an empty array.
//
//	 
//
//	Example 1:
//
//	Input: numCourses = 2, prerequisites = [[1,0]]
//	Output: [0,1]
//	Explanation: There are a total of 2 courses to take. To take course 1 you 
//	should have finished course 0. So the correct course order is [0,1].
//	Example 2:
//
//	Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//	Output: [0,2,1,3]
//	Explanation: There are a total of 4 courses to take. To take course 3 you 
//	should have finished both courses 1 and 2. Both courses 1 and 2 should be 
//	taken after you finished course 0.
//	So one correct course order is [0,1,2,3]. Another correct ordering is 
//	[0,2,1,3].	



//This is actually a topological sort problem

public class CourseScheduleIi {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
		int [] topoSort= {};
		
		List<List<Integer>> adj= new ArrayList<>();
		for(int i=0;i<numCourses;i++) {
			adj.add(new ArrayList<Integer>());
			
		}
		
		for(int [] prerequisite : prerequisites) {
			adj.get(prerequisite[1]).add(prerequisite[0]);
		}
		
		if(cycleCheck(adj,numCourses))
			return topoSort;
		
		topoSort= new int[numCourses];
		boolean [] visited= new boolean [numCourses];
		Stack<Integer> st = new Stack<>();
		
		for(int i1=0;i1<numCourses;i1++) {
			if(!visited[i1]) {
				dfs(i1,adj,visited,st);
			}
		}
		
		int index=0;
		while(!st.isEmpty()) {
			topoSort[index++]=st.pop();
		}
		

		return topoSort;
	}

	private void dfs(int i, List<List<Integer>> adj, boolean[] visited, Stack<Integer> st) {
		// TODO Auto-generated method stub
		
		visited[i]=true;
		for(Integer it : adj.get(i)) {
			if(!visited[it]) {
				dfs(it,adj,visited,st);
			}
		}
		st.push(i);
		
	}

	private boolean cycleCheck(List<List<Integer>> adj, int numCourses) {
		// TODO Auto-generated method stub
		boolean [] visited= new boolean [numCourses];
		boolean [] dfsVisited = new boolean[numCourses];
		for(int i=0;i<numCourses;i++) {
			if(!visited[i]) {
				if(checkCycleWithDFS(i,adj,visited, dfsVisited))
					return true;
			}
		}
		return false;
	}
	private boolean checkCycleWithDFS(int i, List<List<Integer>> adj, boolean[] visited,
			boolean [] dfsVisited) {
		// TODO Auto-generated method stub
		visited[i]=true;
		dfsVisited[i]=true;
		
		for(Integer it : adj.get(i)) {
			if(!visited[it]) {
				if(checkCycleWithDFS(it, adj, visited, dfsVisited))
					return true;
			}
			else if(dfsVisited[it])
				return true;
		}
		
		dfsVisited[i]=false;
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=2;
		int [][] p= {{1,0},{0,1}};
		int [] r= new CourseScheduleIi().findOrder(n, p);
		for(int i : r) {
			System.out.print(i +"  ");
		}
		

	}

}

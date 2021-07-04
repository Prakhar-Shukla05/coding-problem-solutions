package graph.problems;

import java.util.ArrayList;
import java.util.List;

//Leetcode 207
//Problem link-https://leetcode.com/problems/course-schedule/
//
//There are a total of numCourses courses you have to take, labeled from 0 to
//numCourses - 1. You are given an array prerequisites where
//prerequisites[i] = [ai, bi] indicates that you must take course bi first if 
//you want to take course ai.
//
//For example, the pair [0, 1], indicates that to take course 0 you have to first
//take course 1.
//Return true if you can finish all courses. Otherwise, return false.
//
// 
//
//Example 1:
//
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
//Example 2:
//
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you 
//should also have finished course 1. So it is impossible.
//
//
//This is actually a cycle detection problem

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
            
		List<List<Integer>> adj= new ArrayList<>();
		for(int i=0;i<numCourses;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for(int [] prerequisite : prerequisites) {
			adj.get(prerequisite[1]).add(prerequisite[0]);
		}
		
		boolean [] visited= new boolean [numCourses];
		boolean [] dfsVisited = new boolean[numCourses];
		for(int i=0;i<numCourses;i++) {
			if(!visited[i]) {
				if(checkCycleWithDFS(i,adj,visited, dfsVisited))
					return false;
			}
		}
		return true;
		
		
		
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
		int num=2;
		int [] [] p= {{0,1}};
		System.out.println(new CourseSchedule().canFinish(num, p));

	}

}

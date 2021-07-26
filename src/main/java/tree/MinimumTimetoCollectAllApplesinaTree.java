package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//LC 1443
//Problem link-https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

//Given an undirected tree consisting of n vertices numbered from 0 to n-1, which 
//has some apples in their vertices. You spend 1 second to walk over one edge of 
//the tree. Return the minimum time in seconds you have to spend to collect all 
//apples in the tree, starting at vertex 0 and coming back to this vertex.

//The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi]
//means that exists an edge connecting the vertices ai and bi. Additionally, 
//there is a boolean array hasApple, where hasApple[i] = true means that vertex 
//i has an apple; otherwise, it does not have any apple.

//Example 1:
//Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
//Output: 8 
//Explanation: The figure above represents the given tree where red vertices have an apple. 
//One optimal path to collect all apples is shown by the green arrows.  

//Example 2:
//Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
//Output: 6
//Explanation: The figure above represents the given tree where red vertices have an apple. 
//One optimal path to collect all apples is shown by the green arrows.  

public class MinimumTimetoCollectAllApplesinaTree {

	static class Node {
		int id;
		List<Node> next;
		boolean apple;
		boolean visited = false;

		Node(int id) {
			this.id = id;
			this.next = new ArrayList<>();
		}

		Node(int id, boolean apple) {
			this.id = id;
			this.apple = apple;
			this.next = new ArrayList<>();
		}
	}

	public int minTime(int n, int[][] edges, List<Boolean> apple) {

		Map<Integer, Node> graph = new HashMap<>();
		for (int[] edge : edges) {
			int x = edge[0];
			int y = edge[1];
			Node p = graph.getOrDefault(x, new Node(x, apple.get(x)));
			Node c = graph.getOrDefault(y, new Node(y, apple.get(y)));
			p.next.add(c);
			c.next.add(p);
			graph.put(x, p);
			graph.put(y, c);
		}

		return collect(graph.get(0), 2);
	}

	public int collect(Node root, int tol) {

		if (root == null || root.visited)
			return 0;

		int cost = 0;
		root.visited = true;
		for (Node child : root.next) {
			cost = collect(child, 0) + cost;
		}

		if (cost == 0) {
			if (root.apple) {
				return 2 - tol;
			}
			return 0;
		}

		return cost + 2 - tol;
	}
	
	public static void main(String[] args) {
		int n=7;
		int [] [] edges= {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
		boolean [] apples= {false,false,true,false,true,true,false};
        List<Boolean> hasApple= new ArrayList<Boolean>();
        for( boolean a : apples)
        	hasApple.add(a);
		System.out.println(new MinimumTimetoCollectAllApplesinaTree().minTime(n, edges,hasApple ));
	}
}

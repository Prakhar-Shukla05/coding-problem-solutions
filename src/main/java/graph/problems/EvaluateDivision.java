package graph.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

//Leetcode 399
//Problem link- https://leetcode.com/problems/evaluate-division
//
//	You are given an array of variable pairs equations and an array of real 
//	numbers values, where equations[i] = [Ai, Bi] and values[i] represent the
//	equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a 
//	single variable.
//
//	You are also given some queries, where queries[j] = [Cj, Dj] represents the
//	jth query where you must find the answer for Cj / Dj = ?.
//
//	Return the answers to all queries. If a single answer cannot be determined,
//	return -1.0.
//
//	Note: The input is always valid. You may assume that evaluating the querie
//	s will not result in division by zero and that there is no contradiction.
//
//	 
//
//	Example 1:
//
//	Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], 
//	queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
//	Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
//	Explanation: 
//	Given: a / b = 2.0, b / c = 3.0
//	queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//	return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
//	Example 2:
//
//	Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
//	queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//	Output: [3.75000,0.40000,5.00000,0.20000]
//	Example 3:
//
//	Input: equations = [["a","b"]], values = [0.5],
//	queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
//	Output: [0.50000,2.00000,-1.00000,-1.00000]
//	 
//
//	Constraints:
//
//	1 <= equations.length <= 20
//	equations[i].length == 2
//	1 <= Ai.length, Bi.length <= 5
//	values.length == equations.length
//	0.0 < values[i] <= 20.0
//	1 <= queries.length <= 20
//	queries[i].length == 2
//	1 <= Cj.length, Dj.length <= 5
//	Ai, Bi, Cj, Dj consist of lower case English letters and digits.

//This is a dfs problem where we have to find the path multiplication from source
// to destination

public class EvaluateDivision {

	public double[] calcEquation(List<List<String>> equations, double[] values,
			List<List<String>> queries) {
            
            Map<String, List<Node>> graph = new HashMap<>();
            for(int i=0;i<equations.size();i++) {
            	String u = equations.get(i).get(0);
                String v = equations.get(i).get(1);
                double weight= values[i];
                
                graph.computeIfAbsent(u,nodeList -> new ArrayList<>())
                .add(new Node(v,weight));
                graph.computeIfAbsent(v, nodeListb -> new ArrayList<>())
                .add(new Node(u,1/weight));
            }
            
            double [] result= new double[queries.size()];
            for(int i=0;i<queries.size();i++) {
            	String src= queries.get(i).get(0);
            	String dsc= queries.get(i).get(1);
            	HashSet<String> visited = new HashSet<>();
            	if(graph.containsKey(src)) {
            		double [] ans= {-1.0};
            		dfs(src,dsc,graph,visited,ans,1.0);
            		result[i]=ans[0];
            	}
            	else {
            		result[i]=-1.0;
            	}
            }
            return result;
            
            
	}

	

	



	private void dfs(String src, String dsc, Map<String, List<Node>> graph,
			HashSet<String> visited, double [] ans,
			double temp) {
		// TODO Auto-generated method stub
		if(visited.contains(src))
			return ;
		
		if(src.equals(dsc)) {
			ans[0]=temp;
			return ;
		}
		
		
		visited.add(src);
		
		for(Node n : graph.get(src)) {
			String next= n.des;
			double weight=n.value;
			
			if(!visited.contains(next)) {
				dfs(next,dsc,graph,visited,ans,temp*weight);

			}
		}
	}







	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> equations= new ArrayList<>();
		List<List<String>> queries= new ArrayList<List<String>>();
		for(int i=0;i<2;i++) {
			equations.add(new ArrayList<String>());
			queries.add(new ArrayList<String>());
		}
		equations.get(0).add("a");
		equations.get(0).add("b");
		equations.get(1).add("b");
		equations.get(1).add("c");
		double[] values = {2.0,3.0};
		//List<List<String>> queries= new ArrayList<List<String>>();
		queries.get(0).add("a");
		queries.get(0).add("c");
		queries.get(1).add("b");
		queries.get(1).add("a");
		double [] result= new EvaluateDivision().calcEquation(equations, values,
				queries);
		for(double r: result) {
			System.out.println(r+ " ");
		}
	}

}

class Node{
	
	String des;
	double value;
	public Node(String des, double value) {
		super();
		this.des = des;
		this.value = value;
	}
	
	
}

//Alternate solution
class Solution {

	  public class Edge {

	    String nbr;
	    double val;

	    public Edge(String nbr, double val) {
	      this.nbr = nbr;
	      this.val = val;
	    }
	  }

	  private HashMap<String, ArrayList<Edge>> createGraph(List<List<String>> equations,
	      double[] values) {
	    HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
	    for (int i = 0; i < equations.size(); i++) {
	      String var1 = equations.get(i).get(0);
	      String var2 = equations.get(i).get(1);
	      double val = values[i];
	      if (graph.containsKey(var1)) {
	        graph.get(var1).add(new Edge(var2, val));
	      } else {
	        graph.put(var1, new ArrayList<>());
	        graph.get(var1).add(new Edge(var2, val));
	      }
	      if (graph.containsKey(var2)) {
	        graph.get(var2).add(new Edge(var1, 1 / val));
	      } else {
	        graph.put(var2, new ArrayList<>());
	        graph.get(var2).add(new Edge(var1, 1 / val));
	      }
	    }
	    return graph;
	  }

	  public double[] calcEquation(List<List<String>> equations, double[] values,
	      List<List<String>> queries) {
	    HashMap<String, ArrayList<Edge>> graph = createGraph(equations, values);

	    double[] res = new double[queries.size()];

	    for (int i = 0; i < queries.size(); i++) {
	      String var1 = queries.get(i).get(0);
	      String var2 = queries.get(i).get(1);

	      if (!graph.containsKey(var1) || !graph.containsKey(var2)) {
	        res[i] = -1.0;
	      } else {
	        HashSet<String> vis = new HashSet<>();
	        res[i] = getProduct(graph, var1, var2, vis, 1.0);
	      }
	    }
	    return res;
	  }

	  private double getProduct(HashMap<String, ArrayList<Edge>> graph, String src, String dest,
	      HashSet<String> vis, double product) {
	    if (src.equals(dest)) {
	      return product;
	    }
	    vis.add(src);
	    for (Edge e : graph.get(src)) {
	      if (vis.contains(e.nbr) == false) {
	        double result = getProduct(graph, e.nbr, dest, vis, product * e.val);
	        if (result != -1.0) {
	          return result;
	        }
	      }
	    }
	    return -1.0;
	  }
	}

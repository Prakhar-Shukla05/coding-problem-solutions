package graph.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//LeetCode 690
//Problem link- https://leetcode.com/problems/employee-importance/
//You have a data structure of employee information, which includes the employee's unique id, their importance value, and their direct subordinates' id.
//
//You are given an array of employees employees where:
//
//employees[i].id is the ID of the ith employee.
//employees[i].importance is the importance value of the ith employee.
//employees[i].subordinates is a list of the IDs of the subordinates of the ith employee.
//Given an integer id that represents the ID of an employee, return the total importance value of this employee and all their subordinates.
//
// 
//
//Example 1:
//
//
//Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
//Output: 11
//Explanation: Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3.
//They both have importance value 3.
//So the total importance value of employee 1 is 5 + 3 + 3 = 11.

public class EmployeeImportance {
	
	Map<Integer, Employee> emap;
	int result;
	//Use DFS apporach
	public int getImportance(List<Employee> employees, int id) {
            result=0;
            if(employees==null || employees.size()==0)
            	return result;
           
           /* Employee target=null;
            for(Employee e : employees) {
            	if(e.id==id)
            		target=e;
            }
            List<Integer> targetIds= new ArrayList<Integer>();
            for(int i : target.subordinates)
            	targetIds.add(i);
            result+=target.importance;
            for(Employee e : employees) {
            	if(targetIds.contains(e.id)) {
            		result+=e.importance;
            		for(int ids: e.subordinates)
            			targetIds.add(ids);
            	}
            }
            */
            emap = new HashMap<Integer, Employee>();
            for(Employee e : employees) {
            	emap.put(e.id,e);
            }
            dfs(id);
            
            return result;
            
	}
	
	

	private void dfs(int id) {
		// TODO Auto-generated method stub
		Employee target = emap.get(id);
		result+=target.importance;
		for(int subids: target.subordinates) {
			dfs(subids);
		}
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
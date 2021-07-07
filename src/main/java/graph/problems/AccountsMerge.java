package graph.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//Leetcode 721
//Accounts Merge
//Given a list of accounts where each element accounts[i] is a list of strings, where 
//the first element accounts[i][0] is a name, and the rest of the elements are emails 
//representing emails of the account.
//
//Now, we would like to merge these accounts. Two accounts definitely belong to the 
//same person if there is some common email to both accounts. Note that even if two 
//accounts have the same name, they may belong to different people as people could 
//have the same name. A person can have any number of accounts initially, but all 
//of their accounts definitely have the same name.
//
//After merging the accounts, return the accounts in the following format: the 
//first element of each account is the name, and the rest of the elements are emails in
//sorted order. The accounts themselves can be returned in any order.
//
//Example 1:
//
//Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],
//                   ["John","johnsmith@mail.com","john00@mail.com"],
//                   ["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
//Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],
//         ["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
//Explanation:
//The first and third John's are the same person as they have the common email "johnsmith@mail.com".
//The second John and Mary are different people as none of their email addresses are used by other accounts.
//We could return these lists in any order, for example the answer 
//[['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
// ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.

public class AccountsMerge {

	
	// Using DFS to get connected components
	/*
	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		List<List<String>> result= new ArrayList<List<String>>();
		Map<String, List<String>> map= new HashMap<>();
		Map<String,String> emailToOwner= new HashMap<String, String>();
		for(List<String> account: accounts) {
			String name = "";
			for(String email: account) {
				if(name=="") {
					name=email;
					continue;
				}
				
				map.computeIfAbsent(email, x-> new ArrayList<>()).add(account.get(1));
				map.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
				emailToOwner.put(email, name);
					
			}
		}
		
		Set<String> visited= new HashSet<>();
		
		for(String s : map.keySet()) {
			if(!visited.contains(s)) {
				visited.add(s);
				Stack<String> st= new Stack<>();
				st.push(s);
				List<String> current= new ArrayList<String>();
				while(!st.isEmpty()) {
					String top = st.pop();
					current.add(top);
					for(String node : map.get(top)) {
						if(!visited.contains(node)) {
							visited.add(node);
							st.push(node);
						}
					}
				}
				Collections.sort(current);
				current.add(0,emailToOwner.get(s));
				result.add(current);
				}
		}
		return result;
		
		
	}
	 */
	
	//Using Disjoint Set DS
	 public List<List<String>> accountsMerge(List<List<String>> accounts) {
	        DSUAccountsMerge dsu = new DSUAccountsMerge();
	        Map<String, String> emailToName = new HashMap();
	        Map<String, Integer> emailToID = new HashMap();
	        int id = 0;
	        for (List<String> account: accounts) {
	            String name = "";
	            for (String email: account) {
	                if (name == "") {
	                    name = email;
	                    continue;
	                }
	                emailToName.put(email, name);
	                if (!emailToID.containsKey(email)) {
	                    emailToID.put(email, id++);
	                }
	                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
	            }
	        }

	        Map<Integer, List<String>> ans = new HashMap();
	        for (String email: emailToName.keySet()) {
	            int index = dsu.find(emailToID.get(email));
	            ans.computeIfAbsent(index, x-> new ArrayList()).add(email);
	        }
	        for (List<String> component: ans.values()) {
	            Collections.sort(component);
	            component.add(0, emailToName.get(component.get(0)));
	        }
	        return new ArrayList(ans.values());
	    }
	 
	    

}
class DSUAccountsMerge {
    int[] parent;
    public DSUAccountsMerge() {
        parent = new int[10001];
        for (int i = 0; i <= 10000; ++i)
            parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}

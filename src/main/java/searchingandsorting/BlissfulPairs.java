package searchingandsorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Wrong
public class BlissfulPairs {

	public static Set<List<Integer>> subsets(int[] nums) {

		Set<List<Integer>> result = new HashSet();
		
		dfs(0,nums,result,new ArrayList());
		return result;
	}
	
	private static  void dfs(int index, int [] nums, Set<List<Integer>> result, List<Integer> current) {
		
		if(current.size()==2 && current.get(0)>current.get(1)) {
		result.add(new ArrayList<>(current));
		}
		

		for(int i=index;i<nums.length;i++) {
			current.add(nums[i]);
			dfs(i+1, nums,result, current);
			//current.remove(current.size()-1);
			current.remove(Integer.valueOf(nums[i]));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           InputReader in = new InputReader(System.in);
           int n = in.readInt();
           int [] a = IOUtils.readIntArray(in, n);
           Set<List<Integer>> res = subsets(a);
           System.out.println(res.size());
	}

}

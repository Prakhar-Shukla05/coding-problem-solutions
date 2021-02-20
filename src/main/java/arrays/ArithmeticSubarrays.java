package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArithmeticSubarrays {

public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
             
	List<Boolean> result = new ArrayList<Boolean>();
	
	int n=nums.length;
	int m= l.length;
	outer: for(int i=0;i<m;i++) {
		Set<Integer> set = new HashSet<Integer>();
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(int j=l[i];j<=r[i];j++) {
			set.add(nums[j]);
			min =Math.min(min, nums[j]);
			max= Math.max(max, nums[j]);
		}
		
		int d= (max-min)/(r[i]-l[i]);
		if((max-min)%(r[i]-l[i])!=0) {
			result.add(false);
			continue outer;
		}
		
		int x=min;
		while(!set.isEmpty()) {
			if(!set.contains(x)) {
				result.add(false);
				continue outer;
			}
			set.remove(x);
			x+=d;
			
		}
		
		result.add(true);
		
	}
  
	
	return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

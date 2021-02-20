package arrays;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

	public int[] nextGreaterElements(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap();
//        Deque<Integer> d= new  ArrayDeque<Integer>();
//        //boolean [] visited = new boolean[nums.length];
//        for(int i=0;i<nums.length;i++) {
//        	while(!d.isEmpty() && nums[d.getLast()]<nums[i]) {
//        		
//        		map.put(d.removeLast(),nums[i]);
//        		//visited[i-1]=true;
//        	}
//        	d.addLast(i);
//        	
//        }
//        
//        int [] res = new int [nums.length];
//        
//        for(int i=0;i<nums.length;i++) {
//        	if(map.containsKey(i))
//        		res[i]=map.get(i);
//        	else {
//        		if(d.getFirst()==i ||nums[d.getFirst()]==nums[i])
//        			res[i]=-1;
//        		else
//        			res[i]=nums[d.getFirst()];
//        	}
//        }
//        return res;
		
		int [] res = new int [nums.length];
		Arrays.fill(res, -1);
		
		Stack<Integer> s= new Stack();
		for(int i=0;i<2*nums.length;i++)
		{
			while(!s.isEmpty() && nums[s.peek()]<nums[i%nums.length]) {
				res[s.pop()]=nums[i%nums.length];
			}
			
			if(i<nums.length)
			s.push(i);
		}
		return res;
    }
	
	public static void print(int [] a) {
		for(int x: a) {
			System.out.print(x+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int [] nums= {1,3,2,1,5,8};
           int [] res = new NextGreaterElementII().nextGreaterElements(nums);
           print(res);
	}

}

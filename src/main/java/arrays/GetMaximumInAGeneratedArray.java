package arrays;

import java.util.ArrayList;
import java.util.List;

public class GetMaximumInAGeneratedArray {

	public int getMaximumGenerated(int n) {
        if(n==0 || n==1)
            return n;
        List<Integer> list = new ArrayList();
        list.add(0);
        list.add(1);
        int max=0;
        
        for(int i=2;i<n+1;i++){
            
            if(i%2==0)
                list.add(list.get(i/2));
            else
                list.add(list.get(i/2) + list.get((i/2)+1));
            max=Math.max(max,list.get(i));
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

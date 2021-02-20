package recursion;

import java.util.ArrayList;
import java.util.List;

public class JosepheusCircle {

	public static int deadPerson(int n,  int k) {
		 
			List<Integer> list = new ArrayList<Integer>();
			for(int i=1;i<=n;i++) {
				list.add(i);
			}
			int index=0;
			return solve(list,k-1,index);
	}
	
	private static int solve(List<Integer> list, int k, int index) {
		
		if(list.size()==1) {
			return list.get(0);
		}
		
		index=(index+k)%list.size();
		list.remove(index);
		return solve(list,k,index);
		
	}
	
	public static void main(String[] args) {
		InputReader in= new InputReader(System.in);
		int t= in.readInt();
		while(t-->0) {
		int n= in.readInt();
		int k= in.readInt();
		System.out.println(deadPerson(n, k) );
		}
	}
}


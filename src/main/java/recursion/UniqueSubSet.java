package recursion;

import java.util.Set;
import java.util.TreeSet;

public class UniqueSubSet {

	static private Set<String> set = new TreeSet<String>();
	public static void solve(String ip, String op) {
		
		if(ip.length()==0) {
			set.add(op);
			return ;
		}
		
		String op1= op;
		String op2 =op+ ip.charAt(0);
		ip=ip.substring(1);
		solve(ip,op1);
		solve(ip,op2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		String ip= in.readString();
		String op="";
		
		solve(ip,op);
		
		for(String i : set) {
			System.out.println(i);
		}

	}

}

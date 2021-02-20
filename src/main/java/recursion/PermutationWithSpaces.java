package recursion;

public class PermutationWithSpaces {

	public static void solve(String ip, String op) {
		
		if(ip.length()==0) {
			System.out.println(op);
			return ;
		}
		
		String op1= op+ip.charAt(0);
		String op2= op+" "+ip.charAt(0);
		ip=ip.substring(1);
		
		solve(ip,op2);
		solve(ip,op1);
		
		
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in= new InputReader(System.in);
		String ip= in.readString();
		String op=""+ip.charAt(0);
		solve(ip.substring(1),op);
		

	}

}

package recursion;

public class PermutationWithCaseChange {

	public static void solve(String ip, String op) {
		
		if(ip.length()==0) {
			System.out.print(op+" ");
			
			return ;
		}
		
		char ch= ip.charAt(0);
		String op2=op+ ch;
	    String op1="";
		if(Character.isLowerCase(ch)) {
			op1=op+ Character.toUpperCase(ch);
		}else
		{
		    op1= op+ Character.toLowerCase(ch);
		}
		ip=ip.substring(1);
		solve(ip,op1);
		solve(ip,op2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        InputReader in = new InputReader(System.in);
        String ip= in.readString();
        String op ="";
        
        solve(ip,op);
	}

}

package strings;

//Leetcode
//Problem link-https://leetcode.com/problems/add-strings/ 
public class AddStrings {

	 public String addStrings(String num1, String num2) {
	       StringBuilder sb= new StringBuilder();
	       int i=num1.length()-1;
	       int j=num2.length()-1;
	       int carry=0;
	       while(i>=0 || j>=0)	{
	    	   int sum=carry;
	    	   if(i>=0)
	    		   sum+=num1.charAt(i--)-'0';
	    	   if(j>=0)
	    		   sum+=num2.charAt(j--)- '0';
	    	   
	    	   carry=sum/10;
	    	   sum%=10;
	    	   sb.append(sum);
	       }
	       
	       if(carry!=0)
	    	   sb.append(carry);
	       
	       return sb.reverse().toString();
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

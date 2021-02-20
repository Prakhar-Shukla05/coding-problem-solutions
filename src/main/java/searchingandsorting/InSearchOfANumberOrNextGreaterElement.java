package searchingandsorting;

import java.util.Arrays;
import java.util.Scanner;

public class InSearchOfANumberOrNextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    String s= sc.next();
	    int n= s.length();
	    int i=n-2;
	    for(i=n-2;i>=0;i--) {
	    	if((s.charAt(i)-'0') < s.charAt(i+1)-'0') {
	    		break;
	    	}
	    }
	    if(i==-1)
	    	System.out.println(-1);
	    else {
	    	int min =i+1;
	    	for(int j=i+1;j<n;j++) {
	    		int num = s.charAt(j)-'0';
	    		int minelement= (s.charAt(min)-'0');
	    		int swap = (s.charAt(i)-'0') ;
	    		if(/*(s.charAt(j)-'0')*/num </*(s.charAt(min)-'0')*/minelement && /*(s.charAt(j)-'0')*/num>/*(s.charAt(i))*/swap ) {
	    			min=j;
	    		}
	    	}
	    	
	    	char [] c = s.toCharArray();
	    	char temp =c[i];
	    	c[i]=c[min];
	    	c[min]=temp;
	    	
	    	Arrays.sort(c, i+1, n);
	    	
	    	for(char x : c) {
	    		System.out.print(x);
	    	}
	    
	    }

	}

}

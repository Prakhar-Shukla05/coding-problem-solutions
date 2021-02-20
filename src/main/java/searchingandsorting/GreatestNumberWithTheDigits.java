package searchingandsorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GreatestNumberWithTheDigits {

	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
	        */
	        Scanner sc = new Scanner(System.in);
	        int n= sc.nextInt();
	        String s = Integer.toString(n);
	        
	        char [] ch = s.toCharArray();
	        Character [] cha = new Character[ch.length];
	        int i=0;
	        for(char c: ch) {
	        	cha[i]=c;
	        	i++;
	        }
	        Arrays.sort(cha,Collections.reverseOrder());
	        for(char cc  :cha) {
	        	System.out.print(cc);
	        }
	        
	    }
}

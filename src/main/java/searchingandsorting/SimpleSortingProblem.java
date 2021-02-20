package searchingandsorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SimpleSortingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        String [] a = new String[n];
        for(int i=0;i<n;i++){
            a[i]=sc.next();
        }
        Arrays.sort(a, new Comparator<String>(){
            
            public int compare(String s1, String s2){
                if(s1.length()!=s2.length()) {
                	return s1.length()-s2.length();
                }
                else {
                	return s1.compareTo(s2);
                }
            }
        });
        for(String i :a){
            System.out.println(i);
        }

	}

}

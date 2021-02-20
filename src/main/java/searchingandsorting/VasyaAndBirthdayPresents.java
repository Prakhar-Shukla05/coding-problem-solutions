package searchingandsorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class VasyaAndBirthdayPresents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t-->0) {
		int n=sc.nextInt();
		Integer [] a = new Integer [n];
		for(int i=0;i<n;i++) {
			a[i]= sc.nextInt();
		}
		
		ReverseComparator rc = new ReverseComparator();
		Arrays.sort(a, rc);
		
		for(int i : a) {
			System.out.print(i+" ");
		}
        System.out.println();
	}
		sc.close();
	}

}

class ReverseComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o2.compareTo(o1);
	}
	
}

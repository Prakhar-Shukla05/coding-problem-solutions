package searchingandsorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//import com.sun.tools.javac.parser.Scanner;

//import com.sun.java_cup.internal.runtime.Scanner;

public class TheElectronicsStore {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		Integer [] a = new Integer [n];
		for(int i=0;i<n;i++) {
			a[i]= sc.nextInt();
		}
		
		StoreComparator s = new StoreComparator();
		Arrays.sort(a, s);
			
		for(int i : a) {
			System.out.print(i+" ");
		}
	}
}

class StoreComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}
	
	
}

package searchingandsorting;

import java.util.Scanner;

public class OrangePartitioning {

	public static void partition(int [] a, int lo, int hi) {
		
		int i=lo;
		int j=hi-1;
		
		while(true) {
			
			while(less(a[i],a[hi])) {
				i++;
			}
			
			if(i==hi)
				break;
			
			while(less(a[hi],a[j])){
				j--;
			}
			
			if(j==lo) break;
			
			if(i>=j)
				break;
			
			exch(a,i,j);
			
		}
		
		exch(a,hi,i);
	}
	
	private static boolean less(int a, int b) {
		return a<=b;
	}
	
	private static void exch(int [] a, int i, int j) {
		int t= a[i];
		a[i]=a[j];
		a[j]=t;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int [] a = new int [n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		
		partition(a,0,n-1);
		
		for(int i: a) {
			System.out.print(i + " " );
		}

	}

}

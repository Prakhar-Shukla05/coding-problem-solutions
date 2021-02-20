package searchingandsorting;

import java.util.Scanner;

public class OneTeacherTwoClasses {
	
	private static boolean less(int a , int b) {
		return a<b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m=sc.nextInt();
		int [] a = new int [m];
		for(int i=0;i<m;i++) {
			a[i]=sc.nextInt();
		}
		int n= sc.nextInt();
		int [] b = new int [n];
		for(int i=0;i<n;i++) {
			b[i]=sc.nextInt();
		}
		sc.close();
		//int [] res = new int[m+n];
		int i=0;
		int j=0;
		for(int k=0;k<m+n;k++) {
			

            if(i==m) {
                System.out.print(b[j++]+ " ");
            }
            else if(j==n) {
               System.out.print(a[i++]+ " ");
            }
            else if(less(b[j],a[i])) {
                System.out.print(b[j++]+ " ");
            }
            else
                System.out.print(a[i++]+ " ");
            
			
		}
		/*
		for(int el: res) {
			System.out.print(el+ " ");
		}
		*/

	}

}

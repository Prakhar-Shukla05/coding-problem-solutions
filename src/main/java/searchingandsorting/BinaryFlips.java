package searchingandsorting;

import java.util.Scanner;

public class BinaryFlips {

	public static void flips(int []a, int k) {
		
		int i=0;
		int j=0;
		int max=0;
		int [] ar= new int [2];
		for( j=0;j<a.length;j++) {
			if(a[j]==0)
				k--;
			
			while(k<0) {
				if(a[i]==0)
					k++;
				
				i++;
			}
			if(max<j-i) {
				max=j-1;
				ar[0]=i+1;
				ar[1]=j+1;
			}
		}
		System.out.println(ar[0]+ " "+ ar[1]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
        InputReader in = new InputReader(System.in);
        //OutputWriter out = new OutputWriter(System.out);
        int n= in.readInt();
        int k=in.readInt();
        int [] a = IOUtils.readIntArray(in, n);
        
        flips(a,k);
        
        
	}

}

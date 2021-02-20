	package recursion;

public class TowerOfHanoi {

	private static int count=1;
	public static void transfer(int n, int s, int d, int h) {
		count++;
		if(n==1) {
			System.out.println("Moving plate " +n+" from "+ s+ " to "+ d);
			return ;
		}
		
		transfer(n-1,s,h,d);
		System.out.println("Moving plate " +n+" from "+ s+ " to "+ d);
		transfer(n-1,h,d,s);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		//OutputWriter out = new OutputWriter(System.out);
		int n= in.readInt();
		
		//int count=0;
		int s=1;
		int h=2;
		int d=3;
		transfer(n,s,d,h);
		System.out.println("Total steps "+ count);
		
	}

}

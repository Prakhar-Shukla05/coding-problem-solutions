package recursion;

public class KthSymbolInGrammar {

	public int kthGrammar(int N, int K) {
             
		if(N==1 && K==1)
			return 0;
		
		int mid = ((int)Math.pow(2, N-1))/2;
		if(K<=mid) {
			return kthGrammar(N-1, K);
		}
		else {
			return complement((kthGrammar(N-1, K-mid)));
		}
		
	}
	
	private int complement(int x) {
		if(x==1)
			return 0;
		return 1;
	}

	public static void main(String[] args) {
           int N =2;
           int K =2;
           System.out.println(new KthSymbolInGrammar().kthGrammar(N, K));
	}
}

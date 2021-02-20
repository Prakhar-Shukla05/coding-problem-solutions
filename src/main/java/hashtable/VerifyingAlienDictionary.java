package hashtable;

public class VerifyingAlienDictionary {

	private int [] alphabet;
	public boolean isAlienSorted(String[] words, String order) {
		 alphabet= new int[26];
		for(int i=0;i<order.length();i++) {
			alphabet[order.charAt(i)-'a']=i;
		}
		
		for(int i=1;i<words.length;i++) {
			if(compare(words[i-1],words[i])>0)
				return false;
		}
		
		return true;

	}
	
	private int compare(String w1, String w2) {
		int i=0;
		int j=0;
		int cmp=0;
		
		while(i<w1.length() && j<w2.length() && cmp==0) {
			cmp = alphabet[w1.charAt(i)-'a']-alphabet[w2.charAt(i)-'a'];
			i++;
			j++;
		}
		if(cmp==0)
			return w1.length()-w2.length();
		else
			return cmp;
	}
	public static void main(String[] args) {
		String [] words = {"word","world","row"};
		String order= "worldabcefghijkmnpqstuvxyz";
		System.out.println(new VerifyingAlienDictionary().isAlienSorted(words, order));
	}
}

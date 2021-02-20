package strings;

public class PatternMatchingWithKMP {

	/* Simple method for finding whether a substring is present */
	
	public boolean hasSubString(char [] text, char [] pattern) {
		int i=0;
		int j=0;
		int k=0;
		while(i<text.length && j<pattern.length) {
			if(text[i]==pattern[j]) {
				i++;
				j++;
			}
			else {
				j=0;
				k++;
				i=k;
			}
			
			
		}
		if(j==pattern.length)
			return true;
		return false;

    }
	
	public boolean kmpSearch(char [] text, char [] pattern) {
		int [] temp= temporaryArray(pattern);
		int i=0;
		int j=0;
		while(i<text.length &&j<pattern.length) {
			if(text[i]==pattern[j]) {
				i++;
				j++;
			}
			else {
				if(j!=0)
					j=temp[j-1];
				else
					i++;
			}
		}
		if(j==pattern.length)
			return true;
		return false;
	}
	
	private int [] temporaryArray(char [] pattern) {
		int [] res= new int [pattern.length];
		int index=0;
		res[0]=0;
		for(int i=1;i<pattern.length;) {
			if(pattern[index]==pattern[i]) {
				res[i]=index+1;
				i++;
				index++;
			}
			else {
				if(index!=0) {
					index=res[index-1];
				}
				else
				{
					res[i]=0;
					i++;
				}
			}
		}
		return res;
		
	}
	public static void main(String[] args) {
		String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        PatternMatchingWithKMP p= new PatternMatchingWithKMP();
        boolean result1=p.hasSubString(str.toCharArray(), subString.toCharArray());
        boolean result2=p.kmpSearch(str.toCharArray(), subString.toCharArray());
        System.out.println(result1+ " " +result2);
	}
}

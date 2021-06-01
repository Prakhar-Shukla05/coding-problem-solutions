package binarySearch;

public class SmallestLetterGreaterThanTarget {

	public static  char nextGreatestLetter(char[] letters, char target) {
           if(letters==null || letters.length==0)
        	   return 'a';
           char c= ceilSearch(letters,target);
           return c;
	}
	
	private static char ceilSearch(char [] letters, char target) {
		int s=0;
		int e=letters.length-1;
		int res=-1;
		while(s<=e) {
			int mid= s+(e-s)/2;
			if(letters[mid]>target) {
				res=mid;
				e=mid-1;
			}
			else {
				s=mid+1;
			}
		}
		return res!=-1?letters[res]:letters[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char [] letters = {'c','f','j'};
		char target='j';
		System.out.println(nextGreatestLetter(letters, target));

	}

}

package tree;

public class ShortestWayToFormAString {

	public int shortestWay(String source, String target) {
		
		int numberofSubsequences=0;
		
		String remaining=target;
		while(remaining.length()>0) {
			StringBuilder sb = new StringBuilder();
			int i=0;
			int j=0;
			while(i<source.length() && j<remaining.length()) {
				if(source.charAt(i++)==remaining.charAt(j)) {
					sb.append(remaining.charAt(j++));
				}
			}
			
			if(sb.length()==0)
				return -1;
			numberofSubsequences++;
			remaining=remaining.substring(sb.length());
		}
		return numberofSubsequences;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String source="abc";
        String target="abccc";
        System.out.println(new ShortestWayToFormAString().shortestWay(source, target));
	}

}

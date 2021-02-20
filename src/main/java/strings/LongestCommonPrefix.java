package strings;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
//        String longest ="";
//        if(strs==null || strs.length==0)
//            return longest;
//        
//        int index=0;
//        for(char c: strs[0].toCharArray()){
//            for(int i=1;i<strs.length;i++){
//                if(index>=strs[i].length() || c!=strs[i].charAt(index))
//                return longest;
//            }
//            longest+=c;
//            index++;
//            
//        }
//        return longest;
		
		if(strs==null  ||  strs.length==0)
			return "";
		String prefix=strs[0];
		for(int i=1;i<strs.length;i++) {
			while(strs[i].indexOf(prefix)!=0)
				prefix=prefix.substring(0,prefix.length()-1);
		}
		return prefix;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] strs= {"flower","flow","flight"};
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
		System.out.println("over");

	}

}

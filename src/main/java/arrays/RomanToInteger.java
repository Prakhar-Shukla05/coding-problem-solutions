package arrays;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static int romanToInt(String s) {
		int result = 0;
		/*Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		map.put("IV", 4);
		map.put("IX", 9);
		map.put("XL", 40);
		map.put("XC", 90);
		map.put("CD", 400);
		map.put("CM", 900);	
		// boolean included=false;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if ((ch == 'I' || ch == 'X' || ch == 'C') && i != s.length() - 1) {
				String sub = s.substring(i, i + 2);
				if (map.containsKey(sub)) {
					result += map.get(sub);
					i++;
					continue;
				}
			}

			result += map.get(s.substring(i, i + 1));

		}*/
		Map<Character, Integer> map= new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		for(int i=0;i<s.length();i++){
            int current=map.get(s.charAt(i));
            
            if(i!=s.length()-1){
                int next= map.get(s.charAt(i+1));
                if(current>=next)
                    result+=current;
                else
                {
                    result+=next-current;
                    i++;
                }
            }
            else{
                result+=current;
            }
        }

		return result;

	}

	public static void main(String[] args) {
		int res = romanToInt("MCMXCIV");
		System.out.println(res);
	}
}

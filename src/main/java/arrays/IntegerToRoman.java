package arrays;

public class IntegerToRoman {

	public static Equivalence[] equi = { new Equivalence("M", 1000), new Equivalence("CM", 900),
			new Equivalence("D", 500), new Equivalence("CD", 400), new Equivalence("C", 100), new Equivalence("XC", 90),
			new Equivalence("L", 50), new Equivalence("XL", 40), new Equivalence("X", 10), new Equivalence("IX", 9),
			new Equivalence("V", 5), new Equivalence("IV", 4), new Equivalence("I", 1) };

	public String intToRoman(int num) {
		String result = "";
		for (Equivalence e : equi) {
			int numOfSymbols = num / e.val;
			if (numOfSymbols != 0) {
				result += e.roman.repeat(numOfSymbols);
			}
			num %= e.val;
		}
		return result;
	}
}

class Equivalence {
	String roman;
	int val;

	public Equivalence(String roman, int val) {
		super();
		this.roman = roman;
		this.val = val;
	}

}

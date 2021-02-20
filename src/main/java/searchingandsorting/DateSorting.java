package searchingandsorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DateSorting {

		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		Dates [] a = new Dates[t];
		
		for(int i=0;i<t;i++) {
			a[i]= new Dates(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		sc.close();
		DateComparator dc= new DateComparator();
		Arrays.sort(a, dc);
		
		for(Dates d :a ) {
			System.out.println(d.day+ " " + d.month+ " "+ d.year);
		}
		

	}

}

class Dates{
	public int day;
	public int month;
	public int year;
	
	
	public Dates(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
}
	
class DateComparator implements Comparator<Dates>{

	@Override
	public int compare(Dates o1, Dates o2) {
		if(o1.year>o2.year)
			return 1;
		else if(o1.year<o2.year)
			return -1;
		else if(o1.month>o2.month)
			return 1;
		else if(o1.month<o2.month)
			return -1;
		else
			return o1.day-o2.day;
	}
	

	
	
}
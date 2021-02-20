package recursion;


import java.util.ArrayList;
import java.util.List;

//import InputReader.SpaceCharFilter;

public class SortArray {

	public static void sort(List<Integer> list) {
		
		if(list.size()==1)
			return ;
		
		int last= list.get(list.size()-1);
		list.remove(list.size()-1);
		sort(list);
		insert(list,last);
	}
	
	public static void insert(List<Integer> list, int element) {
		
		if(list.size()==0 || list.get(list.size()-1)<=element) {
			list.add(element);
			return ;
		}
		
		int last= list.get(list.size()-1);
		list.remove(list.size()-1);
		insert(list,element);	
		list.add(last);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n= in.readInt();
		int [] arr = IOUtils.readIntArray(in, n);
		List<Integer> list = new ArrayList<Integer>();
		for(int i : arr)
			list.add(i);
		
		sort(list);
		
		for(int i : list) {
			out.print(i+ " ");
		}
        out.close(); 
	}

}
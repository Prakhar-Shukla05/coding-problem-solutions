package dp.lis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dp.lis.BoxStacking.Dimension;

//GFG
//Problem link-
//You are given a set of N types of rectangular 3-D boxes, where the ith box has
//height h, width w and length l. You task is to create a stack of boxes which is
//as tall as possible, but you can only stack a box on top of another box if the 
//dimensions of the 2-D base of the lower box are each strictly larger than those 
//of the 2-D base of the higher box. Of course, you can rotate a box so that any 
//side functions as its base.It is also allowable to use multiple instances of the
//same type of box. You task is to complete the function maxHeight which returns the
//height of the highest possible stack so formed.
//
//
//Note: 
//Base of the lower box should be strictly larger than that of the new box we're
//going to place. This is in terms of both length and width, not just in terms of 
//area. So, two boxes with same base cannot be placed one over the other.
//
// 
//
//Example 1:
//
//Input:
//n = 4
//height[] = {4,1,4,10}
//width[] = {6,2,5,12}
//length[] = {7,3,6,32}
//Output: 60
//Explanation: One way of placing the boxes is
//as follows in the bottom to top manner:
//(Denoting the boxes in (l, w, h) manner)
//(12, 32, 10) (10, 12, 32) (6, 7, 4) 
//(5, 6, 4) (4, 5, 6) (2, 3, 1) (1, 2, 3)
//Hence, the total height of this stack is
//10 + 32 + 4 + 4 + 6 + 1 + 3 = 60.
//No other combination of boxes produces a
//height greater than this.
//Example 2:
//
//Input:
//n = 3
//height[] = {1,4,3}
//width[] = {2,5,4}
//length[] = {3,6,1}
//Output: 15
//Explanation: One way of placing the boxes is
//as follows in the bottom to top manner:
//(Denoting the boxes in (l, w, h) manner)
//(5, 6, 4) (4, 5, 6) (3, 4, 1), (2, 3, 1) 
//(1, 2, 3).
//Hence, the total height of this stack is
//4 + 6 + 1 + 1 + 3 = 15
//No other combination of boxes produces a
//height greater than this.

public class BoxStacking {

	static class Dimension implements Comparator<Dimension> {
		int height;
		int width;
		int length;

		public Dimension() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Dimension(int height, int width, int length) {
			super();
			this.height = height;
			this.width = width;
			this.length = length;
		}

		@Override
		public String toString() {
			return "Dimension [height=" + height + ", width=" + width + ", length=" + length + "]";
		}

		@Override
		public int compare(Dimension o1, Dimension o2) {
			// TODO Auto-generated method stub
			return (o2.length * o2.width) - (o1.length * o1.width);
		}

		private Dimension createNewDimension(int height, int side1, int side2) {
			Dimension d = new Dimension();
			d.height = height;
			if (side1 > side2) {
				d.length = side1;
				d.width = side2;
			} else {
				d.length = side2;
				d.width = side1;
			}
			return d;
		}
	}

	public static int maxHeight(int[] height, int[] width, int[] length, int n) {

		List<Dimension> dimensions = new ArrayList<Dimension>();
		Dimension d = new Dimension();
		for (int i = 0; i < n; i++) {

			dimensions.add(d.createNewDimension(height[i], width[i], length[i]));
			dimensions.add(d.createNewDimension(width[i], length[i], height[i]));
			dimensions.add(d.createNewDimension(length[i], height[i], width[i]));
		}

		Collections.sort(dimensions, d);
		int[] lis = new int[n * 3];
		int[] order = new int[n * 3];
		lis[0] = dimensions.get(0).height;
		for (int i = 1; i < n*3; i++) {
			lis[i] = dimensions.get(i).height;
			for (int j = 0; j < i; j++) {
				if (dimensions.get(i).length < dimensions.get(j).length
						&& dimensions.get(i).width < dimensions.get(j).width) {
					if (lis[i] <= lis[j] + dimensions.get(i).height) {
						lis[i] = lis[j] + dimensions.get(i).height;
						order[i] = j;
					}
				}
			}

		}
		int max=0;
		for(int i=0;i<n*3;i++)
			max=Math.max(max, lis[i]);

		return max;
	}
	
	
	public static void main(String[] args) {
		        int n = 1;
		        int height[] = {1};
		        int width[] = {5};
		        int length[] = {5};
		        System.out.println(maxHeight(height, width, length, n));
		
	}
}

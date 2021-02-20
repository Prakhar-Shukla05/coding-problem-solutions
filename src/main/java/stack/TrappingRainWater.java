package stack;

import java.util.Stack;

public class TrappingRainWater {

	static int trappingWater(int arr[], int n) {
           
		int [] maxLeft= new int [n];
		int [] maxRight= new int[n];
		/*Stack<Integer> s = new Stack<Integer>();
		for(int i=0;i<n;i++) {
			if(s.isEmpty())
				maxLeft[i]=arr[i];
			else if(!s.isEmpty() && s.peek()>arr[i])
				maxLeft[i]=s.peek();
			else {
				while(!s.isEmpty() && s.peek()<arr[i])
					s.pop();
				if(s.isEmpty())
					maxLeft[i]=arr[i];
				else
					maxLeft[i]=s.peek();
			}
			if(s.isEmpty() || arr[i]>s.peek())
			s.push(arr[i]);
		}
		s.clear();
		
		for(int i=n-1;i>=0;i--) {
			if(s.isEmpty())
				maxRight[i]=arr[i];
			else if(!s.isEmpty() && s.peek()>arr[i])
				maxRight[i]=s.peek();
			else {
				while(!s.isEmpty() && s.peek()<arr[i])
					s.pop();
				if(s.isEmpty())
					maxRight[i]=arr[i];
				else
					maxRight[i]=s.peek();
			}
			if(s.isEmpty() || arr[i]>s.peek())
			s.push(arr[i]);
		}
		*/
		
		//Better way to fill maxLeft and maxRight
		maxLeft[0]=arr[0];
		maxRight[n-1]=arr[n-1];
		for(int i=1;i<n;i++) {
			maxLeft[i]=Math.max(maxLeft[i-1], arr[i]);
			
		}
		
		for(int i=n-2;i>=0;i--) {
			maxRight[i]=Math.max(maxRight[i+1], arr[i]);
		}
		int [] water = new int [n];
		int sum=0;
		for(int i=0;i<n;i++) {
			water[i]= Math.min(maxLeft[i], maxRight[i])-arr[i];
			sum+=water[i];
		}
		return sum;
	}

	public static void main(String[] args) {
     InputReader in = new InputReader(System.in);
     OutputWriter out = new OutputWriter(System.out);
     int n=in.readInt();
     int [] arr=  IOUtils.readIntArray(in, n);
     out.print(trappingWater(arr, n));
     out.close();
	}

}

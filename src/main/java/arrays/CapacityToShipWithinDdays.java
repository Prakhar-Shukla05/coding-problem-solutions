package arrays;

public class CapacityToShipWithinDdays {

	private boolean isPossible(int c, int [] weights, int d) {
		int days=1;
		int cap=c;
		for(int x : weights) {
			if(cap>=x)
				cap-=x;
			else {
				days++;
				cap=c-x;
				
			}
		}
		return days<=d;
	}
	public int shipWithinDays(int[] weights, int D) {
            int s=0;
            for(int x: weights)
            	s=Math.max(x, s);
            int e=Integer.MAX_VALUE;
            int ans=Integer.MAX_VALUE;
            
            while(s<=e) {
            	int mid=s+(e-s)/2;
            	if(isPossible(mid,weights,D)) {
            		ans= Math.min(ans, mid);
            		e=mid-1;
            		
            	}
            	else
            		s=mid+1;
            }
            return ans;
	}
	
	public static void main(String[] args) {
	int [] w= {1,2,3,4,5,6,7,8,9,10};
	int D=5;
	System.out.println(new CapacityToShipWithinDdays().shipWithinDays(w, D));
	}
}

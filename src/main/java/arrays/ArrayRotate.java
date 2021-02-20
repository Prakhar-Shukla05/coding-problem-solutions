package arrays;

public class ArrayRotate {
	 public static void rotate(int[][] matrix) {
		        int n=matrix.length;
		        for(int i=0;i<n;i++){
		            for(int j=i;j<n;j++){
		            	 int temp= matrix[i][j];
		            	 matrix[i][j]=matrix[j][i];
		            	 matrix[j][i]=temp;
		            }
		        }
		        
		        for(int i=0;i<n;i++){
		            for(int j=0;j<n/2;j++){
		            	 int temp= matrix[i][j];
		            	 matrix[i][j]=matrix[i][n-j-1];
		            	 matrix[i][n-j-1]=temp;
		            }
		        }
	        
	        
	    }
	    
	   
	    public static void print(int [] [] a) {
	    	for(int i=0;i<a.length;i++) {
	    		for(int j=0;j<a.length;j++) {
	    			System.out.print(a[i][j]+" ");
	    		}
	    		System.out.println();
	    	}
	    }
	    
	    public static void main(String[] args) {
			int [] [] a= {{1,2,3},{4,5,6},{7,8,9}};
			rotate(a);
			print(a);
			
		}
}

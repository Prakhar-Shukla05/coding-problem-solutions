package dfs;

public class LongestIncreasingPath {

	public static int longestIncreasingPath(int[][] matrix) {
           
		if(matrix==null || matrix.length==0)
			return 0;
		int maxPath=0;
		int row= matrix.length;
		int col= matrix[0].length;
		//int [] [] dp = new int [row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				//if(dp[i][j]!=)
				maxPath = Math.max(maxPath,dfs(i,j,matrix,Integer.MIN_VALUE));
			}
		}
		return maxPath;
	}
	
	private static boolean isValid(int i, int j, int row, int col) {
		
		return i>=0 && i<row && j>=0 && j<col;
	}
	private static int dfs(int x, int y, int [] [] matrix, int prev) {
		
		//if(!isValid(x,y,matrix.length,matrix[0].length))
			//return 0;
		
		if(x<0 || x>matrix.length-1 || y<0 || y>matrix[0].length-1)
			return 0;
		
		if(matrix[x][y]<prev)
			return 0;
		
		int p1= dfs(x+1,y,matrix,matrix[x][y]);
		int p2= dfs(x-1,y,matrix,matrix[x][y]);
		int p3= dfs(x,y+1,matrix,matrix[x][y]);
		int p4= dfs(x,y-1,matrix,matrix[x][y]);
		int max1= Math.max(p1, p2);
		int max2=Math.max(p3, p4);
		int count = 1+Math.max(max1, max2);
		
	    return count;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] [] matrix = {{9,9,4},
				  {6,6,8},
				  {2,1,1}};
		System.out.println(longestIncreasingPath(matrix));

	}

}

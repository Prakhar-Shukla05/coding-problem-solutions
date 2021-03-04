package dfs;

public class MaxAreaOfIslands {

	public int maxAreaOfIsland(int[][] grid) {

		int max=0;
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j]==1) {
					max= Math.max(max, dfs(i,j,grid));
				}
			}
		}
		return max;
		
		
		
	}
	
	private int dfs(int i, int j, int [] [] grid) {
		
		if(!isValidPos(i,j,grid)) {
			return 0;
			
		}
		
        grid[i][j]=0;
        int count=1;
        
        count+=dfs(i+1,j,grid);
        count+=dfs(i-1,j,grid);
        count+=dfs(i,j+1,grid);
        count+=dfs(i,j-1,grid);
        
        return count;
	}
	
	private boolean isValidPos(int i, int j, int  [] [] grid) {
		
		return i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j]==1;  
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] [] grid= {
        		 {0,0,1,0,0,0,0,1,0,0,0,0,0},
        		 {0,0,0,0,0,0,0,1,1,1,0,0,0},
        		 {0,1,1,0,1,0,0,0,0,0,0,0,0},
        		 {0,1,0,0,1,1,0,0,1,0,1,0,0},
        		 {0,1,0,0,1,1,0,0,1,1,1,0,0},
        		 {0,0,0,0,0,0,0,0,0,0,1,0,0},
        		 {0,0,0,0,0,0,0,1,1,1,0,0,0},
        		 {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        
        System.out.println("The maximum area of island is :- "+ new MaxAreaOfIslands().maxAreaOfIsland(grid));
	}

}

package dfs;

public class NumberOfIslandsWithDFS {

	public int numIslands(char[][] grid) {
		if(grid==null || grid.length==0 || grid[0].length==0)
			return 0;
		boolean [][] visited = new boolean[grid.length][grid[0].length];
		int count=0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]=='1' && !visited[i][j]) {
					count++;
					visited[i][j]=true;
				    dfs(grid,visited,i,j);
				    
				}
			}
		}
		return count;
	}
	
	public void dfs(char [][] grid, boolean [][] visited, int xsrc, int ysrc) {
		if(isValid(grid,visited,xsrc+1,ysrc)) {
			visited[xsrc+1][ysrc]=true;
			dfs(grid,visited,xsrc+1,ysrc);
		}
		if(isValid(grid,visited,xsrc-1,ysrc)){
			visited[xsrc-1][ysrc]=true;
			dfs(grid,visited,xsrc-1,ysrc); 
		}
		
		if(isValid(grid,visited,xsrc,ysrc+1)){
			visited[xsrc][ysrc+1]=true;
			dfs(grid,visited,xsrc,ysrc+1);
		}
		if(isValid(grid,visited,xsrc,ysrc-1)){
			visited[xsrc][ysrc-1]=true;
			dfs(grid,visited,xsrc,ysrc-1);
		}
	}
	
	public boolean isValid(char [][] grid, boolean [][] visited, int x, int y) {
		
		return ((x>=0) && (x<grid.length) && (y>=0) && (y<grid[0].length) && visited[x][y]==false && grid[x][y]=='1');
	}
	
	
	public static void main(String[] args) {
		
	}	
}
	

package dfs;

import java.util.ArrayList;
import java.util.List;

import backtracking.CombinationSumI;

public class PacificAtlanticWaterFlow {

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
 
		List<List<Integer>> coordinates = new ArrayList();
		if(matrix== null || matrix.length==0)
			return coordinates;
		
		int row = matrix.length;
		int col = matrix[0].length;
		int [] [] pacific = new int [row][col];
		int [] [] atlantic = new int [row] [col];
		
		//First row of pacific
		for(int i=0;i<col;i++) {
			if(isValid(0,i,row,col,pacific))
			dfs(matrix,pacific,0,i, Integer.MIN_VALUE);
		}
		
		//First column of pacific
		for(int i=0;i<row;i++){
			if(isValid(i,0,row,col,pacific))
			dfs(matrix,pacific,i,0,Integer.MIN_VALUE);
		}
		
		//Last row of atlantic
		
		for(int i=0;i<col;i++) {
			if(isValid(row-1,i,row,col,atlantic))
				dfs(matrix,atlantic,row-1,i,Integer.MIN_VALUE);
		}
		
		//Last column of atlantic
		for(int i=0;i<row;i++){
			if(isValid(i,col-1,row,col,atlantic))
			dfs(matrix,atlantic,i,col-1,Integer.MIN_VALUE);
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(pacific[i][j]==1 && atlantic[i][j]==1) {
					List<Integer> temporary= new ArrayList();
					temporary.add(i);
					temporary.add(j);
					coordinates.add(temporary);
				}
			}
		}
		
		
		return coordinates;
		
	}
	
	private boolean isValid(int i, int j, int row, int col, int [] [] matrix) {
		
		//int temp=matrix[i][j];
		return i>=0 && i<row && j>=0  && j<col && matrix[i][j]==0 ;
	}
	
	private void dfs(int [] [] matrix, int [] [] temp, int i, int j, int prev) {
		
		if(!isValid(i,j,matrix.length,matrix[0].length,temp))
			return ;
		
		if(matrix[i][j]<prev)
			return ;
			
		temp[i][j]=1;
		
		dfs(matrix,temp,i+1,j,matrix[i][j]);
		dfs(matrix,temp,i-1,j,matrix[i][j]);
		dfs(matrix,temp,i,j+1,matrix[i][j]);
		dfs(matrix,temp,i,j-1,matrix[i][j]);
		
		
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] [] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

		List<List<Integer>> res =new PacificAtlanticWaterFlow().pacificAtlantic(matrix);
		for (List<Integer> i : res) {
			System.out.print(i+" ");

		//	System.out.println();
		}
	}

}

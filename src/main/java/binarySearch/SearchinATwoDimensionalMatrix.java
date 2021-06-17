package binarySearch;

//GeeksforGeeks
//Problem link- https://practice.geeksforgeeks.org/problems/search-in-a-matrix17201720/1
//Given a matrix mat[][] of size N x M, where every row and column is sorted in increasing order,
//and a number X is given. The task is to find whether element X is present in the matrix or not.
//
//
//Example 1:
//
//Input:
//N = 3, M = 3
//mat[][] = 3 30 38 
//         44 52 54 
//         57 60 69
//X = 62
//Output:
//0
//Explanation:
//62 is not present in the
//matrix, so output is 0

public class SearchinATwoDimensionalMatrix {

	public static int matSearch(int mat[][], int N, int M, int X) {
		if(mat==null ||N==0 || M==0)
			return 0;
		//Start from the top most corner
		int i=0;
		int j=M-1;
		
		while(i<=N && j>=0) {
			if(mat[i][j]==X)
				return 1;
			else if(mat[i][j]>X) {
				j--;
			}
			else if(mat[i][j]<X)
			{
				i++;
			}
		}
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

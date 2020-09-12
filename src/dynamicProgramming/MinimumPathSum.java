/*
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of 
 * minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse 
 * through that cell. Total cost of a path to reach (m, n) is sum of all the costs on that path 
 * (including both source and destination). You can only traverse down, right and diagonally lower cells 
 * from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. 
 * You may assume that all costs are positive integers.
 */

package dynamicProgramming;

public class MinimumPathSum {
	public static class minPathSum {
		public static int minCost(int[][] grid) {
			int m = grid.length; // no. of rows
	        int n = grid[0].length; // no. of columns
	        
	        int cost[][] = new int[m][n];
	        
	        cost[0][0] = grid[0][0];
	        
	        for(int i = 1; i < m; i++){
	            cost[i][0] = cost[i-1][0] + grid[i][0];
	        }
	        
	        for(int j = 1; j < n; j++){
	            cost[0][j] = cost[0][j-1] + grid[0][j];
	        }
	        
	        for(int i = 1; i < m; i++){
	            for(int j = 1; j < n; j++){
	                cost[i][j] = grid[i][j] + min(cost[i-1][j], cost[i][j-1], cost[i-1][j-1]);
	            }
	        }
	        
	        return cost[m-1][n-1];
		}
		
		public static int min(int a, int b, int c){
	        if(a < b && a < c) {
	        	return a;
	        } else if(b < a && b < c) {
	        	return b;
	        } else {
	        	return c;
	        }
	    }
	}
	
	public static void main(String[] args) {
		int cost[][] = {{1, 7, 9, 2}, 
						{8, 6, 3, 2}, 
						{1, 6, 7, 8},
						{2, 9, 8, 2}}; 
		
		System.out.println(minPathSum.minCost(cost));
	}
}

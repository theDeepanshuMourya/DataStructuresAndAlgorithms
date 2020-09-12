/*
 * You are given weights and values of N items, put these items in a knapsack of capacity W to 
 * get the maximum total value in the knapsack. Note that we have only one quantity of each item.
 * In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and 
 * weights associated with N items respectively. Also given an integer W which represents knapsack 
 * capacity, find out the maximum value subset of val[] such that sum of the weights of this subset 
 * is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t 
 * pick it (0-1 property).
 */

package dynamicProgramming;


public class KnapSack {
	public static void main(String[] args) {
		int val[] = new int[]{60, 100, 120}; 
	    int wt[] = new int[]{10, 20, 30}; 
	    int  W = 50; 
	    int n = val.length; 
	    System.out.println(knapSack(W, wt, val, n));
	}
	
	public static int knapSack(int W, int[] wt, int[] val, int n) {
		int K[][] = new int[n+1][W+1];
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= W; j++) {
				if(i==0 || j==0) {
					K[i][j] = 0;
				} else if(wt[i-1] <= j) {
					K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
				} else {
					K[i][j] = K[i-1][j];
				}
			}
		}
		
		return K[n][W];
	}
}

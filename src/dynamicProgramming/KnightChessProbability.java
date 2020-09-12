/*
 * Given an NxN chessboard and a Knight at position (x,y). The Knight has to take exactly K steps, 
 * where at each step it chooses any of the 8 directions uniformly at random. 
 * What is the probability that the Knight remains in the chessboard after taking K steps, 
 * with the condition that it can’t enter the board again once it leaves it.
 */

package dynamicProgramming;

public class KnightChessProbability {
	public static class KnightProbability {
		public static double countProbability(int n, int r, int c, int k, double p, double dp[][][]){
		    if(r < 0 || r >= n || c < 0 || c >= n || k < 0){
		        return 0;
		    }
		    
		    if(k == 0) return p;
		    
		    if(dp[r][c][k] != 0) return dp[r][c][k];
		    
		    double prob = 0;
		    
		    prob += countProbability(n, r+1, c-2, k-1, p/8, dp);
		    prob += countProbability(n, r+2, c-1, k-1, p/8, dp);
		    prob += countProbability(n, r+1, c+2, k-1, p/8, dp);
		    prob += countProbability(n, r+2, c+1, k-1, p/8, dp);
		    prob += countProbability(n, r-1, c-2, k-1, p/8, dp);
		    prob += countProbability(n, r-2, c-1, k-1, p/8, dp);
		    prob += countProbability(n, r-1, c+2, k-1, p/8, dp);
		    prob += countProbability(n, r-2, c+1, k-1, p/8, dp);
		    
		    dp[r][c][k] = prob;
		    return prob;
		}
	}
	
	public static void main(String[] args) {		
		int n = 3;
		int x = 0;
		int y = 0;
		int k = 2;
		    
		double ans = KnightProbability.countProbability(n, x, y, k, 1, new double[n][n][k+1]);
		System.out.println(ans);
	}
}

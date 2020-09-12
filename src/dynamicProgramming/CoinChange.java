/*
 * CoinChange:
 * Given a value N, if we want to make change for N cents, and we have infinite supply of 
 * each of C = { C1, C2, .. , Cm} valued coins, how many ways can we make the change? 
 * The order of coins doesn’t matter.
 * 
 * CoinChangeII:
 * Given a value V. You have to make change for V cents, given that you have infinite supply 
 * of each of C = { C1, C2, .. , Cm} valued coins. Find the minimum number of coins to make the change.
 */

package dynamicProgramming;

import java.util.Arrays;

public class CoinChange {
	public static class CoinChangeI {
		public static long countWays(int[] S, int n, int m) {
			long table[] = new long[m+1];
			
			table[0] = 1;
			
			for(int i = 0; i < n; i++) {
				for(int j = S[i]; j <= m; j++) {
					table[j] += table[j - S[i]];
				}
			}
			
			return table[m];
		}
	}
	
	public static class CoinChangeII {
		public static int minCoins(int[] coins, int amount) {
			int dp[] = new int[amount+1];
	        Arrays.fill(dp, amount+1);
	        dp[0] = 0;
	        
	        for(int i = 1; i <= amount; i++){
	            for(int j = 0; j < coins.length; j++){
	                if(coins[j] <= i){
	                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
	                }
	            }
	        }
	        
	        return (dp[amount] > amount)?-1:dp[amount];
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3}; 
        int n = arr.length; 
        int m = 4; 
        System.out.println(CoinChangeI.countWays(arr, n, m));
        System.out.println(CoinChangeII.minCoins(arr, m));
	}
}
